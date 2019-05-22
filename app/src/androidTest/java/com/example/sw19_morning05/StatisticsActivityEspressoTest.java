package com.example.sw19_morning05;

import android.content.Context;
import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.TextView;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressBack;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;


@RunWith(AndroidJUnit4.class)
public class StatisticsActivityEspressoTest {
    @Rule
    public ActivityTestRule<StatisticsActivity> statistics_activity_test_rule = new ActivityTestRule<>(StatisticsActivity.class);


    @Test
    public void testHighScoreListDisplayed() {
        onView(withId(R.id.statistics_highscore_ly)).check(matches(isDisplayed()));
    }

    @Test
    public void testStatisticsOfUserDisplayed() {
        Context context = statistics_activity_test_rule.getActivity().getApplicationContext();
        onView(withId(R.id.textv_user_hs)).check(matches(isDisplayed()));
        String username = Settings.getUsername(context);
        onView(withId(R.id.textv_user_hs)).check(matches(not(withText(R.string.str_user_hs + " " + username))));
    }

    @Test
    public void testHeaderNumberOfGamesDisplayed() {
        Context context = statistics_activity_test_rule.getActivity().getApplicationContext();
        onView(withId(R.id.textv_statistics_number_header)).check(matches(isDisplayed()));
        onView(withId(R.id.textv_statistics_number_header)).check(matches(not(withText(R.string.str_statistics_number_header))));
    }

    @Test
    public void testNewHighscoreDisplayed() {
        Context context = statistics_activity_test_rule.getActivity().getApplicationContext();
        int game_counter_after = Statistics.getGameCounterTTB(context);
        String username = Settings.getUsername(context);
        List<HighScore>current_highscore_list = Statstics.getHighScoreList(context);
        int new_highscore = current_highscore_list.get(0) + 1;
        Statistics.addHighScore(context, username, new_highscore);

        TextView highscore_view = statistics_activity_test_rule.getActivity().findViewById(R.id.textv_highscore_0);
        int highscore = Integer.parseInt(highscore_view.getText().toString());

        Assert.assertEquals(new_highscore, highscore);
    }

    @Test
    public void testIncrementStatisicsTTB() {
        Context context = statistics_activity_test_rule.getActivity().getApplicationContext();
        int game_counter_after = Statistics.getGameCounterTTB(context);
        Statistics.incrementGameCounterTTB(context);
        Assert.assertEquals((game_counter_after + 1), Statistics.getGameCounterTTB(context));
    }

    @Test
    public void testShowCorrectStatisticsTTB() {
        Context context = statistics_activity_test_rule.getActivity().getApplicationContext();

        TextView game_counter_after = statistics_activity_test_rule.getActivity().findViewById(R.id.textv_game_counter_ttb);
        String game_counter_after_text = game_counter_after.getText().toString();
        Statistics.incrementGameCounterTTB(context);

        onView(withId(R.id.textv_game_counter_ttb)).check(matches((withText(game_counter_after_text))));
    }

    @Test
    public void testIncrementStatisicsTTT() {
        Context context = statistics_activity_test_rule.getActivity().getApplicationContext();
        int game_counter_after = Statistics.getGameCounterTTT(context);
        Statistics.incrementGameCounterTTT(context);
        Assert.assertEquals((game_counter_after + 1), Statistics.getGameCounterTTT(context));
    }

    @Test
    public void testShowCorrectStatisticsTTT() {
        Context context = statistics_activity_test_rule.getActivity().getApplicationContext();

        TextView game_counter_after = statistics_activity_test_rule.getActivity().findViewById(R.id.textv_game_counter_ttt);
        String game_counter_after_text = game_counter_after.getText().toString();
        Statistics.incrementGameCounterTTT(context);

        onView(withId(R.id.textv_game_counter_ttt)).check(matches((withText(game_counter_after_text))));
    }

    @Test
    public void testIncrementStatisicsHM() {
        Context context = statistics_activity_test_rule.getActivity().getApplicationContext();
        int game_counter_after = Statistics.getGameCounterHM(context);
        Statistics.incrementGameCounterHM(context);
        Assert.assertEquals((game_counter_after + 1), Statistics.getGameCounterHM(context));
    }

    @Test
    public void testShowCorrectStatisticsHM() {
        Context context = statistics_activity_test_rule.getActivity().getApplicationContext();

        TextView game_counter_after = statistics_activity_test_rule.getActivity().findViewById(R.id.textv_game_counter_hm);
        String game_counter_after_text = game_counter_after.getText().toString();
        Statistics.incrementGameCounterHM(context);

        onView(withId(R.id.textv_game_counter_hm)).check(matches((withText(game_counter_after_text))));
    }
}