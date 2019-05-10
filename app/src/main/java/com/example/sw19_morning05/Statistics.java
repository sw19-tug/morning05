package com.example.sw19_morning05;

import android.content.Context;
import android.content.SharedPreferences;

public final class Statistics {
    public static final String statistic_key = "statistic_key";

    public static int getGameCounterTTB(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("morning05.statistic", context.MODE_PRIVATE);
        return preferences.getInt(statistic_key, 0);
    }

    public static void incrementGameCounterTTB(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("morning05.statistic", context.MODE_PRIVATE);
        int current_game_counter = preferences.getInt(statistic_key, 0);
        preferences.edit().putInt(statistic_key, current_game_counter + 1).commit();
    }
}
