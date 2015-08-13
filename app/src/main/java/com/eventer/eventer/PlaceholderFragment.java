package com.eventer.eventer;

/**
 * Created by P1451298 on 12/8/2015.
 */

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    protected static final String ARG_SECTION_NUMBER = "section_number";
    protected View rootView;
    protected PlaceholderFragmentAttachedListener placeholderFragmentAttachedListener;

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
        try {
            placeholderFragmentAttachedListener = (PlaceholderFragmentAttachedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement PlaceholderFragmentAttachedListener.");
        }
        if (placeholderFragmentAttachedListener != null)
            placeholderFragmentAttachedListener.onAttachPlaceholderFragment(getArguments().getInt(ARG_SECTION_NUMBER));
    }
    protected void unbindDrawables(View view) {
        if (view.getBackground() != null) {
            view.getBackground().setCallback(null);
        }
        if (view instanceof ViewGroup && !(view instanceof ListView)) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                unbindDrawables(((ViewGroup) view).getChildAt(i));
            }
            ((ViewGroup) view).removeAllViews();
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        unbindDrawables(rootView);
        System.gc();
    }
    /**
     * Callbacks interface that all activities using this fragment must implement.
     */
    public static interface PlaceholderFragmentAttachedListener {
        /**
         * Called when the PlaceholderFragment is attached.
         */
        void onAttachPlaceholderFragment(int sectionNumber);
    }
}