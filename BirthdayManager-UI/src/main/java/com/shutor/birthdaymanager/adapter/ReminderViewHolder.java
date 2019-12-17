package com.shutor.birthdaymanager.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.shutor.birthdaymanager.R;


public class ReminderViewHolder extends RecyclerView.ViewHolder {

    ImageView saveButton;
    ImageView deleteButton;
    TextView dateNotification;
    Spinner unitsBefore;

    public ReminderViewHolder(View itemView) {
        super(itemView);
        saveButton = (ImageView) itemView.findViewById(R.id.item_list_reminder_button_save);
        deleteButton = (ImageView) itemView.findViewById(R.id.item_list_reminder_button_delete);
        dateNotification = (TextView) itemView.findViewById(R.id.item_list_reminder_hour_notification);
        unitsBefore = (Spinner) itemView.findViewById(R.id.item_list_reminder_units_before);
    }
}
