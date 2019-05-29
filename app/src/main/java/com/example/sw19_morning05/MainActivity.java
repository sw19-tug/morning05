package com.example.sw19_morning05;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private AudioManager mAudioManager;
    public MediaPlayer backg_music_player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = this.getApplicationContext();

        TextView textv_greeting_user = (TextView) findViewById((R.id.textv_greeting_user));
        textv_greeting_user.setText(getResources().getString(R.string.str_user_greeting) + " " +
                Settings.getUsername(context));

        TextView textv_score = (TextView) findViewById((R.id.textv_score));
        textv_score.setText(getResources().getString(R.string.str_textv_score) + " " + Score.getScore(context));

        Button btn_switch_lang = (Button) findViewById(R.id.btn_switch_lang);
        btn_switch_lang.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switchLanguage();
            }
        });

        Button btn_start_ttt = (Button) findViewById(R.id.btn_ttt);
        btn_start_ttt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                navigateTicTacToe();
            }
        });

        Button btn_start_ttb = (Button) findViewById(R.id.btn_ttb);
        btn_start_ttb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                navigateTouchTheBlock();
            }
        });

        Button btn_start_hm = (Button) findViewById(R.id.btn_hm);
        btn_start_hm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                navigateHangman();
            }
        });

        Button btn_gamestatistic = (Button) findViewById(R.id.btn_gamestatistic);
        btn_gamestatistic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                navigateStatistics();
            }
        });

        Button btn_settings = (Button) findViewById(R.id.btn_settings);
        btn_settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                navigateSettings();
            }
        });

        Button btn_help = (Button) findViewById(R.id.btn_help);
        btn_help.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showHelp();
            }
        });

        if(Settings.getBackgroundMusic(context) && !BackgroundMusicPlayer.isplayingAudio)
        {
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

    private void navigateWelcomeScreen() {
        Intent intent = new Intent(this, MainActivity.class);
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
