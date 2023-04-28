package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DelaysActivity extends AppCompatActivity {

    Button B1, B2;
    TextView Tv1, Tv2;
    DayOff day1;
    String date1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delays);

        B1 = (Button) findViewById(R.id.B1);
        B2 = (Button) findViewById(R.id.B2);
        Tv1 = (TextView) findViewById(R.id.Tv1);
        Tv2 = (TextView) findViewById(R.id.Tv2);
        day1 = new DayOff(4, 21,23, "teacher meeting day");
        date1 = day1.getMonth() + "/" + day1.getDay() + "/" + day1.getYear();

        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tv1.setText("SAT Day for 11th graders");
            }
        });
        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tv2.setText("Spring Break");
            }
        });

    }
}