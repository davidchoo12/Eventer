package com.eventer.eventer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * Created by P1451298 on 10/8/2015.
 */
public class NotificationView extends RelativeLayout {
    private ImageView notificationImage;
    private TextView notificationDesc;

    public NotificationView(Context context) {
        super(context);
        init();
    }

    public NotificationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NotificationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_notification, this);
        this.notificationImage = (ImageView)this.findViewById(R.id.notification_img);
        this.notificationDesc = (TextView)this.findViewById(R.id.notification_desc);
    }

    public void setNotificationImage(Bitmap notificationImage) {
        this.notificationImage.setImageBitmap(notificationImage);
    }

    public void setNotificationDesc(String notificationDesc){
        this.notificationDesc.setText(notificationDesc);
    }

}
