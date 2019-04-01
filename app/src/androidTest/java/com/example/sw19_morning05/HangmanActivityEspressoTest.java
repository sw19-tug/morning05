package com.example.sw19_morning05;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.isDialog;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.containsString;
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
        onView(withId(R.id.button_q)).perform(click());
        onView(withId(R.id.button_q)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_w)).perform(click());
        onView(withId(R.id.button_w)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_e)).perform(click());
        onView(withId(R.id.button_e)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_r)).perform(click());
        onView(withId(R.id.button_r)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_t)).perform(click());
        onView(withId(R.id.button_t)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_z)).perform(click());
        onView(withId(R.id.button_z)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_u)).perform(click());
        onView(withId(R.id.button_u)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_i)).perform(click());
        onView(withId(R.id.button_i)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_o)).perform(click());
        onView(withId(R.id.button_o)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_p)).perform(click());
        onView(withId(R.id.button_p)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_a)).perform(click());
        onView(withId(R.id.button_a)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_s)).perform(click());
        onView(withId(R.id.button_s)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_d)).perform(click());
        onView(withId(R.id.button_d)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_f)).perform(click());
        onView(withId(R.id.button_f)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_g)).perform(click());
        onView(withId(R.id.button_g)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_h)).perform(click());
        onView(withId(R.id.button_h)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_j)).perform(click());
        onView(withId(R.id.button_j)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_k)).perform(click());
        onView(withId(R.id.button_k)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_l)).perform(click());
        onView(withId(R.id.button_l)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_y)).perform(click());
        onView(withId(R.id.button_y)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_x)).perform(click());
        onView(withId(R.id.button_x)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_c)).perform(click());
        onView(withId(R.id.button_c)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_v)).perform(click());
        onView(withId(R.id.button_v)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_b)).perform(click());
        onView(withId(R.id.button_b)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_n)).perform(click());
        onView(withId(R.id.button_n)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_m)).perform(click());
        onView(withId(R.id.button_m)).check(matches(not(isEnabled())));
    }

    @Test
    public void testIfWordExists()
    {
        onView(withId(R.id.word)).check(matches(isDisplayed()));
    }

    @Test
    public void testWordShown()
    {
        onView(withId(R.id.word)).check(matches(not(withText("word"))));
    }

    @Test
    public void testCheckIfNoUnderlinesAnnymore()
    {
        onView(withId(R.id.button_q)).perform(click());
        onView(withId(R.id.button_w)).perform(click());
        onView(withId(R.id.button_e)).perform(click());
        onView(withId(R.id.button_r)).perform(click());
        onView(withId(R.id.button_t)).perform(click());
        onView(withId(R.id.button_z)).perform(click());
        onView(withId(R.id.button_u)).perform(click());
        onView(withId(R.id.button_i)).perform(click());
        onView(withId(R.id.button_o)).perform(click());
        onView(withId(R.id.button_p)).perform(click());
        onView(withId(R.id.button_a)).perform(click());
        onView(withId(R.id.button_s)).perform(click());
        onView(withId(R.id.button_d)).perform(click());
        onView(withId(R.id.button_f)).perform(click());
        onView(withId(R.id.button_g)).perform(click());
        onView(withId(R.id.button_h)).perform(click());
        onView(withId(R.id.button_j)).perform(click());
        onView(withId(R.id.button_k)).perform(click());
        onView(withId(R.id.button_l)).perform(click());
        onView(withId(R.id.button_y)).perform(click());
        onView(withId(R.id.button_x)).perform(click());
        onView(withId(R.id.button_c)).perform(click());
        onView(withId(R.id.button_v)).perform(click());
        onView(withId(R.id.button_b)).perform(click());
        onView(withId(R.id.button_n)).perform(click());
        onView(withId(R.id.button_m)).perform(click());

        onView(withId((R.id.word))).check(matches(not(withText(containsString("_")))));
    }

    @Test
    public void testWinMessage()
    {
        onView(withId(R.id.button_q)).perform(click());
        onView(withId(R.id.button_w)).perform(click());
        onView(withId(R.id.button_e)).perform(click());
        onView(withId(R.id.button_r)).perform(click());
        onView(withId(R.id.button_t)).perform(click());
        onView(withId(R.id.button_z)).perform(click());
        onView(withId(R.id.button_u)).perform(click());
        onView(withId(R.id.button_i)).perform(click());
        onView(withId(R.id.button_o)).perform(click());
        onView(withId(R.id.button_p)).perform(click());
        onView(withId(R.id.button_a)).perform(click());
        onView(withId(R.id.button_s)).perform(click());
        onView(withId(R.id.button_d)).perform(click());
        onView(withId(R.id.button_f)).perform(click());
        onView(withId(R.id.button_g)).perform(click());
        onView(withId(R.id.button_h)).perform(click());
        onView(withId(R.id.button_j)).perform(click());
        onView(withId(R.id.button_k)).perform(click());
        onView(withId(R.id.button_l)).perform(click());
        onView(withId(R.id.button_y)).perform(click());
        onView(withId(R.id.button_x)).perform(click());
        onView(withId(R.id.button_c)).perform(click());
        onView(withId(R.id.button_v)).perform(click());
        onView(withId(R.id.button_b)).perform(click());
        onView(withId(R.id.button_n)).perform(click());
        onView(withId(R.id.button_m)).perform(click());

        onView(withText("Play Again"))
                .inRoot(isDialog())
                .check(matches(isDisplayed()))
                .perform(click());

        onView(withId(R.id.button_q)).perform(click());
        onView(withId(R.id.button_w)).perform(click());
        onView(withId(R.id.button_e)).perform(click());
        onView(withId(R.id.button_r)).perform(click());
        onView(withId(R.id.button_t)).perform(click());
        onView(withId(R.id.button_z)).perform(click());
        onView(withId(R.id.button_u)).perform(click());
        onView(withId(R.id.button_i)).perform(click());
        onView(withId(R.id.button_o)).perform(click());
        onView(withId(R.id.button_p)).perform(click());
        onView(withId(R.id.button_a)).perform(click());
        onView(withId(R.id.button_s)).perform(click());
        onView(withId(R.id.button_d)).perform(click());
        onView(withId(R.id.button_f)).perform(click());
        onView(withId(R.id.button_g)).perform(click());
        onView(withId(R.id.button_h)).perform(click());
        onView(withId(R.id.button_j)).perform(click());
        onView(withId(R.id.button_k)).perform(click());
        onView(withId(R.id.button_l)).perform(click());
        onView(withId(R.id.button_y)).perform(click());
        onView(withId(R.id.button_x)).perform(click());
        onView(withId(R.id.button_c)).perform(click());
        onView(withId(R.id.button_v)).perform(click());
        onView(withId(R.id.button_b)).perform(click());
        onView(withId(R.id.button_n)).perform(click());
        onView(withId(R.id.button_m)).perform(click());

        onView(withText("Exit"))
                .inRoot(isDialog())
                .check(matches(isDisplayed()))
                .perform(click());
    }
}
