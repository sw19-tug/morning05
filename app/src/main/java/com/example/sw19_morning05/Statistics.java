package com.example.sw19_morning05;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public final class Statistics {
    private static final String statistic_hm_key = "statistic_hm_key";
    private static final String statistic_ttt_key = "statistic_ttt_key";
    private static final String statistic_ttb_key = "statistic_ttb_key";
    private static final String statistic_highscorelist = "statistic_highscorelist";

    public static int getGameCounterTTB(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("morning05.statistic", Context.MODE_PRIVATE);
        return preferences.getInt(statistic_ttb_key, 0);
    }

    public static void incrementGameCounterTTB(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("morning05.statistic", Context.MODE_PRIVATE);
        int current_game_counter = preferences.getInt(statistic_ttb_key, 0);
        preferences.edit().putInt(statistic_ttb_key, current_game_counter + 1).commit();
    }

    public static int getGameCounterHM(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("morning05.statistic", Context.MODE_PRIVATE);
        return preferences.getInt(statistic_hm_key, 0);
    }

    public static void incrementGameCounterHM(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("morning05.statistic", Context.MODE_PRIVATE);
        int current_game_counter = preferences.getInt(statistic_hm_key, 0);
        preferences.edit().putInt(statistic_hm_key, current_game_counter + 1).commit();
    }

    public static int getGameCounterTTT(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("morning05.statistic", Context.MODE_PRIVATE);
        return preferences.getInt(statistic_ttt_key, 0);
    }

    public static void incrementGameCounterTTT(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("morning05.statistic", Context.MODE_PRIVATE);
        int current_game_counter = preferences.getInt(statistic_ttt_key, 0);
        preferences.edit().putInt(statistic_ttt_key, current_game_counter + 1).commit();
    }

    public static List<HighScore> getHighScoreList(Context context) {
        List<HighScore> list = new ArrayList<>();

        SharedPreferences preferences = context.getSharedPreferences("morning05.statistic", Context.MODE_PRIVATE);
        String json = preferences.getString(statistic_highscorelist, "");

        if (json.equals("")) {
            list.add(new HighScore(new Date(), Settings.getUsername(context), 0));
            return list;
        }

        Gson gson = new Gson();
        Type type = new TypeToken<List<HighScore>>() {
        }.getType();
        list = gson.fromJson(json, type);

        Collections.sort(list, new Comparator<HighScore>() {
            @Override
            public int compare(HighScore o1, HighScore o2) {
                return o1.getHighScore() > o2.getHighScore() ? -1 : 1;
            }
        });

        if (list.size() > 5) {
            list.subList(5, list.size()).clear();
        }
        return list;
    }

    public static void addHighScore(Context context, int highscore) {
        ArrayList<HighScore> list = (ArrayList<HighScore>) Statistics.getHighScoreList(context);

        HighScore hs = new HighScore(new Date(), Settings.getUsername(context), highscore);
        list.add(hs);

        Gson gson = new Gson();
        String json = gson.toJson(list);

        SharedPreferences preferences = context.getSharedPreferences("morning05.statistic", Context.MODE_PRIVATE);
        preferences.edit().putString(statistic_highscorelist, json).commit();
    }
}
