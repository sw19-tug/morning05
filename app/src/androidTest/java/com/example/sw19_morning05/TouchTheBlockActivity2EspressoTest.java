package com.example.sw19_morning05;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class TouchTheBlockActivity2EspressoTest {

    @Rule
    public ActivityTestRule<TouchTheBlockActivity> ActivityTestRule =
            new ActivityTestRule<>(TouchTheBlockActivity.class);

    @Test
    public void check_Button()
    {
        onView(withId(R.id.btt_start_button)).check(matches(isDisplayed()));
        onView(withId(R.id.btt_pause_button)).check(matches(isDisplayed()));
        onView(withId(R.id.btt_stop_button)).check(matches(isDisplayed()));
    }

    @Test
    public void check_Title()
    {
        onView(ViewMatchers.withId(R.id.btt_title)).check(matches(isDisplayed()));
    }
/*
    @Test
    public void check_Block()
    {
        onView(ViewMatchers.withId(R.id.btt_block)).check(matches(isDisplayed()));
    }*/
}
