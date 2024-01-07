package com.example.medicalecare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MedicineDetailsActivity extends AppCompatActivity {
    TextView tvPackageName,tvTotalCost;
    EditText edetails;
    Button btnBack,btnAddtoCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_details);
        tvPackageName=findViewById(R.id.mdtextView4);
        edetails=findViewById(R.id.mdeditTextTextPersonName2);
        tvTotalCost=findViewById(R.id.mdtextView6);
        btnBack=findViewById(R.id.mdbutton);
        btnAddtoCard=findViewById(R.id.mdbutton3);



        edetails.setKeyListener(null);

        Intent it = getIntent();
        tvPackageName.setText(it.getStringExtra("text1"));
        edetails.setText(it.getStringExtra("text2"));
        tvTotalCost.setText("Total Cost: " + it.getStringExtra("text3"));
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MedicineDetailsActivity.this, MedicineActivity.class));

            }
        });

        btnAddtoCard.setOnClickListener(new View.OnClickListener() {
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
                    db.addcart(username, product, price, "medicine");
                    Toast.makeText(getApplicationContext(), "Product added to the card.", Toast.LENGTH_LONG).show();
                }
                startActivity(new Intent(MedicineDetailsActivity.this,MedicineActivity.class));
            }

        });
    }
}