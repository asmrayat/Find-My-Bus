package com.algostackbd.findmybus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class login_as_admin extends AppCompatActivity {
    TextView signupAsAdmin;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_as_admin);

        login = findViewById(R.id.loginAsAdminBtn);

        signupAsAdmin = findViewById(R.id.signupTxtAdmin);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginBtn = new Intent(login_as_admin.this,MainActivity.class);
                startActivity(loginBtn);
            }
        });

        signupAsAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(login_as_admin.this, signup_as_admin.class);
                startActivity(loginIntent);
            }
        });
    }
}