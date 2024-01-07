package com.example.medicalecare;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
public class OrderDetailsActivity extends AppCompatActivity {
   EditText name,address,contact,amount,otype;
   Button btn;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        name = findViewById(R.id.odbutton);
        address = findViewById(R.id.odtextView9);
       contact = findViewById(R.id.odlistView);
        amount= findViewById(R.id.odlistView);
        otype= findViewById(R.id.odlistView);

        btn= findViewById(R.id.odlistView);



      Intent intent = getIntent();
      String price = intent.getStringExtra("price").toString();

btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        SharedPreferences sharedPreferences = getSharedPreferences("shared_pres", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username","").toString();

        Database db = new Database(getApplicationContext(),"Healthcare",null,1);
        db.addOrder(username,address.getText().toString(),contact.getText().toString(),amount.getText().toString(),otype.getText().toString());
        startActivity(new Intent(OrderDetailsActivity.this,HomeActivity.class));
    }
});



    }
}