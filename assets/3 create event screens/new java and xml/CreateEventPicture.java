package com.lamxw2.login;

/**
 * Create New Event, Add Picture screen
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class CreateEventPicture extends AppCompatActivity implements OnClickListener{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_event_picture);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Skip button view
        View skipBtn = findViewById(R.id.________);
        skipBtn.OnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id._____:
                Intent i = new Intent(this, CreateEventInvMembers.class);
                startActivity(i);
                break;
        }

    }

}
