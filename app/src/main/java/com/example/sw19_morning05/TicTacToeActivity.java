package com.example.sw19_morning05;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;


public class TicTacToeActivity extends AppCompatActivity  implements View.OnClickListener {

    private Button buttons[][] = new Button[3][3];
    private int board[][] = new int [3][3];


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

    private int currentPlayer = 1;

    private CheckBox cb_autoplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initTicTacToe();
    }

    private void initTicTacToe()
    {
        setContentView(R.layout.activity_tictactoe);

        for(int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++){
                String buttonID = "bt_field" + col + "" + row;
                int resourceID = getResources().getIdentifier(
                        buttonID, "id", getPackageName());

                buttons[col][row] = findViewById(resourceID);
                buttons[col][row].setOnClickListener(this);
            }
        }

        TextView tv_currentPlayer = findViewById(R.id.textv_current_player);
        tv_currentPlayer.setText(getResources().getString(R.string.str_textv_player1_turn));

        for(int col = 0; col < 3; col++) {
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

        button_settings.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                initSettingsTicTacToe();
            }
        });
    }

    @Override
    public void onClick(View view) {
      Context context = this.getApplicationContext();

      cb_autoplayer = findViewById(R.id.cbox_autoplayer_ttt);
      cb_autoplayer.setEnabled(false);

      int viewId = view.getId();

      if (R.id.btn_reset_ttt == viewId)
      {
          resetBoard();
          return;
      }

      TextView tv_currentPlayer;
      tv_currentPlayer = findViewById(R.id.textv_current_player);

      int return_value_winner;

      for (int col = 0; col < 3; col++)
      {
          for (int row = 0; row < 3; row++)
          {
              if (buttons[col][row].getId() == viewId)
              {
                  if (currentPlayer == 1)
                  {
                      buttons[col][row].setText(sign_me);
                      buttons[col][row].setTextColor(getResources().getColor(sign_color));
                      tv_currentPlayer.setText(getResources().getString(R.string.str_textv_player2_turn));
                  }
                  else
                  {
                      buttons[col][row].setText(sign_opp);
                      buttons[col][row].setTextColor(getResources().getColor(sign_color_opp));
                      tv_currentPlayer.setText(getResources().getString(R.string.str_textv_player1_turn));
                  }

                  buttons[col][row].setEnabled(false);
                  board[col][row] = currentPlayer;
                  return_value_winner = calculateWinner(board);

                  if(return_value_winner == 1)
                  {
                      tv_currentPlayer.setText(getResources().getString(R.string.str_textv_player1_wins));
                      disableBoardAfterEndOfGame(board);
                      Score.incrementScore(context, 1);
                      return;
                  }
                  else if(return_value_winner == 2)
                  {
                      tv_currentPlayer.setText(getResources().getString(R.string.str_textv_player2_wins));
                      disableBoardAfterEndOfGame(board);
                      Score.decrementScore(context, 2);
                      return;
                  }
                  else if(return_value_winner == 0)
                  {
                      tv_currentPlayer.setText(getResources().getString(R.string.str_textv_draw));
                      return;
                  }

                  currentPlayer = (currentPlayer == 1) ? 2 : 1;
                  break;
              }
          }
      }

      if(cb_autoplayer.isChecked())
      {
          Random randi = new Random();
          int row;
          int col;

          while(true)
          {
              row = randi.nextInt(3);
              col = randi.nextInt(3);

              if(buttons[row][col].isEnabled())
              {
                  buttons[row][col].setText(sign_opp);
                  buttons[row][col].setTextColor(getResources().getColor(sign_color_opp));
                  buttons[row][col].setEnabled(false);
                  board[row][col] = currentPlayer;

                  return_value_winner = calculateWinner(board);

                  if(return_value_winner == 1)
                  {
                      tv_currentPlayer.setText(getResources().getString(R.string.str_textv_player1_wins));
                      disableBoardAfterEndOfGame(board);
                      Score.incrementScore(context, 1);
                      return;
                  }
                  else if(return_value_winner == 2)
                  {
                      tv_currentPlayer.setText(getResources().getString(R.string.str_textv_player2_wins));
                      disableBoardAfterEndOfGame(board);
                      Score.decrementScore(context, 2);
                      return;
                  }
                  else if(return_value_winner == 0)
                  {
                      tv_currentPlayer.setText(getResources().getString(R.string.str_textv_draw));
                      return;
                  }

                  currentPlayer = (currentPlayer == 1) ? 2 : 1;
                  tv_currentPlayer.setText(getResources().getString(R.string.str_textv_player1_turn));

                  break;
              }
          }
      }
    }

    public void disableBoardAfterEndOfGame(int board[][])
    {
        for(int col = 0; col < 3; col++){
            for(int row = 0; row < 3; row++){
                if(board[col][row] == -1){
                    buttons[col][row].setEnabled(false);
                }
            }
        }
    }

    public static int calculateWinner(int board[][])
    {
        for(int col = 0; col < 3; col++){
            if((board[col][0] == board[col][1]) && (board[col][1] == board[col][2])) {
                if(board[col][0] == 1){
                    return 1;
                }
                if(board[col][0] == 2){
                    return 2;
                }
            }
        }
        for(int row = 0; row < 3; row++){
            if((board[0][row] == board[1][row]) && (board[1][row] == board[2][row])) {
                if(board[0][row] == 1){
                    return 1;
                }
                if(board[0][row] == 2){
                    return 2;
                }
            }
        }
        if(((board[0][0] == board[1][1]) && (board[1][1] == board[2][2])) ||
                (board[0][2] == board[1][1]) && (board[1][1] == board[2][0])){
            if(board[1][1] == 1){
                return 1;
            }
            if(board[1][1] == 2){
                return 2;
            }
        }
        for(int col = 0; col < 3; col++){
            for(int row = 0; row < 3; row++){
                if(board[col][row] == -1){
                    return -1;
                }
            }
        }
        return 0;
    }

    public void resetBoard()
    {
        TextView tv_currentPlayer = findViewById(R.id.textv_current_player);
        tv_currentPlayer.setText(getResources().getString(R.string.str_textv_player1_turn));

        currentPlayer = 1;

        for(int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {
                board[col][row] = -1;
                buttons[col][row].setText("");
                buttons[col][row].setEnabled(true);
            }
        }
        cb_autoplayer.setEnabled(true);
    }

    private void navigateWelcomeScreen() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void initSettingsTicTacToe()
    {
        setContentView(R.layout.settings_tictactoe);

        final Button btn_sign_X = findViewById(R.id.btn_sign_x_ttt);
        final Button btn_sign_O = findViewById(R.id.btn_sign_o_ttt);

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
        if(sign_me.equals("X"))
            btn_sign_X.setEnabled(false);
        else
            btn_sign_O.setEnabled(false);



        btn_sign_X.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                btn_sign_X.setEnabled(false);
                btn_sign_O.setEnabled(true);
                sign_me = "X";
                sign_opp = "0";
            }
        });

        btn_sign_O.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                btn_sign_X.setEnabled(true);
                btn_sign_O.setEnabled(false);
                sign_me = "O";
                sign_opp = "X";
            }
        });



        btn_color_01.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
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

        btn_color_02.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
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

        btn_color_03.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
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

        btn_color_04.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
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
        bt_set_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                initTicTacToe();
            }
        });
    }

    private void pickOppColor()
    {
        int c_id;
        do {
            Random randi = new Random();
            c_id = randi.nextInt(4);
        }
        while (color[c_id] == sign_color);

        sign_color_opp = color[c_id];
    }
}
