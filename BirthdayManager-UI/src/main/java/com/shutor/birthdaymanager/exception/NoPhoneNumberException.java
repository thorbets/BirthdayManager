package com.shutor.birthdaymanager.exception;


public class NoPhoneNumberException extends Exception {

    public NoPhoneNumberException() {
        super("No Phone Number for this contact");
    }
}
