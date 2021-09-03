package com.example.cst_438_wk01hw02;

import android.app.Application;
import android.content.Context;

public class MyContext extends Application {
    private static Context mContext;

    public void onCreate() {
        super.onCreate();
        mContext = this.getApplicationContext();
    }

    public static Context getAppContext() {
        return mContext;
    }
}
