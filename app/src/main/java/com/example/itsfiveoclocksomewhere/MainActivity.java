package com.example.itsfiveoclocksomewhere;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.itsfiveoclocksomewhere.ui.login.LoginActivity;
import com.uber.sdk.android.core.UberSdk;
import com.uber.sdk.rides.client.SessionConfiguration;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SessionConfiguration config = new SessionConfiguration.Builder()
                // mandatory
                .setClientId("<CLIENT_ID>")
                // required for enhanced button features
                .setServerToken("<TOKEN>")
                // required for implicit grant authentication
                .setRedirectUri("<REDIRECT_URI>")
                // optional: set sandbox as operating environment
                .setEnvironment(SessionConfiguration.Environment.SANDBOX)
                .build();
        UberSdk.initialize(config);
        if(BuildConfig.DEBUG){
           Timber.plant(new Timber.DebugTree());
        }
        Timber.d("Main activity onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Timber.d("Main activity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Timber.d("Main activity onResume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Timber.d("Main activity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Timber.d("Main activity onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Timber.d("Main activity onDestroy");
    }
    /** Called when the user touches the button */
    public void sendMessageLogin(View view) {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    public void sendMessageMap(View view) {
        Intent intent = new Intent(MainActivity.this, MapsActivity.class);
        startActivity(intent);
    }



}