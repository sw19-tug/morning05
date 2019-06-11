package com.example.sw19_morning05;

import android.content.Context;
import android.content.SharedPreferences;

public final class Score {
    public static final String highscore_key = "highscore_key";

    public static int getScore(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("morning05.highscore", context.MODE_PRIVATE);
        return preferences.getInt(highscore_key, 0);
    }

    public static void incrementScore(Context context, int points) {
        SharedPreferences preferences = context.getSharedPreferences("morning05.highscore", context.MODE_PRIVATE);
        int current_score = preferences.getInt(highscore_key, 0);
        preferences.edit().putInt(highscore_key, current_score + points).commit();
    }

    public static void decrementScore(Context context, int points) {
        SharedPreferences preferences = context.getSharedPreferences("morning05.highscore", context.MODE_PRIVATE);
        int current_score = preferences.getInt(highscore_key, 0);
        preferences.edit().putInt(highscore_key, current_score - points).commit();
    }

    public static String getScoreMessage(Context context) {
        String message = context.getResources().getString(R.string.str_score_message) + " " + getScore(context);
        return message;
    }
}
