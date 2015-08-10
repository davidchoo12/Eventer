package com.eventer.eventer;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.ref.WeakReference;

/**
 * Created by P1451298 on 8/8/2015.
 */
public class EventCard extends CardView {

    private ImageView eventImage;
    private TextView eventTitle;
    private TextView eventTime;
    private TextView eventLoc;
    private TextView eventTaskCount;

    public EventCard(Context context) {
        super(context);
        init();
    }

    public EventCard(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EventCard(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        this.setRadius(16);
        inflate(getContext(), R.layout.view_event, this);
        this.eventImage = (ImageView)findViewById(R.id.event_image);
        this.eventTitle = (TextView)findViewById(R.id.event_title);
        this.eventTime = (TextView)findViewById(R.id.event_time_text);
        this.eventLoc = (TextView)findViewById(R.id.event_location_text);
        this.eventTaskCount = (TextView)findViewById(R.id.event_task_text);
    }


    public void setEventImage(int resourceId){
        this.setPreventCornerOverlap(false);
//        BitmapWorkerTask task = new BitmapWorkerTask(this.eventImage);
//        task.execute(resourceId);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resourceId);
        bitmap = ImageHelper.getRoundedCornerBitmap(bitmap, (int)this.getRadius()*2);
        this.eventImage.setImageBitmap(bitmap);
    }
    public void setEventTitle(String eventTitle) {
        this.eventTitle.setText(eventTitle);
    }

    public void setEventTime(String eventTime) {
        this.eventTime.setText(eventTime);
    }

    public void setEventLoc(String eventLoc) {
        this.eventLoc.setText(eventLoc);
    }

    public void setEventTaskCount(String eventTaskCount) {
        this.eventTaskCount.setText(eventTaskCount);
    }



    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }
    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }
    class BitmapWorkerTask extends AsyncTask<Integer, Void, Bitmap> {
        private final WeakReference<ImageView> imageViewReference;
        private int data = 0;

        public BitmapWorkerTask(ImageView imageView) {
            // Use a WeakReference to ensure the ImageView can be garbage collected
            imageViewReference = new WeakReference<ImageView>(imageView);
        }

        // Decode image in background.
        @Override
        protected Bitmap doInBackground(Integer... params) {
            data = params[0];
            return BitmapFactory.decodeResource(getResources(), data);
        }

        // Once complete, see if ImageView is still around and set bitmap.
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (imageViewReference != null && bitmap != null) {
                final ImageView imageView = imageViewReference.get();
                if (imageView != null) {
                    ImageHelper.getRoundedCornerBitmap(bitmap, 16);
                    imageView.setImageBitmap(bitmap);
                }
            }
        }
    }
}
