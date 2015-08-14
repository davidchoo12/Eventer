package com.eventer.eventer;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by P1451298 on 10/8/2015.
 */
public class CheckableMemberView extends RelativeLayout {
    private ImageView memberImg;
    private TextView memberName;
    private TextView memberEmail;
    private CheckBox checkBox;
    private Context context1;

    public CheckableMemberView(Context context) {
        super(context);
        this.context1 = context;
        init();
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context1, "Checkable Member View tapped", Toast.LENGTH_SHORT);
            }
        });
    }

    public CheckableMemberView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context1, "Checkable Member View tapped", Toast.LENGTH_SHORT);
            }
        });
    }

    public CheckableMemberView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context1, "Checkable Member View tapped", Toast.LENGTH_SHORT);
            }
        });
    }

    private void init() {
        inflate(getContext(), R.layout.view_checkable_member, this);
        this.memberImg = (ImageView) this.findViewById(R.id.checkable_member_img);
        this.memberName = (TextView) this.findViewById(R.id.checkable_member_name);
        this.memberEmail = (TextView) this.findViewById(R.id.checkable_member_email);
        this.checkBox = (CheckBox) this.findViewById(R.id.checkable_member_checkbox);
    }

    public void setChecked(boolean checked) {
        this.checkBox.setChecked(checked);
    }

    public void setMemberImg(Bitmap memberImg) {
        this.memberImg.setImageBitmap(memberImg);
    }

    public void setMemberName(String name) {
        this.memberName.setText(name);
    }

    public void setMemberEmail(String email) {
        this.memberEmail.setText(email);
    }
}
