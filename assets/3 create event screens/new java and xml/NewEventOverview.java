package com.lamxw2.login;

// New event overview

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class NewEventOverview extends AppCompatActivity implements OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_event_overview);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    // Skip button view
        View skipBtn = findViewById(R.id.________);
        skipBtn.OnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id._____:
                Intent i = new Intent(this, ______.class);
                startActivity(i);
                break;
        }
    }

}
