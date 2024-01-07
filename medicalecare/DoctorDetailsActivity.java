package com.example.medicalecare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.medicalecare.BookAppoinmentActivity;
import com.example.medicalecare.FindDoctorActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1={
            {"Doctor Name : Soyjoy Roy","Hospital Address : Chittagong","Exp:5yrs","Mobile Number: 5454778746","600"},
            {"Doctor Name : Soyjoy Roy","Hospital Address : Chittagong","Exp:5yrs","Mobile Number: 5454778746","600"},
            {"Doctor Name : Soyjoy Roy","Hospital Address : Chittagong","Exp:5yrs","Mobile Number: 5454778746","600"},
            {"Doctor Name : Soyjoy Roy","Hospital Address : Chittagong","Exp:5yrs","Mobile Number: 5454778746","600"},
            {"Doctor Name : Soyjoy Roy","Hospital Address : Chittagong","Exp:5yrs","Mobile Number: 5454778746","600"}
    };
    private String[][] doctor_details2={
            {"Doctor Name : Soyjoy Roy","Hospital Address : Chittagong","Exp:5yrs","Mobile Number: 5454778746","600"},
            {"Doctor Name : Soyjoy Roy","Hospital Address : Chittagong","Exp:5yrs","Mobile Number: 5454778746","600"},
            {"Doctor Name : Soyjoy Roy","Hospital Address : Chittagong","Exp:5yrs","Mobile Number: 5454778746","600"},
            {"Doctor Name : Soyjoy Roy","Hospital Address : Chittagong","Exp:5yrs","Mobile Number: 5454778746","600"},
            {"Doctor Name : Soyjoy Roy","Hospital Address : Chittagong","Exp:5yrs","Mobile Number: 5454778746","600"}
    };
    private String[][] doctor_details3={
            {"Doctor Name : Soyjoy Roy","Hospital Address : Chittagong","Exp:5yrs","Mobile Number: 5454778746","600"},
            {"Doctor Name : Soyjoy Roy","Hospital Address : Chittagong","Exp:5yrs","Mobile Number: 5454778746","600"},
            {"Doctor Name : Soyjoy Roy","Hospital Address : Chittagong","Exp:5yrs","Mobile Number: 5454778746","600"},
            {"Doctor Name : Soyjoy Roy","Hospital Address : Chittagong","Exp:5yrs","Mobile Number: 5454778746","600"},
            {"Doctor Name : Soyjoy Roy","Hospital Address : Chittagong","Exp:5yrs","Mobile Number: 5454778746","600"}
    };
    private String[][] doctor_details4={
            {"Doctor Name : Soyjoy Roy","Hospital Address : Chittagong","Exp:5yrs","Mobile Number: 5454778746","600"},
            {"Doctor Name : Soyjoy Roy","Hospital Address : Chittagong","Exp:5yrs","Mobile Number: 5454778746","600"},
            {"Doctor Name : Soyjoy Roy","Hospital Address : Chittagong","Exp:5yrs","Mobile Number: 5454778746","600"},
            {"Doctor Name : Soyjoy Roy","Hospital Address : Chittagong","Exp:5yrs","Mobile Number: 5454778746","600"},
            {"Doctor Name : Soyjoy Roy","Hospital Address : Chittagong","Exp:5yrs","Mobile Number: 5454778746","600"}
    };
    private String[][] doctor_details5={
            {"Doctor Name : Soyjoy Roy","Hospital Address : Chittagong","Exp:5yrs","Mobile Number: 5454778746","600"},
            {"Doctor Name : Soyjoy Roy","Hospital Address : Chittagong","Exp:5yrs","Mobile Number: 5454778746","600"},
            {"Doctor Name : Soyjoy Roy","Hospital Address : Chittagong","Exp:5yrs","Mobile Number: 5454778746","600"},
            {"Doctor Name : Soyjoy Roy","Hospital Address : Chittagong","Exp:5yrs","Mobile Number: 5454778746","600"},
            {"Doctor Name : Soyjoy Roy","Hospital Address : Chittagong","Exp:5yrs","Mobile Number: 5454778746","600"}
    };
    private String[][] doctor_details={};
    ArrayList list;
    SimpleAdapter sa;
    HashMap<String,String> item;
    TextView tv;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        tv = findViewById(R.id.ddtextView2);
        btn = findViewById(R.id.ddbutton);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physician")==0){
            doctor_details=doctor_details1;
        }
        else  if(title.compareTo("Deitician")==0){
            doctor_details=doctor_details2;
        }
        else if(title.compareTo("Dentist")==0){
            doctor_details=doctor_details3;
        }
        else if(title.compareTo("Sergeon")==0){
            doctor_details=doctor_details4;
        }
        else{
            doctor_details=doctor_details5;
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });
        list= new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item= new HashMap<String,String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Fees; "+doctor_details[i][4]+"TK");
            list.add(item);


        }
        sa=new SimpleAdapter(this,list,R.layout.multilines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.a,R.id.b,R.id.c,R.id.d,R.id.e});
        ListView lst = findViewById(R.id.ddlistView);
        lst.setAdapter(sa);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener(){



           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this, BookAppoinmentActivity.class);
               it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][2]);
                it.putExtra("text5",doctor_details[i][3]);
               startActivity(it);
            }
        });
    }
}