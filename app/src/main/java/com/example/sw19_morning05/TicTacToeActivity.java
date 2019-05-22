package com.example.sw19_morning05;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;


public class TicTacToeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttons[][] = new Button[3][3];
    private int board[][] = new int[3][3];


    private int color[] = {
            R.color.colorBlack,
            R.color.colorRed,
            R.color.colorBlue,
            R.color.colorGreen
    };

    private int sign_color = R.color.colorBlack;
    private int sign_color_opp = R.color.colorBlack;
    private String sign_me = "X";
    private String sign_opp = "O";

    private int current_player = 1;

    private CheckBox cbox_autoplayer_easy;
    private CheckBox cbox_autoplayer_hard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initTicTacToe();
    }

    private void initTicTacToe() {
        setContentView(R.layout.activity_tictactoe);

        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {
                String buttonID = "bt_field" + col + "" + row;
                int resourceID = getResources().getIdentifier(
                        buttonID, "id", getPackageName());

                buttons[col][row] = findViewById(resourceID);
                buttons[col][row].setOnClickListener(this);
            }
        }

        TextView tv_currentPlayer = findViewById(R.id.textv_current_player);
        tv_currentPlayer.setText(getResources().getString(R.string.str_textv_player1_turn));

        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {
                board[col][row] = -1;
            }
        }

        Button btnTicTacToe = (Button) findViewById(R.id.btn_back_ttt);
        btnTicTacToe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                navigateWelcomeScreen();
            }
        });

        Button reset_button = findViewById(R.id.btn_reset_ttt);
        reset_button.setOnClickListener(this);

        ImageButton button_settings = findViewById(R.id.btn_settings_ttt);

        button_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initSettingsTicTacToe();
            }
        });

        final CheckBox cbox_auto_play_easy = findViewById(R.id.cbox_autoplayer_easy_ttt);
        cbox_auto_play_easy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox cbox_auto_play_hard = findViewById(R.id.cbox_autoplayer_hard_ttt);

                if (cbox_auto_play_hard.isChecked() && cbox_auto_play_easy.isChecked()) {
                    cbox_auto_play_hard.setChecked(false);
                    cbox_auto_play_easy.setChecked(true);
                }
            }
        });

        final CheckBox cbox_auto_play_hard = findViewById(R.id.cbox_autoplayer_hard_ttt);
        cbox_auto_play_hard.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox cbox_auto_play_easy = findViewById(R.id.cbox_autoplayer_easy_ttt);

                if (cbox_auto_play_easy.isChecked() && cbox_auto_play_hard.isChecked()) {
                    cbox_auto_play_easy.setChecked(false);
                    cbox_auto_play_hard.setChecked(true);
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        Context context = this.getApplicationContext();

        cbox_autoplayer_easy = findViewById(R.id.cbox_autoplayer_easy_ttt);
        cbox_autoplayer_hard = findViewById(R.id.cbox_autoplayer_hard_ttt);
        cbox_autoplayer_easy.setEnabled(false);
        cbox_autoplayer_hard.setEnabled(false);

        int view_id = view.getId();

        if (R.id.btn_reset_ttt == view_id) {
            resetBoard();
            return;
        }

        TextView tv_current_player;
        tv_current_player = findViewById(R.id.textv_current_player);

        int return_value_winner;

        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {
                if (buttons[col][row].getId() == view_id) {
                    if (current_player == 1) {
                        buttons[col][row].setText(sign_me);
                        buttons[col][row].setTextColor(getResources().getColor(sign_color));
                        tv_current_player.setText(getResources().getString(R.string.str_textv_player2_turn));
                    } else {
                        buttons[col][row].setText(sign_opp);
                        buttons[col][row].setTextColor(getResources().getColor(sign_color_opp));
                        tv_current_player.setText(getResources().getString(R.string.str_textv_player1_turn));
                    }

                    buttons[col][row].setEnabled(false);
                    board[col][row] = current_player;
                    return_value_winner = calculateWinner(board);

                    if (return_value_winner == 1) {
                        tv_current_player.setText(getResources().getString(R.string.str_textv_player1_wins));
                        disableBoardAfterEndOfGame(board);
                        Score.incrementScore(context, 1);
                        Vibration.vibrate(context, 1000);
                        return;
                    } else if (return_value_winner == 2) {
                        tv_current_player.setText(getResources().getString(R.string.str_textv_player2_wins));
                        disableBoardAfterEndOfGame(board);
                        Score.decrementScore(context, 2);
                        Vibration.vibrate(context, 1000);
                        return;
                    } else if (return_value_winner == 0) {
                        tv_current_player.setText(getResources().getString(R.string.str_textv_draw));
                        Vibration.vibrate(context, 1000);
                        return;
                    }

                    current_player = (current_player == 1) ? 2 : 1;
                    break;
                }
            }
        }

        if (cbox_autoplayer_easy.isChecked()) {
            Random randi = new Random();
            int row;
            int col;

            while (true) {
                row = randi.nextInt(3);
                col = randi.nextInt(3);

                if (buttons[row][col].isEnabled()) {

                    buttons[row][col].setText(sign_opp);
                    buttons[row][col].setTextColor(getResources().getColor(sign_color_opp));
                    buttons[row][col].setEnabled(false);
                    board[row][col] = current_player;

                    return_value_winner = calculateWinner(board);

                    if (return_value_winner == 1) {
                        tv_current_player.setText(getResources().getString(R.string.str_textv_player1_wins));
                        disableBoardAfterEndOfGame(board);
                        Score.incrementScore(context, 1);
                        return;
                    } else if (return_value_winner == 2) {
                        tv_current_player.setText(getResources().getString(R.string.str_textv_player2_wins));
                        disableBoardAfterEndOfGame(board);
                        Score.decrementScore(context, 2);
                        return;
                    } else if (return_value_winner == 0) {
                        tv_current_player.setText(getResources().getString(R.string.str_textv_draw));
                        return;
                    }
                    current_player = (current_player == 1) ? 2 : 1;
                    tv_current_player.setText(getResources().getString(R.string.str_textv_player1_turn));
                    break;
                }
            }
        } else if (cbox_autoplayer_hard.isChecked()) {
            int row = 0;
            int col = 0;

            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 2; j++){
                    if (!buttons[i][j].isEnabled())
                    {
                        row = i;
                        col = j;
                    }
                }
            }
            if (row == 1 && col == 1)
            {
                buttons[0][0].setText(sign_opp);
                buttons[0][0].setTextColor(getResources().getColor(sign_color_opp));
                buttons[0][0].setEnabled(false);
                board[0][0] = current_player;
            }
            else if ((row == 0 && col == 0) || (row == 2 && col == 0) ||
                    (row == 0 && col == 2) || (row == 2 && col == 2))
            {
                int temp_row = 0;
                int temp_col = 0;

                if (row == 0)
                    temp_row = 2;
                if (col == 0)
                    temp_col = 2;
                if (row == 2)
                    temp_row = 0;
                if (col == 2)
                    temp_col = 0;

                buttons[temp_row][temp_col].setText(sign_opp);
                buttons[temp_row][temp_col].setTextColor(getResources().getColor(sign_color_opp));
                buttons[temp_row][temp_col].setEnabled(false);
                board[temp_row][temp_col] = current_player;
            }
            else if ((row == 0 && col == 1) || (row == 1 && col == 0) ||
                    (row == 1 && col == 2) || (row == 2 && col == 1))
            {
                buttons[1][1].setText(sign_opp);
                buttons[1][1].setTextColor(getResources().getColor(sign_color_opp));
                buttons[1][1].setEnabled(false);
                board[1][1] = current_player;
            }

            return_value_winner = calculateWinner(board);

            if (return_value_winner == 1) {
                tv_current_player.setText(getResources().getString(R.string.str_textv_player1_wins));
                disableBoardAfterEndOfGame(board);
                Score.incrementScore(context, 1);
                return;
            } else if (return_value_winner == 2) {
                tv_current_player.setText(getResources().getString(R.string.str_textv_player2_wins));
                disableBoardAfterEndOfGame(board);
                Score.decrementScore(context, 2);
                return;
            } else if (return_value_winner == 0) {
                tv_current_player.setText(getResources().getString(R.string.str_textv_draw));
                return;
            }
            current_player = (current_player == 1) ? 2 : 1;
            tv_current_player.setText(getResources().getString(R.string.str_textv_player1_turn));
        }
    }

    public void disableBoardAfterEndOfGame(int board[][]) {
        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {
                if (board[col][row] == -1) {
                    buttons[col][row].setEnabled(false);
                }
            }
        }
    }

    public static int calculateWinner(int board[][]) {
        for (int col = 0; col < 3; col++) {
            if ((board[col][0] == board[col][1]) && (board[col][1] == board[col][2])) {
                if (board[col][0] == 1) {
                    return 1;
                }
                if (board[col][0] == 2) {
                    return 2;
                }
            }
        }
        for (int row = 0; row < 3; row++) {
            if ((board[0][row] == board[1][row]) && (board[1][row] == board[2][row])) {
                if (board[0][row] == 1) {
                    return 1;
                }
                if (board[0][row] == 2) {
                    return 2;
                }
            }
        }
        if (((board[0][0] == board[1][1]) && (board[1][1] == board[2][2])) ||
                (board[0][2] == board[1][1]) && (board[1][1] == board[2][0])) {
            if (board[1][1] == 1) {
                return 1;
            }
            if (board[1][1] == 2) {
                return 2;
            }
        }
        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {
                if (board[col][row] == -1) {
                    return -1;
                }
            }
        }
        return 0;
    }

    public void resetBoard() {
        TextView tv_current_player = findViewById(R.id.textv_current_player);
        tv_current_player.setText(getResources().getString(R.string.str_textv_player1_turn));

        current_player = 1;

        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {
                board[col][row] = -1;
                buttons[col][row].setText("");
                buttons[col][row].setEnabled(true);
            }
        }
        cbox_autoplayer_easy.setEnabled(true);
        cbox_autoplayer_hard.setEnabled(true);
    }

    private void navigateWelcomeScreen() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void initSettingsTicTacToe() {
        setContentView(R.layout.settings_tictactoe);

        final Button btn_sign_x = findViewById(R.id.btn_sign_x_ttt);
        final Button btn_sign_o = findViewById(R.id.btn_sign_o_ttt);

        final Button btn_color_01 = findViewById(R.id.btn_color_01_ttt);
        final Button btn_color_02 = findViewById(R.id.btn_color_02_ttt);
        final Button btn_color_03 = findViewById(R.id.btn_color_03_ttt);
        final Button btn_color_04 = findViewById(R.id.btn_color_04_ttt);

        switch (sign_color) {
            case R.color.colorBlack:
                btn_color_01.setEnabled(false);
                btn_color_01.setBackgroundResource(R.color.colorBlackSoft);
                break;
            case R.color.colorRed:
                btn_color_02.setEnabled(false);
                btn_color_02.setBackgroundResource(R.color.colorRedSoft);
                break;
            case R.color.colorBlue:
                btn_color_03.setEnabled(false);
                btn_color_03.setBackgroundResource(R.color.colorBlueSoft);
                break;
            case R.color.colorGreen:
                btn_color_04.setEnabled(false);
                btn_color_04.setBackgroundResource(R.color.colorGreenSoft);
                break;
        }
        if (sign_me.equals("X"))
            btn_sign_x.setEnabled(false);
        else
            btn_sign_o.setEnabled(false);


        btn_sign_x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_sign_x.setEnabled(false);
                btn_sign_o.setEnabled(true);
                sign_me = "X";
                sign_opp = "0";
            }
        });

        btn_sign_o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_sign_x.setEnabled(true);
                btn_sign_o.setEnabled(false);
                sign_me = "O";
                sign_opp = "X";
            }
        });


        btn_color_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_color_01.setEnabled(false);
                btn_color_01.setBackgroundResource(R.color.colorBlackSoft);
                btn_color_02.setEnabled(true);
                btn_color_02.setBackgroundResource(R.color.colorRed);
                btn_color_03.setEnabled(true);
                btn_color_03.setBackgroundResource(R.color.colorBlue);
                btn_color_04.setEnabled(true);
                btn_color_04.setBackgroundResource(R.color.colorGreen);

                sign_color = color[0];
                pickOppColor();
            }
        });

        btn_color_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_color_01.setEnabled(true);
                btn_color_01.setBackgroundResource(R.color.colorBlack);
                btn_color_02.setEnabled(false);
                btn_color_02.setBackgroundResource(R.color.colorRedSoft);
                btn_color_03.setEnabled(true);
                btn_color_03.setBackgroundResource(R.color.colorBlue);
                btn_color_04.setEnabled(true);
                btn_color_04.setBackgroundResource(R.color.colorGreen);

                sign_color = color[1];
                pickOppColor();
            }
        });

        btn_color_03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_color_01.setEnabled(true);
                btn_color_01.setBackgroundResource(R.color.colorBlack);
                btn_color_02.setEnabled(true);
                btn_color_02.setBackgroundResource(R.color.colorRed);
                btn_color_03.setEnabled(false);
                btn_color_03.setBackgroundResource(R.color.colorBlueSoft);
                btn_color_04.setEnabled(true);
                btn_color_04.setBackgroundResource(R.color.colorGreen);

                sign_color = color[2];
                pickOppColor();
            }
        });

        btn_color_04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_color_01.setEnabled(true);
                btn_color_01.setBackgroundResource(R.color.colorBlack);
                btn_color_02.setEnabled(true);
                btn_color_02.setBackgroundResource(R.color.colorRed);
                btn_color_03.setEnabled(true);
                btn_color_03.setBackgroundResource(R.color.colorBlue);
                btn_color_04.setEnabled(false);
                btn_color_04.setBackgroundResource(R.color.colorGreenSoft);

                sign_color = color[3];
                pickOppColor();
            }
        });

        final Button bt_set_back = findViewById(R.id.btn_settings_back_ttt);
        bt_set_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initTicTacToe();
            }
        });
    }

    private void pickOppColor() {
        int c_id;
        do {
            Random randi = new Random();
            c_id = randi.nextInt(4);
        }
        while (color[c_id] == sign_color);

        sign_color_opp = color[c_id];
    }
}
