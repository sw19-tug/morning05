package com.example.sw19_morning05;


//iimport android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;




public class TicTacToeActivity extends AppCompatActivity  implements View.OnClickListener {

    Button buttonOne;
    Button buttons[] = new Button[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tictactoe);

        buttonOne = findViewById(R.id.bt_field00);

        //Button bt_field00 = (Button) findViewById(R.id.bt_field00);

        int button_count = 0;

        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++){
                String buttonID = "bt_field" + i + "" + j;
                int resourceID = getResources().getIdentifier(
                        buttonID, "id", getPackageName());

                buttons[button_count] =  findViewById(resourceID);
                buttons[button_count].setOnClickListener(this);

                button_count++;
            }
        }
    }

    @Override
    public void onClick(View view) {

    }
}

