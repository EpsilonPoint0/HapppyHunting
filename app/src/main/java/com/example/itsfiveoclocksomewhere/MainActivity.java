package com.example.itsfiveoclocksomewhere;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.itsfiveoclocksomewhere.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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