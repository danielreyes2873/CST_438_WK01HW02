package com.example.cst_438_wk01hw02;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

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
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        User testUser = new User(5,"daniel","asdf1234");
        Intent control = new Intent(InstrumentationRegistry.getInstrumentation().getTargetContext(),MainActivity2.class);
        Intent test = MainActivity.intentFactory(appContext,testUser);
        assertTrue(test.filterEquals(control));
        //assertEquals("com.example.cst_438_wk01hw02", appContext.getPackageName());
    }
}