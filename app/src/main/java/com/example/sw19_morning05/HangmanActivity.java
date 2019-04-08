package com.example.sw19_morning05;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HangmanActivity extends AppCompatActivity
{


    public static String word_list[] = {"GIN", "VODKA", "RUM", "BRANDY", "BACARDI", "COGNAC", "WHISKY", "JAEGERMEISTER"};
    String word_to_guess;
    String place_holder;


    @Override  //testIfTitleExists
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangman);

        //Test testButtonPressedGoesDisabled
        final Button button_a = findViewById(R.id.button_a);
        button_a.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                button_a.setEnabled(false);
                checkInput('A');
            }
        });

        final Button button_b = findViewById(R.id.button_b);
        button_b.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                button_b.setEnabled(false);
                checkInput('B');
            }
        });

        final Button button_c = findViewById(R.id.button_c);
        button_c.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                button_c.setEnabled(false);
                checkInput('C');
            }
        });

        final Button button_d = findViewById(R.id.button_d);
        button_d.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                button_d.setEnabled(false);
                checkInput('D');
            }
        });

        final Button button_e = findViewById(R.id.button_e);
        button_e.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                button_e.setEnabled(false);
                checkInput('E');
            }
        });

        final Button button_f = findViewById(R.id.button_f);
        button_f.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                button_f.setEnabled(false);
                checkInput('F');
            }
        });

        final Button button_g = findViewById(R.id.button_g);
        button_g.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                button_g.setEnabled(false);
                checkInput('G');
            }
        });

        final Button button_h = findViewById(R.id.button_h);
        button_h.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                button_h.setEnabled(false);
                checkInput('H');
            }
        });

        final Button button_i = findViewById(R.id.button_i);
        button_i.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                button_i.setEnabled(false);
                checkInput('I');
            }
        });

        final Button button_j = findViewById(R.id.button_j);
        button_j.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                button_j.setEnabled(false);
                checkInput('J');
            }
        });

        final Button button_k = findViewById(R.id.button_k);
        button_k.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                button_k.setEnabled(false);
                checkInput('K');
            }
        });

        final Button button_l = findViewById(R.id.button_l);
        button_l.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                button_l.setEnabled(false);
                checkInput('L');
            }
        });

        final Button button_m = findViewById(R.id.button_m);
        button_m.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                button_m.setEnabled(false);
                checkInput('M');
            }
        });

        final Button button_n = findViewById(R.id.button_n);
        button_n.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                button_n.setEnabled(false);
                checkInput('N');
            }
        });

        final Button button_o = findViewById(R.id.button_o);
        button_o.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                button_o.setEnabled(false);
                checkInput('O');
            }
        });

        final Button button_p = findViewById(R.id.button_p);
        button_p.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                button_p.setEnabled(false);
                checkInput('P');
            }
        });

        final Button button_q = findViewById(R.id.button_q);
        button_q.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                button_q.setEnabled(false);
                checkInput('Q');
            }
        });

        final Button button_r = findViewById(R.id.button_r);
        button_r.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                button_r.setEnabled(false);
                checkInput('R');
            }
        });

        final Button button_s = findViewById(R.id.button_s);
        button_s.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                button_s.setEnabled(false);
                checkInput('S');
            }
        });

        final Button button_t = findViewById(R.id.button_t);
        button_t.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                button_t.setEnabled(false);
                checkInput('T');
            }
        });

        final Button button_u = findViewById(R.id.button_u);
        button_u.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                button_u.setEnabled(false);
                checkInput('U');
            }
        });

        final Button button_v = findViewById(R.id.button_v);
        button_v.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                button_v.setEnabled(false);
                checkInput('V');
            }
        });

        final Button button_w = findViewById(R.id.button_w);
        button_w.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                button_w.setEnabled(false);
                checkInput('W');
            }
        });

        final Button button_x = findViewById(R.id.button_x);
        button_x.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                button_x.setEnabled(false);
                checkInput('X');
            }
        });

        final Button button_y = findViewById(R.id.button_y);
        button_y.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                button_y.setEnabled(false);
                checkInput('Y');
            }
        });

        final Button button_z = findViewById(R.id.button_z);
        button_z.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                button_z.setEnabled(false);
                checkInput('Z');
            }
        });

        final Button button_reset = findViewById(R.id.button_reset);
        button_reset.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {

                HangmanActivity.this.reset();
            }
        });

        final Button button_exit = findViewById(R.id.button_exit);
        button_exit.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                HangmanActivity.this.finish();
            }
        });

        final Button button_back = findViewById(R.id.bt_backHangman);
        button_back.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                navigateWelcomeScreen();
            }
        });

        //Test WordShown
        setWordView();

    }

    private void navigateWelcomeScreen() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    void setWordView()
    {
        place_holder = "";

        int random = randomWithRange(word_list.length);

        TextView word_view = findViewById(R.id.word);

        word_to_guess = word_list[random];

        int temp = word_to_guess.length() + word_to_guess.length() - 1;


        for (int i = 0; i < temp; i++) {
            if (i % 2 == 0) {
                place_holder += "_";
            }
            else {
                place_holder += " ";
            }
        }
        word_view.setText(place_holder);
    }

    int randomWithRange(int max)
    {
        return (int) (Math.random() * max);
    }

    void checkInput(char c)
    {
        TextView word = findViewById(R.id.word);
        StringBuilder new_placeholder = new StringBuilder(place_holder);

        for (int i = 0, j = 0; i < word_to_guess.length(); i++, j += 2) {
            if (word_to_guess.charAt(i) == c) {
                new_placeholder.setCharAt(j, c);
            }
        }
        place_holder = new_placeholder.toString();
        word.setText(place_holder);

        if (!place_holder.contains("_")) {

            win();

      /*
      AlertDialog.Builder winAlert = new AlertDialog.Builder(this);
      winAlert.setTitle("YAY");
      winAlert.setMessage("You win!\n\nThe answer was:\n\n" + word_to_guess);
      winAlert.setPositiveButton("Play Again",
        new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface dialog, int id)
          {
            HangmanActivity.this.reset();
          }
        });

      winAlert.setNegativeButton("Exit",
        new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface dialog, int id)
          {
            HangmanActivity.this.finish();
          }
        });

      winAlert.show();*/
        }
    }

    private void reset()
    {
        findViewById(R.id.win_ly).setVisibility(View.INVISIBLE);

        findViewById(R.id.button_q).setEnabled(true);
        findViewById(R.id.button_w).setEnabled(true);
        findViewById(R.id.button_e).setEnabled(true);
        findViewById(R.id.button_r).setEnabled(true);
        findViewById(R.id.button_t).setEnabled(true);
        findViewById(R.id.button_z).setEnabled(true);
        findViewById(R.id.button_u).setEnabled(true);
        findViewById(R.id.button_i).setEnabled(true);
        findViewById(R.id.button_o).setEnabled(true);
        findViewById(R.id.button_p).setEnabled(true);
        findViewById(R.id.button_a).setEnabled(true);
        findViewById(R.id.button_s).setEnabled(true);
        findViewById(R.id.button_d).setEnabled(true);
        findViewById(R.id.button_f).setEnabled(true);
        findViewById(R.id.button_g).setEnabled(true);
        findViewById(R.id.button_h).setEnabled(true);
        findViewById(R.id.button_j).setEnabled(true);
        findViewById(R.id.button_k).setEnabled(true);
        findViewById(R.id.button_l).setEnabled(true);
        findViewById(R.id.button_y).setEnabled(true);
        findViewById(R.id.button_x).setEnabled(true);
        findViewById(R.id.button_c).setEnabled(true);
        findViewById(R.id.button_v).setEnabled(true);
        findViewById(R.id.button_b).setEnabled(true);
        findViewById(R.id.button_n).setEnabled(true);
        findViewById(R.id.button_m).setEnabled(true);

        setWordView();
    }

    private void win()
    {
        findViewById(R.id.win_ly).setVisibility(View.VISIBLE);

        findViewById(R.id.button_q).setEnabled(false);
        findViewById(R.id.button_w).setEnabled(false);
        findViewById(R.id.button_e).setEnabled(false);
        findViewById(R.id.button_r).setEnabled(false);
        findViewById(R.id.button_t).setEnabled(false);
        findViewById(R.id.button_z).setEnabled(false);
        findViewById(R.id.button_u).setEnabled(false);
        findViewById(R.id.button_i).setEnabled(false);
        findViewById(R.id.button_o).setEnabled(false);
        findViewById(R.id.button_p).setEnabled(false);
        findViewById(R.id.button_a).setEnabled(false);
        findViewById(R.id.button_s).setEnabled(false);
        findViewById(R.id.button_d).setEnabled(false);
        findViewById(R.id.button_f).setEnabled(false);
        findViewById(R.id.button_g).setEnabled(false);
        findViewById(R.id.button_h).setEnabled(false);
        findViewById(R.id.button_j).setEnabled(false);
        findViewById(R.id.button_k).setEnabled(false);
        findViewById(R.id.button_l).setEnabled(false);
        findViewById(R.id.button_y).setEnabled(false);
        findViewById(R.id.button_x).setEnabled(false);
        findViewById(R.id.button_c).setEnabled(false);
        findViewById(R.id.button_v).setEnabled(false);
        findViewById(R.id.button_b).setEnabled(false);
        findViewById(R.id.button_n).setEnabled(false);
        findViewById(R.id.button_m).setEnabled(false);
    }
}