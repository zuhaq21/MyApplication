package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Order extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        btn = (Button) findViewById(R.id.logoutBtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getSharedPreferences(Login.prefsName,0);
                SharedPreferences.Editor editor = sp.edit();

                editor.putBoolean("hasLoggedIn",false);
                editor.commit();

                startActivity(new Intent(Order.this, Login.class));
                finish();
            }
        });


    }
}