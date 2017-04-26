package com.mad.jpushtest;

import android.app.Application;

import com.mad.jpush.JPushManager;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by shoki on 2017. 4. 26..
 */

public class JPushTestApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        new JPushManager()
                .setDebugMode(true)
                .init(this);
    }
}
