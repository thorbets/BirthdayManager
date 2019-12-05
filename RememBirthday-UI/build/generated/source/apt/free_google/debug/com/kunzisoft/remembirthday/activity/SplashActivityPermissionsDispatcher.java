// This file was generated by PermissionsDispatcher. Do not modify!
package com.kunzisoft.remembirthday.activity;

import android.support.v4.app.ActivityCompat;
import java.lang.Override;
import java.lang.String;
import java.lang.ref.WeakReference;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.PermissionUtils;

final class SplashActivityPermissionsDispatcher {
  private static final int REQUEST_SHOWRATIONALFORCONTACTS = 3;

  private static final String[] PERMISSION_SHOWRATIONALFORCONTACTS = new String[] {"android.permission.READ_CONTACTS"};

  private SplashActivityPermissionsDispatcher() {
  }

  static void showRationalForContactsWithCheck(SplashActivity target) {
    if (PermissionUtils.hasSelfPermissions(target, PERMISSION_SHOWRATIONALFORCONTACTS)) {
      target.showRationalForContacts();
    } else {
      if (PermissionUtils.shouldShowRequestPermissionRationale(target, PERMISSION_SHOWRATIONALFORCONTACTS)) {
        target.showRationaleForContacts(new ShowRationalForContactsPermissionRequest(target));
      } else {
        ActivityCompat.requestPermissions(target, PERMISSION_SHOWRATIONALFORCONTACTS, REQUEST_SHOWRATIONALFORCONTACTS);
      }
    }
  }

  static void onRequestPermissionsResult(SplashActivity target, int requestCode, int[] grantResults) {
    switch (requestCode) {
      case REQUEST_SHOWRATIONALFORCONTACTS:
      if (PermissionUtils.verifyPermissions(grantResults)) {
        target.showRationalForContacts();
      } else {
        if (!PermissionUtils.shouldShowRequestPermissionRationale(target, PERMISSION_SHOWRATIONALFORCONTACTS)) {
          target.showNeverAskForContacts();
        } else {
          target.showDeniedForContacts();
        }
      }
      break;
      default:
      break;
    }
  }

  private static final class ShowRationalForContactsPermissionRequest implements PermissionRequest {
    private final WeakReference<SplashActivity> weakTarget;

    private ShowRationalForContactsPermissionRequest(SplashActivity target) {
      this.weakTarget = new WeakReference<SplashActivity>(target);
    }

    @Override
    public void proceed() {
      SplashActivity target = weakTarget.get();
      if (target == null) return;
      ActivityCompat.requestPermissions(target, PERMISSION_SHOWRATIONALFORCONTACTS, REQUEST_SHOWRATIONALFORCONTACTS);
    }

    @Override
    public void cancel() {
      SplashActivity target = weakTarget.get();
      if (target == null) return;
      target.showDeniedForContacts();
    }
  }
}