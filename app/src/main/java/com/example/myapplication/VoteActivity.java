package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class VoteActivity extends AppCompatActivity {
    TextView dayOfWeekTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);
        dayOfWeekTV = (TextView) findViewById(R.id.dayOfWeekTV);
        Intent myIntent = getIntent();
        String dayOfWeek = myIntent.getStringExtra("dayOfWeek");
        dayOfWeekTV.setText(dayOfWeek);

    }

}