package com.example.sw19_morning05;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HangmanActivity extends AppCompatActivity {

    int[] images = {
            R.drawable.image_hm_1,
            R.drawable.image_hm_2,
            R.drawable.image_hm_3,
            R.drawable.image_hm_4,
            R.drawable.image_hm_5,
            R.drawable.image_hm_6,
            R.drawable.image_hm_7,
            R.drawable.image_hm_8,
    };

    public static ArrayList<Pair<String, Boolean>>  word_list;

    String word_to_guess;
    String word_place_holder;
    int wrong_guesses = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Context context = getApplicationContext();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangman);

        ImageView image = findViewById(R.id.image_hm);
        image.setContentDescription("wrongGuess" + wrong_guesses);

        word_list = Settings.getHangmanWordList(context);

        final Button btn_a = findViewById(R.id.btn_a);
        btn_a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_a.setEnabled(false);
                checkInput('A');
            }
        });

        final Button btn_b = findViewById(R.id.btn_b);
        btn_b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_b.setEnabled(false);
                checkInput('B');
            }
        });

        final Button btn_c = findViewById(R.id.btn_c);
        btn_c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_c.setEnabled(false);
                checkInput('C');
            }
        });

        final Button btn_d = findViewById(R.id.btn_d);
        btn_d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_d.setEnabled(false);
                checkInput('D');
            }
        });

        final Button btn_e = findViewById(R.id.btn_e);
        btn_e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_e.setEnabled(false);
                checkInput('E');
            }
        });

        final Button btn_f = findViewById(R.id.btn_f);
        btn_f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_f.setEnabled(false);
                checkInput('F');
            }
        });

        final Button btn_g = findViewById(R.id.btn_g);
        btn_g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_g.setEnabled(false);
                checkInput('G');
            }
        });

        final Button btn_h = findViewById(R.id.btn_h);
        btn_h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_h.setEnabled(false);
                checkInput('H');
            }
        });

        final Button btn_i = findViewById(R.id.btn_i);
        btn_i.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_i.setEnabled(false);
                checkInput('I');
            }
        });

        final Button btn_j = findViewById(R.id.btn_j);
        btn_j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_j.setEnabled(false);
                checkInput('J');
            }
        });

        final Button btn_k = findViewById(R.id.btn_k);
        btn_k.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_k.setEnabled(false);
                checkInput('K');
            }
        });

        final Button btn_l = findViewById(R.id.btn_l);
        btn_l.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_l.setEnabled(false);
                checkInput('L');
            }
        });

        final Button btn_m = findViewById(R.id.btn_m);
        btn_m.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_m.setEnabled(false);
                checkInput('M');
            }
        });

        final Button btn_n = findViewById(R.id.btn_n);
        btn_n.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_n.setEnabled(false);
                checkInput('N');
            }
        });

        final Button btn_o = findViewById(R.id.btn_o);
        btn_o.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_o.setEnabled(false);
                checkInput('O');
            }
        });

        final Button btn_p = findViewById(R.id.btn_p);
        btn_p.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_p.setEnabled(false);
                checkInput('P');
            }
        });

        final Button btn_q = findViewById(R.id.btn_q);
        btn_q.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_q.setEnabled(false);
                checkInput('Q');
            }
        });

        final Button btn_r = findViewById(R.id.btn_r);
        btn_r.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_r.setEnabled(false);
                checkInput('R');
            }
        });

        final Button btn_s = findViewById(R.id.btn_s);
        btn_s.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_s.setEnabled(false);
                checkInput('S');
            }
        });

        final Button btn_t = findViewById(R.id.btn_t);
        btn_t.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_t.setEnabled(false);
                checkInput('T');
            }
        });

        final Button btn_u = findViewById(R.id.btn_u);
        btn_u.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_u.setEnabled(false);
                checkInput('U');
            }
        });

        final Button btn_v = findViewById(R.id.btn_v);
        btn_v.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_v.setEnabled(false);
                checkInput('V');
            }
        });

        final Button btn_w = findViewById(R.id.btn_w);
        btn_w.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_w.setEnabled(false);
                checkInput('W');
            }
        });

        final Button btn_x = findViewById(R.id.btn_x);
        btn_x.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_x.setEnabled(false);
                checkInput('X');
            }
        });

        final Button btn_y = findViewById(R.id.btn_y);
        btn_y.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_y.setEnabled(false);
                checkInput('Y');
            }
        });

        final Button btn_z = findViewById(R.id.btn_z);
        btn_z.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_z.setEnabled(false);
                checkInput('Z');
            }
        });

        final Button btn_reset = findViewById(R.id.btn_reset_hm);
        btn_reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                HangmanActivity.this.reset();
            }
        });

        final Button btn_exit = findViewById(R.id.btn_exit);
        btn_exit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                HangmanActivity.this.finish();
            }
        });

        final Button btn_back = findViewById(R.id.btn_back_hm);
        btn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                navigateToWelcomeScreen();
            }
        });


        final Button btn_hm_extend_words = findViewById(R.id.btn_hm_extend_words);
        btn_hm_extend_words.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                navigateToExtendWordsScreen();
            }
        });

        final Button btn_hint_hm = findViewById(R.id.btn_hint_hm);
        btn_hint_hm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                giveHint();
            }
        });
        setWordView();
    }

    private void navigateToWelcomeScreen() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void navigateToExtendWordsScreen() {
        Intent intent = new Intent(this, ExtendWordsActivity.class);
        startActivity(intent);
    }

    void setWordView() {
        word_place_holder = "";

        int random = randomWithRange(word_list.size());

        TextView textv_word_view = findViewById(R.id.textv_word_to_guess);

        word_to_guess = word_list.get(random).first;

        int temp = word_to_guess.length() + word_to_guess.length() - 1;

        for (int count = 0; count < temp; count++) {
            if (count % 2 == 0) {
                word_place_holder += "_";
            } else {
                word_place_holder += " ";
            }
        }
        textv_word_view.setText(word_place_holder);
    }

    int randomWithRange(int max) {
        return (int) (Math.random() * max);
    }

    void checkInput(char c) {
        TextView textv_word_view = findViewById(R.id.textv_word_to_guess);
        StringBuilder new_placeholder = new StringBuilder(word_place_holder);
        boolean notFound = true;

        for (int pos_w = 0, pos_ph = 0; pos_w < word_to_guess.length(); pos_w++, pos_ph += 2) {
            if (word_to_guess.charAt(pos_w) == c) {
                new_placeholder.setCharAt(pos_ph, c);
                notFound = false;
            }
        }
        word_place_holder = new_placeholder.toString();
        textv_word_view.setText(word_place_holder);

        if (notFound) {
            ImageView image = findViewById(R.id.image_hm);
            image.setImageResource(images[wrong_guesses]);
            wrong_guesses++;
            image.setContentDescription("wrongGuess" + wrong_guesses);
        }

        if (wrong_guesses == 8) {
            lost();
        }

        if (!word_place_holder.contains("_")) {
            win();
        }
    }

    private void reset() {
        Context context = this.getApplicationContext();
        Vibration.vibrate(context, 1000);
        this.recreate();
    }

    private void giveHint() {
        for (int i = 0; i < word_to_guess.length(); i++) {
            String current_char = "" + word_to_guess.charAt(i);

            if (!word_place_holder.contains(current_char)) {
                Context context = this.getApplicationContext();
                int points = 3;
                Score.decrementScore(context, points);
                checkInput(current_char.charAt(0));
                break;
            }
        }
    }

    private void win() {
        Context context = this.getApplicationContext();

        disabledButtons();

        Score.incrementScore(context, 1);
        Vibration.vibrate(context, 1000);
    }

    private void lost() {
        Context context = this.getApplicationContext();

        final TextView textv_2 = findViewById(R.id.textv_2);
        textv_2.setText(getResources().getString(R.string.str_textv_lose_hm));
        disabledButtons();

        Score.decrementScore(context, 2);
        Vibration.vibrate(context, 1000);
    }

    private void disabledButtons (){
        findViewById(R.id.win_ly).setVisibility(View.VISIBLE);

        findViewById(R.id.btn_q).setEnabled(false);
        findViewById(R.id.btn_w).setEnabled(false);
        findViewById(R.id.btn_e).setEnabled(false);
        findViewById(R.id.btn_r).setEnabled(false);
        findViewById(R.id.btn_t).setEnabled(false);
        findViewById(R.id.btn_z).setEnabled(false);
        findViewById(R.id.btn_u).setEnabled(false);
        findViewById(R.id.btn_i).setEnabled(false);
        findViewById(R.id.btn_o).setEnabled(false);
        findViewById(R.id.btn_p).setEnabled(false);
        findViewById(R.id.btn_a).setEnabled(false);
        findViewById(R.id.btn_s).setEnabled(false);
        findViewById(R.id.btn_d).setEnabled(false);
        findViewById(R.id.btn_f).setEnabled(false);
        findViewById(R.id.btn_g).setEnabled(false);
        findViewById(R.id.btn_h).setEnabled(false);
        findViewById(R.id.btn_j).setEnabled(false);
        findViewById(R.id.btn_k).setEnabled(false);
        findViewById(R.id.btn_l).setEnabled(false);
        findViewById(R.id.btn_y).setEnabled(false);
        findViewById(R.id.btn_x).setEnabled(false);
        findViewById(R.id.btn_c).setEnabled(false);
        findViewById(R.id.btn_v).setEnabled(false);
        findViewById(R.id.btn_b).setEnabled(false);
        findViewById(R.id.btn_n).setEnabled(false);
        findViewById(R.id.btn_m).setEnabled(false);
    }
}