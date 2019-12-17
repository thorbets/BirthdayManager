package com.shutor.birthdaymanager.adapter.observer;

import android.content.Context;
import android.widget.Toast;

import com.shutor.birthdaymanager.element.AutoMessage;
import com.shutor.birthdaymanager.R;
import com.shutor.birthdaymanager.adapter.AbstractReminderAdapter;

import java.util.List;


public class AutoSmsToastObserver implements AbstractReminderAdapter.ReminderDataObserver<AutoMessage> {

    private Context context;

    public AutoSmsToastObserver(Context context) {
        this.context = context;
    }

    @Override
    public void onReminderAdded(AutoMessage reminder) {
        Toast.makeText(context, context.getString(R.string.auto_sms_added, reminder.getDate()), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRemindersAdded(List<AutoMessage> reminders) {

    }

    @Override
    public void onReminderUpdated(AutoMessage reminder) {
        Toast.makeText(context, context.getString(R.string.auto_sms_updated, reminder.getDate()), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRemindersUpdated(List<AutoMessage> reminders) {

    }

    @Override
    public void onReminderDeleted(AutoMessage reminder) {
        Toast.makeText(context, context.getString(R.string.auto_sms_deleted), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRemindersDeleted(List<AutoMessage> reminders) {

    }
}
