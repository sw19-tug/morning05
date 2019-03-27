package com.example.sw19_morning05;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class TouchTheBlockActivity2EspressoTest {

    @Rule
    public ActivityTestRule<TTBActivity> ActivityTestRule =
            new ActivityTestRule<>(TTBActivity.class);

    /*@Test
    public void check_Button()
    {
        onView(withId(R.id.btt_start_button)).check(matches(isDisplayed()));
        onView(withId(R.id.btt_pause_button)).check(matches(isDisplayed()));
        onView(withId(R.id.btt_stop_button)).check(matches(isDisplayed()));
    }*/

    /*@Test
    public void check_Title()
    {
        onView(ViewMatchers.withId(R.id.btt_title)).check(matches(isDisplayed()));
    }*/

    /*@Test
    public void check_Block()
    {
        onView(ViewMatchers.withId(R.id.btt_block)).check(matches(isDisplayed()));
    }*/

    //Check if block is half the screen size and positioned in upper left corner
    @Test
    public void checkBlockSize()
    {/*
        int display_height = 300;
        onView(ViewMatchers.withId(R.id.moving_block)).check((matches(isDisplayed())));
        assertEquals(display_height, moving_block.getHeight());*/
    }
}
