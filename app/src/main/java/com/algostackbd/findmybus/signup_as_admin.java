package com.algostackbd.findmybus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class signup_as_admin extends AppCompatActivity {
    TextView signupAsAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_as_admin);

        signupAsAdmin = findViewById(R.id.loginTxtAdmin);

        signupAsAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(signup_as_admin.this, login_as_admin.class);
                startActivity(loginIntent);
            }
        });
    }
}