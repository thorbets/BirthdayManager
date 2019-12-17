package com.shutor.birthdaymanager.factory;

import com.shutor.birthdaymanager.R;

public class MenuActionGift extends MenuAction{

    public static final int ITEM_ID = 2561957;

    public MenuActionGift(STATE state) {
        super(R.string.gift_title,
                R.drawable.ic_gift_white_24dp,
                state);
    }

    public MenuActionGift() {
        this(STATE.ACTIVE);
    }

    @Override
    public int getItemId() {
        return ITEM_ID;
    }
}
