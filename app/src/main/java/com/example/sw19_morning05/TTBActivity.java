package com.example.sw19_morning05;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class TTBActivity extends Activity {

    boolean button_ready = false;
    boolean background_ready = false;
    int temp_color;

    int block_color = 0;
    int background_color = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        initTTB();
    }

    private void initTTB() {
        setContentView(R.layout.activity_ttb);

        Button btn_play = (Button)findViewById(R.id.btn_play);
        Button btn_settings = (Button)findViewById(R.id.btn_settings_ttb);
        Button btn_backToWelcomeScreen = (Button)findViewById(R.id.btn_back_main);

        btn_play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                playTTB();
            }
        });


        btn_settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                settingsTTB();
            }
        });


        btn_backToWelcomeScreen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void playTTB() {
        setContentView(R.layout.play_ttb);

        final Button block = (Button)findViewById(R.id.moving_block);
        final Button background = (Button)findViewById(R.id.background_btn);

        Display d = ((WindowManager)getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        final int w = d.getWidth();
        final int h = d.getHeight();
        //Changing start position
        block.setY((float)((h / 2) * Math.random()));

        block.setEnabled(false);
        block.setVisibility(View.INVISIBLE);
        background.setEnabled(false);

        block.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {

                //Changing block size
                ViewGroup.LayoutParams params = block.getLayoutParams();
                if (Math.random() >= 0.5)
                    params.height = params.height/2;
                else
                    params.width = params.width/2;
                block.setLayoutParams(params);

                //Changing position
                Random r = new Random();
                int range_width = r.nextInt(w);
                int range_height = r.nextInt(h);

                //handles that the button stays completely in the screen
                if ((w - range_width) < params.width)
                    block.setX(w - params.width);
                else
                    block.setX(range_width);

                if ((h - range_height) < params.height)
                    block.setY(h - params.height);
                else
                    block.setY(range_height);
            }
        });

        if (background_color != 0) {
            background.setBackgroundColor(background_color);
        }

        if (block_color != 0) {
            block.setBackgroundColor(block_color);
        }

        block.setEnabled(true);
        block.setVisibility(View.VISIBLE);
        background.setEnabled(true);

        background.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                clickedBackground(block, background);
            }
        });

        final Button restart = findViewById(R.id.button_reset);
        final Button back = findViewById(R.id.btn_backTouchTheBlock);

        restart.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(), TTBActivity.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                initTTB();
            }
        });
    }

    private void settingsTTB() {
        setContentView(R.layout.settings_ttb);

        final Button block_green = findViewById(R.id.green_button);
        final Button block_blue = findViewById(R.id.blue_button);
        final Button block_red = findViewById(R.id.red_button);
        final Button block_magenta = findViewById(R.id.magenta_button);
        final Button background_white = findViewById(R.id.white_background);
        final Button background_grey = findViewById(R.id.grey_background);
        final Button background_black = findViewById(R.id.black_background);
        final Button background_magenta = findViewById(R.id.magenta_background);

        final Button back = findViewById(R.id.btn_settings_ttb_back);
        final Button ok = findViewById(R.id.btn_settings_ttb_ok);

        back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                block_color = 0;
                background_color = 0;
                initTTB();
            }
        });

        ok.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                initTTB();
            }
        });

        block_green.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                block_color = getResources().getColor(R.color.colorGreen);
                disableButtons(block_green, block_blue, block_red, block_magenta);
            }
        });


        block_blue.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                block_color = getResources().getColor(R.color.colorBlue);
                disableButtons(block_green, block_blue, block_red, block_magenta);
            }
        });


        block_red.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                block_color = getResources().getColor(R.color.colorRed);
                disableButtons(block_green, block_blue, block_red, block_magenta);
            }
        });


        block_magenta.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                if (background_color == getResources().getColor(R.color.colorMagenta))
                {
                    block_magenta.setError("");
                    return;
                }

                block_color = getResources().getColor(R.color.colorRed);
                disableButtons(block_green, block_blue, block_red, block_magenta);
            }
        });

        background_black.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                background_color = getResources().getColor(R.color.colorRed);
                disableButtons(background_black, background_grey, background_white, background_magenta);
            }
        });

        background_grey.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                background_color = getResources().getColor(R.color.colorGrey);
                disableButtons(background_black, background_grey, background_white, background_magenta);
            }
        });

        background_white.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                background_color = getResources().getColor(R.color.colorWhite);
                disableButtons(background_black, background_grey, background_white, background_magenta);
            }
        });

        background_magenta.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                if (block_color == getResources().getColor(R.color.colorMagenta))
                {
                    background_magenta.setError("");
                    return;
                }

                background_color = getResources().getColor(R.color.colorMagenta);
                disableButtons(background_black, background_grey, background_white, background_magenta);
            }
        });
    }

    public void clickedBackground(Button block, Button background) {
        findViewById(R.id.win_ly).setVisibility(View.VISIBLE);
        block.setVisibility(View.INVISIBLE);
        background.setVisibility((View.INVISIBLE));
    }

    private void disableButtons(Button button1, Button button2, Button button3,
                                Button button4)
    {
        button1.setEnabled(false);
        button1.setVisibility(View.INVISIBLE);
        button2.setEnabled(false);
        button2.setVisibility(View.INVISIBLE);
        button3.setEnabled(false);
        button3.setVisibility(View.INVISIBLE);
        button4.setEnabled(false);
        button4.setVisibility(View.INVISIBLE);
    }
}
