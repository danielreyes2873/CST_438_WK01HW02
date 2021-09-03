package com.example.cst_438_wk01hw02;

import android.content.Intent;
import android.widget.TextView;

import junit.framework.TestCase;

public class MainActivityTest extends TestCase {

    public void testValidateUsername() {
        MainActivity.populate();
        String username = "default";
        String password = "default";

        assertTrue(MainActivity.validateUsername(username,password));
    }

    public void testValidateUsernameIncorrect() {
        MainActivity.populate();
        String username = "asdf";
        String password = "asdf";
        assertFalse(MainActivity.validateUsername(username,password));
    }

    public void testValidatePassword() {
        MainActivity.populate();
        User test = new User(5,"daniel","asdf1234");
        assertTrue(MainActivity.validatePassword(test,"asdf1234"));
    }

    public void testValidatePasswordIncorrect() {
        MainActivity.populate();
        User test = new User(5,"daniel","asdf1234");
        assertFalse(MainActivity.validatePassword(test,"ok"));
    }
}