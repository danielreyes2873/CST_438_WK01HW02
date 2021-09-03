package com.example.cst_438_wk01hw02;

import junit.framework.TestCase;

public class LoginActivityTest extends TestCase {

    public void testValidateUsername() {
        /*
        This test verifies several usernames against a hardcoded list of usernames. Each is found in the list
        and a value of true is returned from the validateUsername method.
         */
        LoginActivity.populate();
        String username1 = "default";
        String password1 = "default";
        String username2 = "alice";
        String password2 = "@licE";
        String username3 = "bob";
        String password3 = "B0b";
        String username4 = "chris";
        String password4 = "Chri$";
        String username5 = "daniel";
        String password5 = "asdf1234";

        assertTrue(LoginActivity.validateUsername(username1,password1));
        assertTrue(LoginActivity.validateUsername(username2,password2));
        assertTrue(LoginActivity.validateUsername(username3,password3));
        assertTrue(LoginActivity.validateUsername(username4,password4));
        assertTrue(LoginActivity.validateUsername(username5,password5));
    }

    public void testValidateUsernameIncorrect() {
        /*
        This test verifies several usernames that are not present in the predefined list and therefore a boolean
        value of false is return from the validateUsername method.
         */
        LoginActivity.populate();
        String username1 = "asdf";
        String password1 = "asdf";
        String username2 = "fdsa";
        String password2 = "fdsa";
        String username3 = "234";
        String password3 = "5432";
        String username4 = "$%^wer";
        String password4 = "*&^urei";
        String username5 = "Jimmy";
        String password5 = "Neutron";

        assertFalse(LoginActivity.validateUsername(username1,password1));
        assertFalse(LoginActivity.validateUsername(username2,password2));
        assertFalse(LoginActivity.validateUsername(username3,password3));
        assertFalse(LoginActivity.validateUsername(username4,password4));
        assertFalse(LoginActivity.validateUsername(username5,password5));
    }

    public void testValidatePassword() {
        /*
        This test validates passwords against a predefined list of hardcoded user objects. User objects with the
        same credentials are created and passed to the validatePassword method. If the passwords match a boolean value of
        true is returned.
         */
        LoginActivity.populate();
        User test1 = new User();
        User test2 = new User(2,"alice","@licE");
        User test3 = new User(3,"bob","B0b");
        User test4 = new User(4,"chris","Chri$");
        User test5 = new User(5,"daniel","asdf1234");

        assertTrue(LoginActivity.validatePassword(test1,"default"));
        assertTrue(LoginActivity.validatePassword(test2,"@licE"));
        assertTrue(LoginActivity.validatePassword(test3,"B0b"));
        assertTrue(LoginActivity.validatePassword(test4,"Chri$"));
        assertTrue(LoginActivity.validatePassword(test5,"asdf1234"));
    }

    public void testValidatePasswordIncorrect() {
        /*
        This test also creates a list of user objects that are the same as the hardcoded list in the LoginActivity class,
        but it passes passwords that are incorrect. Due to this, boolean values of 'false' are passed back from the
        validatePassword method.
         */
        LoginActivity.populate();
        User test1 = new User();
        User test2 = new User(2,"alice","@licE");
        User test3 = new User(3,"bob","B0b");
        User test4 = new User(4,"chris","Chri$");
        User test5 = new User(5,"daniel","asdf1234");

        assertFalse(LoginActivity.validatePassword(test1,"yes"));
        assertFalse(LoginActivity.validatePassword(test2,"hello"));
        assertFalse(LoginActivity.validatePassword(test3,"this"));
        assertFalse(LoginActivity.validatePassword(test4,"is"));
        assertFalse(LoginActivity.validatePassword(test5,"dog"));
    }
}