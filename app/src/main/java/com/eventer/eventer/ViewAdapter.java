package com.eventer.eventer;

import android.app.usage.UsageEvents;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by P1451298 on 11/8/2015.
 */
public class ViewAdapter<T extends View> extends ArrayAdapter<T> {
//    private ArrayList<EventCard> eventCardList;
    private Class<T> viewClass;

    public ViewAdapter(Class<T> tClass, Context context, int textViewResourceId) {
        super(context, textViewResourceId);
        this.viewClass = tClass;
    }

    public ViewAdapter(Class<T> tClass, Context context, int resource, List<T> items) {
        super(context, resource, items);
        this.viewClass = tClass;
//        this.eventCardList = new ArrayList<EventCard>();
//        this.eventCardList.addAll(items);
    }
    public T createInstance(Context context) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException { return this.viewClass.getDeclaredConstructor(Context.class).newInstance(context); }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        T v = (T)convertView;

        if (v == null) {
            try {v = createInstance(getContext());}
            catch (Exception e) {
                Log.e("test", "create instance failed" + e.toString());}
        }

        T p = getItem(position);

        if (p != null) {
//            ImageView eventImage = (ImageView) v.findViewById(R.id.event_image);
//            TextView eventTitle = (TextView) v.findViewById(R.id.event_title);
//            TextView eventTime = (TextView) v.findViewById(R.id.event_time_text);
//            TextView eventLoc = (TextView) v.findViewById(R.id.event_location_text);
//            TextView eventTaskCount = (TextView) v.findViewById(R.id.event_task_text);
//            if (eventImage != null) {
//                v.setEventImage(((BitmapDrawable) p.getEventImage().getDrawable()).getBitmap());
//            }
//            if (eventTitle != null) {
//                v.setEventTitle(p.getEventTitle().getText().toString());
//            }
//            if (eventTime != null) {
//                v.setEventTime(p.getEventTime().getText().toString());
//            }
//            if (eventLoc != null) {
//                v.setEventLoc(p.getEventLoc().getText().toString());
//            }
//            if (eventTaskCount != null) {
//                v.setEventTaskCount(p.getEventTaskCount().getText().toString());
//            }
            v = p;
        }
        return v;
    }
    public void updateEventList(List<T> newList){
        this.clear();
        this.addAll(newList);
        this.notifyDataSetChanged();
    }
}
