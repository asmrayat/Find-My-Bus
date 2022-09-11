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
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login_as_user extends AppCompatActivity {

    TextView signup;
    private TextInputEditText con_userfield;
    private TextInputEditText con_passfield;
    Button userLogbtn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_as_user);

        con_userfield = (TextInputEditText) findViewById(R.id.txtuser) ;
        con_passfield = (TextInputEditText) findViewById(R.id.txtpass) ;
        userLogbtn = (Button) findViewById(R.id.u_logbtn);
        mAuth = FirebaseAuth.getInstance();

        userLogbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = con_userfield.getText().toString().trim();
                String pass =  con_passfield.getText().toString().trim();

                if(email.isEmpty()){
                    con_userfield.setError("Email cannot be empty");
                    con_userfield.requestFocus();
                } else if(pass.isEmpty()){
                    con_passfield.setError("Email cannot be empty");
                    con_passfield.requestFocus();
                }else {

                    mAuth.signInWithEmailAndPassword(email, pass)
                            .addOnCompleteListener(login_as_user.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Intent myIntent = new Intent(login_as_user.this, signup_as_admin.class);
                                        startActivity(myIntent);
                                        con_passfield.setText("");
                                        con_userfield.setText("");

                                    } else {
                                        // If sign in fails, display a message to the user.
                                        con_passfield.setText("");
                                        con_userfield.setText("");
                                        Toast.makeText(getApplicationContext(),"Invalid Email or Password",Toast.LENGTH_LONG).show();
                                    }
                                }
                            });

                }

            }
        });

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