package com.example.medicalecare;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Pattern;
public class CardMedActivity extends AppCompatActivity{
    HashMap<String,String> item;
    ArrayList list;
    ListView listView;
    SimpleAdapter sa;
    TextView tvTotal;
    Button btnConfirm,btnBack;

    private String[][] packages ={};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_med);

        btnConfirm = findViewById(R.id.cmbutton3);
        btnBack=findViewById(R.id.cmbutton);
        tvTotal=findViewById(R.id.cmtextView8);
        listView=findViewById(R.id.cmlistView1);
        list = new ArrayList();



                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs",Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username","").toString();


                Database db = new Database(getApplicationContext(),"healthcare",null,1);

                float totalAmount =0;
                ArrayList dbData = db.getCartData(username,"medicine");



                packages = new String[dbData.size()][];

                for(int i=0; i<packages.length;i++){
                    packages[i] = new String[5];
                }

                for(int i=0;i<dbData.size();i++){
                    String arrData = dbData.get(i).toString();

                    String[] strData = arrData.split(java.util.regex.Pattern.quote("$"));
                    packages[i][0] = strData[0];
                    packages[i][4] = "Cost : "+strData[1]+"/-";
                    totalAmount= totalAmount+Float.parseFloat(strData[1]);
                }

                tvTotal.setText("Total Cost: "+totalAmount);

        for(int i=0;i<packages.length;i++) {
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", packages[i][4]);
            list.add(item);
        }
            sa= new SimpleAdapter(this,list,R.layout.multilines,new String[]{"line1","line2","line3","line4","line5"},
                    new int[]{R.id.a,R.id.b,R.id.c,R.id.d,R.id.e});
            // ListView listView=findViewById(R.id.listView);
            listView.setAdapter(sa);



            btnBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(CardMedActivity.this,HomeActivity.class));
                }
            });
        }


    }















