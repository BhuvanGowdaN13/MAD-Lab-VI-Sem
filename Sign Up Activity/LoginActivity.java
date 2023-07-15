package com.example.signupactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText email2,password2;
    Button loginbtn;
    int count=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email2=findViewById(R.id.login_mail);
        password2=findViewById(R.id.login_password);
        loginbtn=findViewById(R.id.login);

        String registeredEmail=getIntent().getStringExtra("email");
        String registeredPassword = getIntent().getStringExtra("password");

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eEmail=email2.getText().toString();
                String ePassword = password2.getText().toString();

                if (registeredEmail.equals(eEmail) && registeredPassword.equals(ePassword)){
                    Toast.makeText(getBaseContext(),"Login Successful",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(LoginActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();
                }
                count--;
                if(count==0){
                    Toast.makeText(LoginActivity.this,"Failed Login Attempt",Toast.LENGTH_SHORT).show();
                    loginbtn.setEnabled(false);
                }

            }
        });
    }
}