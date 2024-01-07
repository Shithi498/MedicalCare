package com.example.medicalecare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username","").toString();

        CardView Logout =findViewById(R.id.hmcardExit);
        Logout.setOnClickListener(view -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();

            startActivity(new Intent(HomeActivity.this,LoginActivity.class));
        });


        CardView findDoctor =findViewById(R.id.hmcardFindDoctor);
        findDoctor.setOnClickListener(view -> startActivity(new Intent(HomeActivity.this,FindDoctorActivity.class)));


        CardView labTest =findViewById(R.id.hmcardLabTest);
        labTest .setOnClickListener(view -> startActivity(new Intent(HomeActivity.this,LabTestActivity.class)));


        CardView medicine =findViewById(R.id.hmcardBuyMedcinie);
        medicine.setOnClickListener(view -> startActivity(new Intent(HomeActivity.this,MedicineActivity.class)));




    }
}