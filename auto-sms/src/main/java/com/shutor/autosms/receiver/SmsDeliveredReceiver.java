package com.shutor.autosms.receiver;

import com.shutor.autosms.service.SmsDeliveredService;

public class SmsDeliveredReceiver extends WakefulBroadcastReceiver {

    @Override
    protected Class getServiceClass() {
        return SmsDeliveredService.class;
    }
}
