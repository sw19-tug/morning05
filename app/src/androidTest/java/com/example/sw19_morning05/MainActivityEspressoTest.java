package com.example.sw19_morning05;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.rule.ActivityTestRule;
import android.widget.TextView;

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

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityEspressoTest {
    @Rule
public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);
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

}
