package com.algostackbd.findmybus.Admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.algostackbd.findmybus.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup_as_user extends AppCompatActivity {

    TextView login;
    private FirebaseAuth mAuth;
// ...
// Initialize Firebase Auth
  private   TextInputLayout nametxt,id_number,contact_number;
    Button signbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_signup);
        login = findViewById(R.id.loginTxt);


        nametxt =(TextInputLayout) findViewById(R.id.fullName);
        id_number = (TextInputLayout) findViewById(R.id.IdNumber);
        contact_number =(TextInputLayout) findViewById(R.id.ContactNumber);
        signbtn = (Button) findViewById(R.id.signbtn);
        signbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nametxt.getEditText().getText().toString().trim();
                String idNumber = id_number.getEditText().getText().toString().trim();
                String contactNumber = contact_number.getEditText().getText().toString().trim();

                if(TextUtils.isEmpty(name)){
                    nametxt.setError("Name cannot be empty");
                    nametxt.requestFocus();
                }else if(TextUtils.isEmpty(idNumber)){
                    id_number.setError("ID NUumber cannot be empty");
                    id_number.requestFocus();
                }else if(TextUtils.isEmpty(contactNumber)){
                    contact_number.setError("Contact Number cannot be empty");
                    contact_number.requestFocus();
                } else{

                    mAuth.createUserWithEmailAndPassword(email,password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                }
                            });
                }

            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(signup_as_user.this, login_as_user.class);
                startActivity(loginIntent);

            }
        });
    }


}