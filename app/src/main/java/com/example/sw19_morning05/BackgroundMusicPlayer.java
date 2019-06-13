package com.example.sw19_morning05;

import android.content.Context;
import android.media.MediaPlayer;

public class BackgroundMusicPlayer {
    public static MediaPlayer mediaPlayer;

    public static boolean isplayingAudio = false;

    public static int selected = 0;

    public static void playAudio(Context c) {
        mediaPlayer = MediaPlayer.create(c, Settings.getBackgMusicFile(c));
        if (!mediaPlayer.isPlaying()) {
            isplayingAudio = true;
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
        }
    }
    public static void stopAudio() {
        isplayingAudio = false;
        mediaPlayer.stop();
    }

    public static void setSelected(int sel)
    {
        selected = sel;
    }

    public static int getSelected()
    {
        return selected;
    }
}
