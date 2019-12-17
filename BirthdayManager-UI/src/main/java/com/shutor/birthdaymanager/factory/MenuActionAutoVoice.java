package com.shutor.birthdaymanager.factory;

import com.shutor.birthdaymanager.R;


public class MenuActionAutoVoice extends MenuAction{

    public static final int ITEM_ID = 1691968;

    public MenuActionAutoVoice(STATE state) {
        super(R.string.auto_sound_title,
                R.drawable.ic_event_voice_24dp,
                state);
    }

    public MenuActionAutoVoice() {
        this(STATE.ACTIVE);
    }

    @Override
    public int getItemId() {
        return ITEM_ID;
    }
}
