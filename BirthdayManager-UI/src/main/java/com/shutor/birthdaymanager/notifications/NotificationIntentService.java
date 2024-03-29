package com.shutor.birthdaymanager.notifications;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.util.TypedValue;

import com.shutor.birthdaymanager.activity.NotificationActivity;
import com.shutor.birthdaymanager.element.Contact;
import com.shutor.birthdaymanager.R;

/**
 * Service for send notifications of each anniversary
 */
public class NotificationIntentService extends IntentService {

    private static final int NOTIFICATION_ID = 1;
    private static final String ACTION_START = "ACTION_START";
    private static final String ACTION_DELETE = "ACTION_DELETE";

    private static final String EXTRA_CONTACT_NOTIFICATION = "EXTRA_CONTACT_NOTIFICATION_SERVICE";


    public NotificationIntentService() {
        super(NotificationIntentService.class.getSimpleName());
    }

    public static Intent createIntentStartNotificationService(Context context, Contact contact) {
        Intent intent = new Intent(context, NotificationIntentService.class);
        intent.putExtra(EXTRA_CONTACT_NOTIFICATION, contact);
        intent.setAction(ACTION_START);
        return intent;
    }

    public static Intent createIntentDeleteNotification(Context context) {
        Intent intent = new Intent(context, NotificationIntentService.class);
        intent.setAction(ACTION_DELETE);
        return intent;
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(getClass().getSimpleName(), "onHandleIntent, started handling a notification event");
        try {
            String action = intent.getAction();
            if (ACTION_START.equals(action)) {
                Contact contact = intent.getParcelableExtra(EXTRA_CONTACT_NOTIFICATION);
                //TODO processStartNotification(contact);
            }
            if (ACTION_DELETE.equals(action)) {
                processDeleteNotification(intent);
            }
        } finally {
            WakefulBroadcastReceiver.completeWakefulIntent(intent);
        }
    }

    private void processStartNotification(Contact contact) {

        //TODO in future
        String textMessage
                = getString(R.string.notifications_anniversary_today, contact.getName());

        final NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle(getString(R.string.notifications_anniversary_title))
                .setAutoCancel(true);
        // Get ColorAccent for notification
        TypedValue typedValue = new TypedValue();
        TypedArray a = obtainStyledAttributes(typedValue.data, new int[] { R.attr.colorAccent });
        int color = a.getColor(0, 0);
        a.recycle();
        builder.setColor(color)
                .setContentText(textMessage)
                .setSmallIcon(R.drawable.ic_notification_24dp);

        // TODO contact.getID() with anniversary
        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                (int) (contact.getRawId()),
                new Intent(this, NotificationActivity.class),
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        builder.setDeleteIntent(NotificationEventReceiver.getDeleteIntent(this));

        final NotificationManager manager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify((int) (contact.getRawId()), builder.build());
    }

    private void processDeleteNotification(Intent intent) {
        // Log something?
    }
}
