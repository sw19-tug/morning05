package com.example.sw19_morning05;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class TicTacToeUnitTest {

    @Test
    public void addition_isCorrect() {
        int test_array[][] = new int[3][3];

        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                test_array[i][j] = -1;
            }
        }

        int return_value = TicTacToeActivity.calculateWinner(test_array);

        assertEquals(-1, return_value);
    }


}