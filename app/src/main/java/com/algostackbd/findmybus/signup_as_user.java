package com.algostackbd.findmybus;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.algostackbd.findmybus.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class signup_as_user extends AppCompatActivity {

    TextView login;
    private FirebaseAuth mAuth;
    // ...
// Initialize Firebase Auth
    private TextInputLayout nametxt, id_number, contact_number, email, password;
    Button signbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_signup_as_user);
        login = findViewById(R.id.loginTxt);


        email = (TextInputLayout) findViewById(R.id.emailForUser);
        password = (TextInputLayout) findViewById(R.id.passwordForUser);
        nametxt = (TextInputLayout) findViewById(R.id.fullName);
        id_number = (TextInputLayout) findViewById(R.id.IdNumber);
        contact_number = (TextInputLayout) findViewById(R.id.ContactNumber);
        signbtn = (Button) findViewById(R.id.signbtn);
        signbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nametxt.getEditText().getText().toString().trim();
                String emailuser = email.getEditText().getText().toString().trim();
                String passuser = password.getEditText().getText().toString().trim();
                String idNumber = id_number.getEditText().getText().toString().trim();
                String contactNumber = contact_number.getEditText().getText().toString().trim();

                if (name.isEmpty()) {
                    nametxt.setError("Name cannot be empty");
                    nametxt.requestFocus();
                } else if (idNumber.isEmpty()) {
                    id_number.setError("ID NUumber cannot be empty");
                    id_number.requestFocus();
                } else if (contactNumber.isEmpty()) {
                    contact_number.setError("Contact Number cannot be empty");
                    contact_number.requestFocus();
                } else if (emailuser.isEmpty()) {
                    email.setError("Email is requird");
                    email.requestFocus();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(emailuser).matches()) {
                    email.setError("Plase provide valid email");
                    email.requestFocus();
                } else if (passuser.isEmpty()) {
                    password.setError("Email is requird");
                    password.requestFocus();
                } else if (passuser.length() < 6) {
                    password.setError("Min password length should be 6 characters!");
                    password.requestFocus();
                } else {

                    mAuth.createUserWithEmailAndPassword(emailuser, passuser)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if(task.isSuccessful()){
                                        User user = new User(name,emailuser,idNumber,contactNumber);
                                        FirebaseDatabase.getInstance().getReference("Users")
                                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {
                                                        if(task.isSuccessful()){
                                                            Toast.makeText(signup_as_user.this,"User has been register successfully!", Toast.LENGTH_LONG).show();

                                                            nametxt.getEditText().setText("");
                                                            id_number.getEditText().setText("");
                                                            contact_number.getEditText().setText("");
                                                            email.getEditText().setText("");
                                                            password.getEditText().setText("");

                                                        }
                                                        else{
                                                            Toast.makeText(signup_as_user.this,"Failed to register! TRy again!", Toast.LENGTH_LONG).show();

                                                            nametxt.getEditText().setText("");
                                                            id_number.getEditText().setText("");
                                                            contact_number.getEditText().setText("");
                                                            email.getEditText().setText("");
                                                            password.getEditText().setText("");
                                                        }
                                                    }
                                                });
                                    } else{
                                        Toast.makeText(signup_as_user.this,"Failed to register!", Toast.LENGTH_LONG).show();

                                    }

                                }
                            });


                }
            }

        });
    }
}


