package com.shutor.birthdaymanager.factory;

import com.shutor.birthdaymanager.R;

public class MenuActionMessage extends MenuAction{

    public static final int ITEM_ID = 1667954;

    public MenuActionMessage() {
        super(R.string.message_title,
                R.drawable.ic_message_white_24dp);
    }

    @Override
    public int getItemId() {
        return ITEM_ID;
    }
}
