package com.example.medicalecare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText Name,email,pass,Cpass;
    TextView healthcare,register;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Name=findViewById(R.id.rName);
        email=findViewById(R.id.rEmail);
        pass=findViewById(R.id.rPass);
        Cpass=findViewById(R.id.rCPass);
        healthcare=findViewById(R.id.rtextView);

        btn=findViewById(R.id.rbutton);


       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

                   String name = Name.getText().toString();
                   String Email = email.getText().toString();
                   String Pass = pass.getText().toString();
                   String cPass = Cpass.getText().toString();

               Database db = new Database(getApplicationContext(),"healthcare",null,1);

               if(name.length()==0 || Email.length()==0 || Pass.length()==0 || cPass.length()==0){
                   Toast.makeText(RegisterActivity.this, "Please Enter name,email,password & Confirm password", Toast.LENGTH_SHORT).show();
               }
               else if(Pass.compareTo(cPass)==0){
                    if(isValid(Pass)){

                        db.register(name,Email,Pass);
                        Toast.makeText(RegisterActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    }
                    else{
                        Toast.makeText(RegisterActivity.this, "Invalid password", Toast.LENGTH_SHORT).show();
                    }
               }
               else{
                   Toast.makeText(RegisterActivity.this, "Password & Confirm password aren't matched", Toast.LENGTH_SHORT).show();
               }
              

               }
       });


    }
    public static boolean isValid(String pass){
        int f1=0,f2=0,f3=0;
        if(pass.length()<8){
            return false;
        }
        else{
            for(int p=0;p<pass.length();p++){
                if(Character.isLetter(pass.charAt(p))){
                    f1=1;
                }
            }
            for(int p=0;p<pass.length();p++){
                if(Character.isDigit(pass.charAt(p))){
                    f2=1;
                }
            }
            for(int p=0;p<pass.length();p++){
                char c = pass.charAt(p);
                if(c>=33&&c<=46||c==64){
                    f3=1;
                }
            }
            if(f1==1 && f2==1 && f3==1){
                return true;
            }
            return false;
        }
    }
}