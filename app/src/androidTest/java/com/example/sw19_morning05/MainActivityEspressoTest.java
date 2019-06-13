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
public class MainActivityEspressoTest {
    @Rule
    public ActivityTestRule<MainActivity> main_activity_test_rule = new ActivityTestRule<>(MainActivity.class);

    @Rule
    public ActivityTestRule<TicTacToeActivity> ttt_activity_test_rule = new ActivityTestRule<>(TicTacToeActivity.class);

    @Test
    public void testGameButtonsVisible() {
        onView(withId(R.id.btn_ttt)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_hm)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_ttb)).check(matches(isDisplayed()));
    }

    @Test
    public void testTitleText() {
        onView(withId(R.id.textv_title)).check(matches(isDisplayed()));
        onView(withId(R.id.textv_title)).check(matches(withText(R.string.str_app_title)));
    }

    @Test
    public void testHelpButtonShouldShowGameDescription() {
        onView(withId(R.id.btn_help)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_help)).check(matches(withText(R.string.str_help)));

        onView(withId(R.id.btn_help)).perform(click());

        onView(withId(R.id.textv_help_hm)).check(matches(isDisplayed()));

        onView(withText(R.string.str_help)).perform(pressBack());
    }

    @Test
    public void testTranslationButton() {
        TextView title = main_activity_test_rule.getActivity().findViewById(R.id.textv_title);
        String english_title = title.getText().toString();
        onView(withId(R.id.btn_switch_lang)).perform(click());
        onView(withId(R.id.textv_title)).check(matches(not(withText(english_title))));
        onView(withId(R.id.btn_switch_lang)).perform(click());
    }

    @Test
    public void testLanguageTicTacToe() {
        TextView button_text = ttt_activity_test_rule.getActivity().findViewById(R.id.btn_reset_ttt);
        String german_title = button_text.getText().toString();
        onView(withId(R.id.btn_switch_lang)).perform(click());
        onView(withId(R.id.btn_ttt)).perform(click());
        onView(withId(R.id.btn_reset_ttt)).check(matches(not(withText(german_title))));
        onView(withId(R.id.btn_back_ttt)).perform(click());
        onView(withId(R.id.btn_switch_lang)).perform(click());
    }

    @Test
    public void testPlayerLanguageTicTacToe() {
        onView(withId(R.id.btn_switch_lang)).perform(click());
        onView(withId(R.id.btn_ttt)).perform(click());
        onView(withId(R.id.textv_current_player)).check(matches(withText("Spieler X Zug!")));
        onView(withId(R.id.btn_back_ttt)).perform(click());
        onView(withId(R.id.btn_switch_lang)).perform(click());
    }

    @Test
    public void testLanguageHangman() {
        onView(withId(R.id.btn_switch_lang)).perform(click());
        onView(withId(R.id.btn_hm)).perform(click());
        onView(withId(R.id.btn_reset_hm)).check(matches(withText("NEUSTART")));
        onView(withId(R.id.btn_back_hm)).perform(click());
        onView(withId(R.id.btn_switch_lang)).perform(click());
    }

    @Test
    public void testShowPoints() {
        onView(withId(R.id.textv_score)).check(matches(isDisplayed()));
    }

    @Test
    public void testIncrementScore() {
        Context context = main_activity_test_rule.getActivity().getApplicationContext();
        int points = 1;
        int score = Score.getScore(context);
        Score.incrementScore(context, points);
        Assert.assertEquals((score + points), Score.getScore(context));
    }

    @Test
    public void testDecrementScore() {
        Context context = main_activity_test_rule.getActivity().getApplicationContext();
        int points = 1;
        int score = Score.getScore(context);
        Score.decrementScore(context, points);
        Assert.assertEquals((score - points), Score.getScore(context));
    }

    @Test
    public void testShowCorrectPointsAfterChange() {
        Context context = main_activity_test_rule.getActivity().getApplicationContext();
        int points = 3;

        TextView score = main_activity_test_rule.getActivity().findViewById(R.id.textv_score);
        String score_text = score.getText().toString();
        Score.incrementScore(context, points);
        Intent intent = main_activity_test_rule.getActivity().getIntent();
        main_activity_test_rule.getActivity().finish();
        main_activity_test_rule.getActivity().startActivity(intent);
        onView(withId(R.id.textv_score)).check(matches(not(withText(score_text))));
    }

    @Test
    public void testNavigateTicTacToe() {
        onView(withId(R.id.btn_ttt)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_ttt)).perform(click());
        onView(withId(R.id.textv_header)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_back_ttt)).perform(click());
    }

    @Test
    public void testNavigateTouchTheBlock() {
        onView(withId(R.id.btn_ttb)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_ttb)).perform(click());
        onView(withId(R.id.textv_2)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_back_main)).perform(click());
    }

    @Test
    public void testNavigateHangman() {
        onView(withId(R.id.btn_hm)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_hm)).perform(click());
        onView(withId(R.id.ly_title)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_back_hm)).perform(click());
    }

    @Test
    public void testNavigateGameStatisics() {
        onView(withId(R.id.btn_gamestatistic)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_gamestatistic)).perform(click());
        onView(withId(R.id.textv_gamestatistic)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_back_gamestatistic)).perform(click());
    }

    @Test
    public void testNavigateSettings() {
        onView(withId(R.id.btn_settings)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_settings)).perform(click());
        onView(withId(R.id.textv_settings_title)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_settings_back)).perform(click());
    }

    @Test
    public void testcheckUserGreetingDisplayed() {
        Context context = main_activity_test_rule.getActivity().getApplicationContext();
        onView(withId(R.id.textv_greeting_user)).check(matches(isDisplayed()));
        String username = Settings.getUsername(context);
        onView(withId(R.id.textv_greeting_user)).check(matches(not(withText(R.string.str_user_greeting
                + " " + username))));
    }

    @Test
    public void testUpdateSettingsUsernameInputfield() {
        Context context = main_activity_test_rule.getActivity().getApplicationContext();
        onView(withId(R.id.btn_settings)).perform(click());
        String new_username = "homer_simpson";
        onView(withId(R.id.input_username)).perform(replaceText(new_username));
        onView(withId(R.id.btn_username_save)).perform(click());
        onView(withId(R.id.btn_settings_back)).perform(click());

        String username = Settings.getUsername(context);
        onView(withId(R.id.btn_settings)).perform(click());
        onView(withId(R.id.input_username)).check(matches(withText(username)));
        onView(withId(R.id.btn_settings_back)).perform(click());
    }

    @Test
    public void testBackgroundMusicStarts(){
        assert(!BackgroundMusicPlayer.isplayingAudio);
    }
}