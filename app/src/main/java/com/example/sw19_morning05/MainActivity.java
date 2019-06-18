package com.example.sw19_morning05;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

import static android.support.v7.app.AppCompatDelegate.MODE_NIGHT_NO;
import static android.support.v7.app.AppCompatDelegate.MODE_NIGHT_YES;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context context = this.getApplicationContext();

        boolean nightmode = Settings.getNightmode(context);
        if (nightmode) {
            AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO);
        }
        setContentView(R.layout.activity_main);

        TextView textv_greeting_user = findViewById((R.id.textv_greeting_user_m));
        textv_greeting_user.setText(getResources().getString(R.string.str_user_greeting) + " " + Settings.getUsername(context));

        TextView textv_score = findViewById((R.id.textv_score_m));
        textv_score.setText(getResources().getString(R.string.str_textv_score) + " " + Score.getScore(context));

        Button btn_switch_lang = findViewById(R.id.btn_switch_lang_m);
        btn_switch_lang.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switchLanguage();
            }
        });

        Button btn_start_ttt = findViewById(R.id.btn_ttt_m);
        btn_start_ttt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                navigateTicTacToe();
            }
        });

        Button btn_start_ttb = findViewById(R.id.btn_ttb_m);
        btn_start_ttb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                navigateTouchTheBlock();
            }
        });

        Button btn_start_hm = findViewById(R.id.btn_hm_m);
        btn_start_hm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                navigateHangman();
            }
        });

        Button btn_gamestatistic = findViewById(R.id.btn_gamestatistic_m);
        btn_gamestatistic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                navigateStatistics();
            }
        });

        Button btn_settings = findViewById(R.id.btn_settings_m);
        btn_settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                navigateSettings();
            }
        });

        Button btn_help = findViewById(R.id.btn_help_m);
        btn_help.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showHelp();
            }
        });

        if (Settings.getBackgroundMusic(context) && !BackgroundMusicPlayer.is_playing) {
            BackgroundMusicPlayer.playAudio(context);
        }
    }

    private void showHelp() {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.dialog_help, null);

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(R.string.str_help);

        alert.setView(alertLayout);

        alert.setCancelable(false);

        alert.setPositiveButton(R.string.str_ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }

    public void switchLanguage() {
        Configuration config = new Configuration();

        String lang = Locale.getDefault().getDisplayLanguage();
        Locale locale;

        if (lang.equals("English")) {
            locale = new Locale("de");
        } else {
            locale = new Locale("en");
        }

        Locale.setDefault(locale);
        config.setLocale(locale);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());

        MainActivity.this.recreate();
    }

    private void navigateHangman() {
        Intent intent = new Intent(this, HangmanActivity.class);
        Statistics.incrementGameCounterHM(this.getApplicationContext());
        startActivity(intent);
    }

    private void navigateTicTacToe() {
        Intent intent = new Intent(this, TicTacToeActivity.class);
        Statistics.incrementGameCounterTTT(this.getApplicationContext());
        startActivity(intent);
    }

    private void navigateTouchTheBlock() {
        Intent intent = new Intent(this, TTBActivity.class);
        Statistics.incrementGameCounterTTB(this.getApplicationContext());
        startActivity(intent);
    }

    private void navigateSettings() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    private void navigateStatistics() {
        Intent intent = new Intent(this, StatisticsActivity.class);
        startActivity(intent);
    }
}
