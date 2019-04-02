package com.example.sw19_morning05;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class TTBActivityEspressoTest
{
    @Rule
    public ActivityTestRule<TTBActivity> ttbActivityActivityTestRule =
            new ActivityTestRule<>(TTBActivity.class);

    @Test
    public void testBlockButtonVisible()
    {
        onView(withId(R.id.moving_block)).check(matches(isDisplayed()));
    }

    @Test
    public void testBlockIsClickable()
    {
        onView(withId(R.id.moving_block)).check(matches(isClickable()));
    }

    @Test
    public void BlockHasNewPosition()
    {
        onView(withId(R.id.moving_block)).check(matches(withText("TOUCH THE BLOCK")));

        //onData(withId(R.id.moving_block)).atPosition()
    }
}