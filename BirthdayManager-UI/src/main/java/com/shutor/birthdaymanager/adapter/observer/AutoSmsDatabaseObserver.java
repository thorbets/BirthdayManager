package com.shutor.birthdaymanager.adapter.observer;

import android.content.Context;
import android.util.Log;

import com.shutor.autosms.Scheduler;
import com.shutor.autosms.database.AutoSmsDbHelper;
import com.shutor.autosms.model.AutoSms;
import com.shutor.birthdaymanager.element.AutoMessage;
import com.shutor.birthdaymanager.element.Contact;
import com.shutor.birthdaymanager.adapter.AbstractReminderAdapter;
import com.shutor.birthdaymanager.element.ProxyAutoMessage;
import com.shutor.birthdaymanager.preference.PreferencesManager;

import java.util.List;

public class AutoSmsDatabaseObserver implements AbstractReminderAdapter.ReminderDataObserver<AutoMessage> {

    private final static String TAG = "AutoSmsDatabaseObserver";
    private Contact contact;
    private Context context;

    public AutoSmsDatabaseObserver(Contact contact, Context context) {
        this.contact = contact;
        this.context = context;
    }

    @Override
    public void onReminderAdded(AutoMessage autoMessage) {
        AutoSms autoSms = ProxyAutoMessage.getAutoSms(contact, autoMessage);
        AutoSmsDbHelper.getDbHelper(context).insert(autoSms);
        autoMessage.setId(autoSms.getDateCreated().getTime());
        boolean autoSmsReminder = PreferencesManager.isAutoSmsRemindersActive(context);
        new Scheduler(context).schedule(autoSms, autoSmsReminder);
        Log.d(TAG, "Message added and scheduled " + autoSms);
    }

    @Override
    public void onRemindersAdded(List<AutoMessage> autoMessages) {

    }

    @Override
    public void onReminderUpdated(AutoMessage autoMessage) {
        Log.d(TAG, "Content : " + autoMessage);
        AutoSms autoSms = ProxyAutoMessage.getAutoSms(contact, autoMessage);
        AutoSmsDbHelper.getDbHelper(context).update(autoSms);
        boolean autoSmsReminder = PreferencesManager.isAutoSmsRemindersActive(context);
        new Scheduler(context).schedule(autoSms, autoSmsReminder);
        Log.d(TAG, "Message updated and scheduled " + autoSms);
    }

    @Override
    public void onRemindersUpdated(List<AutoMessage> autoMessages) {

    }

    @Override
    public void onReminderDeleted(AutoMessage autoMessage) {
        AutoSms autoSms = ProxyAutoMessage.getAutoSms(contact, autoMessage);
        long id = autoSms.getDateCreated().getTime();
        AutoSmsDbHelper.getDbHelper(context).deleteById(id);
        new Scheduler(context).unschedule(id);
        Log.d(TAG, "Message remove and unscheduled " + autoSms);
    }

    @Override
    public void onRemindersDeleted(List<AutoMessage> reminders) {

    }
}
