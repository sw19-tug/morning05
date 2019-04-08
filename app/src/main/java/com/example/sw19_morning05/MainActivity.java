package com.example.sw19_morning05;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
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

        TextView tv_score = (TextView) findViewById((R.id.tv_score));
        Context context = this.getApplicationContext();
        tv_score.setText(getResources().getString(R.string.tv_score_text)+ " " + Score.getScore(context));

        Button btnClickEvent = (Button) findViewById(R.id.bt_switchLanguage);
        btnClickEvent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switchLanguage();
            }
        });

        Button btnTicTacToe = (Button) findViewById(R.id.bt_tictactoe);
        btnTicTacToe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                navigateTicTacToe();
            }
        });

        Button btnTouchTheBlock= (Button) findViewById(R.id.bt_touchtheblock);
        btnTouchTheBlock.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                navigateTouchTheBlock();
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


    private void navigateTicTacToe() {
        Intent intent = new Intent(this, TicTacToeActivity.class);
        startActivity(intent);
    }


    private void navigateTouchTheBlock() {
        Intent intent = new Intent(this, TTBActivity.class);
        startActivity(intent);
    }
}
