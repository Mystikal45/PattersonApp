package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button seniorBTN;
    Button mentalBTN;
    Button lunchBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seniorBTN = (Button) findViewById(R.id.seniorBTN);
        mentalBTN = (Button) findViewById(R.id.mentalBTN);
        lunchBTN = (Button) findViewById(R.id.lunchBTN);

        seniorBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, SeniorActivity.class);

                startActivity(myIntent);
            }
        });
        mentalBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, MentalActivity.class);

                startActivity(myIntent);
            }
        });
        lunchBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, LunchActivity.class);
            }
        });

    }
}