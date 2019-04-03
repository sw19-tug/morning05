package com.example.sw19_morning05;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.Button;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(AndroidJUnit4.class)
public class TTBActivityEspressoTest
{
    @Rule
    public ActivityTestRule<TTBActivity> ttbActivityActivityTestRule =
            new ActivityTestRule<>(TTBActivity.class);

    @Test
    public void testBlockButton()
    {
        onView(withId(R.id.moving_block)).check(matches(isDisplayed()));
        onView(withId(R.id.moving_block)).check(matches(isClickable()));
        onView(withId(R.id.moving_block)).check(matches(withText("")));
    }

    @Test
    public void testBackgroundButton()
    {
        onView(withId(R.id.background_btn)).check(matches(isDisplayed()));
        onView(withId(R.id.background_btn)).check(matches(isClickable()));
        onView(withId(R.id.background_btn)).check(matches(withText("")));
    }

    @Test
    public void testBlockMoves()
    {
        Handler handler = new Handler(Looper.getMainLooper())
        {
            @Override
            public void handleMessage(Message message)
            {
                Looper.prepareMainLooper();
                Button button = new TTBActivity().findViewById(R.id.moving_block);

                float buttonX = button.getX();
                float buttonY = button.getY();

                onView(withId(R.id.moving_block)).perform(click());

                float buttonX_new = button.getX();
                float buttonY_new = button.getY();

                assertNotEquals(buttonX, buttonX_new, 0);
                assertNotEquals(buttonY, buttonY_new, 0);
            }
        };
    }

    @Test
    public void testBlockResizes()
    {
        Handler handler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message message)
            {
                Looper.prepareMainLooper();
                Button button = new TTBActivity().findViewById(R.id.moving_block);

                float button_height = button.getHeight();
                float button_width = button.getWidth();

                onView(withId(R.id.moving_block)).perform(click());

                float button_height_new = button.getHeight();
                float button_width_new = button.getWidth();

                if (button_height == button_height_new)
                {
                    assertEquals(button_width, button_width_new * 2);
                }
                else
                {
                    assertEquals(button_height, button_height_new * 2);
                }
            }
        };
    }
}