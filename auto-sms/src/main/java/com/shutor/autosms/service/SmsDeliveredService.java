package com.shutor.autosms.service;

import android.content.Intent;

import com.shutor.autosms.database.AutoSmsDbHelper;
import com.shutor.autosms.model.AutoSms;
import com.shutor.autosms.receiver.WakefulBroadcastReceiver;

public class SmsDeliveredService extends SmsIntentService {

    public SmsDeliveredService() {
        super("SmsDeliveredService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        super.onHandleIntent(intent);
        if (timestampCreated == 0) {
            return;
        }
        AutoSms sms = AutoSmsDbHelper.getDbHelper(this).getAutoSmsById(timestampCreated);
        sms.setStatus(AutoSms.Status.DELIVERED);
        AutoSmsDbHelper.getDbHelper(this).insert(sms);
        WakefulBroadcastReceiver.completeWakefulIntent(intent);
    }
}
