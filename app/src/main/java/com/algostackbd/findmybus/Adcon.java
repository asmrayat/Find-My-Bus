package com.algostackbd.findmybus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Adcon extends AppCompatActivity {

    Button adminBtn, consumerBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adcon);

        adminBtn = findViewById(R.id.adminbtn);
        consumerBtn = findViewById(R.id.consumerbtn);


        adminBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent adminIntent = new Intent(Adcon.this,login_as_admin.class);
                startActivity(adminIntent);
            }
        });

        consumerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent consumerIntent = new Intent(Adcon.this,login_as_user.class);
                startActivity(consumerIntent);
            }
        });
    }
}