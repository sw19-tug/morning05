package com.example.sw19_morning05;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

public class SettingsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Context context = getApplicationContext();
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_settings);

        EditText input_username = (EditText) findViewById((R.id.input_username));
        input_username.setText(Settings.getUsername(context));

        Button btnTicTacToe = (Button) findViewById(R.id.btn_settings_back);
        btnTicTacToe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                navigateWelcomeScreen();
            }
        });

        final Switch switch_nightmode = findViewById(R.id.switch_nightmode);
        switch_nightmode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Settings.setNightmode(context, isChecked);
            }
        });
        switch_nightmode.setChecked(Settings.getNightmode(context));

        final Switch switch_music = findViewById(R.id.switch_music);
        switch_music.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Settings.setBackgroundMusic(context, isChecked);
            }
        });
        switch_music.setChecked((Settings.getBackgroundMusic(context)));

        final Switch switch_physical = findViewById(R.id.switch_physical);
        switch_physical.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Settings.setPhysicalFeedback(context, isChecked);
                Vibration.vibrate(context, 1000);
            }
        });
        switch_physical.setChecked((Settings.getPhysicalFeedback(context)));

        final Button btn_username_save = findViewById(R.id.btn_username_save);
        btn_username_save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText input_username = findViewById(R.id.input_username);
                String username = input_username.getText().toString();
                Settings.setUsername(context, username);
            }
        });

    }

    private void navigateWelcomeScreen() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
