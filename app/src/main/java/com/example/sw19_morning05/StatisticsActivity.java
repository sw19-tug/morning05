package com.example.sw19_morning05;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StatisticsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Context context = getApplicationContext();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        TextView textv_game_counter = (TextView) findViewById((R.id.textv_game_counter_ttb));
        textv_game_counter.setText(getResources().getString(R.string.str_textv_statistic_ttb) + " " + Statistics.getGameCounterTTB(context));

        textv_game_counter = (TextView) findViewById((R.id.textv_game_counter_hm));
        textv_game_counter.setText(getResources().getString(R.string.str_textv_statistic_hm) + " " + Statistics.getGameCounterHM(context));

        textv_game_counter = (TextView) findViewById((R.id.textv_game_counter_ttt));
        textv_game_counter.setText(getResources().getString(R.string.str_textv_statistic_ttt) + " " + Statistics.getGameCounterTTT(context));

        TextView textv_greeting_user = (TextView) findViewById((R.id.textv_user_hs));
        textv_greeting_user.setText(getResources().getString(R.string.str_user_hs) + " " +
                Settings.getUsername(context));

        Button btn_back_gamestatistic = (Button) findViewById(R.id.btn_back_gamestatistic);

        btn_back_gamestatistic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                navigateWelcomeScreen();
            }
        });
    }

    private void navigateWelcomeScreen() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
