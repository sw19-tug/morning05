package com.example.sw19_morning05;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class StatisticsActivity extends AppCompatActivity {

    private static HighScoreAdapter highScoreAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Context context = getApplicationContext();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        TextView textv_game_counter = findViewById((R.id.textv_game_counter_ttb));
        textv_game_counter.setText(getResources().getString(R.string.str_textv_statistic_ttb) + " " + Statistics.getGameCounterTTB(context));

        textv_game_counter = findViewById((R.id.textv_game_counter_hm));
        textv_game_counter.setText(getResources().getString(R.string.str_textv_statistic_hm) + " " + Statistics.getGameCounterHM(context));

        textv_game_counter = findViewById((R.id.textv_game_counter_ttt));
        textv_game_counter.setText(getResources().getString(R.string.str_textv_statistic_ttt) + " " + Statistics.getGameCounterTTT(context));

        TextView textv_greeting_user = findViewById((R.id.textv_user_hs));
        textv_greeting_user.setText(getResources().getString(R.string.str_user_hs) + " " +
                Settings.getUsername(context));

        Button btn_share_score = findViewById(R.id.btn_share_score);
        btn_share_score.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
                whatsappIntent.setType("text/plain");
                whatsappIntent.setPackage("com.whatsapp");
                whatsappIntent.putExtra(Intent.EXTRA_TEXT, "HIGHSCORE");
                try {
                    startActivity(whatsappIntent);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(
                            context,
                            "WhatsApp is not Installed",
                            Toast.LENGTH_LONG
                    ).show();
                }
            }
        });

        Button btn_back_gamestatistic = (Button) findViewById(R.id.btn_back_gamestatistic);
        btn_back_gamestatistic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                navigateWelcomeScreen();
            }
        });

        ListView lv = findViewById(R.id.listview_statistics_hs);
        ArrayList<HighScore> highscore_list = (ArrayList<HighScore>) Statistics.getHighScoreList(context);

        highScoreAdapter = new HighScoreAdapter(highscore_list, getApplicationContext());

        lv.setAdapter(highScoreAdapter);
    }

    private void navigateWelcomeScreen() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
