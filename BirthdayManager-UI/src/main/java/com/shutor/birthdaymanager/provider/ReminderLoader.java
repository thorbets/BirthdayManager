package com.shutor.birthdaymanager.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.CalendarContract;

import com.shutor.birthdaymanager.element.CalendarEvent;
import com.shutor.birthdaymanager.element.Reminder;

import java.util.ArrayList;
import java.util.List;
public class ReminderLoader {

    public static List<Reminder> getRemindersFromEvent(Context context, CalendarEvent calendarEvent) {
        List<Reminder> reminderList = new ArrayList<>();
        String[] projection = new String[] {
                CalendarContract.Reminders._ID,
                CalendarContract.Reminders.EVENT_ID,
                CalendarContract.Reminders.MINUTES,
                CalendarContract.Reminders.METHOD};
        String where = CalendarContract.Reminders.EVENT_ID + "=?";
        String[] whereParam = {Long.toString(calendarEvent.getId())};

        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = contentResolver.query(
                CalendarLoader.getBirthdayAdapterUri(context, CalendarContract.Reminders.CONTENT_URI),
                projection,
                where,
                whereParam,
                null);
        if(cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Reminder reminder = new Reminder(
                        calendarEvent.getDate(),
                        cursor.getInt(cursor.getColumnIndex(CalendarContract.Reminders.MINUTES)));
                reminder.setId(cursor.getLong(cursor.getColumnIndex(CalendarContract.Reminders._ID)));
                reminderList.add(reminder);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return reminderList;
    }
}
