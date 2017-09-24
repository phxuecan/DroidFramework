package com.leehq.aroidframe;

import android.app.Application;
import android.content.Context;

/**
 * Created by putao_lhq on 17-6-8.
 */

public class BaseApplication extends Application {

    public static Context sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    public static Context getInstance(){
        return sInstance;
    }
}
