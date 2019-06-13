package com.example.sw19_morning05;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
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
        switch_music.setChecked(Settings.getBackgroundMusic(context));

        switch_music.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Settings.setBackgroundMusic(context, isChecked);
                if (isChecked) {
                    BackgroundMusicPlayer.playAudio(context);
                } else {
                    BackgroundMusicPlayer.stopAudio();
                }
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

        final Spinner spinner = findViewById(R.id.spinn_backg_music);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.music_list, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        if (Settings.getBackgMusicFile(context) == R.raw.cantina) {
            BackgroundMusicPlayer.setSelected(0);
        } else if (Settings.getBackgMusicFile(context) == R.raw.gummibaer) {
            BackgroundMusicPlayer.setSelected(1);
        } else if (Settings.getBackgMusicFile(context) == R.raw.fahrstuhl) {
            BackgroundMusicPlayer.setSelected(2);
        } else if (Settings.getBackgMusicFile(context) == R.raw.mario) {
            BackgroundMusicPlayer.setSelected(3);
        }
        spinner.setSelection(BackgroundMusicPlayer.getSelected());

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                String item = spinner.getSelectedItem().toString();


                if(BackgroundMusicPlayer.getSelected() == spinner.getSelectedItemPosition())
                {
                    return;
                }
                BackgroundMusicPlayer.setSelected(spinner.getSelectedItemPosition());

                if (item.equals(getResources().getString(R.string.str_cantina_music))) {
                    Settings.setBackgMusicFile(context, R.raw.cantina);
                    BackgroundMusicPlayer.stopAudio();
                    BackgroundMusicPlayer.playAudio(context);
                } else if (item.equals(getResources().getString(R.string.str_elevator_music))) {
                    Settings.setBackgMusicFile(context, R.raw.fahrstuhl);
                    BackgroundMusicPlayer.stopAudio();
                    BackgroundMusicPlayer.playAudio(context);
                } else if (item.equals(getResources().getString(R.string.str_mario_music))) {
                    Settings.setBackgMusicFile(context, R.raw.mario);
                    BackgroundMusicPlayer.stopAudio();
                    BackgroundMusicPlayer.playAudio(context);
                } else if (item.equals(getResources().getString(R.string.str_gummibear_music))) {
                    Settings.setBackgMusicFile(context, R.raw.gummibaer);
                    BackgroundMusicPlayer.stopAudio();
                    BackgroundMusicPlayer.playAudio(context);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void navigateWelcomeScreen() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
