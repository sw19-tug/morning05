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
import static android.support.test.internal.runner.junit4.statement.UiThreadStatement.runOnUiThread;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(AndroidJUnit4.class)
public class TTBActivityEspressoTest {
    final Context context = InstrumentationRegistry.getTargetContext();

    @Rule
    public ActivityTestRule<TTBActivity> activity_test_rule =
            new ActivityTestRule<>(TTBActivity.class);

    public void clickBackground() {
        try {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Button btn = activity_test_rule.getActivity().findViewById(R.id.btn_background);
                    btn.callOnClick();
                }
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Test
    public void testBlockButton() {
        onView(withId(R.id.btn_play)).perform(click());

        onView(withId(R.id.moving_block)).check(matches(isDisplayed()));
        onView(withId(R.id.moving_block)).check(matches(isClickable()));
        onView(withId(R.id.moving_block)).check(matches(withText("")));

        clickBackground();

        onView(withId(R.id.btn_back_ttb)).perform(click());
    }

    @Test
    public void testPlayAgainButton() {
        onView(withId(R.id.btn_play)).perform(click());

        onView(withId(R.id.moving_block)).check(matches(isDisplayed()));
        onView(withId(R.id.moving_block)).check(matches(isClickable()));
        onView(withId(R.id.moving_block)).check(matches(withText("")));

        clickBackground();

        onView(withId(R.id.btn_reset_ttb)).perform(click());

        onView(withId(R.id.moving_block)).check(matches(isDisplayed()));
        onView(withId(R.id.moving_block)).check(matches(isClickable()));
        onView(withId(R.id.moving_block)).check(matches(withText("")));

        clickBackground();
        onView(withId(R.id.btn_back_ttb)).perform(click());
    }


    @Test
    public void testResetButton() {
        onView(withId(R.id.btn_play)).perform(click());

        clickBackground();

        onView(withId(R.id.btn_reset_ttb)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_reset_ttb)).check(matches(isClickable()));

        clickBackground();
        onView(withId(R.id.btn_back_ttb)).perform(click());
    }

    @Test
    public void testBackgroundButton() {
        onView(withId(R.id.btn_play)).perform(click());

        onView(withId(R.id.btn_background)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_background)).check(matches(isClickable()));
        onView(withId(R.id.btn_background)).check(matches(withText("")));

        clickBackground();
        onView(withId(R.id.btn_back_ttb)).perform(click());
    }


    @Test
    public void testBlockMoves() {
        onView(withId(R.id.btn_play)).perform(click());

        Handler handler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message message) {
                Looper.prepareMainLooper();
                Button button = new TTBActivity().findViewById(R.id.moving_block);

                float button_x = button.getX();
                float button_y = button.getY();

                onView(withId(R.id.moving_block)).perform(click());

                float button_x_new = button.getX();
                float button_y_new = button.getY();

                assertNotEquals(button_x, button_x_new, 0);
                assertNotEquals(button_y, button_y_new, 0);
            }
        };
        clickBackground();

        onView(withId(R.id.btn_back_ttb)).perform(click());
    }

    @Test
    public void testBlockResizes() {
        onView(withId(R.id.btn_play)).perform(click());

        Button button = activity_test_rule.getActivity().findViewById(R.id.moving_block);

        float button_height = button.getHeight();
        float button_width = button.getWidth();

        onView(withId(R.id.moving_block)).perform(click());

        float button_height_new = button.getHeight();
        float button_width_new = button.getWidth();

        if (button_height == button_height_new) {
            assertEquals(button_width, button_width_new * 2 + 1, 0f);
        } else {
            assertEquals(button_height, button_height_new * 2 + 1, 0f);
        }

        clickBackground();

        onView(withId(R.id.btn_back_ttb)).perform(click());
    }

    @Test
    public void testColorsDisplayed() {
        onView(withId(R.id.btn_settings_ttb)).perform(click());

        onView(withId(R.id.btn_green)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_blue)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_red)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_magenta)).check(matches(isDisplayed()));

        onView(withId(R.id.btn_black_background)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_grey_background)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_white_background)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_magenta_background)).check(matches(isDisplayed()));

        onView(withId(R.id.btn_settings_back_ttb)).perform(click());
    }

    @Test
    public void testColorsClickable() {
        onView(withId(R.id.btn_settings_ttb)).perform(click());

        onView(withId(R.id.btn_green)).check(matches(isClickable()));
        onView(withId(R.id.btn_blue)).check(matches(isClickable()));
        onView(withId(R.id.btn_red)).check(matches(isClickable()));
        onView(withId(R.id.btn_magenta)).check(matches(isClickable()));

        onView(withId(R.id.btn_black_background)).check(matches(isClickable()));
        onView(withId(R.id.btn_grey_background)).check(matches(isClickable()));
        onView(withId(R.id.btn_white_background)).check(matches(isClickable()));
        onView(withId(R.id.btn_magenta_background)).check(matches(isClickable()));

        onView(withId(R.id.btn_settings_back_ttb)).perform(click());
    }

    @Test
    public void testColorTexts() {
        onView(withId(R.id.btn_settings_ttb)).perform(click());

        onView(withId(R.id.btn_green)).check(matches(withText("green")));
        onView(withId(R.id.btn_blue)).check(matches(withText("blue")));
        onView(withId(R.id.btn_red)).check(matches(withText("red")));
        onView(withId(R.id.btn_magenta)).check(matches(withText("magenta")));

        onView(withId(R.id.btn_black_background)).check(matches(withText("black")));
        onView(withId(R.id.btn_grey_background)).check(matches(withText("grey")));
        onView(withId(R.id.btn_white_background)).check(matches(withText("white")));
        onView(withId(R.id.btn_magenta_background)).check(matches(withText("magenta")));

        onView(withId(R.id.btn_settings_back_ttb)).perform(click());
    }

    @Test
    public void testBlockColorDisabledAndVisibility() {
        onView(withId(R.id.btn_settings_ttb)).perform(click());

        int correct_counter = 0;

        onView(withId(R.id.btn_green)).perform(click());

        Button btn_green = activity_test_rule.getActivity().findViewById(R.id.btn_green);
        Button btn_blue = activity_test_rule.getActivity().findViewById(R.id.btn_blue);
        Button btn_red = activity_test_rule.getActivity().findViewById(R.id.btn_red);
        Button btn_magenta = activity_test_rule.getActivity().findViewById(R.id.btn_magenta);

        if (!btn_green.isEnabled())
            correct_counter++;
        if (btn_green.getVisibility() == View.INVISIBLE)
            correct_counter++;
        if (!btn_blue.isEnabled())
            correct_counter++;
        if (btn_blue.getVisibility() == View.INVISIBLE)
            correct_counter++;
        if (!btn_red.isEnabled())
            correct_counter++;
        if (btn_red.getVisibility() == View.INVISIBLE)
            correct_counter++;
        if (!btn_magenta.isEnabled())
            correct_counter++;
        if (btn_magenta.getVisibility() == View.INVISIBLE)
            correct_counter++;

        onView(withId(R.id.btn_settings_back_ttb)).perform(click());
        assertEquals(8, correct_counter);
    }

    @Test
    public void testBackgroundColorDisabledAndVisibility() {
        onView(withId(R.id.btn_settings_ttb)).perform(click());

        int correct_counter = 0;

        onView(withId(R.id.btn_magenta_background)).perform(click());

        Button btn_black = activity_test_rule.getActivity().findViewById(R.id.btn_black_background);
        Button btn_grey = activity_test_rule.getActivity().findViewById(R.id.btn_grey_background);
        Button btn_white = activity_test_rule.getActivity().findViewById(R.id.btn_white_background);
        Button btn_magenta = activity_test_rule.getActivity().findViewById(R.id.btn_magenta_background);

        if (!btn_black.isEnabled())
            correct_counter++;
        if (btn_black.getVisibility() == View.INVISIBLE)
            correct_counter++;
        if (!btn_grey.isEnabled())
            correct_counter++;
        if (btn_grey.getVisibility() == View.INVISIBLE)
            correct_counter++;
        if (!btn_white.isEnabled())
            correct_counter++;
        if (btn_white.getVisibility() == View.INVISIBLE)
            correct_counter++;
        if (!btn_magenta.isEnabled())
            correct_counter++;
        if (btn_magenta.getVisibility() == View.INVISIBLE)
            correct_counter++;

        onView(withId(R.id.btn_settings_back_ttb)).perform(click());
        assertEquals(8, correct_counter);
    }

    @Test
    public void testColoredBlocks() {
        onView(withId(R.id.btn_settings_ttb)).perform(click());

        onView(withId(R.id.btn_magenta_background)).perform(click());
        onView(withId(R.id.btn_red)).perform(click());

        onView(withId(R.id.btn_settings_ok_ttb)).perform(click());
        onView(withId(R.id.btn_play)).perform(click());

        Button btn_block = activity_test_rule.getActivity().findViewById(R.id.moving_block);
        ColorDrawable color_block = (ColorDrawable) btn_block.getBackground();
        Button btn_background = activity_test_rule.getActivity().findViewById(R.id.btn_background);
        ColorDrawable color_bg = (ColorDrawable) btn_background.getBackground();

        int color_b_color = color_block.getColor();
        int color_bg_color = color_bg.getColor();

        clickBackground();
        onView(withId(R.id.btn_back_ttb)).perform(click());

        assertEquals(0xFFFF000F, color_b_color);
        assertEquals(0xFFFF00FF, color_bg_color);
    }

    @Test
    public void testSettingsBackButton() {
        onView(withId(R.id.btn_settings_ttb)).perform(click());

        onView(withId(R.id.btn_magenta_background)).perform(click());
        onView(withId(R.id.btn_red)).perform(click());

        onView(withId(R.id.btn_settings_back_ttb)).perform(click());
        onView(withId(R.id.btn_play)).check(matches(isDisplayed()));
    }

}