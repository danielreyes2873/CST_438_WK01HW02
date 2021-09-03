package com.example.cst_438_wk01hw02;

import android.content.Context;
import android.content.Intent;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class InstrumentedTest {
    @Test
    public void intentFactoryTest() {
        /*
        This test makes several intents passing valid user objects and compares the returned intent to a control
        made locally in this method.
         */
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Intent control = new Intent(InstrumentationRegistry.getInstrumentation().getTargetContext(), MainActivity.class);
        User testUser1 = new User();
        Intent test1 = LoginActivity.intentFactory(appContext,testUser1);
        User testUser2 = new User(2,"alice","@licE");
        Intent test2 = LoginActivity.intentFactory(appContext,testUser2);
        User testUser3 = new User(3,"bob","B0b");
        Intent test3 = LoginActivity.intentFactory(appContext,testUser3);
        User testUser4 = new User(4,"chris","Chri$");
        Intent test4 = LoginActivity.intentFactory(appContext,testUser4);
        User testUser5 = new User(5,"daniel","asdf1234");
        Intent test5 = LoginActivity.intentFactory(appContext,testUser5);

        assertTrue(test1.filterEquals(control));
        assertTrue(test2.filterEquals(control));
        assertTrue(test3.filterEquals(control));
        assertTrue(test4.filterEquals(control));
        assertTrue(test5.filterEquals(control));
    }
}