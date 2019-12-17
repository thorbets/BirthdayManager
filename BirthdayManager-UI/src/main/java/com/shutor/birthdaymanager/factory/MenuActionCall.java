package com.shutor.birthdaymanager.factory;

import com.shutor.birthdaymanager.R;

public class MenuActionCall extends MenuAction{

    public static final int ITEM_ID = 1567967;

    public MenuActionCall() {
        super(R.string.call_title,
                R.drawable.ic_call_white_24dp);
    }

    @Override
    public int getItemId() {
        return ITEM_ID;
    }
}
