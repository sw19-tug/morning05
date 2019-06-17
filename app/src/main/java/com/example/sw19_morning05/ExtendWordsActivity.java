package com.example.sw19_morning05;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ExtendWordsActivity extends AppCompatActivity {
    private HangmanWordAdapter hangman_word_adapter;
    private ArrayList<Pair<String, Boolean>> word_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Context context = getApplicationContext();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extend_words);

        final Button btn_back = findViewById(R.id.btn_back_hm_ew);
        btn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                navigateToWelcomeScreen();
            }
        });

        final FloatingActionButton btn_dialog = findViewById(R.id.btn_add_hm_ew);
        btn_dialog.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                addWordDialog();
            }
        });

        ListView lv = findViewById(R.id.listv_list_hm_ew);
        word_list = Settings.getHangmanWordList(context);

        hangman_word_adapter = new HangmanWordAdapter(word_list, getApplicationContext());

        lv.setAdapter(hangman_word_adapter);
    }

    private void navigateToWelcomeScreen() {
        Intent intent = new Intent(this, HangmanActivity.class);
        startActivity(intent);
    }

    private boolean isWordValid(String word) {
        return ((word != null) && (word.length() > 2) && word.matches("^[a-zA-Z]*$"));
    }

    private void addWordDialog() {
        final Context context = getApplicationContext();

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.str_dialog_title_hw_ew);

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        builder.setPositiveButton(R.string.str_ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton(R.string.str_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        final AlertDialog alert_dialog = builder.create();
        alert_dialog.show();
        Button btn_plus = alert_dialog.getButton(DialogInterface.BUTTON_POSITIVE);
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String new_word = input.getText().toString().toUpperCase();
                if (!isWordValid(new_word)) {
                    Toast.makeText(ExtendWordsActivity.this,
                            getResources().getString(R.string.str_dialog_warning_hw_ew),
                            Toast.LENGTH_SHORT).show();
                } else {
                    Settings.addNewHangmanWord(context, new_word);
                    word_list = Settings.getHangmanWordList(context);
                    hangman_word_adapter.add(word_list.get(word_list.size() - 1));
                    alert_dialog.dismiss();
                }
            }
        });
    }
}
