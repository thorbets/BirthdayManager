package com.shutor.birthdaymanager.factory;

import com.shutor.birthdaymanager.R;


public class MenuActionAutoMessage extends MenuAction{

    public static final int ITEM_ID = 1684968;

    public MenuActionAutoMessage(STATE state) {
        super(R.string.auto_message_title,
                R.drawable.ic_text_clock_white_24dp,
                state);
    }

    public MenuActionAutoMessage() {
        this(STATE.ACTIVE);
    }

    @Override
    public int getItemId() {
        return ITEM_ID;
    }
}
