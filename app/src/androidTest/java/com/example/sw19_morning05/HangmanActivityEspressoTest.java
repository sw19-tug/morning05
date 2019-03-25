package com.example.sw19_morning05;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class HangmanActivityEspressoTest {

    @Rule
    public ActivityTestRule<HangmanActivity> activityTestRule = new ActivityTestRule<>(HangmanActivity.class);

    //tests if the header "Hangman" is displayed
    @Test
    public void testIfTitleExists()
    {
        onView(withId(R.id.title)).check(matches(isDisplayed()));
    }

    //tests if all keyboard-buttons are displayed
    @Test
    public void testIfButtonsExist()
    {
        onView(withId(R.id.button_q)).check(matches(isDisplayed()));
        onView(withId(R.id.button_w)).check(matches(isDisplayed()));
        onView(withId(R.id.button_e)).check(matches(isDisplayed()));
        onView(withId(R.id.button_r)).check(matches(isDisplayed()));
        onView(withId(R.id.button_t)).check(matches(isDisplayed()));
        onView(withId(R.id.button_z)).check(matches(isDisplayed()));
        onView(withId(R.id.button_u)).check(matches(isDisplayed()));
        onView(withId(R.id.button_i)).check(matches(isDisplayed()));
        onView(withId(R.id.button_o)).check(matches(isDisplayed()));
        onView(withId(R.id.button_p)).check(matches(isDisplayed()));
        onView(withId(R.id.button_a)).check(matches(isDisplayed()));
        onView(withId(R.id.button_s)).check(matches(isDisplayed()));
        onView(withId(R.id.button_d)).check(matches(isDisplayed()));
        onView(withId(R.id.button_f)).check(matches(isDisplayed()));
        onView(withId(R.id.button_g)).check(matches(isDisplayed()));
        onView(withId(R.id.button_h)).check(matches(isDisplayed()));
        onView(withId(R.id.button_j)).check(matches(isDisplayed()));
        onView(withId(R.id.button_k)).check(matches(isDisplayed()));
        onView(withId(R.id.button_l)).check(matches(isDisplayed()));
        onView(withId(R.id.button_y)).check(matches(isDisplayed()));
        onView(withId(R.id.button_x)).check(matches(isDisplayed()));
        onView(withId(R.id.button_c)).check(matches(isDisplayed()));
        onView(withId(R.id.button_v)).check(matches(isDisplayed()));
        onView(withId(R.id.button_b)).check(matches(isDisplayed()));
        onView(withId(R.id.button_n)).check(matches(isDisplayed()));
        onView(withId(R.id.button_m)).check(matches(isDisplayed()));
    }
}
