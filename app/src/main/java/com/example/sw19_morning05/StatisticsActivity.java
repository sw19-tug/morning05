package com.example.sw19_morning05;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class StatisticsActivity extends AppCompatActivity {
    private static HighScoreAdapter high_score_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Context context = getApplicationContext();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        TextView textv_game_counter = findViewById((R.id.textv_game_counter_ttb_stat));
        textv_game_counter.setText(getResources().getString(R.string.str_textv_statistic_ttb) + " " + Statistics.getGameCounterTTB(context));

        textv_game_counter = findViewById((R.id.textv_game_counter_hm_stat));
        textv_game_counter.setText(getResources().getString(R.string.str_textv_statistic_hm) + " " + Statistics.getGameCounterHM(context));

        textv_game_counter = findViewById((R.id.textv_game_counter_ttt_stat));
        textv_game_counter.setText(getResources().getString(R.string.str_textv_statistic_ttt) + " " + Statistics.getGameCounterTTT(context));

        TextView textv_greeting_user = findViewById((R.id.textv_user_hs_stat));
        textv_greeting_user.setText(getResources().getString(R.string.str_user_hs_stat) + " " +
                Settings.getUsername(context));

        Button btn_share_score = findViewById(R.id.btn_share_stat);
        btn_share_score.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent whatsapp_intent = new Intent(Intent.ACTION_SEND);
                whatsapp_intent.setType("text/plain");
                whatsapp_intent.setPackage("com.whatsapp");
                whatsapp_intent.putExtra(Intent.EXTRA_TEXT, Score.getScoreMessage(context));
                try {
                    startActivity(whatsapp_intent);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(
                            context,
                            getResources().getString(R.string.str_whatsapp_not_installed),
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });

        Button btn_back_gamestatistic = findViewById(R.id.btn_back_stat);
        btn_back_gamestatistic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                navigateWelcomeScreen();
            }
        });
        ListView lv = findViewById(R.id.listv_hs_stat);
        ArrayList<HighScore> highscore_list = (ArrayList<HighScore>) Statistics.getHighScoreList(context);

        high_score_adapter = new HighScoreAdapter(highscore_list, getApplicationContext());

        lv.setAdapter(high_score_adapter);
    }

    private void navigateWelcomeScreen() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
