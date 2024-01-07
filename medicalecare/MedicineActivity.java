package com.example.medicalecare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MedicineActivity extends AppCompatActivity {

        private String[][] packages={
                {"Aspirin","Number of tablets: ","10","","10"},
                {"Ibuprofen","Number of tablets: ","10","","20"},
                {"Acetaminophen","Number of tablets: ","10","","15"},
                {"Ciprofloxacin","Number of tablets: ","10","","60"},
                {"Lisinopril","Number of tablets: ","10","","40"},
                {"Simvastatin","Number of tablets: ","10","","60"},
                {"Metformin","Number of tablets: ","10","","30"},
                {"Amoxicillin","Number of tablets: ","10","","60"},
                {"Omeprazole","Number of tablets: ","10","","50"},
                {"Diphenhydramine","Number of tablets: ","10","","30"} };

        private String[] package_details ={"Aspirin - Pain reliever, anti-inflammatory",
                "Ibuprofen - Pain, fever reducer, anti-inflammatory",
                "Acetaminophen - Pain, fever reducer",
                "Ciprofloxacin - Antibiotic for bacterial infections",
                "Lisinopril - Blood pressure medication",
                "Simvastatin - Cholesterol-lowering statin",
                "Metformin - Diabetes medication, controls blood sugar",
                "Amoxicillin - Antibiotic for various infections",
                "Omeprazole - Reduces stomach acid, treats heartburn",
                "Diphenhydramine - Allergy, sleep aid, antihistamine"
        };

        HashMap<String,String> item;
        ArrayList list;
        SimpleAdapter sa;
        ListView listView;
        Button btnBack,btnGoToCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);

        listView=findViewById(R.id.mdslistView);
        btnBack=findViewById(R.id.mdsbutton);
        btnGoToCard=findViewById(R.id.button3);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MedicineActivity.this,HomeActivity.class));
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

        sa = new SimpleAdapter(this,list,
                R.layout.multilines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[] {R.id.a,R.id.b,R.id.c,R.id.d,R.id.e});
        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(MedicineActivity.this,MedicineDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);

            }
        });
        btnGoToCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MedicineActivity.this,CardMedActivity.class);
                startActivity(it);
            }
        });

    }
}