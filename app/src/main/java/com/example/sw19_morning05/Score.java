package com.example.sw19_morning05;

import android.content.Context;
import android.content.SharedPreferences;

public final class  Score {
    public static final String highscoreKey = "highscore_key";

    public static int getScore(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("morning05.highscore", context.MODE_PRIVATE);
        return preferences.getInt(highscoreKey, 0);
    }

    public static void incrementScore(Context context, int points) {
        SharedPreferences preferences = context.getSharedPreferences("morning05.highscore", context.MODE_PRIVATE);
        int currentScore = preferences.getInt(highscoreKey, 0);
        preferences.edit().putInt(highscoreKey, currentScore + points).commit();
    }

    public static void decrementScore(Context context, int points) {
        SharedPreferences preferences = context.getSharedPreferences("morning05.highscore", context.MODE_PRIVATE);
        int currentScore = preferences.getInt(highscoreKey, 0);
        preferences.edit().putInt(highscoreKey, currentScore - points).commit();
    }
}
