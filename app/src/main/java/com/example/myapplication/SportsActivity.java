package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SportsActivity extends AppCompatActivity {

    // define objects for edit text and button
    Button Sport1BTN;
    Button Sport2BTN;
    Button sendFB;
    EditText NameET;
    TextView sportname1;
    TextView sportname2;
    TextView Coachname1;
    TextView Coachname2;
    String emailsend,emailsubject,emailbody;
    SportInfo sport1, sport2;

    FirebaseDatabase database;
    DatabaseReference myRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);

        // Write a message to the database
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");


        Sport1BTN = (Button) findViewById(R.id.Sport1BTN);
        Sport2BTN = (Button) findViewById(R.id.Sport2BTN);
        sportname1= (TextView) findViewById(R.id.Sportname1);
        sportname2= (TextView) findViewById(R.id.Sportname2);
        Coachname1= (TextView) findViewById(R.id.Coachname1);
        Coachname2= (TextView) findViewById(R.id.Coachname2);
        sendFB = (Button) findViewById(R.id.SendFB);


        // Getting instance of edittext and button
        emailsend = "rahwagebrhiwe@gmail.com";
        emailsubject = "Happy to join";
        emailbody = "...";

        sport1= new SportInfo("Soccer","Blum",emailsend);
        sport2= new SportInfo("Tennis","Kelley",emailsend);
        Coachname2.setText(sport2.getCoachName());
        sportname2.setText(sport2.getSportName());
        

        // attach setOnClickListener to button with Intent object define in it
        Sport1BTN.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // define Intent object with action attribute as ACTION_SEND
                Intent intent = new Intent(Intent.ACTION_SEND);

                // add three fields to intent using putExtra function
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailsend});
                intent.putExtra(Intent.EXTRA_SUBJECT, emailsubject);
                intent.putExtra(Intent.EXTRA_TEXT, emailbody);

                // set type of intent
                intent.setType("message/rfc822");

                // startActivity with intent with chooser as Email client using createChooser function
                startActivity(Intent.createChooser(intent, "Choose an Email client :"));
            }
        });

        // attach setOnClickListener to button with Intent object define in it
        Sport1BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // define Intent object with action attribute as ACTION_SEND
                Intent intent = new Intent(Intent.ACTION_SEND);

                // add three fields to intent using putExtra function
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailsend});
                intent.putExtra(Intent.EXTRA_SUBJECT, emailsubject);
                intent.putExtra(Intent.EXTRA_TEXT, emailbody);

                // set type of intent
                intent.setType("message/rfc822");

                // startActivity with intent with chooser as Email client using createChooser function
                startActivity(Intent.createChooser(intent, "Choose an Email client :"));
            }
        });
        sendFB.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Write a message to the database

                myRef.setValue(sport1);

            }
        });



    }
}


