package com.example.sw19_morning05;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textv_score = (TextView) findViewById((R.id.textv_score));
        Context context = this.getApplicationContext();
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
        setContentView(R.layout.statistics_games);

        TextView textv_game_counter = (TextView) findViewById((R.id.textv_game_counter_ttb));
        Context context = this.getApplicationContext();
        textv_game_counter.setText(getResources().getString(R.string.str_textv_statistic_ttb) + " " + Statistics.getGameCounterTTB(context));

        textv_game_counter = (TextView) findViewById((R.id.textv_game_counter_hm));
        context = this.getApplicationContext();
        textv_game_counter.setText(getResources().getString(R.string.str_textv_statistic_hm) + " " + Statistics.getGameCounterHM(context));

        textv_game_counter = (TextView) findViewById((R.id.textv_game_counter_ttt));
        context = this.getApplicationContext();
        textv_game_counter.setText(getResources().getString(R.string.str_textv_statistic_ttt) + " " + Statistics.getGameCounterTTT(context));

        Button btn_back_gamestatistic = (Button) findViewById(R.id.btn_back_gamestatistic);

        btn_back_gamestatistic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                navigateWelcomeScreen();
            }
        });
    }
}
