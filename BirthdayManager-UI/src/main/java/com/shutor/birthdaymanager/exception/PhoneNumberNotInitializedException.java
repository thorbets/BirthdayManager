package com.shutor.birthdaymanager.exception;

public class PhoneNumberNotInitializedException extends Exception {

    public PhoneNumberNotInitializedException() {
        super("Phone number has not been initialized, use the 'setPhoneNumbers' or 'setPhoneNumber' method of contact");
    }
}
