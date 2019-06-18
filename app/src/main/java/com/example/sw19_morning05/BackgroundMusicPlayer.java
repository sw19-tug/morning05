package com.example.sw19_morning05;

import android.content.Context;
import android.media.MediaPlayer;

class BackgroundMusicPlayer {
    private static int selected = 0;
    public static boolean is_playing = false;
    private static MediaPlayer media_player;

    static void playAudio(Context c) {
        media_player = MediaPlayer.create(c, Settings.getBackgMusicFile(c));
        if (!media_player.isPlaying()) {
            is_playing = true;
            media_player.start();
            media_player.setLooping(true);
        }
    }

    static void stopAudio() {
        is_playing = false;
        media_player.stop();
    }

    static void setSelected(int sel) {
        selected = sel;
    }

    static int getSelected() {
        return selected;
    }
}
