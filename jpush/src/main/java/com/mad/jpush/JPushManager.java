package com.mad.jpush;

import android.content.Context;

import cn.jpush.android.api.JPushInterface;

/**
 *
 * Created by Ted
 */
public class JPushManager {
    public JPushManager setDebugMode(boolean debug) {
        JPushInterface.setDebugMode(debug);
        return this;
    }

    public void init(Context context) {
        JPushInterface.init(context);
        JPushPreferences.NAME = context.getPackageName();
    }

    public static void setRegisterID(Context context, String registerID) {
        JPushPreferences.setRegisterID(context, registerID);
    }

    public static String getRegisterID(Context context) {
        return JPushPreferences.getRegisterID(context, null);
    }
}
