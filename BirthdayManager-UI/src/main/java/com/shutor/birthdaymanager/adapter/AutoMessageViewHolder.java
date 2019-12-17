package com.shutor.birthdaymanager.adapter;

import android.view.View;
import android.widget.TextView;

import com.shutor.birthdaymanager.R;


public class AutoMessageViewHolder extends ReminderViewHolder {

    TextView messageContent;

    public AutoMessageViewHolder(View itemView) {
        super(itemView);
        messageContent = (TextView) itemView.findViewById(R.id.item_list_auto_message_content);
    }
}
