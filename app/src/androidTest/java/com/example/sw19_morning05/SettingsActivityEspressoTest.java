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

        onView(withId(R.id.switch_nightmode)).check(not(matches(isChecked())));
        onView(withId(R.id.switch_nightmode)).check(not(matches(isChecked())));
        onView(withId(R.id.switch_nightmode)).check(not(matches(isChecked())));

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
        onView(withId(R.id.input_username)).perform(typeText(new_username));
        onView(withId(R.id.btn_username_save)).perform(click());

        Context context = settings_activity_test_rule.getActivity().getApplicationContext();
        String username = Settings.getUsername(context);

        Assert.assertEquals(username, new_username);
    }

    @Test
    public void testUpdateSwitches() {
        boolean is_nightmode = Settings.getNightmode(context);
        boolean is_music = Settings.getMusic(context);
        boolean is_physical = Settings.getPhysical(context);

        onView(withId(R.id.switch_nightmode)).perform(click());
        onView(withId(R.id.switch_music)).perform(click());
        onView(withId(R.id.switch_physical)).perform(click());

        onView(withId(R.id.switch_nightmode)).check(matches(isChecked()));
        onView(withId(R.id.switch_nightmode)).check(matches(isChecked()));
        onView(withId(R.id.switch_nightmode)).check(matches(isChecked()));

        Assert.assertNotEquals(is_nightmode, Settings.getNightmode(context));
        Assert.assertNotEquals(is_music, Settings.getMusic(context));
        Assert.assertNotEquals(is_physical, Settings.getPhysical(context));
    }
}
