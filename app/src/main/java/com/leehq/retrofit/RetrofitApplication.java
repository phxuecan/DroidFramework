package com.leehq.retrofit;

import com.leehq.aroidframe.BaseApplication;

import io.realm.Realm;

/**
 * Created by putao_lhq on 17-6-6.
 */

public class RetrofitApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
