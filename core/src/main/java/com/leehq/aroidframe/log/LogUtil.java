package com.leehq.aroidframe.log;

import android.util.Log;

import com.leehq.aroidframe.BuildConfig;

/**
 * Created by putao_lhq on 17-6-8.
 */

public class LogUtil {

    private static final boolean DEBUG = BuildConfig.DEBUG;
    private static String DEFAULT_TAG = "leehq";

    public static void i(String tag, String message) {
        if(DEBUG){
            Log.i(tag, message);
        }
    }

    public static void i(String message) {
        if(DEBUG){
            Log.i(DEFAULT_TAG, message);
        }
    }
}
