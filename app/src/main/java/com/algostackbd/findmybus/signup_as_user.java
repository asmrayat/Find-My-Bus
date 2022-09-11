package com.algostackbd.findmybus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class signup_as_user extends AppCompatActivity {

    String[] roleOption = new String[]{"Student ","Teacher ","Staff "};

    TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_as_user);
        login = findViewById(R.id.loginTxt);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(
                this ,
                R.layout.drop_down_item,
                roleOption
        );
        AutoCompleteTextView autoCompleteTextView1=findViewById(R.id.selectRoles);
        autoCompleteTextView1.setAdapter(adapter1);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(signup_as_user.this, login_as_user.class);
                startActivity(loginIntent);
            }
        });
    }
}