package com.eventer.eventer;

import android.content.Context;
import android.support.v4.widget.TextViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by P1451298 on 10/8/2015.
 */
public class TaskView extends RelativeLayout {
    private CheckBox taskCheckbox;
    private TextView taskTitle;
    private TextView taskDesc;
    private TextView taskDate;

    public TaskView(Context context) {
        super(context);
        init();
    }

    public TaskView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TaskView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_task, this);
        this.taskCheckbox = (CheckBox)this.findViewById(R.id.task_checkbox);
        this.taskTitle = (TextView)this.findViewById(R.id.task_title);
        this.taskDesc = (TextView)this.findViewById(R.id.task_desc);
        this.taskDate = (TextView)this.findViewById(R.id.task_date);
    }

    public void setChecked(boolean checked){
        this.taskCheckbox.setChecked(checked);
    }

    public void setTaskTitle(String taskTitle){
        this.taskTitle.setText(taskTitle);
    }

    public void setTaskDesc(String taskDesc){
        this.taskDesc.setText(taskDesc);
    }

    public void setTaskDate(String taskDate){
        this.taskDate.setText(taskDate);
    }

    public void setTaskDate(GregorianCalendar taskDate){
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd");
        this.taskDate.setText(sdf.format(taskDate.getTime()));
    }
}
