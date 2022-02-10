package com.example.lifeline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignupActivity extends AppCompatActivity {
    Button sign_up;
    private FirebaseAuth mAuth;
    EditText edt_email,edt_pass;

    @Override
    public void onStart()
    {
        super.onStart();
        FirebaseUser currnetUser = mAuth.getCurrentUser();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth = FirebaseAuth.getInstance();

        edt_email = findViewById(R.id.edt_email);
        edt_pass = findViewById(R.id.edt_pass);
        sign_up = findViewById(R.id.btn_signup);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = edt_email.getText().toString().trim();
                String pass = edt_pass.getText().toString().trim();

                mAuth.createUserWithEmailAndPassword(email,pass)
                        .addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()) {
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Toast.makeText(SignupActivity.this,"Sign up Success",Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(SignupActivity.this,DonorActivity.class));
                                }
                                else{
                                    Toast.makeText(SignupActivity.this,"Sign Up Not Success",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

    }
}