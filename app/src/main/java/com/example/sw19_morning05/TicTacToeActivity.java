package com.example.sw19_morning05;


//iimport android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class TicTacToeActivity extends AppCompatActivity  implements View.OnClickListener {

    Button buttons[][] = new Button[3][3];
    int board[][] = new int [3][3];

    int currentPlayer = 1;  // 1 = Player 1, 2 = Player 2

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

        //initialize board
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = -1;
            }
        }
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        String text;
        TextView tv_currentPlayer;
        tv_currentPlayer = findViewById(R.id.tv_currentPlayer);

        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++){
                if(buttons[i][j].getId() == viewId){
                    if(currentPlayer == 1) {
                        buttons[i][j].setText("X");
                        text = "Player O turn!";
                    }
                    else{
                        buttons[i][j].setText("O");
                        text = "Player X turn!";
                    }

                    buttons[i][j].setEnabled(false);
                    board[i][j] = currentPlayer;
                    currentPlayer = (currentPlayer == 1) ? 2 : 1;
                    tv_currentPlayer.setText(text);
                    break;
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

}

