package com.example.itsfiveoclocksomewhere;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.itsfiveoclocksomewhere.ui.login.LoginActivity;
import com.uber.sdk.android.core.UberSdk;
import com.uber.sdk.core.auth.Scope;
import com.uber.sdk.rides.client.SessionConfiguration;

import java.sql.Connection;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

                        //connection to database

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






        if(BuildConfig.DEBUG){
            Timber.plant(new Timber.DebugTree());
        }
        //conn = DBMethods.initializeDB(DB_Name); //creating a connection to the database
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
    protected void onStop() {
        super.onStop();
        Timber.d("Main activity onStop");
    }

    /** Called when the user touches the button */
    public void sendMessageLogin(View view) {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        Timber.d("Button clicked");
        startActivity(intent);
    }

    public void sendMessageMap(View view) {
        Intent intent = new Intent(MainActivity.this, MapsActivity.class);
        startActivity(intent);
    }


}