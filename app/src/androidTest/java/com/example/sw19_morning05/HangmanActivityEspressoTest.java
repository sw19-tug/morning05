package com.example.sw19_morning05;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.Button;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.IsNot.not;
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

    @Test
    public void testButtonPressedGoesDisabled()
    {
        onView(withId(R.id.button_q)).perform(ViewActions.click());
        onView(withId(R.id.button_q)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_w)).perform(ViewActions.click());
        onView(withId(R.id.button_w)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_e)).perform(ViewActions.click());
        onView(withId(R.id.button_e)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_r)).perform(ViewActions.click());
        onView(withId(R.id.button_r)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_t)).perform(ViewActions.click());
        onView(withId(R.id.button_t)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_z)).perform(ViewActions.click());
        onView(withId(R.id.button_z)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_u)).perform(ViewActions.click());
        onView(withId(R.id.button_u)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_i)).perform(ViewActions.click());
        onView(withId(R.id.button_i)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_o)).perform(ViewActions.click());
        onView(withId(R.id.button_o)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_p)).perform(ViewActions.click());
        onView(withId(R.id.button_p)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_a)).perform(ViewActions.click());
        onView(withId(R.id.button_a)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_s)).perform(ViewActions.click());
        onView(withId(R.id.button_s)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_d)).perform(ViewActions.click());
        onView(withId(R.id.button_d)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_f)).perform(ViewActions.click());
        onView(withId(R.id.button_f)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_g)).perform(ViewActions.click());
        onView(withId(R.id.button_g)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_h)).perform(ViewActions.click());
        onView(withId(R.id.button_h)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_j)).perform(ViewActions.click());
        onView(withId(R.id.button_j)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_k)).perform(ViewActions.click());
        onView(withId(R.id.button_k)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_l)).perform(ViewActions.click());
        onView(withId(R.id.button_l)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_y)).perform(ViewActions.click());
        onView(withId(R.id.button_y)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_x)).perform(ViewActions.click());
        onView(withId(R.id.button_x)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_c)).perform(ViewActions.click());
        onView(withId(R.id.button_c)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_v)).perform(ViewActions.click());
        onView(withId(R.id.button_v)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_b)).perform(ViewActions.click());
        onView(withId(R.id.button_b)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_n)).perform(ViewActions.click());
        onView(withId(R.id.button_n)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_m)).perform(ViewActions.click());
        onView(withId(R.id.button_m)).check(matches(not(isEnabled())));
    }

    @Test
    public void testIfWordExists()
    {
        onView(withId(R.id.Word)).check(matches(isDisplayed()));
    }
}
