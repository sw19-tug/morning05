package com.example.sw19_morning05;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public final class Settings {
    private static final String sett_file = "morning05.settings";
    private static final String sett_key_username = "key_username";
    private static final String sett_key_nightmode = "key_nightmode";
    private static final String sett_key_backg_music = "key_backg_music";
    private static final String settings_hangman_words = "key_hangman_words";
    private static final String sett_key_physical_feedb = "key_physical_feedb";
    private static final String sett_backg_music_file = "key_backg_music_file";

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

    public static void setNightmode(Context context, boolean isChecked) {
        setBooleanPreference(context, sett_key_nightmode, isChecked);
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

    public static ArrayList<Pair<String, Boolean>> getHangmanWordList(Context context) {

        ArrayList<Pair<String, Boolean>> list = new ArrayList<>();
        SharedPreferences preferences = context.getSharedPreferences(sett_file, Context.MODE_PRIVATE);
        String json = preferences.getString(settings_hangman_words, "");

        if (json.equals("")) {
            String word_list[] = {"GIN", "VODKA", "RUM", "BRANDY", "BACARDI", "COGNAC", "WHISKY",
                    "JAEGERMEISTER", "HAVANNA", "BELVEDERE", "ABSOLUT", "GREYGOOSE", "WILLIAMS", "SCHNAPS", "ABSINTH"};

            for (String word : word_list) {
                list.add(new Pair<>(word, false));
            }
            return list;
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Pair<String, Boolean>>>() {
        }.getType();

        return gson.fromJson(json, type);
    }

    public static void addNewHangmanWord(Context context, String new_word) {
        ArrayList<Pair<String, Boolean>> list = Settings.getHangmanWordList(context);

        list.add(new Pair<>(new_word, true));
        Gson gson = new Gson();
        String json = gson.toJson(list);

        SharedPreferences preferences = context.getSharedPreferences(sett_file, Context.MODE_PRIVATE);
        preferences.edit().putString(settings_hangman_words, json).commit();
    }

    public static void removeHangmanWord(Context context, int index_to_remove) {
        ArrayList<Pair<String, Boolean>> list = Settings.getHangmanWordList(context);

        list.remove(index_to_remove);
        Gson gson = new Gson();
        String json = gson.toJson(list);

        SharedPreferences preferences = context.getSharedPreferences(sett_file, context.MODE_PRIVATE);
        preferences.edit().putString(settings_hangman_words, json).commit();
    }

    public static boolean getBooleanPreference(Context context, String key) {
        SharedPreferences preferences = context.getSharedPreferences(sett_file, Context.MODE_PRIVATE);
        return preferences.getBoolean(key, false);
    }

    public static void setBooleanPreference(Context context, String key, boolean state) {
        SharedPreferences preferences = context.getSharedPreferences(sett_file, Context.MODE_PRIVATE);
        preferences.edit().putBoolean(key, state).commit();
    }

    public static void setBackgMusicFile(Context context, int file) {
        SharedPreferences preferences = context.getSharedPreferences(sett_backg_music_file, Context.MODE_PRIVATE);
        preferences.edit().putInt(sett_backg_music_file, file).commit();
    }

    public static int getBackgMusicFile(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(sett_backg_music_file, Context.MODE_PRIVATE);
        return preferences.getInt(sett_backg_music_file, R.raw.cantina);
    }
}
