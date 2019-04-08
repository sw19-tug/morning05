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

import java.util.Random;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class TTBActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.ttb_activity);


        final Button block = (Button)findViewById(R.id.moving_block);
        final Button restart = (Button)findViewById(R.id.button_reset);
        final Button back = (Button)findViewById(R.id.btn_backTouchTheBlock);

        Display d = ((WindowManager)getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        final int w = d.getWidth();
        final int h = d.getHeight();

        //Changing start position
        block.setY((float)((h / 2) * Math.random()));

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
        final Button background = (Button)findViewById(R.id.background_btn);

        background.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                findViewById(R.id.win_ly).setVisibility(View.VISIBLE);
                block.setVisibility(View.INVISIBLE);
                background.setVisibility((View.INVISIBLE));
            }
        });
    }
}
