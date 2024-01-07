package com.example.medicalecare;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {
    private String[][] packages = {
            {" Full Body Checkup","","Details","","999"},
            {" Covid-19 test","","Details","","299"},
            {" Thyroid Check","","Details","","899"},
            {" Imunity Check","","Details","","499"},
            {" Full Body Checkup","","Details","","699"}

    };


    private String[] package_details= {
            "Blood Glucose Fasting\n"+"HaA1c\n"+"Iron Studies\n"+"Kidney Function Test\n"+
                    "LDH Lactete Dehydrogense\n"+"Lipide Profile\n"+"Liver Profile\n"+
                    "Liver Functionn Test\n","Blood Glucose Fasting\n",
            "COVID-19 Antibody_IgG\n","Thyroid Profile\n",
            "Complete Hemogram"
    };

    HashMap<String,String> item;
    ArrayList list;

    SimpleAdapter sa;

    Button btnGoToCard,btnBack;

    ListView listView;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        btnGoToCard = findViewById(R.id.ltbutton3);
        btnBack = findViewById(R.id.ltbutton);
        listView = findViewById(R.id.ltlistView1);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this, HomeActivity.class));
            }
        });

    list=new ArrayList();
        for(int i=0;i<packages.length;i++){
        item= new HashMap<String,String>();
        item.put("line1",packages[i][0]);
        item.put("line2",packages[i][1]);
        item.put("line3",packages[i][2]);
        item.put("line4",packages[i][3]);
        item.put("line5","Total cost: "+packages[i][4]+"/-");
        list.add(item);
    }

    sa = new SimpleAdapter(this,list,R.layout.multilines,new String[]{"line1","line2","line3","line4","line5"},
            new int[] {R.id.a,R.id.b,R.id.c,R.id.d,R.id.e});
        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Intent it = new Intent(LabTestActivity.this,LabTestDetailsActivity.class);
            it.putExtra("text1",packages[i][0]);
            it.putExtra("text2",package_details[i]);
            it.putExtra("text3",packages[i][4]);
            startActivity(it);

        }
    });
        btnGoToCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(LabTestActivity.this,CardLabActivity.class);
                startActivity(it);
            }
        });

    }
    }
