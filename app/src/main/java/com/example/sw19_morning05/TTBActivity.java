package com.example.sw19_morning05;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class TTBActivity extends Activity {

    Context context;
    int block_color = 0;
    int background_color = 0;
    CountDownTimer cdt_play_time;
    int ttb_block_counter = 0;

    ViewGroup.LayoutParams last_block_size;
    float last_block_x_position;
    float last_block_y_position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context = this.getApplicationContext();
        super.onCreate(savedInstanceState);
        initTTB();
    }

    private void initTTB() {
        setContentView(R.layout.activity_ttb);

        Button btn_play = (Button) findViewById(R.id.btn_play);
        Button btn_settings = (Button) findViewById(R.id.btn_settings_ttb);
        Button btn_backToWelcomeScreen = (Button) findViewById(R.id.btn_back_main);

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

        final Button btn_block = (Button) findViewById(R.id.moving_block);
        final Button btn_background = (Button) findViewById(R.id.btn_background);
        final TextView tv_timer = (TextView) findViewById(R.id.timer);
        Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();

        if (ttb_block_counter > 0) {
            btn_block.setLayoutParams(last_block_size);
            btn_block.setY(last_block_y_position);
            btn_block.setX(last_block_x_position);
        }
        else
        {
            ViewGroup.LayoutParams new_params = btn_block.getLayoutParams();
            new_params.width = display.getWidth();
            btn_block.setLayoutParams(new_params);
        }

        final MediaPlayer mp_alarm = MediaPlayer.create(this, R.raw.alarm);

        tv_timer.setText("TIME: " + 3 + ":" + 000);
        cdt_play_time = new CountDownTimer(3000, 1) {
            public void onTick(long millisUntilFinished) {
                tv_timer.setText("TIME: " + millisUntilFinished / 1000 + ":" + millisUntilFinished % 1000);

                if (millisUntilFinished < 1000) {
                    mp_alarm.start();
                }
            }

            public void onFinish() {
                if (mp_alarm.isPlaying()) {
                    mp_alarm.stop();
                }
                clickedBackground(btn_block, btn_background, tv_timer);
            }
        };


        final int get_width = display.getWidth();
        final int get_height = display.getHeight();
        double start_height = get_height / 2 * Math.random();
        final Rect boundaries = new Rect();
        Paint textPaint = tv_timer.getPaint();
        String text = "Time: ";
        textPaint.getTextBounds(text, 0, text.length(), boundaries);

        final int textview_height = boundaries.height() * 2;

        if (start_height < textview_height) {
            start_height += textview_height;
        }

        if (ttb_block_counter == 0) {
            btn_block.setY((float) (textview_height));
        }

        btn_block.setEnabled(false);
        btn_block.setVisibility(View.INVISIBLE);
        btn_background.setEnabled(false);



        if (background_color != 0) {
            btn_background.setBackgroundColor(background_color);
        }

        if (block_color != 0) {
            btn_block.setBackgroundColor(block_color);
        }

        btn_block.setEnabled(true);
        btn_block.setVisibility(View.VISIBLE);
        btn_background.setEnabled(true);

        if (btn_block.getWidth() > get_width) {
            btn_block.setWidth(get_width);
        }
        if (btn_block.getHeight() > get_height) {
            btn_block.setHeight(get_height);
        }
        btn_block.setWidth(get_width);

        btn_block.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clickedBlock(mp_alarm, btn_block, get_width, get_height, textview_height);
            }
        });

        btn_background.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mp_alarm.stop();
                clickedBackground(btn_block, btn_background, tv_timer);
            }
        });

        final Button btn_restart = findViewById(R.id.btn_reset_ttb);
        final Button btn_back = findViewById(R.id.btn_back_ttb);
        final Button btn_continue = (Button) findViewById(R.id.btn_continue_ttb);

        btn_restart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Context context = getApplicationContext();
                Score.incrementScore(context, ttb_block_counter);
                Statistics.addHighScore(context, Settings.getUsername(context), ttb_block_counter);
                ttb_block_counter = 0;
                playTTB();
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Context context = getApplicationContext();
                Score.incrementScore(context, ttb_block_counter);
                Statistics.addHighScore(context, Settings.getUsername(context), ttb_block_counter);
                ttb_block_counter = 0;
                initTTB();
            }
        });

        btn_continue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getApplicationContext();
                Score.decrementScore(getApplicationContext(), 10);
                playTTB();
            }
        });
    }

    private void settingsTTB() {

        setContentView(R.layout.settings_ttb);

        final Button btn_block_green = findViewById(R.id.btn_green);
        final Button btn_block_blue = findViewById(R.id.btn_blue);
        final Button btn_block_red = findViewById(R.id.btn_red);
        final Button btn_block_magenta = findViewById(R.id.btn_magenta);
        final Button btn_background_white = findViewById(R.id.btn_white_background);
        final Button btn_background_grey = findViewById(R.id.btn_grey_background);
        final Button btn_background_black = findViewById(R.id.btn_black_background);
        final Button btn_background_magenta = findViewById(R.id.btn_magenta_background);

        final Button btn_back = findViewById(R.id.btn_settings_back_ttb);
        final Button btn_ok = findViewById(R.id.btn_settings_ok_ttb);

        btn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                block_color = 0;
                background_color = 0;
                initTTB();
            }
        });

        btn_ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                initTTB();
            }
        });

        btn_block_green.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                block_color = getResources().getColor(R.color.colorGreen);
                disableButtons(btn_block_green, btn_block_blue, btn_block_red, btn_block_magenta);
            }
        });


        btn_block_blue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                block_color = getResources().getColor(R.color.colorBlue);
                disableButtons(btn_block_green, btn_block_blue, btn_block_red, btn_block_magenta);
            }
        });


        btn_block_red.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                block_color = getResources().getColor(R.color.colorRed);
                disableButtons(btn_block_green, btn_block_blue, btn_block_red, btn_block_magenta);
            }
        });


        btn_block_magenta.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (background_color == getResources().getColor(R.color.colorMagenta)) {
                    btn_block_magenta.setError("");
                    return;
                }

                block_color = getResources().getColor(R.color.colorMagenta);
                disableButtons(btn_block_green, btn_block_blue, btn_block_red, btn_block_magenta);
            }
        });

        btn_background_black.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                background_color = getResources().getColor(R.color.colorBlack);
                disableButtons(btn_background_black, btn_background_grey, btn_background_white, btn_background_magenta);
            }
        });

        btn_background_grey.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                background_color = getResources().getColor(R.color.colorGrey);
                disableButtons(btn_background_black, btn_background_grey, btn_background_white, btn_background_magenta);
            }
        });

        btn_background_white.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                background_color = getResources().getColor(R.color.colorWhite);
                disableButtons(btn_background_black, btn_background_grey, btn_background_white, btn_background_magenta);
            }
        });

        btn_background_magenta.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (block_color == getResources().getColor(R.color.colorMagenta)) {
                    btn_background_magenta.setError("");
                    return;
                }

                background_color = getResources().getColor(R.color.colorMagenta);
                disableButtons(btn_background_black, btn_background_grey, btn_background_white, btn_background_magenta);
            }
        });
    }

    public void clickedBackground(Button block, Button background, TextView timer) {
        Context context = this.getApplicationContext();
        if (Score.getScore(context) < 10) {
            findViewById(R.id.btn_continue_ttb).setEnabled(false);
        } else {
            findViewById(R.id.btn_continue_ttb).setEnabled(true);
        }

        findViewById(R.id.win_ly).setVisibility(View.VISIBLE);
        block.setVisibility(View.INVISIBLE);
        background.setVisibility((View.INVISIBLE));
        Vibration.vibrate(context, 1000);
        cdt_play_time.cancel();
    }

    public void clickedBlock(MediaPlayer alarm, Button block, int width, int height, int textview_height) {
        ttb_block_counter++;
        cdt_play_time.cancel();
        if (alarm.isPlaying()) {
            alarm.pause();
            alarm.seekTo(0);
        }

        cdt_play_time.start();

        Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        ViewGroup.LayoutParams params = block.getLayoutParams();
        if (params.height > display.getHeight()) {
            params.height = display.getHeight();
        }
        if (params.width > display.getWidth()) {
            params.width = display.getWidth();
        }
        if (Math.random() >= 0.5) {
            params.height = params.height / 2;
        } else
            params.width = params.width / 2;
        last_block_size = params;
        block.setLayoutParams(params);

        Resources resources = context.getResources();
        int resource_id = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        int nav_bar_height = resources.getDimensionPixelSize(resource_id);

        Random randi = new Random();
        int range_width = randi.nextInt(width);
        int range_height = randi.nextInt(height - nav_bar_height);

        if ((width - range_width) < params.width)
            block.setX(width - params.width);
        else
            block.setX(range_width);

        if (range_height < textview_height)
            range_height += textview_height;

        if ((height - range_height) < params.height) {
            block.setY(height - params.height);
        } else
            block.setY(range_height);

        if((range_height + params.height) > (height - nav_bar_height))
        {
            block.setY(height - params.height);
        }

        last_block_x_position = block.getX();
        last_block_y_position = block.getY();

    }


    private void disableButtons(Button button_1, Button button_2, Button button_3,
                                Button button_4) {
        button_1.setEnabled(false);
        button_1.setVisibility(View.INVISIBLE);
        button_2.setEnabled(false);
        button_2.setVisibility(View.INVISIBLE);
        button_3.setEnabled(false);
        button_3.setVisibility(View.INVISIBLE);
        button_4.setEnabled(false);
        button_4.setVisibility(View.INVISIBLE);
    }
}
