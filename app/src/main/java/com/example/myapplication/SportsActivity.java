package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SportsActivity extends AppCompatActivity {

    // define objects for edit text and button
    Button Sport1BTN;
    Button Sport2BTN;
    Button Sport3BTN;
    Button sendFB;
    EditText NameET;
    TextView sportname1;
    TextView sportname2;
    TextView Coachname1;
    TextView Coachname2;
    TextView sportname3;
    TextView coachname3;
    String emailsend,emailsubject,emailbody;
    SportInfo sport1, sport2,anysport;

    FirebaseDatabase database;
    DatabaseReference myRef;
    ArrayList<SportInfo> listsport;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);

        // Write a message to the database
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");


        Sport1BTN = (Button) findViewById(R.id.Sport1BTN);
        Sport2BTN = (Button) findViewById(R.id.Sport2BTN);
        Sport3BTN = (Button)findViewById(R.id.Sport3BTN);
        sportname1= (TextView) findViewById(R.id.Sportname1);
        sportname2= (TextView) findViewById(R.id.Sportname2);
        Coachname1= (TextView) findViewById(R.id.Coachname1);
        Coachname2= (TextView) findViewById(R.id.Coachname2);
        sendFB = (Button) findViewById(R.id.SendFB);
        sportname3= (TextView) findViewById(R.id.sportname3);
        coachname3= (TextView) findViewById(R.id.coachname3);
        // Getting instance of edittext and button
        emailsend = "rahwagebrhiwe@gmail.com";
        emailsubject = "Happy to join";
        emailbody = "...";

        sport1= new SportInfo("Soccer","Blum",emailsend);
        sport2= new SportInfo("Tennis","Kelley",emailsend);
        Coachname2.setText(sport2.getCoachName());
        sportname2.setText(sport2.getSportName());

        listsport= new ArrayList<SportInfo>();
        

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
                String key = myRef.push().getKey();
                myRef.child(key).setValue(sport1);

                // Read from the database
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        // Iterate through all the children in the snapshot
                        for (DataSnapshot SportSnapShot : dataSnapshot.getChildren()) {
                            //From our snapshot, get the value of our key/value pair. This value
                            //contains a SportInfo object
                            SportInfo newsport = SportSnapShot.getValue(SportInfo.class);
                            listsport.add(newsport);

                        }

                        anysport=listsport.get(0);
                        sportname3.setText(anysport.getSportName());
                        coachname3.setText(anysport.getCoachName());

                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("FAILEDTOREAD", "Failed to read value.", error.toException());
                    }
                });
            }
        });



    }
}


