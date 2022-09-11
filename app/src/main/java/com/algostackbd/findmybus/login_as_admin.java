package com.algostackbd.findmybus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login_as_admin extends AppCompatActivity {
    TextView signupAsAdmin;
    Button login;
    private TextInputEditText ad_userfield;
    private TextInputEditText ad_passfield;
    Button adLogbtn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_as_admin);

        login = findViewById(R.id.loginAsAdminBtn);
        ad_userfield = (TextInputEditText) findViewById(R.id.adtxtuser) ;
        ad_passfield = (TextInputEditText) findViewById(R.id.adtxtpass) ;
        adLogbtn = (Button) findViewById(R.id.loginAsAdminBtn);
        mAuth = FirebaseAuth.getInstance();
        adLogbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = ad_userfield.getText().toString().trim();
                String pass =  ad_passfield.getText().toString().trim();

                if(email.isEmpty()){
                    ad_userfield.setError("Email cannot be empty");
                    ad_userfield.requestFocus();
                } else if(pass.isEmpty()){
                    ad_passfield.setError("Email cannot be empty");
                    ad_passfield.requestFocus();
                }else {

                    mAuth.signInWithEmailAndPassword(email, pass)
                            .addOnCompleteListener(login_as_admin.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Intent myIntent = new Intent(login_as_admin.this, MainActivity.class);
                                        startActivity(myIntent);
                                        ad_passfield.setText("");
                                        ad_userfield.setText("");

                                    } else {
                                        // If sign in fails, display a message to the user.
                                        ad_passfield.setText("");
                                        ad_userfield.setText("");
                                        Toast.makeText(getApplicationContext(),"Invalid Email or Password",Toast.LENGTH_LONG).show();
                                    }
                                }
                            });

                }

            }
        });



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