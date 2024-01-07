package com.example.medicalecare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    EditText email,pass;
    TextView healthcare,login,register;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.ladd);
        pass = findViewById(R.id.lphnNbr);
        healthcare = findViewById(R.id.ltextView);
        login = findViewById(R.id.ltextView2);
        btn = findViewById(R.id.lbutton);
        register = findViewById(R.id.ltextView3);

        btn.setOnClickListener(view -> startActivity(new Intent(LoginActivity.this, HomeActivity.class)));
        register.setOnClickListener(view -> startActivity(new Intent(LoginActivity.this, RegisterActivity.class)));
    }
}