package com.example.sw19_morning05;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ExtendWordsActivity extends AppCompatActivity {

    private static HighScoreAdapter highScoreAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Context context = getApplicationContext();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extend_words);

        final Button btn_back = findViewById(R.id.btn_hm_back_extend_words);
        btn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                navigateToWelcomeScreen();
            }
        });
    }

    private void navigateToWelcomeScreen() {
        Intent intent = new Intent(this, HangmanActivity.class);
        startActivity(intent);
    }

}
