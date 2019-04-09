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
import android.widget.Toast;
import android.widget.TextView;

import java.util.Random;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class TTBActivity extends Activity {

    boolean button_ready = false;
    boolean background_ready = false;
    boolean button_is_magenta = false;
    int temp_color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.ttb_activity);

        final Button block = (Button)findViewById(R.id.moving_block);
        final Button background = (Button)findViewById(R.id.background_btn);
        final Button block_green = (Button)findViewById(R.id.green_button);
        final Button block_blue = (Button)findViewById(R.id.blue_button);
        final Button block_red = (Button)findViewById(R.id.red_button);
        final Button block_magenta = (Button)findViewById(R.id.magenta_button);
        final Button background_white = (Button)findViewById(R.id.white_background);
        final Button background_grey = (Button)findViewById(R.id.grey_background);
        final Button background_black = (Button)findViewById(R.id.black_background);
        final Button background_magenta = (Button)findViewById(R.id.magenta_background);

        final TextView button_color = (TextView)findViewById(R.id.button_title);
        final TextView background_color = (TextView)findViewById(R.id.background_title);

        final Button restart = (Button)findViewById(R.id.button_reset);
        final Button back = (Button)findViewById(R.id.btn_backTouchTheBlock);

        Display d = ((WindowManager)getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        final int w = d.getWidth();
        final int h = d.getHeight();
        //Changing start position
        block.setY((float)((h / 2) * Math.random()));

        block.setEnabled(false);
        block.setVisibility(View.INVISIBLE);
        background.setEnabled(false);


        //------------------------------------------------------------------------------------------
        block_green.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                block.setBackgroundColor(0xFF00FF00);
                disableButtons(block_green, block_blue, block_red, block_magenta, button_color);
                button_ready = true;
                if (background_ready)
                {
                    startGame(block, background);
                }
            }
        });


        //------------------------------------------------------------------------------------------
        block_blue.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                block.setBackgroundColor(0xFF00FFFF);
                disableButtons(block_green, block_blue, block_red, block_magenta, button_color);
                button_ready = true;
                if (background_ready)
                {
                    startGame(block, background);
                }
            }
        });


        //------------------------------------------------------------------------------------------
        block_red.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                block.setBackgroundColor(0xFFFF000F);
                disableButtons(block_green, block_blue, block_red, block_magenta, button_color);
                button_ready = true;
                if (background_ready)
                {
                    startGame(block, background);
                }
            }
        });


        //------------------------------------------------------------------------------------------
        block_magenta.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                if (temp_color == 0xFFFF00FF)
                {
                    block_magenta.setError("");
                    return;
                }
                block.setBackgroundColor(0xFFFF00FF);
                disableButtons(block_green, block_blue, block_red, block_magenta, button_color);
                button_ready = true;
                button_is_magenta = true;
                if (background_ready)
                {
                    startGame(block, background);
                }
            }
        });



        //------------------------------------------------------------------------------------------
        //------------------------------------------------------------------------------------------
        background_black.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                temp_color = 0xFF000000;
                disableButtons(background_black, background_grey, background_white,
                        background_magenta, background_color);
                background_ready = true;
                if (button_ready)
                {
                    startGame(block, background);
                }
            }
        });


        //------------------------------------------------------------------------------------------
        background_grey.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                temp_color = 0xFF888888;
                disableButtons(background_black, background_grey, background_white,
                        background_magenta, background_color);
                background_ready = true;
                if (button_ready)
                {
                    startGame(block, background);
                }
            }
        });


        //------------------------------------------------------------------------------------------
        background_white.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                temp_color = 0xFFFFFF;
                disableButtons(background_black, background_grey, background_white,
                        background_magenta, background_color);
                background_ready = true;
                if (button_ready)
                {
                    startGame(block, background);
                }
            }
        });


        //------------------------------------------------------------------------------------------
        background_magenta.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                if (button_is_magenta)
                {
                    background_magenta.setError("");
                    return;
                }
                temp_color = 0xFFFF00FF;
                disableButtons(background_black, background_grey, background_white,
                        background_magenta, background_color);
                background_ready = true;
                if (button_ready)
                {
                    startGame(block, background);
                }
            }
        });


        //------------------------------------------------------------------------------------------
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
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        // returns to the start page, when the user touches the background
        background.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                findViewById(R.id.win_ly).setVisibility(View.VISIBLE);
                block.setVisibility(View.INVISIBLE);
                background.setVisibility((View.INVISIBLE));
            }
        });
    }


    private void startGame(Button block, Button background)
    {
        background.setBackgroundColor(temp_color);
        block.setEnabled(true);
        block.setVisibility(View.VISIBLE);
        background.setEnabled(true);
    }

    private void disableButtons(Button button1, Button button2, Button button3,
                                Button button4, TextView title)
    {
        button1.setEnabled(false);
        button1.setVisibility(View.INVISIBLE);
        button2.setEnabled(false);
        button2.setVisibility(View.INVISIBLE);
        button3.setEnabled(false);
        button3.setVisibility(View.INVISIBLE);
        button4.setEnabled(false);
        button4.setVisibility(View.INVISIBLE);
        title.setVisibility(View.INVISIBLE);
    }


}
