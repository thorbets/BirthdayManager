package com.shutor.birthdaymanager.factory;

import android.content.Context;

import com.shutor.birthdaymanager.BuildConfig;

public class MenuContactCreator {

    private MenuContact menuFactory;

    public static MenuContact emptyMenuContact() {
        return new MenuContact() {
            @Override
            public void setActionContactMenu(ActionContactMenu actionContactMenu) {
                super.setActionContactMenu(actionContactMenu);
            }
        };
    }

    public MenuContactCreator(Context context, boolean asPhoneNumber) {
        // List for menu, depend of variant of app
        if(!BuildConfig.FULL_VERSION)
            menuFactory = new MenuFactoryFree(context, asPhoneNumber);
        else {
            menuFactory = new MenuFactoryPro(context, asPhoneNumber);
        }
    }

    public MenuContact create() {
        return menuFactory;
    }
}
