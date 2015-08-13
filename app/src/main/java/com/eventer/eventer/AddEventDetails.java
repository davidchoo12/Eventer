package com.eventer.eventer;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TimePicker;

import com.balysv.materialmenu.MaterialMenuDrawable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class AddEventDetails extends AppCompatActivity {
    private Toolbar mToolbar;
    private MaterialMenuDrawable materialMenu;
    private Calendar calendar = Calendar.getInstance();
    private DatePickerDialog.OnDateSetListener dateSetListener;
    private TimePickerDialog.OnTimeSetListener timeSetListener;
    private View datePickerCaller;
    private final String DATEFORMAT = "EEE, MMM d, yyyy";
    private final String TIMEFORMAT = "h:mm aaa";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event_details);
        // to remove focus on the Event Name field, prevent keyboard from automatically popping up
        findViewById(R.id.toolbar).requestFocus();

        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button nextBtn = (Button)findViewById(R.id.next_btn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(), CreateEventPicture.class);
                startActivity(myIntent);
            }
        });


        dateSetListener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updatePickerButton(true);
            }
        };
        timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                calendar.set(Calendar.MINUTE, minute);
                updatePickerButton(false);
            }
        };

        View.OnClickListener datePickerListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(AddEventDetails.this, dateSetListener, calendar
                        .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
                datePickerCaller = v;
            }
        };
        View.OnClickListener timePickerListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new TimePickerDialog(AddEventDetails.this, timeSetListener, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false).show();
                datePickerCaller = v;
            }
        };


        Button startDateBtn = (Button)findViewById(R.id.start_date_btn);
        Button endDateBtn = (Button)findViewById(R.id.end_date_btn);
        Button startTimeBtn = (Button)findViewById(R.id.start_time_btn);
        Button endTimeBtn = (Button)findViewById(R.id.end_time_btn);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        startDateBtn.setText(new SimpleDateFormat(DATEFORMAT).format(calendar.getTime()));
        endDateBtn.setText(new SimpleDateFormat(DATEFORMAT).format(calendar.getTime()));
        startTimeBtn.setText(new SimpleDateFormat(TIMEFORMAT).format(calendar.getTime()));
        calendar.add(Calendar.HOUR_OF_DAY, 1);
        endTimeBtn.setText(new SimpleDateFormat(TIMEFORMAT).format(calendar.getTime()));
        startDateBtn.setOnClickListener(datePickerListener);
        endDateBtn.setOnClickListener(datePickerListener);
        startTimeBtn.setOnClickListener(timePickerListener);
        endTimeBtn.setOnClickListener(timePickerListener);
//        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override public void onClick(View v) {
//                // Handle your drawable state here
//                materialMenu.animateIconState(MaterialMenuDrawable.IconState.BURGER);
//            }
//        });
//        materialMenu = new MaterialMenuDrawable(this, Color.WHITE, MaterialMenuDrawable.Stroke.THIN);
//        mToolbar.setNavigationIcon(materialMenu);
    }

    private void updatePickerButton(boolean isDatePickerButton) {
        String myFormat = isDatePickerButton ? DATEFORMAT : TIMEFORMAT; //select between date format or time format
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        ((Button)datePickerCaller).setText(sdf.format(calendar.getTime()));
    }
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), Main.class);
        myIntent.putExtra(Main.SECTION, Main.Section.EVENT.name());
        startActivity(myIntent);
        return true;
    }
}