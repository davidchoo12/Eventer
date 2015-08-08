package com.eventer.eventer;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;


public class Main extends AppCompatActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }
    // method to handle screen navigations through drawer
    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        Fragment fragment;
        FragmentManager fragmentManager = getSupportFragmentManager(); // For AppCompat use getSupportFragmentManager
        switch(position) {
            default:
            case 0: //Tasks
                fragment = new TaskFragment().newInstance(1);
                break;
            case 1: //Events
                fragment = new EventsFragment().newInstance(2);
                break;
        }
        fragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction()
//                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
//                .commit();
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.events, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        protected static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }
        protected PlaceholderFragment setSectionNumber(int sectionNumber) {
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            this.setArguments(args);
            return this;
        }
        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((Main) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class EventsFragment extends PlaceholderFragment {

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static EventsFragment newInstance(int sectionNumber) {
            EventsFragment fragment = new EventsFragment();
            return (EventsFragment)fragment.setSectionNumber(sectionNumber);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_events, container, false);
            EventCard edwardsWedding = (EventCard)rootView.findViewById(R.id.edwards_wedding_card);
            edwardsWedding.setEventImage(R.drawable.event_image);
            edwardsWedding.setEventTitle("Edward's Wedding asdf");
            edwardsWedding.setEventTime("Sat, August 1, 7pm - 10pm asdf");
            edwardsWedding.setEventLoc("Marina Bay Sands asdf");
            edwardsWedding.setEventTaskCount("2 tasks : 2 todo asdf");

            EventCard test = new EventCard(getActivity());
            test.setEventImage(R.drawable.event_image);
            test.setEventTitle("Edward's Wedding test");
            test.setEventTime("Sat, August 1, 7pm - 10pm test");
            test.setEventLoc("Marina Bay Sands test");
            test.setEventTaskCount("2 tasks : 2 todo test");
            // insert into main view
            ViewGroup insertPoint = (ViewGroup) rootView.findViewById(R.id.event_list);
            insertPoint.addView(test);

            return rootView;
        }
    }

    /**
     * Task view fragment
     */
    public static class TaskFragment extends PlaceholderFragment {
        public static final int PICK_IMAGE = 1;
        View rootView;

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static TaskFragment newInstance(int sectionNumber) {
            TaskFragment fragment = new TaskFragment();
            return (TaskFragment)fragment.setSectionNumber(sectionNumber);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            rootView = inflater.inflate(R.layout.fragment_tasks, container, false);

            LayoutInflater vi = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = vi.inflate(R.layout.task_item_view, null);

// fill in any details dynamically here
            TextView textView = (TextView) v.findViewById(R.id.task_title);
            textView.setText("New Task here");

// insert into main view
            ViewGroup insertPoint = (ViewGroup) rootView.findViewById(R.id.task_list);
            insertPoint.addView(v, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//            Button btn = (Button)rootView.findViewById(R.id.btn);
//            btn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                    pickIntent.setType("image/*");
//
//                    Intent chooserIntent = Intent.createChooser(pickIntent, "Select Image");
//
//                    startActivityForResult(chooserIntent, PICK_IMAGE);
//                }
//            });
            return rootView;
        }

        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {
                if (data == null) {
                    //Display an error
                    return;
                }
                try {
                    Context context = getActivity().getApplicationContext();
                    InputStream is = context.getContentResolver().openInputStream(data.getData());
                    Bitmap bm = BitmapFactory.decodeStream(is);
                    ((ImageView)rootView.findViewById(R.id.img)).setImageBitmap(bm);
                } catch(Exception e) {
                    Toast.makeText(getActivity(), "Image not found", Toast.LENGTH_SHORT);
                }
            }
        }
    }
}
