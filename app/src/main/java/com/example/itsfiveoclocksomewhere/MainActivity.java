package com.example.itsfiveoclocksomewhere;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.itsfiveoclocksomewhere.ui.login.LoginActivity;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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