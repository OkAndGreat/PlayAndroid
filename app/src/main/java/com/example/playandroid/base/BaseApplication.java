package com.example.playandroid.base;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

public class BaseApplication extends Application {
    private static Handler sHandler = null;

    private static Context sContext = null;
    @Override
    public void onCreate() {
        super.onCreate();
        sHandler = new Handler();
        sContext = getBaseContext();
    }

    public static Handler getHandler(){
        return sHandler;
    }

    public static Context getContext(){
        return sContext;
    }
}
