package com.example.sw19_morning05;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ScoreUnitTest {
    @Test
    public void testIncrementScore() {
        int points = 1;
        int score = Score.getScore();
        Score.incrementScore(points);
        Assert(Score.getScore() == (score + points));
    }
}