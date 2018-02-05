package com.varun.project;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    Button register;
    EditText email;
    EditText password;
    EditText confirmPassword;

    String getEmail, getPassword, getConfirmPassword;

    TextView signin;

    FirebaseAuth firebaseAuth;

    ProgressDialog processDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //changing statusbar color
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.white));
        }

        firebaseAuth = FirebaseAuth.getInstance();

        processDialog = new ProgressDialog(this);

        if(firebaseAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }

        register = (Button) findViewById(R.id.register);

        email = (EditText) findViewById(R.id.RegEmail);
        password = (EditText) findViewById(R.id.RegPassword);
        signin = (TextView) findViewById(R.id.signin);
        confirmPassword = (EditText) findViewById(R.id.ConfirmPassword);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEmail = email.getText().toString().trim();
                getPassword = password.getText().toString().trim();
                getConfirmPassword = confirmPassword.getText().toString().trim();

                if(getPassword.equals(getConfirmPassword)) {
                    registerUser(getEmail, getPassword);
                }
                else{
                    Toast.makeText(Register.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });
    }


    private void registerUser(String email, String password){
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please enter your Email-ID", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please enter a Password", Toast.LENGTH_SHORT).show();
            return;
        }

        processDialog.setMessage("Please Wait...");
        processDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            processDialog.dismiss();
                            Toast.makeText(Register.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                            finish();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }
                        else {
                            processDialog.dismiss();
                            Toast.makeText(Register.this, "Could not register. Please try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}
