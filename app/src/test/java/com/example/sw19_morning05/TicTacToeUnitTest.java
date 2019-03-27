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
    public void testNoWinnerYet() {
        int test_array[][] = new int[3][3];

        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                test_array[i][j] = -1;
            }
        }

        int return_value = TicTacToeActivity.calculateWinner(test_array);
        assertEquals(-1, return_value);
    }


    @Test
    public void testPlayer01Winner01() {
        int test_array[][] = new int[3][3];

        test_array[0][0] = 1;
        test_array[0][1] = 1;
        test_array[0][2] = 1;

        test_array[1][0] = 2;
        test_array[1][1] = 2;

        int return_value = TicTacToeActivity.calculateWinner(test_array);
        assertEquals(1, return_value);
    }

    @Test
    public void testPlayer02Winner01() {
        int test_array[][] = new int[3][3];

        test_array[1][2] = 1;
        test_array[1][1] = 1;
        test_array[2][1] = 1;

        test_array[1][0] = 2;
        test_array[2][0] = 2;
        test_array[0][0] = 2;

        int return_value = TicTacToeActivity.calculateWinner(test_array);
        assertEquals(2, return_value);
    }

    @Test
    public void testDraw() {
        int test_array[][] = new int[3][3];

        test_array[0][0] = 1;
        test_array[0][1] = 2;
        test_array[0][2] = 1;
        test_array[1][0] = 1;
        test_array[1][1] = 1;
        test_array[1][2] = 2;
        test_array[2][0] = 2;
        test_array[2][1] = 1;
        test_array[2][2] = 2;

        int return_value = TicTacToeActivity.calculateWinner(test_array);
        assertEquals(0, return_value);
    }

}