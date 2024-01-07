package com.example.medicalecare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) CardView exit = findViewById(R.id.cardBack);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FindDoctorActivity.this, HomeActivity.class));
            }
        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})  CardView familyPhy = findViewById(R.id.cardfamilyPhy);
        familyPhy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent it = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
             it.putExtra("title","Family Physician");
             startActivity(it);
            }
        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})   CardView dietician = findViewById(R.id.cardDietician);
        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Dietician");
                startActivity(it);
            }
        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})  CardView dentist = findViewById(R.id.cardDentist);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Dentist");
                startActivity(it);
            }
        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})   CardView surgeon = findViewById(R.id.cardSergeon);
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Surgeon");
                startActivity(it);
            }
        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})   CardView gyno = findViewById(R.id.cardGynecologist);
        gyno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title"," gyno");
                startActivity(it);
            }
        });
    }

    private Intent createDoctorDetailsIntent(String doctorType) {
        Intent intent = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
        intent.putExtra("title", doctorType);
        return intent;
    }
}
