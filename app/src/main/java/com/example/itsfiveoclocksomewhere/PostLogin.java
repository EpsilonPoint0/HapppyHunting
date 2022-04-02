package com.example.itsfiveoclocksomewhere;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.itsfiveoclocksomewhere.ui.login.LoginActivity;

import timber.log.Timber;

public class PostLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_login);
    }
    /** Called when the user touches the button */
    public void sendMessageLogin(View view) {
        Intent intent = new Intent(PostLogin.this, MainActivity.class);
        Timber.d("Button clicked");
        startActivity(intent);
    }

    public void sendMessageMap(View view) {
        Intent intent = new Intent(PostLogin.this, MapsActivity.class);
        startActivity(intent);
    }
}