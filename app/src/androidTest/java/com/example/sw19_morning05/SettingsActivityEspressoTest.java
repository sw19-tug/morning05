package com.example.sw19_morning05;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewAssertion;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.TextView;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;


@RunWith(AndroidJUnit4.class)
public class SettingsActivityEspressoTest {

    @Rule
    public ActivityTestRule<SettingsActivity> settings_activity_test_rule = new ActivityTestRule<>(SettingsActivity.class);

    @Test
    public void testSettingsVisible() {
        onView(withId(R.id.switch_nightmode)).check(matches(isDisplayed()));
        onView(withId(R.id.switch_music)).check(matches(isDisplayed()));
        onView(withId(R.id.switch_physical)).check(matches(isDisplayed()));
        onView(withId(R.id.input_username)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_username_save)).check(matches(isDisplayed()));
    }

    @Test
    public void testSettingsSwitchesSwitchable() {
        onView(withId(R.id.switch_nightmode)).check(matches(isDisplayed()));
        onView(withId(R.id.switch_music)).check(matches(isDisplayed()));
        onView(withId(R.id.switch_physical)).check(matches(isDisplayed()));

        onView(withId(R.id.switch_nightmode)).check(matches(not(isChecked())));
        onView(withId(R.id.switch_nightmode)).check(matches(not(isChecked())));
        onView(withId(R.id.switch_nightmode)).check(matches(not(isChecked())));

        onView(withId(R.id.switch_nightmode)).perform(click());
        onView(withId(R.id.switch_music)).perform(click());
        onView(withId(R.id.switch_physical)).perform(click());

        onView(withId(R.id.switch_nightmode)).check(matches(isChecked()));
        onView(withId(R.id.switch_nightmode)).check(matches(isChecked()));
        onView(withId(R.id.switch_nightmode)).check(matches(isChecked()));

        onView(withId(R.id.switch_nightmode)).perform(click());
        onView(withId(R.id.switch_music)).perform(click());
        onView(withId(R.id.switch_physical)).perform(click());
    }

    @Test
    public void testUpdateUsername() {
        String new_username = "jon_snow_69";
        onView(withId(R.id.input_username)).perform(replaceText(new_username));
        onView(withId(R.id.btn_username_save)).perform(click());

        Context context = settings_activity_test_rule.getActivity().getApplicationContext();
        String username = Settings.getUsername(context);

        Assert.assertEquals(username, new_username);
    }

    @Test
    public void testNightMode() {
        Context context = settings_activity_test_rule.getActivity().getApplicationContext();
        Resources.Theme theme = context.getTheme();
        onView(withId(R.id.switch_nightmode)).perform(click());
        Resources.Theme theme_new = context.getTheme();

        Assert.assertNotEquals(theme, theme_new);
        //Assert.assertEquals("Color does not match", RED_COLOR, defaultColor);
        onView(withId(R.id.switch_nightmode)).perform(click());
    }

    @Test
    public void testUpdateSwitches() {
        Context context = settings_activity_test_rule.getActivity().getApplicationContext();

        boolean is_nightmode = Settings.getNightmode(context);
        boolean is_music = Settings.getBackgroundMusic(context);
        boolean is_physical = Settings.getPhysicalFeedback(context);

        onView(withId(R.id.switch_nightmode)).perform(click());
        onView(withId(R.id.switch_music)).perform(click());
        onView(withId(R.id.switch_physical)).perform(click());

        Assert.assertNotEquals(is_nightmode, Settings.getNightmode(context));
        Assert.assertNotEquals(is_music, Settings.getBackgroundMusic(context));
        Assert.assertNotEquals(is_physical, Settings.getPhysicalFeedback(context));

        onView(withId(R.id.switch_nightmode)).perform(click());
        onView(withId(R.id.switch_music)).perform(click());
        onView(withId(R.id.switch_physical)).perform(click());
    }

    @Test
    public void testPhysicalFeedback()
    {
        Context context = settings_activity_test_rule.getActivity().getApplicationContext();
        onView(withId(R.id.switch_physical)).perform(click());

        long duration_ms = 1000;
        Vibration.vibrate(context, duration_ms);
        Assert.assertEquals(Vibration.checkVibrateActive(), true);

        onView(withId(R.id.switch_physical)).perform(click());
    }
}
