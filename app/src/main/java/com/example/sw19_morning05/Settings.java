package com.example.sw19_morning05;

import android.content.Context;
import android.content.SharedPreferences;

public final class Settings {
    public static final String sett_key_nightmode = "key_nightmode";
    public static final String sett_key_physical_feedb = "key_physical_feedb";
    public static final String sett_key_backg_music = "key_backg_music";
    public static final String sett_key_username = "key_username";

    public static boolean getNightmode(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("morning05.settings", Context.MODE_PRIVATE);
        return preferences.getBoolean(sett_key_nightmode, false);
    }

    public static boolean getBackgroundMusic(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("morning05.settings", Context.MODE_PRIVATE);
        return preferences.getBoolean(sett_key_backg_music, false);
    }

    public static boolean getPhysicalFeedback(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("morning05.settings", Context.MODE_PRIVATE);
        return preferences.getBoolean(sett_key_physical_feedb, false);
    }

    public static String getUsername(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("morning05.settings", Context.MODE_PRIVATE);
        return preferences.getString(sett_key_username, "User1");
    }

    public static void setNightmode(Context context, boolean state) {
        SharedPreferences preferences = context.getSharedPreferences("morning05.settings", Context.MODE_PRIVATE);
        preferences.edit().putBoolean(sett_key_nightmode, state).commit();
    }

    public static void setBackgroundMusic(Context context, boolean state) {
        SharedPreferences preferences = context.getSharedPreferences("morning05.settings", Context.MODE_PRIVATE);
        preferences.edit().putBoolean(sett_key_backg_music, state).commit();
    }

    public static void setPhysicalFeedback(Context context, boolean state) {
        SharedPreferences preferences = context.getSharedPreferences("morning05.settings", Context.MODE_PRIVATE);
        preferences.edit().putBoolean(sett_key_physical_feedb, state).commit();
    }

    public static void setUsername(Context context, String name) {
        SharedPreferences preferences = context.getSharedPreferences("morning05.settings", Context.MODE_PRIVATE);
        preferences.edit().putString(sett_key_username, name).commit();
    }
}
