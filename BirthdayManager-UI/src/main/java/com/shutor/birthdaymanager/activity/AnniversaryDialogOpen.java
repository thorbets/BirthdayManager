package com.shutor.birthdaymanager.activity;

import com.shutor.birthdaymanager.element.Contact;


public interface AnniversaryDialogOpen {

    /**
     * Displays the event selection dialog
     * @param contact Contact who contains and RowId of contact defined in ContactsContract.Data.RAW_CONTACT_ID
     */
    void openAnniversaryDialogSelection(Contact contact);
}
