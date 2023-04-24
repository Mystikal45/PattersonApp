package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LunchActivity extends AppCompatActivity {
    Button mondayVote;
    Button tuesdayVote;
    Button wednesdayVote;
    Button thursdayVote;
    Button fridayVote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch);

        mondayVote = (Button) findViewById(R.id.mondayVote);
        tuesdayVote = (Button) findViewById(R.id.tuesdayVote);
        wednesdayVote = (Button) findViewById(R.id.wednesdayVote);
        thursdayVote = (Button) findViewById(R.id.thursdayVote);
        fridayVote = (Button) findViewById(R.id.fridayVote);

        mondayVote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(LunchActivity.this, VoteActivity.class);
            public intent putExtra(String, 5 )
                startActivity(myIntent);
            }

        });
    }
}