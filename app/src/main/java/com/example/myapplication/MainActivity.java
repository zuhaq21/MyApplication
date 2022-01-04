package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static int splash = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sp = getSharedPreferences(Login.prefsName,0);
                boolean hasLoggedIn = sp.getBoolean("hasLoggedIn",false);

                if (hasLoggedIn){
                    startActivity(new Intent(MainActivity.this, Order.class));
                    finish();
                }
                else
                {
                    startActivity(new Intent(MainActivity.this, Login.class));
                    finish();
                }
            }
        }, splash);
    }
}