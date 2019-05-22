package com.example.sw19_morning05;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class Statistics {
    public static final String statistic_ttb_key = "statistic_ttb_key";
    public static final String statistic_hm_key = "statistic_hm_key";
    public static final String statistic_ttt_key = "statistic_ttt_key";

    public static int getGameCounterTTB(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("morning05.statistic", context.MODE_PRIVATE);
        return preferences.getInt(statistic_ttb_key, 0);
    }

    public static void incrementGameCounterTTB(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("morning05.statistic", context.MODE_PRIVATE);
        int current_game_counter = preferences.getInt(statistic_ttb_key, 0);
        preferences.edit().putInt(statistic_ttb_key, current_game_counter + 1).commit();
    }

    public static int getGameCounterHM(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("morning05.statistic", context.MODE_PRIVATE);
        return preferences.getInt(statistic_hm_key, 0);
    }

    public static void incrementGameCounterHM(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("morning05.statistic", context.MODE_PRIVATE);
        int current_game_counter = preferences.getInt(statistic_ttb_key, 0);
        preferences.edit().putInt(statistic_hm_key, current_game_counter + 1).commit();
    }

    public static int getGameCounterTTT(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("morning05.statistic", context.MODE_PRIVATE);
        return preferences.getInt(statistic_ttt_key, 0);
    }

    public static void incrementGameCounterTTT(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("morning05.statistic", context.MODE_PRIVATE);
        int current_game_counter = preferences.getInt(statistic_ttt_key, 0);
        preferences.edit().putInt(statistic_ttt_key, current_game_counter + 1).commit();
    }

    public static List<HighScore> getHighScoreList(Context context) {

        List<HighScore> list = new ArrayList<>();

        HighScore hs = new HighScore(new Date(), Settings.getUsername(context), 0);
        list.add(hs);

        return list;

    }

    public static void addHighScore(Context context, String username, int highscore) {
    }
}
