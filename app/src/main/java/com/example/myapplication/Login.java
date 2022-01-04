package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    public static String prefsName = "MyPrefsFile";
    EditText username, password;
    String name, pass;
    Button logBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        logBtn = (Button) findViewById(R.id.loginBtn);
        username = (EditText) findViewById(R.id.usernameET);
        password = (EditText) findViewById(R.id.passwordET);
        name = username.getText().toString();
        pass = password.getText().toString();

        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name == "user" && pass == "user")
                {
                    SharedPreferences sharedPreferences = getSharedPreferences(Login.prefsName,0);
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.putBoolean("hasLoggedIn",true);
                    editor.commit();

                    startActivity(new Intent(Login.this, Order.class));
                    finish();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Invalid Credentials", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}