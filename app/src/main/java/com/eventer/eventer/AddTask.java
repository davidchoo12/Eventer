package com.eventer.eventer;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;

import com.balysv.materialmenu.MaterialMenuDrawable;

import java.util.ArrayList;


public class AddTask extends AppCompatActivity {
    private Toolbar mToolbar;
    private MaterialMenuDrawable materialMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        // to remove focus on the Event Name field, prevent keyboard from automatically popping up
        findViewById(R.id.toolbar).requestFocus();

        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button nextBtn = (Button)findViewById(R.id.next_btn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(), EventSpecificActivity.class);
                startActivity(myIntent);
            }
        });

        ListView eventList = (ListView)findViewById(R.id.checkable_member_list);
        CheckableMemberView edward = new CheckableMemberView(this);
        edward.setMemberImg(BitmapFactory.decodeResource(getResources(), R.drawable.profile_image));
        edward.setMemberName("Edward Tan");
        edward.setMemberEmail("edwardtan@gmail.com");
        edward.setChecked(true);

        ArrayList<CheckableMemberView> checkableMemberViewArrayList = new ArrayList<CheckableMemberView>();
        checkableMemberViewArrayList.add(edward);

        ViewAdapter viewAdapter = new ViewAdapter(CheckableMemberView.class, this, R.layout.view_checkable_member, checkableMemberViewArrayList);
        eventList.setAdapter(viewAdapter);

        CheckableMemberView ian = new CheckableMemberView(this);
        ian.setMemberImg(BitmapFactory.decodeResource(getResources(), R.drawable.profile_image));
        ian.setMemberName("Ian Soo");
        ian.setMemberEmail("qcaxz0@gmail.com");
        ian.setChecked(false);
        viewAdapter.add(ian);


        //remove auto focus from textfields
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

    }
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), EventSpecificActivity.class);
        startActivity(myIntent);
        return true;
    }
}