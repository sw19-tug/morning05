package com.example.sw19_morning05;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Rule;
import android.support.test.rule.ActivityTestRule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class TicTacToeInstrumentedTest {
    @Rule
    public ActivityTestRule<TicTacToeActivity> activityTestRule = new ActivityTestRule<>(TicTacToeActivity.class);

    @Test
    public void testTextViewVisible() {
        onView(withId(R.id.tv_header)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_header)).check(matches(withText("Tic Tac Toe")));

    }
}
