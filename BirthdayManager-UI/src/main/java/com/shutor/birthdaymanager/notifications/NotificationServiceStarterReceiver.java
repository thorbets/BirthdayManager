package com.shutor.birthdaymanager.notifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class NotificationServiceStarterReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO changement de fuseau horaire
        //NotificationEventReceiver.setupAlarm(context);
    }
}
