package com.example.signupactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText email1,password1;
    Button signupbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email1=findViewById(R.id.login_mail);
        password1=findViewById(R.id.login_password);
        signupbtn=findViewById(R.id.login);

        signupbtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String email=email1.getText().toString();
                String password =password1.getText().toString();

                if (!ValidatePassword(password)){
                    Toast.makeText(MainActivity.this,"Password Rules Not Met", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                intent.putExtra("email",email);
                intent.putExtra("Password",password);
                startActivity(intent);

            }
        });
    }
    String regularexp="(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!]).{8,20}";
    private boolean ValidatePassword(String password){
        Pattern pattern=Pattern.compile(regularexp);
        Matcher matcher=pattern.matcher(password);
        return matcher.matches();
    }
}
