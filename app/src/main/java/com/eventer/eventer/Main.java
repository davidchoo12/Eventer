package com.eventer.eventer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import com.balysv.materialmenu.MaterialMenuDrawable;

import java.util.Calendar;
import java.util.GregorianCalendar;


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
    private MaterialMenuDrawable materialMenu;
    private Toolbar mToolbar;
    public static Context baseContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        baseContext = getApplicationContext();
        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                // Handle your drawable state here
                materialMenu.animateIconState(MaterialMenuDrawable.IconState.BURGER);
            }
        });
        materialMenu = new MaterialMenuDrawable(this, Color.WHITE, MaterialMenuDrawable.Stroke.THIN);
        mToolbar.setNavigationIcon(materialMenu);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout),
                mToolbar);

    }

    // method to handle screen navigations through drawer
    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        Fragment fragment = new ProfileFragment().newInstance(4);
        FragmentManager fragmentManager = getSupportFragmentManager(); // For AppCompat use getSupportFragmentManager
        switch(position) {
            default:
            case 0: //Tasks
                fragment = new TasksFragment().newInstance(1);
                break;
            case 1: //Events
                fragment = new EventsFragment().newInstance(2);
                break;
            case 2: //Notifications
                fragment = new NotificationsFragment().newInstance(3);
                break;
            case 3: //Profile
//                LayoutInflater vi = LayoutInflater.from(this);
//                View v = vi.inflate(R.layout.toolbar_profile, null);
//                ViewGroup.LayoutParams lp = mToolbar.getLayoutParams();
//                lp.height = dpToPx(128);
//                mToolbar.setLayoutParams(lp);
//                mToolbar.addView(v);
                mToolbar.setVisibility(View.GONE);
                findViewById(R.id.toolbar_profile).setVisibility(View.VISIBLE);
                fragment = new ProfileFragment().newInstance(4);
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
            case 4:
                mTitle = getString(R.string.title_section4);
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

    public void openEventSpecificActivity(View eventCard){
        Intent intent = new Intent(this, EventSpecificActivity.class);
        startActivity(intent);
    }
    /**
     * Task view fragment
     */
    public static class TasksFragment extends PlaceholderFragment {
        View rootView;

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static TasksFragment newInstance(int sectionNumber) {
            TasksFragment fragment = new TasksFragment();
            return (TasksFragment)fragment.setSectionNumber(sectionNumber);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            rootView = inflater.inflate(R.layout.fragment_tasks, container, false);

//            LayoutInflater vi = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            View v = vi.inflate(R.layout.view_task, null);

//            // fill in any details dynamically here
//            TextView textView = (TextView) v.findViewById(R.id.task_title);
//            textView.setText("New Task here");
//
//            // insert into main view
//            ViewGroup insertPoint = (ViewGroup) rootView.findViewById(R.id.task_list);
//            insertPoint.addView(v, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            TaskView taskView = new TaskView(getActivity());
            taskView.setTaskTitle("Test task");
            taskView.setTaskDesc("Task description right here lorem ipsum. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
            taskView.setChecked(true);
            taskView.setTaskDate(new GregorianCalendar(2015, Calendar.JULY, 11, 15, 10));
            // insert into main view
            ViewGroup insertPoint = (ViewGroup) rootView.findViewById(R.id.task_list);
            insertPoint.addView(taskView);

            return rootView;
        }
    }


    /**
     * Notification view fragment
     */
    public static class NotificationsFragment extends PlaceholderFragment {
        public static final int PICK_IMAGE = 1;
        View rootView;

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static NotificationsFragment newInstance(int sectionNumber) {
            NotificationsFragment fragment = new NotificationsFragment();
            return (NotificationsFragment)fragment.setSectionNumber(sectionNumber);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            rootView = inflater.inflate(R.layout.fragment_notifications, container, false);

            NotificationView notificationView = new NotificationView(getActivity());
            notificationView.setNotificationDesc("Notification description right here lorem ipsum. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
            notificationView.setNotificationImage(BitmapFactory.decodeResource(getResources(),R.drawable.event_image));
            // insert into main view
            ViewGroup insertPoint = (ViewGroup) rootView.findViewById(R.id.task_list);
            insertPoint.addView(notificationView);
            return rootView;
        }
    }

    /**
     * Profile view fragment
     */
    public static class ProfileFragment extends PlaceholderFragment {
        View rootView;

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static ProfileFragment newInstance(int sectionNumber) {
            ProfileFragment fragment = new ProfileFragment();
            return (ProfileFragment)fragment.setSectionNumber(sectionNumber);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            rootView = inflater.inflate(R.layout.fragment_profile, container, false);
            return rootView;
        }

        @Override
        public void onDestroyView() {
            //TODO: fix the extended toolbar, ultimate way is to just add a green box with the image and profile into the fragment_profile or make profile screen as new activity
            super.onDestroyView();
//            Toolbar tb = ((Toolbar)getActivity().findViewById(R.id.toolbar));
//            tb.removeView(LayoutInflater.from(getActivity()).inflate(R.layout.toolbar_profile, null));
//            ViewGroup.LayoutParams lp = tb.getLayoutParams();
//            lp.height = dpToPx(56);
//            tb.setLayoutParams(lp);
//            ((Main)getActivity()).restoreActionBar();
            getActivity().findViewById(R.id.toolbar).setVisibility(View.VISIBLE);
            getActivity().findViewById(R.id.toolbar_profile).setVisibility(View.GONE);
        }
    }

    public static int dpToPx(int dp) {
        DisplayMetrics displayMetrics = baseContext.getResources().getDisplayMetrics();
        return (int)((dp * displayMetrics.density) + 0.5);
    }
}
