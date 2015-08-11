package com.eventer.eventer;

import android.app.usage.UsageEvents;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by P1451298 on 11/8/2015.
 */
public class EventAdapter extends ArrayAdapter<EventCard> {
//    private ArrayList<EventCard> eventCardList;

    public EventAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public EventAdapter(Context context, int resource, List<EventCard> items) {
        super(context, resource, items);
//        this.eventCardList = new ArrayList<EventCard>();
//        this.eventCardList.addAll(items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        EventCard v = (EventCard)convertView;

        if (v == null) {
            v = new EventCard(getContext());
        }

        EventCard p = getItem(position);

        if (p != null) {
            ImageView eventImage = (ImageView) v.findViewById(R.id.event_image);
            TextView eventTitle = (TextView) v.findViewById(R.id.event_title);
            TextView eventTime = (TextView) v.findViewById(R.id.event_time_text);
            TextView eventLoc = (TextView) v.findViewById(R.id.event_location_text);
            TextView eventTaskCount = (TextView) v.findViewById(R.id.event_task_text);
            if (eventImage != null) {
                v.setEventImage(((BitmapDrawable) p.getEventImage().getDrawable()).getBitmap());
            }
            if (eventTitle != null) {
                v.setEventTitle(p.getEventTitle().getText().toString());
            }
            if (eventTime != null) {
                v.setEventTime(p.getEventTime().getText().toString());
            }
            if (eventLoc != null) {
                v.setEventLoc(p.getEventLoc().getText().toString());
            }
            if (eventTaskCount != null) {
                v.setEventTaskCount(p.getEventTaskCount().getText().toString());
            }
        }
        return v;
    }
    public void updateEventList(List<EventCard> newList){
        this.clear();
        this.addAll(newList);
        this.notifyDataSetChanged();
    }
}
