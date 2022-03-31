package com.example.itsfiveoclocksomewhere.ui.login;

import android.app.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.itsfiveoclocksomewhere.DBMethods;
import com.example.itsfiveoclocksomewhere.MainActivity;
import com.example.itsfiveoclocksomewhere.R;
import com.example.itsfiveoclocksomewhere.databinding.ActivityLoginBinding;

import org.apache.log4j.chainsaw.Main;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    private ActivityLoginBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loginViewModel = new ViewModelProvider(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);

        final EditText usernameEditText = binding.username;
        final EditText passwordEditText = binding.password;
        final Button loginButton = binding.login;
        final ProgressBar loadingProgressBar = binding.loading;

        loginViewModel.getLoginFormState().observe(this, new Observer<LoginFormState>() {
            @Override
            public void onChanged(@Nullable LoginFormState loginFormState) {
                if (loginFormState == null) {
                    return;
                }
                loginButton.setEnabled(loginFormState.isDataValid());
                if (loginFormState.getUsernameError() != null) {
                    usernameEditText.setError(getString(loginFormState.getUsernameError()));
                }
                if (loginFormState.getPasswordError() != null) {
                    passwordEditText.setError(getString(loginFormState.getPasswordError()));
                }
            }
        });

        loginViewModel.getLoginResult().observe(this, new Observer<LoginResult>() {
            @Override
            public void onChanged(@Nullable LoginResult loginResult) {
                if (loginResult == null) {
                    return;
                }
                loadingProgressBar.setVisibility(View.GONE);

                //checking if someone has used this username
                int exists = DBMethods.checkExistsAndFirstValue(MainActivity.conn,
                        "SELECT 1 FROM User WHERE Username = \'" + usernameEditText.getText().toString()
                                +"\' COLLATE NOCASE;");

                //if there is a user with this username, checks to see if password was correct
                if (exists != 0) {
                    int match = DBMethods.checkExistsAndFirstValue(MainActivity.conn,
                            "SELECT 1 FROM User WHERE Username = \'" + usernameEditText.getText().toString()
                                    +"\' AND password = \'" + passwordEditText.getText().toString()
                            + "\' COLLATE NOCASE;");

                    //if the user entered the correct password, welcomes them back
                    if (match != 0) {
                        updateUIWelcomeMessage(loginResult.getSuccess(), false);
                        setResult(Activity.RESULT_OK);
                        finish();  //Complete and destroy login activity once successful

                    //if the user entered an incorrect password, displays error message
                    } else {
                        updateUIWrongPassword(loginResult.getSuccess());
                    }

                 //if no user has that username, creates new account
                } else {
                    int UserId = DBMethods.getRows(MainActivity.conn, "User") + 1; //making user's new id
                    DBMethods.writeToDB(MainActivity.conn, "INSERT INTO User VALUES (" + UserId
                        + ", \'" + usernameEditText.getText().toString() +"\', "
                        + passwordEditText.getText().toString() + "null, null);");
                    updateUIWelcomeMessage(loginResult.getSuccess(), true);
                    setResult(Activity.RESULT_OK);
                    finish();  //Complete and destroy login activity once successful
                }

                //TODO do we still need these?
//                if (loginResult.getError() != null) {
 //                   showLoginFailed(loginResult.getError());
  //              }
   //             if (loginResult.getSuccess() != null) {
    //                updateUiWithUser(loginResult.getSuccess());
     //           }



            }
        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                loginViewModel.loginDataChanged(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        };
        usernameEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    loginViewModel.login(usernameEditText.getText().toString(),
                            passwordEditText.getText().toString());
                }
                return false;
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingProgressBar.setVisibility(View.VISIBLE);
                loginViewModel.login(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        });
    }

    private void updateUIWelcomeMessage(LoggedInUserView model, boolean NewUser) {
        String welcome ="";
        if (NewUser) {
            welcome = getString(R.string.welcome) + model.getDisplayName();
        } else {
            welcome = getString(R.string.returning) + model.getDisplayName();
        }
        // TODO : initiate successful logged in experience
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }

    private void updateUIWrongPassword(LoggedInUserView model) {

        Toast.makeText(getApplicationContext(), "Sorry, that password does not match our records." +
                " Please Try Again", Toast.LENGTH_LONG).show();

    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }
}