package com.example.medicalecare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class LabTestDetailsActivity extends AppCompatActivity {
    TextView tvPackageName, tvTotalCost;
    EditText eDetails;
    Button btnAddToCart, btnBAck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_details);

        tvPackageName = findViewById(R.id.ltdtextView4);
        tvTotalCost = findViewById(R.id.ltdtextView5);
        eDetails = findViewById(R.id.ltdeditText);
        btnAddToCart = findViewById(R.id.ltdbutton3);
        btnBAck = findViewById(R.id.ltdbutton);

        eDetails.setKeyListener(null);

        Intent it = getIntent();
        tvPackageName.setText(it.getStringExtra("text1"));
        eDetails.setText(it.getStringExtra("text2"));
        tvTotalCost.setText("Total Cost: " + it.getStringExtra("text3"));
        btnBAck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestDetailsActivity.this, LabTestActivity.class));

            }
        });

       btnAddToCart.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
             SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs",Context.MODE_PRIVATE);
             String username = sharedPreferences.getString("username","").toString();
             String product =   tvPackageName.getText().toString();
             float price = Float.parseFloat(it.getStringExtra("text3").toString());
             Database db = new Database(getApplicationContext(),"healthcare",null,1);
             if(db.checkCart(username,product)==1){
                 Toast.makeText(getApplicationContext(),"Product Already added.",Toast.LENGTH_LONG).show();

             }else {
                 db.addcart(username, product, price, "lab");
                 Toast.makeText(getApplicationContext(), "Product added to the cart.", Toast.LENGTH_LONG).show();
             }
                 startActivity(new Intent(LabTestDetailsActivity.this,LabTestActivity.class));
             }

    });
    }
}