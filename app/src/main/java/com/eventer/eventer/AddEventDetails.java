package com.eventer.eventer;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.balysv.materialmenu.MaterialMenuDrawable;


public class AddEventDetails extends ActionBarActivity {
    private Toolbar mToolbar;
    private MaterialMenuDrawable materialMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event_details);

        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button nextBtn = (Button)findViewById(R.id.next_btn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(), Main.class);
                myIntent.putExtra(Main.SECTION, Main.Section.EVENT.name());
                startActivity(myIntent);
                startActivity(myIntent);
            }
        });
//        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override public void onClick(View v) {
//                // Handle your drawable state here
//                materialMenu.animateIconState(MaterialMenuDrawable.IconState.BURGER);
//            }
//        });
//        materialMenu = new MaterialMenuDrawable(this, Color.WHITE, MaterialMenuDrawable.Stroke.THIN);
//        mToolbar.setNavigationIcon(materialMenu);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), Main.class);
        myIntent.putExtra(Main.SECTION, Main.Section.EVENT.name());
        startActivity(myIntent);
        return true;
    }
}