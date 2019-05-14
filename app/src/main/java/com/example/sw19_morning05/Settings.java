package com.example.sw19_morning05;

import android.content.Context;
import android.content.SharedPreferences;

public final class Settings {
    public static final String sett_key_nightmode = "key_nightmode";
    public static final String sett_key_physical_feedb = "key_physical_feedb";
    public static final String sett_key_backg_music = "key_backg_music";
    public static final String sett_key_username = "key_username";
    public static final String sett_file = "morning05.settings";

    public static boolean getNightmode(Context context) {
        return getBooleanPreference(context, sett_key_nightmode);
    }

    public static boolean getBackgroundMusic(Context context) {
        return getBooleanPreference(context, sett_key_backg_music);
    }

    public static boolean getPhysicalFeedback(Context context) {
        return getBooleanPreference(context, sett_key_physical_feedb);
    }

    public static String getUsername(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(sett_file, Context.MODE_PRIVATE);
        return preferences.getString(sett_key_username, "User1");
    }

    public static void setNightmode(Context context, boolean state) {
        setBooleanPreference(context, sett_key_nightmode, state);
    }

    public static void setBackgroundMusic(Context context, boolean state) {
        setBooleanPreference(context, sett_key_backg_music, state);
    }

    public static void setPhysicalFeedback(Context context, boolean state) {
        setBooleanPreference(context, sett_key_physical_feedb, state);
    }

    public static void setUsername(Context context, String name) {
        SharedPreferences preferences = context.getSharedPreferences(sett_file, Context.MODE_PRIVATE);
        preferences.edit().putString(sett_key_username, name).commit();
    }

    private static boolean getBooleanPreference(Context context, String key) {
        SharedPreferences preferences = context.getSharedPreferences(sett_file, Context.MODE_PRIVATE);
        return preferences.getBoolean(key, false);
    }

    private static void setBooleanPreference(Context context, String key, boolean state) {
        SharedPreferences preferences = context.getSharedPreferences(sett_file, Context.MODE_PRIVATE);
        preferences.edit().putBoolean(key, state).commit();
    }
}
