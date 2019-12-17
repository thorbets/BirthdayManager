package com.shutor.autosms.receiver;

import com.shutor.autosms.service.ReminderService;

public class ReminderReceiver extends WakefulBroadcastReceiver {

    @Override
    protected Class getServiceClass() {
        return ReminderService.class;
    }
}
