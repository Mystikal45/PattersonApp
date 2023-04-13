package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SportsActivity extends AppCompatActivity {

    // define objects for edit text and button
    Button BlumBTN;
    Button TbqBTN;
    EditText NameET;
    String emailsend,emailsubject,emailbody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);

        BlumBTN = (Button) findViewById(R.id.BlumBTN);

        // Getting instance of edittext and button
        emailsend = "rahwagebrhiwe@gmail.com";
        emailsubject = "Happy to join";
        emailbody = "...";

        // attach setOnClickListener to button with Intent object define in it
        BlumBTN.setOnClickListener(new View.OnClickListener() {
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


    }
}


