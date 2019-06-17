package com.example.sw19_morning05;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;

public final class Vibration {
    private static  boolean was_active = false;

    @SuppressWarnings("deprecation")
    public static void vibrate(Context context, long duration) {
        was_active = false;
        boolean enabled = Settings.getPhysicalFeedback(context);

        if (enabled) {
            Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
            was_active = true;

            if(Build.VERSION.SDK_INT >= 26) {
                vibrator.vibrate(VibrationEffect.createOneShot(duration, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                vibrator.vibrate(duration);
            }
        }
    }

    public static boolean checkVibrateActive() {
        return was_active;
    }
}
