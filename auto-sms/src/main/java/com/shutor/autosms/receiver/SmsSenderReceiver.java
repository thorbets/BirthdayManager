package com.shutor.autosms.receiver;

import com.shutor.autosms.service.SmsSenderService;

public class SmsSenderReceiver extends WakefulBroadcastReceiver {

    @Override
    protected Class getServiceClass() {
        return SmsSenderService.class;
    }
}
