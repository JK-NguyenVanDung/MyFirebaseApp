package com.example.myfirebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {
    EditText email,password;
    TextView message;
    Button register,login,forgotPassword,cancel;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        matching();

        auth = FirebaseAuth.getInstance();
        if(auth.getCurrentUser() != null) {
        }else {
            login.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    String strEmail = email.getText().toString().trim();
                    String strPassword = password.getText().toString().trim();
                    if (TextUtils.isEmpty(strEmail)) {
                        message.setText("Enter email address!");
                        return;
                    }
                    if (TextUtils.isEmpty(strPassword)) {
                        message.setText("Enter password!");
                        return;
                    }
                    if (strPassword.length() < 6) {
                        message.setText("Password too short, enter minimum 6 characters");
                        return;
                    }
                    auth.signInWithEmailAndPassword(strEmail, strPassword).addOnCompleteListener(SignInActivity.this, new OnCompleteListener<AuthResult>() {

                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                message.setText(task.getException().toString());
                            } else {
                                Toast.makeText(SignInActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(SignInActivity.this, MainActivity.class));
                                finish();
                            }
                        }
                    });
                }
            });
        }
        forgotPassword.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

            }
        });
        cancel.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

            }
        });
    }

    public void matching(){
        email = findViewById(R.id.signIn_et_email);
        password = findViewById(R.id.signIn_et_password);
        message = findViewById(R.id.signIn_tv_error);
        register = findViewById(R.id.signIn_btn_register);
        login = findViewById(R.id.signIn_btn_login);
        forgotPassword = findViewById(R.id.signIn_btn_forgot_password);
        cancel = findViewById(R.id.signIn_btn_cancel);
    }
}