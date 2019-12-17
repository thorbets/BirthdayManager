package com.shutor.birthdaymanager.adapter.observer;

import android.content.Context;
import android.widget.Toast;

import com.shutor.birthdaymanager.element.Reminder;
import com.shutor.birthdaymanager.R;
import com.shutor.birthdaymanager.adapter.AbstractReminderAdapter;

import java.util.List;

public class ReminderToastObserver implements AbstractReminderAdapter.ReminderDataObserver<Reminder> {

    private Context context;

    public ReminderToastObserver(Context context) {
        this.context = context;
    }

    @Override
    public void onReminderAdded(Reminder reminder) {
        Toast.makeText(context, context.getString(R.string.reminder_added, reminder.getDate()), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRemindersAdded(List<Reminder> reminders) {

    }

    @Override
    public void onReminderUpdated(Reminder reminder) {
        Toast.makeText(context, context.getString(R.string.reminder_updated, reminder.getDate()), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRemindersUpdated(List<Reminder> reminders) {

    }

    @Override
    public void onReminderDeleted(Reminder reminder) {
        Toast.makeText(context, context.getString(R.string.reminder_deleted), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRemindersDeleted(List<Reminder> reminders) {

    }
}
