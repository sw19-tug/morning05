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
      R.color.ttt_b1_black_normal,
      R.color.ttt_b2_red_normal,
      R.color.ttt_b3_blue_normal,
      R.color.ttt_b4_green_normal
    };

    private int sign_color = R.color.ttt_b1_black_normal;
    private int sign_color_opp = R.color.ttt_b1_black_normal;
    private String sign = "X";
    private String sign_opp = "O";

    private int currentPlayer = 1;  // 1 = Player 1, 2 = Player 2

    private CheckBox cb_autoplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initTicTacToe();
    }

    private void initTicTacToe()
    {
        setContentView(R.layout.activity_tictactoe);

        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++){
                String buttonID = "bt_field" + i + "" + j;
                int resourceID = getResources().getIdentifier(
                        buttonID, "id", getPackageName());

                buttons[i][j] = findViewById(resourceID);
                buttons[i][j].setOnClickListener(this);
            }
        }

        TextView tv_currentPlayer = findViewById(R.id.tv_currentPlayer);
        tv_currentPlayer.setText(getResources().getString(R.string.tv_player1_turn));

        //initialize board
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = -1;
            }
        }

        Button btnTicTacToe = (Button) findViewById(R.id.bt_backTicTacToe);
        btnTicTacToe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                navigateWelcomeScreen();
            }
        });

        Button reset_button = findViewById(R.id.bt_reset);
        reset_button.setOnClickListener(this);

        ImageButton button_settings = findViewById(R.id.bt_settings);

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

      cb_autoplayer = findViewById(R.id.cb_autoplayer);
      cb_autoplayer.setEnabled(false);

      int viewId = view.getId();

      if (R.id.bt_reset == viewId)
      {
          resetBoard();
          return;
      }

      TextView tv_currentPlayer;
      tv_currentPlayer = findViewById(R.id.tv_currentPlayer);

      int return_value_winner;

      for (int i = 0; i < 3; i++)
      {
          for (int j = 0; j < 3; j++)
          {
              if (buttons[i][j].getId() == viewId)
              {
                  if (currentPlayer == 1)
                  {
                      buttons[i][j].setText(sign);
                      buttons[i][j].setTextColor(getResources().getColor(sign_color));
                      tv_currentPlayer.setText(getResources().getString(R.string.tv_player2_turn));
                  }
                  else
                  {
                      buttons[i][j].setText(sign_opp);
                      buttons[i][j].setTextColor(getResources().getColor(sign_color_opp));
                      tv_currentPlayer.setText(getResources().getString(R.string.tv_player1_turn));
                  }

                  buttons[i][j].setEnabled(false);
                  board[i][j] = currentPlayer;
                  return_value_winner = calculateWinner(board);

                  if(return_value_winner == 1)
                  {
                      tv_currentPlayer.setText(getResources().getString(R.string.tv_player1_wins));
                      disableBoardAfterEndOfGame(board);
                      Score.incrementScore(context, 1);
                      return;
                  }
                  else if(return_value_winner == 2)
                  {
                      tv_currentPlayer.setText(getResources().getString(R.string.tv_player2_wins));
                      disableBoardAfterEndOfGame(board);
                      Score.decrementScore(context, 2);
                      return;
                  }
                  else if(return_value_winner == 0)
                  {
                      tv_currentPlayer.setText(getResources().getString(R.string.tv_TicTacToe_draw));
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
                      tv_currentPlayer.setText(getResources().getString(R.string.tv_player1_wins));
                      disableBoardAfterEndOfGame(board);
                      Score.incrementScore(context, 1);
                      return;
                  }
                  else if(return_value_winner == 2)
                  {
                      tv_currentPlayer.setText(getResources().getString(R.string.tv_player2_wins));
                      disableBoardAfterEndOfGame(board);
                      Score.decrementScore(context, 2);
                      return;
                  }
                  else if(return_value_winner == 0)
                  {
                      tv_currentPlayer.setText(getResources().getString(R.string.tv_TicTacToe_draw));
                      return;
                  }

                  currentPlayer = (currentPlayer == 1) ? 2 : 1;
                  tv_currentPlayer.setText(getResources().getString(R.string.tv_player1_turn));

                  break;
              }
          }
      }
    }

    public void disableBoardAfterEndOfGame(int board[][])
    {
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i][j] == -1){
                    buttons[i][j].setEnabled(false);
                }
            }
        }
    }

    public static int calculateWinner(int board[][])
    {
        // horizontal
        for(int i = 0; i < 3; i++){
            if((board[i][0] == board[i][1]) && (board[i][1] == board[i][2])) {
                if(board[i][0] == 1){
                    return 1;
                }
                if(board[i][0] == 2){
                    return 2;
                }
            }
        }
        // vertikal
        for(int i = 0; i < 3; i++){
            if((board[0][i] == board[1][i]) && (board[1][i] == board[2][i])) {
                if(board[0][i] == 1){
                    return 1;
                }
                if(board[0][i] == 2){
                    return 2;
                }
            }
        }
        // diagonal
        if(((board[0][0] == board[1][1]) && (board[1][1] == board[2][2])) ||
                (board[0][2] == board[1][1]) && (board[1][1] == board[2][0])){
            if(board[1][1] == 1){
                return 1;
            }
            if(board[1][1] == 2){
                return 2;
            }
        }
        // draw
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i][j] == -1){
                    return -1;
                }
            }
        }

        return 0;
    }

    public void resetBoard()
    {
        TextView tv_currentPlayer = findViewById(R.id.tv_currentPlayer);
        tv_currentPlayer.setText(getResources().getString(R.string.tv_player1_turn));

        currentPlayer = 1;

        //initialize board
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = -1;

                buttons[i][j].setText("");

                buttons[i][j].setEnabled(true);
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

        final Button bt_sign_X = findViewById(R.id.bt_sign_X);
        final Button bt_sign_O = findViewById(R.id.bt_sign_O);

        final Button bt_color_01 = findViewById(R.id.bt_color_01);
        final Button bt_color_02 = findViewById(R.id.bt_color_02);
        final Button bt_color_03 = findViewById(R.id.bt_color_03);
        final Button bt_color_04 = findViewById(R.id.bt_color_04);


        switch (sign_color) {
            case R.color.ttt_b1_black_normal:
                bt_color_01.setEnabled(false);
                bt_color_01.setBackgroundResource(R.color.ttt_b1_black_clicked);
                break;
            case R.color.ttt_b2_red_normal:
                bt_color_02.setEnabled(false);
                bt_color_02.setBackgroundResource(R.color.ttt_b2_red_clicked);
                break;
            case R.color.ttt_b3_blue_normal:
                bt_color_03.setEnabled(false);
                bt_color_03.setBackgroundResource(R.color.ttt_b3_blue_clicked);
                break;
            case R.color.ttt_b4_green_normal:
                bt_color_04.setEnabled(false);
                bt_color_04.setBackgroundResource(R.color.ttt_b4_green_clicked);
                break;
        }
        if(sign.equals("X"))
            bt_sign_X.setEnabled(false);
        else
            bt_sign_O.setEnabled(false);



        bt_sign_X.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                bt_sign_X.setEnabled(false);
                bt_sign_O.setEnabled(true);
                sign = "X";
                sign_opp = "0";
            }
        });

        bt_sign_O.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                bt_sign_X.setEnabled(true);
                bt_sign_O.setEnabled(false);
                sign = "O";
                sign_opp = "X";
            }
        });



        bt_color_01.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                bt_color_01.setEnabled(false);
                bt_color_01.setBackgroundResource(R.color.ttt_b1_black_clicked);
                bt_color_02.setEnabled(true);
                bt_color_02.setBackgroundResource(R.color.ttt_b2_red_normal);
                bt_color_03.setEnabled(true);
                bt_color_03.setBackgroundResource(R.color.ttt_b3_blue_normal);
                bt_color_04.setEnabled(true);
                bt_color_04.setBackgroundResource(R.color.ttt_b4_green_normal);

                sign_color = color[0];
                pickOppColor();
            }
        });

        bt_color_02.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                bt_color_01.setEnabled(true);
                bt_color_01.setBackgroundResource(R.color.ttt_b1_black_normal);
                bt_color_02.setEnabled(false);
                bt_color_02.setBackgroundResource(R.color.ttt_b2_red_clicked);
                bt_color_03.setEnabled(true);
                bt_color_03.setBackgroundResource(R.color.ttt_b3_blue_normal);
                bt_color_04.setEnabled(true);
                bt_color_04.setBackgroundResource(R.color.ttt_b4_green_normal);

                sign_color = color[1];
                pickOppColor();
            }
        });

        bt_color_03.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                bt_color_01.setEnabled(true);
                bt_color_01.setBackgroundResource(R.color.ttt_b1_black_normal);
                bt_color_02.setEnabled(true);
                bt_color_02.setBackgroundResource(R.color.ttt_b2_red_normal);
                bt_color_03.setEnabled(false);
                bt_color_03.setBackgroundResource(R.color.ttt_b3_blue_clicked);
                bt_color_04.setEnabled(true);
                bt_color_04.setBackgroundResource(R.color.ttt_b4_green_normal);

                sign_color = color[2];
                pickOppColor();
            }
        });

        bt_color_04.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                bt_color_01.setEnabled(true);
                bt_color_01.setBackgroundResource(R.color.ttt_b1_black_normal);
                bt_color_02.setEnabled(true);
                bt_color_02.setBackgroundResource(R.color.ttt_b2_red_normal);
                bt_color_03.setEnabled(true);
                bt_color_03.setBackgroundResource(R.color.ttt_b3_blue_normal);
                bt_color_04.setEnabled(false);
                bt_color_04.setBackgroundResource(R.color.ttt_b4_green_clicked);

                sign_color = color[3];
                pickOppColor();
            }
        });

        final Button bt_set_back = findViewById(R.id.bt_set_back);
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
        int ci;
        do {
            Random randi = new Random();
            ci = randi.nextInt(4);
        }
        while (color[ci] == sign_color);

        sign_color_opp = color[ci];
    }
}
