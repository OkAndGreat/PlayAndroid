package com.example.playandroid.utils;

import android.util.Log;

public class LogUtil {


    //控制是否要输出log
    public static boolean sIsRelease = true;

    public static void d(String TAG, String content) {
        if (!sIsRelease) {
            Log.d(TAG, content);
        }
    }

    public static void v(String TAG, String content) {
        if (!sIsRelease) {
            Log.d(TAG, content);
        }
    }

    public static void i(String TAG, String content) {
        if (!sIsRelease) {
            Log.d(TAG, content);
        }
    }

    public static void w(String TAG, String content) {
        if (!sIsRelease) {
            Log.d( TAG, content);
        }
    }

    public static void e(String TAG, String content) {
        if (!sIsRelease) {
            Log.d( TAG, content);
        }
    }
}
