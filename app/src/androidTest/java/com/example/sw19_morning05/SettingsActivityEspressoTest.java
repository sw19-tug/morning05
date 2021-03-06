package com.example.sw19_morning05;

import android.content.Context;
import android.content.res.Configuration;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
public class SettingsActivityEspressoTest {

    @Rule
    public ActivityTestRule<SettingsActivity> settings_activity_test_rule = new ActivityTestRule<>(SettingsActivity.class);


    @Test
    public void testSettingsVisible() {
        onView(withId(R.id.switch_nightmode_sett)).check(matches(isDisplayed()));
        onView(withId(R.id.switch_music_sett)).check(matches(isDisplayed()));
        onView(withId(R.id.switch_physical_sett)).check(matches(isDisplayed()));
        onView(withId(R.id.input_username_sett)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_username_save_sett)).check(matches(isDisplayed()));
    }

    @Test
    public void testSettingsSwitchesSwitchable() {
        Context context = settings_activity_test_rule.getActivity().getApplicationContext();

        boolean is_music = Settings.getNightmode(context);
        boolean is_nightmode = Settings.getBackgroundMusic(context);
        boolean is_physical = Settings.getPhysicalFeedback(context);

        onView(withId(R.id.switch_music_sett)).perform(click());
        onView(withId(R.id.switch_nightmode_sett)).perform(click());
        onView(withId(R.id.switch_physical_sett)).perform(click());

        Assert.assertNotEquals(is_music, Settings.getNightmode(context));
        Assert.assertNotEquals(is_nightmode, Settings.getBackgroundMusic(context));
        Assert.assertNotEquals(is_physical, Settings.getPhysicalFeedback(context));

        onView(withId(R.id.switch_music_sett)).perform(click());
        onView(withId(R.id.switch_nightmode_sett)).perform(click());
        onView(withId(R.id.switch_physical_sett)).perform(click());

        Assert.assertEquals(is_music, Settings.getNightmode(context));
        Assert.assertEquals(is_nightmode, Settings.getBackgroundMusic(context));
        Assert.assertEquals(is_physical, Settings.getPhysicalFeedback(context));

    }

    @Test
    public void testUpdateUsername() {
        String new_username = "jon_snow_69";
        onView(withId(R.id.input_username_sett)).perform(replaceText(new_username));
        onView(withId(R.id.btn_username_save_sett)).perform(click());

        Context context = settings_activity_test_rule.getActivity().getApplicationContext();
        String username = Settings.getUsername(context);

        Assert.assertEquals(username, new_username);
    }

    @Test
    public void testNightMode() {
        Context context = settings_activity_test_rule.getActivity().getApplicationContext();
        onView(withId(R.id.switch_nightmode_sett)).perform(click());

        onView(withId(R.id.btn_back_sett)).perform(click());
        onView(withId(R.id.btn_settings_m)).perform(click());

        Configuration conf = context.getResources().getConfiguration();
        if (Settings.getNightmode(context)) {
            int currentNightMode = conf.uiMode & Configuration.UI_MODE_NIGHT_MASK;
            Assert.assertEquals(currentNightMode, Configuration.UI_MODE_NIGHT_YES);
        } else {
            int currentNightMode = conf.uiMode & Configuration.UI_MODE_NIGHT_MASK;
            Assert.assertEquals(currentNightMode, Configuration.UI_MODE_NIGHT_NO);
        }
        onView(withId(R.id.switch_nightmode_sett)).perform(click());
    }

    @Test
    public void testUpdateSwitches() {
        Context context = settings_activity_test_rule.getActivity().getApplicationContext();

        boolean is_nightmode = Settings.getNightmode(context);
        boolean is_music = Settings.getBackgroundMusic(context);
        boolean is_physical = Settings.getPhysicalFeedback(context);

        onView(withId(R.id.switch_nightmode_sett)).perform(click());
        onView(withId(R.id.switch_music_sett)).perform(click());
        onView(withId(R.id.switch_physical_sett)).perform(click());

        Assert.assertNotEquals(is_nightmode, Settings.getNightmode(context));
        Assert.assertNotEquals(is_music, Settings.getBackgroundMusic(context));
        Assert.assertNotEquals(is_physical, Settings.getPhysicalFeedback(context));

        onView(withId(R.id.switch_nightmode_sett)).perform(click());
        onView(withId(R.id.switch_music_sett)).perform(click());
        onView(withId(R.id.switch_physical_sett)).perform(click());
    }

    @Test
    public void testPhysicalFeedback() {
        Context context = settings_activity_test_rule.getActivity().getApplicationContext();
        onView(withId(R.id.switch_physical_sett)).perform(click());

        long duration_ms = 1000;
        Vibration.vibrate(context, duration_ms);
        Assert.assertEquals(Vibration.checkVibrateActive(), true);

        onView(withId(R.id.switch_physical_sett)).perform(click());
    }

    @Test
    public void testMusicSpinnerExists() {
        onView(withId(R.id.spinn_backg_music_sett)).check(matches(isDisplayed()));
    }

    @Test
    public void testEnableBackgroundMusic() {

        assert(!BackgroundMusicPlayer.is_playing);
        onView(withId(R.id.switch_music_sett)).perform(click());
        assert(BackgroundMusicPlayer.is_playing);
        onView(withId(R.id.switch_music_sett)).perform(click());
    }
}
