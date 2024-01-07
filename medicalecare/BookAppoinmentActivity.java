package com.example.medicalecare;

import androidx.appcompat.app.AppCompatActivity;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BookAppoinmentActivity extends AppCompatActivity {
    EditText edi1, edi2, edi3, edi4;
    TextView tv;
    Button btnBAck,btnRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appoinment);
        tv = findViewById(R.id.bktextView2);
        edi1 = findViewById(R.id.bkeditTextTextPersonName);
        edi2 = findViewById(R.id.bkadd);
        edi3 = findViewById(R.id.bkphnNbr);
        edi4 = findViewById(R.id.bkfees);

        btnBAck = findViewById(R.id.bkbutton2);
        btnRegister=findViewById(R.id.bkbutton);


        edi1.setOnKeyListener(null);
        edi2.setOnKeyListener(null);
        edi3.setOnKeyListener(null);
        edi4.setOnKeyListener(null);

        btnBAck.setOnClickListener(view -> startActivity(new Intent(BookAppoinmentActivity.this,FindDoctorActivity.class)));

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Appoinment Booked.",Toast.LENGTH_LONG ).show();
                Toast.makeText(getApplicationContext(),"We will send your appoinment schedule in your Phone number",Toast.LENGTH_LONG ).show();
            }
        });






        Intent it = getIntent();
        String title = it.getStringExtra("text1");
        String fullname = it.getStringExtra("text2");
        String address = it.getStringExtra("text3");
        String contact = it.getStringExtra("text4");
        String fees = it.getStringExtra("text5");


        tv.setText(title);
        edi1.setText(fullname);
        edi2.setText(address);
        edi3.setText(contact);
        edi4.setText(fees);
    }
}