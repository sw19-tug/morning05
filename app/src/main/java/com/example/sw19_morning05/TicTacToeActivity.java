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

    Button buttons[][] = new Button[3][3];
    int board[][] = new int [3][3];

    int currentPlayer = 1;  // 1 = Player 1, 2 = Player 2

    CheckBox cb_autoplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                setContentView(R.layout.settings_tictactoe);
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
                      buttons[i][j].setText("X");
                      tv_currentPlayer.setText(getResources().getString(R.string.tv_player2_turn));
                  }
                  else
                  {
                      buttons[i][j].setText("O");
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
                  buttons[row][col].setText("O");
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
}
