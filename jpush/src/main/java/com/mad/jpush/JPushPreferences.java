package com.mad.jpush;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Class collection of android shared preferences
 * Created by Ted
 */
public class JPushPreferences {
    public static String NAME = "JPushTest";
    private static final String JPUSH_REGISTER_ID = "JPUSH_REGISTER_ID";

    public static void setRegisterID(Context context, String value) {
        SharedPreferences pref = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        edit.putString(JPUSH_REGISTER_ID, value);
        edit.apply();
    }

    public static String getRegisterID(Context context, String defaultValue) {
        SharedPreferences pref = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return pref.getString(JPUSH_REGISTER_ID, defaultValue);
    }
}
