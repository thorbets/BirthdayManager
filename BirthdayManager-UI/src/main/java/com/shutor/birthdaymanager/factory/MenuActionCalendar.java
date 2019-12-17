package com.shutor.birthdaymanager.factory;

import com.shutor.birthdaymanager.R;

public class MenuActionCalendar extends MenuAction{

    public static final int ITEM_ID = 1684954;

    public MenuActionCalendar() {
        super(R.string.calendar_title, R.drawable.ic_event_note_white_24dp);
    }

    @Override
    public int getItemId() {
        return ITEM_ID;
    }
}
