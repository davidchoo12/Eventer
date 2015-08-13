package com.eventer.eventer;

import android.content.Context;
import android.graphics.Bitmap;
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
public class CheckableMemberView extends RelativeLayout {
    private ImageView memberImg;
    private TextView memberName;
    private TextView memberEmail;
    private CheckBox checkBox;

    public CheckableMemberView(Context context) {
        super(context);
        init();
    }

    public CheckableMemberView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CheckableMemberView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_checkable_member, this);
        this.memberImg = (ImageView)this.findViewById(R.id.checkable_member_img);
        this.memberName = (TextView)this.findViewById(R.id.checkable_member_name);
        this.memberEmail = (TextView)this.findViewById(R.id.checkable_member_email);
        this.checkBox = (CheckBox)this.findViewById(R.id.checkable_member_checkbox);
    }

    public void setChecked(boolean checked){
        this.checkBox.setChecked(checked);
    }

    public void setMemberImg(Bitmap memberImg){
        this.memberImg.setImageBitmap(memberImg);
    }

    public void setMemberName(String name){
        this.memberName.setText(name);
    }

    public void setMemberEmail(String email){
        this.memberEmail.setText(email);
    }
}
