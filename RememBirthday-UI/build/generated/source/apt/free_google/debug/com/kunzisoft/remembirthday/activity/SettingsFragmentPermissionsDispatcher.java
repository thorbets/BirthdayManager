// This file was generated by PermissionsDispatcher. Do not modify!
package com.kunzisoft.remembirthday.activity;

import java.lang.Override;
import java.lang.String;
import java.lang.ref.WeakReference;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.PermissionUtils;

final class SettingsFragmentPermissionsDispatcher {
  private static final int REQUEST_ONPREFERENCECALENDARPERMISSIONCLICK = 1;

  private static final String[] PERMISSION_ONPREFERENCECALENDARPERMISSIONCLICK = new String[] {"android.permission.WRITE_CALENDAR"};

  private static final int REQUEST_ONPREFERENCESENDSMSPERMISSIONCLICK = 2;

  private static final String[] PERMISSION_ONPREFERENCESENDSMSPERMISSIONCLICK = new String[] {"android.permission.SEND_SMS"};

  private SettingsFragmentPermissionsDispatcher() {
  }

  static void onPreferenceCalendarPermissionClickWithCheck(SettingsFragment target) {
    if (PermissionUtils.hasSelfPermissions(target.getActivity(), PERMISSION_ONPREFERENCECALENDARPERMISSIONCLICK)) {
      target.onPreferenceCalendarPermissionClick();
    } else {
      if (PermissionUtils.shouldShowRequestPermissionRationale(target, PERMISSION_ONPREFERENCECALENDARPERMISSIONCLICK)) {
        target.showRationaleForCalendar(new OnPreferenceCalendarPermissionClickPermissionRequest(target));
      } else {
        target.requestPermissions(PERMISSION_ONPREFERENCECALENDARPERMISSIONCLICK, REQUEST_ONPREFERENCECALENDARPERMISSIONCLICK);
      }
    }
  }

  static void onPreferenceSendSmsPermissionClickWithCheck(SettingsFragment target) {
    if (PermissionUtils.hasSelfPermissions(target.getActivity(), PERMISSION_ONPREFERENCESENDSMSPERMISSIONCLICK)) {
      target.onPreferenceSendSmsPermissionClick();
    } else {
      if (PermissionUtils.shouldShowRequestPermissionRationale(target, PERMISSION_ONPREFERENCESENDSMSPERMISSIONCLICK)) {
        target.showRationaleForSendSms(new OnPreferenceSendSmsPermissionClickPermissionRequest(target));
      } else {
        target.requestPermissions(PERMISSION_ONPREFERENCESENDSMSPERMISSIONCLICK, REQUEST_ONPREFERENCESENDSMSPERMISSIONCLICK);
      }
    }
  }

  static void onRequestPermissionsResult(SettingsFragment target, int requestCode, int[] grantResults) {
    switch (requestCode) {
      case REQUEST_ONPREFERENCECALENDARPERMISSIONCLICK:
      if (PermissionUtils.verifyPermissions(grantResults)) {
        target.onPreferenceCalendarPermissionClick();
      } else {
        if (!PermissionUtils.shouldShowRequestPermissionRationale(target, PERMISSION_ONPREFERENCECALENDARPERMISSIONCLICK)) {
          target.showNeverAskForCalendar();
        } else {
          target.showDeniedForCalendar();
        }
      }
      break;
      case REQUEST_ONPREFERENCESENDSMSPERMISSIONCLICK:
      if (PermissionUtils.verifyPermissions(grantResults)) {
        target.onPreferenceSendSmsPermissionClick();
      } else {
        if (!PermissionUtils.shouldShowRequestPermissionRationale(target, PERMISSION_ONPREFERENCESENDSMSPERMISSIONCLICK)) {
          target.showNeverAskForSendSms();
        } else {
          target.showDeniedForSendSms();
        }
      }
      break;
      default:
      break;
    }
  }

  private static final class OnPreferenceCalendarPermissionClickPermissionRequest implements PermissionRequest {
    private final WeakReference<SettingsFragment> weakTarget;

    private OnPreferenceCalendarPermissionClickPermissionRequest(SettingsFragment target) {
      this.weakTarget = new WeakReference<SettingsFragment>(target);
    }

    @Override
    public void proceed() {
      SettingsFragment target = weakTarget.get();
      if (target == null) return;
      target.requestPermissions(PERMISSION_ONPREFERENCECALENDARPERMISSIONCLICK, REQUEST_ONPREFERENCECALENDARPERMISSIONCLICK);
    }

    @Override
    public void cancel() {
      SettingsFragment target = weakTarget.get();
      if (target == null) return;
      target.showDeniedForCalendar();
    }
  }

  private static final class OnPreferenceSendSmsPermissionClickPermissionRequest implements PermissionRequest {
    private final WeakReference<SettingsFragment> weakTarget;

    private OnPreferenceSendSmsPermissionClickPermissionRequest(SettingsFragment target) {
      this.weakTarget = new WeakReference<SettingsFragment>(target);
    }

    @Override
    public void proceed() {
      SettingsFragment target = weakTarget.get();
      if (target == null) return;
      target.requestPermissions(PERMISSION_ONPREFERENCESENDSMSPERMISSIONCLICK, REQUEST_ONPREFERENCESENDSMSPERMISSIONCLICK);
    }

    @Override
    public void cancel() {
      SettingsFragment target = weakTarget.get();
      if (target == null) return;
      target.showDeniedForSendSms();
    }
  }
}