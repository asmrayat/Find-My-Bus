package com.algostackbd.findmybus.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.algostackbd.findmybus.R;

public class login_as_user extends AppCompatActivity {

    TextView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signup = findViewById(R.id.signupTxt);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(login_as_user.this, signup_as_user.class);
                startActivity(loginIntent);
            }
        });
    }
}