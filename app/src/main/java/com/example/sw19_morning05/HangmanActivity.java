package com.example.sw19_morning05;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class HangmanActivity extends AppCompatActivity {


    public static String word_list[] = {"GIN", "VODKA", "RUM", "BRANDY"};
    String word_to_guess;
    String place_holder;


    @Override  //testIfTitleExists
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangman);

        //Test testButtonPressedGoesDisabled
        final Button button_a = (Button) findViewById(R.id.button_a);
        button_a.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v){
            button_a.setEnabled(false);
                checkInput('A');
        }
        });

        final Button button_b = (Button) findViewById(R.id.button_b);
        button_b.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v){
                button_b.setEnabled(false);
                checkInput('B');
            }
        });

        final Button button_c = (Button) findViewById(R.id.button_c);
        button_c.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v){
                button_c.setEnabled(false);
                checkInput('C');
            }
        });

        final Button button_d = (Button) findViewById(R.id.button_d);
        button_d.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v){
                button_d.setEnabled(false);
                checkInput('D');
            }
        });

        final Button button_e = (Button) findViewById(R.id.button_e);
        button_e.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v){
                button_e.setEnabled(false);
                checkInput('E');
            }
        });

        final Button button_f = (Button) findViewById(R.id.button_f);
        button_f.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v){
                button_f.setEnabled(false);
                checkInput('F');
            }
        });

        final Button button_g = (Button) findViewById(R.id.button_g);
        button_g.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v){
                button_g.setEnabled(false);
                checkInput('G');
            }
        });

        final Button button_h = (Button) findViewById(R.id.button_h);
        button_h.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v){
                button_h.setEnabled(false);
                checkInput('H');
            }
        });

        final Button button_i = (Button) findViewById(R.id.button_i);
        button_i.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v){
                button_i.setEnabled(false);
                checkInput('I');
            }
        });

        final Button button_j = (Button) findViewById(R.id.button_j);
        button_j.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v){
                button_j.setEnabled(false);
                checkInput('J');
            }
        });

        final Button button_k = (Button) findViewById(R.id.button_k);
        button_k.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v){
                button_k.setEnabled(false);
                checkInput('K');
            }
        });

        final Button button_l = (Button) findViewById(R.id.button_l);
        button_l.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v){
                button_l.setEnabled(false);
                checkInput('L');
            }
        });

        final Button button_m = (Button) findViewById(R.id.button_m);
        button_m.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v){
                button_m.setEnabled(false);
                checkInput('M');
            }
        });

        final Button button_n = (Button) findViewById(R.id.button_n);
        button_n.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v){
                button_n.setEnabled(false);
                checkInput('N');
            }
        });

        final Button button_o = (Button) findViewById(R.id.button_o);
        button_o.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v){
                button_o.setEnabled(false);
                checkInput('O');
            }
        });

        final Button button_p = (Button) findViewById(R.id.button_p);
        button_p.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v){
                button_p.setEnabled(false);
                checkInput('P');
            }
        });

        final Button button_q = (Button) findViewById(R.id.button_q);
        button_q.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v){
                button_q.setEnabled(false);
                checkInput('Q');
            }
        });

        final Button button_r = (Button) findViewById(R.id.button_r);
        button_r.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v){
                button_r.setEnabled(false);
                checkInput('R');
            }
        });

        final Button button_s = (Button) findViewById(R.id.button_s);
        button_s.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v){
                button_s.setEnabled(false);
                checkInput('S');
            }
        });

        final Button button_t = (Button) findViewById(R.id.button_t);
        button_t.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v){
                button_t.setEnabled(false);
                checkInput('T');
            }
        });

        final Button button_u = (Button) findViewById(R.id.button_u);
        button_u.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v){
                button_u.setEnabled(false);
                checkInput('U');
            }
        });

        final Button button_v = (Button) findViewById(R.id.button_v);
        button_v.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v){
                button_v.setEnabled(false);
                checkInput('V');
            }
        });

        final Button button_w = (Button) findViewById(R.id.button_w);
        button_w.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v){
                button_w.setEnabled(false);
                checkInput('W');
            }
        });

        final Button button_x = (Button) findViewById(R.id.button_x);
        button_x.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v){
                button_x.setEnabled(false);
                checkInput('X');
            }
        });

        final Button button_y = (Button) findViewById(R.id.button_y);
        button_y.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v){
                button_y.setEnabled(false);
                checkInput('Y');
            }
        });

        final Button button_z = (Button) findViewById(R.id.button_z);
        button_z.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v){
                button_z.setEnabled(false);
                checkInput('Z');
            }
        });


        //Test WordShown
        setWordView();

    }

    void setWordView()
    {
        place_holder = "";

        int random = randomWithRange(0,word_list.length);

        TextView word_view = findViewById(R.id.word);

        word_to_guess = word_list[random];

        int temp = word_to_guess.length() + word_to_guess.length() - 1;


        for(int i = 0; i < temp; i++)
        {
            if(i % 2 == 0)
                place_holder += "_";
            else
                place_holder += " ";
        }
        word_view.setText(place_holder);
    }

    int randomWithRange(int min, int max)
    {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }

    void checkInput(char c)
    {
        TextView word = (TextView) findViewById(R.id.word);
        StringBuilder new_placeholder = new StringBuilder(place_holder);

        for(int i = 0, j = 0; i < word_to_guess.length(); i++, j += 2)
        {
            if(word_to_guess.charAt(i) == c)
            {
                new_placeholder.setCharAt(j, c);
            }
        }
        place_holder = new_placeholder.toString();
        word.setText(place_holder);
    }


}

