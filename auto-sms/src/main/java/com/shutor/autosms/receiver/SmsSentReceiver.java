package com.shutor.autosms.receiver;

import com.shutor.autosms.service.SmsSentService;

public class SmsSentReceiver extends WakefulBroadcastReceiver {

    @Override
    protected Class getServiceClass() {
        return SmsSentService.class;
    }
}
