package com.example.sw19_morning05;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.rule.ActivityTestRule;
import android.widget.TextView;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Rule;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityEspressoTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Rule
    public ActivityTestRule<TicTacToeActivity> ticTacToeActivityTestRule = new ActivityTestRule<>(TicTacToeActivity.class);

    @Test
    public void testGameButtonsVisible() {
        onView(withId(R.id.bt_tictactoe)).check(matches(isDisplayed()));
        onView(withId(R.id.bt_hangman)).check(matches(isDisplayed()));
        onView(withId(R.id.bt_touchtheblock)).check(matches(isDisplayed()));
    }

    @Test
    public void testTitleText() {
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_title)).check(matches(withText(R.string.app_title)));

    }

    @Test
    public void testTranslationButton() {
        TextView title = activityTestRule.getActivity().findViewById(R.id.tv_title);
        String englishTitle = title.getText().toString();
        onView(withId(R.id.bt_switchLanguage)).perform(click());
        onView(withId(R.id.tv_title)).check(matches(not(withText(englishTitle))));
    }

    @Test
    public void testShowPoints() {
        onView(withId(R.id.tv_score)).check(matches(isDisplayed()));
    }

    @Test
    public void testIncrementScore() {
        Context context = activityTestRule.getActivity().getApplicationContext();
        int points = 1;
        int score = Score.getScore(context);
        Score.incrementScore(context, points);
        Assert.assertEquals((score + points), Score.getScore(context));
    }

    @Test
    public void testDecrementScore() {
        Context context = activityTestRule.getActivity().getApplicationContext();
        int points = 1;
        int score = Score.getScore(context);
        Score.decrementScore(context, points);
        Assert.assertEquals((score - points), Score.getScore(context));
    }

    @Test
    public void testShowCorrectPointsAfterChange() {
        Context context = activityTestRule.getActivity().getApplicationContext();
        int points = 3;

        TextView score = activityTestRule.getActivity().findViewById(R.id.tv_score);
        String scoreText = score.getText().toString();
        Score.incrementScore(context, points);
        Intent intent = activityTestRule.getActivity().getIntent();
        activityTestRule.getActivity().finish();
        activityTestRule.getActivity().startActivity(intent);
        onView(withId(R.id.tv_score)).check(matches(not(withText(scoreText))));
    }

    @Test
    public void testNavigateTicTacToe() {

        assertNull(ticTacToeActivityTestRule.getActivity().getCallingActivity());
        onView(withId(R.id.bt_tictactoe)).perform(click());
        assertNotNull(ticTacToeActivityTestRule.getActivity().getCallingActivity());
    }
}
