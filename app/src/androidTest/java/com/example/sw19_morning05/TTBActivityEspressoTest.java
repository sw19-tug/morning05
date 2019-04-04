package com.example.sw19_morning05;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
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
    final Context context = InstrumentationRegistry.getTargetContext();

    @Rule
    public ActivityTestRule<TTBActivity> ttbActivityActivityTestRule =
            new ActivityTestRule<>(TTBActivity.class);

    @Test
    public void testBlockButton()
    {
        onView(withId(R.id.magenta_background)).perform(click());
        onView(withId(R.id.red_button)).perform(click());

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

        onView(withId(R.id.magenta_background)).perform(click());
        onView(withId(R.id.red_button)).perform(click());

        Button button = ttbActivityActivityTestRule.getActivity().findViewById(R.id.moving_block);

        float button_height = button.getHeight();
        float button_width = button.getWidth();

        onView(withId(R.id.moving_block)).perform(click());

        float button_height_new = button.getHeight();
        float button_width_new = button.getWidth();

        if (button_height == button_height_new) {
            assertEquals(button_width, button_width_new * 2 + 1, 0f);
        }
        else {
            assertEquals(button_height, button_height_new * 2 + 1, 0f);
        }
    }

    @Test
    public void testColorsDisplayed()
    {
        onView(withId(R.id.green_button)).check(matches(isDisplayed()));
        onView(withId(R.id.blue_button)).check(matches(isDisplayed()));
        onView(withId(R.id.red_button)).check(matches(isDisplayed()));
        onView(withId(R.id.magenta_button)).check(matches(isDisplayed()));


        onView(withId(R.id.black_background)).check(matches(isDisplayed()));
        onView(withId(R.id.grey_background)).check(matches(isDisplayed()));
        onView(withId(R.id.white_background)).check(matches(isDisplayed()));
        onView(withId(R.id.magenta_background)).check(matches(isDisplayed()));
    }

    @Test
    public void testColorsClickable()
    {
        onView(withId(R.id.green_button)).check(matches(isClickable()));
        onView(withId(R.id.blue_button)).check(matches(isClickable()));
        onView(withId(R.id.red_button)).check(matches(isClickable()));
        onView(withId(R.id.magenta_button)).check(matches(isClickable()));

        onView(withId(R.id.black_background)).check(matches(isClickable()));
        onView(withId(R.id.grey_background)).check(matches(isClickable()));
        onView(withId(R.id.white_background)).check(matches(isClickable()));
        onView(withId(R.id.magenta_background)).check(matches(isClickable()));
    }

    @Test
    public void testColorTexts()
    {
        onView(withId(R.id.green_button)).check(matches(withText("green")));
        onView(withId(R.id.blue_button)).check(matches(withText("blue")));
        onView(withId(R.id.red_button)).check(matches(withText("red")));
        onView(withId(R.id.magenta_button)).check(matches(withText("magenta")));

        onView(withId(R.id.black_background)).check(matches(withText("black")));
        onView(withId(R.id.grey_background)).check(matches(withText("grey")));
        onView(withId(R.id.white_background)).check(matches(withText("white")));
        onView(withId(R.id.magenta_background)).check(matches(withText("magenta")));
    }

    @Test
    public void testBlockColorDisabledAndVisibility()
    {
        int correct_counter = 0;

        onView(withId(R.id.green_button)).perform(click());

        Button green = ttbActivityActivityTestRule.getActivity().findViewById(R.id.green_button);
        Button blue = ttbActivityActivityTestRule.getActivity().findViewById(R.id.blue_button);
        Button red = ttbActivityActivityTestRule.getActivity().findViewById(R.id.red_button);
        Button magenta = ttbActivityActivityTestRule.getActivity().findViewById(R.id.magenta_button);

        if (!green.isEnabled())
            correct_counter++;
        if (green.getVisibility() == View.INVISIBLE)
            correct_counter++;
        if (!blue.isEnabled())
            correct_counter++;
        if (blue.getVisibility() == View.INVISIBLE)
            correct_counter++;
        if (!red.isEnabled())
            correct_counter++;
        if (red.getVisibility() == View.INVISIBLE)
            correct_counter++;
        if (!magenta.isEnabled())
            correct_counter++;
        if (magenta.getVisibility() == View.INVISIBLE)
            correct_counter++;

        assertEquals(8, correct_counter);
    }

    @Test
    public void testBackgroundColorDisabledAndVisibility()
    {
        int correct_counter = 0;

        onView(withId(R.id.magenta_background)).perform(click());

        Button black = ttbActivityActivityTestRule.getActivity().findViewById(R.id.black_background);
        Button grey = ttbActivityActivityTestRule.getActivity().findViewById(R.id.grey_background);
        Button white = ttbActivityActivityTestRule.getActivity().findViewById(R.id.white_background);
        Button magenta = ttbActivityActivityTestRule.getActivity().findViewById(R.id.magenta_background);

        if (!black.isEnabled())
            correct_counter++;
        if (black.getVisibility() == View.INVISIBLE)
            correct_counter++;
        if (!grey.isEnabled())
            correct_counter++;
        if (grey.getVisibility() == View.INVISIBLE)
            correct_counter++;
        if (!white.isEnabled())
            correct_counter++;
        if (white.getVisibility() == View.INVISIBLE)
            correct_counter++;
        if (!magenta.isEnabled())
            correct_counter++;
        if (magenta.getVisibility() == View.INVISIBLE)
            correct_counter++;

        assertEquals(8, correct_counter);
    }

    @Test
    public void testColoredBlocks()
    {
        onView(withId(R.id.magenta_background)).perform(click());
        onView(withId(R.id.red_button)).perform(click());

        Button block = ttbActivityActivityTestRule.getActivity().findViewById(R.id.moving_block);
        ColorDrawable color_b = (ColorDrawable) block.getBackground();
        Button background = ttbActivityActivityTestRule.getActivity().findViewById(R.id.background_btn);
        ColorDrawable color_bg = (ColorDrawable) background.getBackground();

        int color_bColor = color_b.getColor();
        int color_bgColor = color_bg.getColor();

        assertEquals(0xFFFF000F, color_bColor);
        assertEquals(0xFFFF00FF, color_bgColor);
    }


}