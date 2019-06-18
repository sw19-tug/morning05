package com.example.sw19_morning05;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.Display;
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
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.internal.runner.junit4.statement.UiThreadStatement.runOnUiThread;
import static org.hamcrest.Matchers.not;
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
                    Button btn = activity_test_rule.getActivity().findViewById(R.id.btn_background_ttb);
                    btn.callOnClick();
                }
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Test
    public void testBlockButton() {
        onView(withId(R.id.btn_play_ttb)).perform(click());

        onView(withId(R.id.btn_moving_block_ttb)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_moving_block_ttb)).check(matches(isClickable()));
        onView(withId(R.id.btn_moving_block_ttb)).check(matches(withText("")));

        clickBackground();

        onView(withId(R.id.btn_back_ttb)).perform(click());
    }

    @Test
    public void testPlayAgainButton() {
        onView(withId(R.id.btn_play_ttb)).perform(click());

        onView(withId(R.id.btn_moving_block_ttb)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_moving_block_ttb)).check(matches(isClickable()));
        onView(withId(R.id.btn_moving_block_ttb)).check(matches(withText("")));

        clickBackground();

        onView(withId(R.id.btn_reset_ttb)).perform(click());

        onView(withId(R.id.btn_moving_block_ttb)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_moving_block_ttb)).check(matches(isClickable()));
        onView(withId(R.id.btn_moving_block_ttb)).check(matches(withText("")));

        clickBackground();
        onView(withId(R.id.btn_back_ttb)).perform(click());
    }

    @Test
    public void testResetButton() {
        onView(withId(R.id.btn_play_ttb)).perform(click());

        clickBackground();

        onView(withId(R.id.btn_reset_ttb)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_reset_ttb)).check(matches(isClickable()));

        clickBackground();
        onView(withId(R.id.btn_back_ttb)).perform(click());
    }

    @Test
    public void testBackgroundButton() {
        onView(withId(R.id.btn_play_ttb)).perform(click());

        onView(withId(R.id.btn_background_ttb)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_background_ttb)).check(matches(isClickable()));
        onView(withId(R.id.btn_background_ttb)).check(matches(withText("")));

        clickBackground();
        onView(withId(R.id.btn_back_ttb)).perform(click());
    }

    @Test
    public void testBlockMoves() {
        onView(withId(R.id.btn_play_ttb)).perform(click());

        Handler handler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message message) {
                Looper.prepareMainLooper();
                Button button = new TTBActivity().findViewById(R.id.btn_moving_block_ttb);

                float button_x = button.getX();
                float button_y = button.getY();

                onView(withId(R.id.btn_moving_block_ttb)).perform(click());

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
        onView(withId(R.id.btn_play_ttb)).perform(click());

        Button button = activity_test_rule.getActivity().findViewById(R.id.btn_moving_block_ttb);
        CountDownTimer countDownTimer = this.activity_test_rule.getActivity().cdt_play_time;
        Display display = activity_test_rule.getActivity().getWindowManager().getDefaultDisplay();

        float button_height = button.getHeight();
        float button_width = button.getWidth();
        if (button_width > display.getWidth()) {
            button_width = display.getWidth();
        }

        onView(withId(R.id.btn_moving_block_ttb)).perform(click());
        countDownTimer.cancel();

        float button_height_new = button.getHeight();
        float button_width_new = button.getWidth();

        if (button_height == button_height_new) {
            assertEquals(button_width, button_width_new * 2, 1);
        } else {
            assertEquals(button_height, button_height_new * 2, 1);
        }

        clickBackground();

        onView(withId(R.id.btn_back_ttb)).perform(click());
    }

    @Test
    public void testColorsDisplayed() {
        onView(withId(R.id.btn_settings_ttb)).perform(click());

        onView(withId(R.id.btn_b_green_ttbsett)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_b_blue_ttbsett)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_b_red_ttbsett)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_b_magenta_ttbsett)).check(matches(isDisplayed()));

        onView(withId(R.id.btn_s_black_ttbsett)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_s_grey_ttbsett)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_s_white_ttbsett)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_s_magenta_ttbsett)).check(matches(isDisplayed()));

        onView(withId(R.id.btn_back_ttbsett)).perform(click());
    }

    @Test
    public void testColorsClickable() {
        onView(withId(R.id.btn_settings_ttb)).perform(click());

        onView(withId(R.id.btn_b_green_ttbsett)).check(matches(isClickable()));
        onView(withId(R.id.btn_b_blue_ttbsett)).check(matches(isClickable()));
        onView(withId(R.id.btn_b_red_ttbsett)).check(matches(isClickable()));
        onView(withId(R.id.btn_b_magenta_ttbsett)).check(matches(isClickable()));

        onView(withId(R.id.btn_s_black_ttbsett)).check(matches(isClickable()));
        onView(withId(R.id.btn_s_grey_ttbsett)).check(matches(isClickable()));
        onView(withId(R.id.btn_s_white_ttbsett)).check(matches(isClickable()));
        onView(withId(R.id.btn_s_magenta_ttbsett)).check(matches(isClickable()));

        onView(withId(R.id.btn_back_ttbsett)).perform(click());
    }

    @Test
    public void testColorTexts() {
        onView(withId(R.id.btn_settings_ttb)).perform(click());

        onView(withId(R.id.btn_b_green_ttbsett)).check(matches(withText("Green")));
        onView(withId(R.id.btn_b_blue_ttbsett)).check(matches(withText("Blue")));
        onView(withId(R.id.btn_b_red_ttbsett)).check(matches(withText("Red")));
        onView(withId(R.id.btn_b_magenta_ttbsett)).check(matches(withText("Magenta")));

        onView(withId(R.id.btn_s_black_ttbsett)).check(matches(withText("Black")));
        onView(withId(R.id.btn_s_grey_ttbsett)).check(matches(withText("Grey")));
        onView(withId(R.id.btn_s_white_ttbsett)).check(matches(withText("White")));
        onView(withId(R.id.btn_s_magenta_ttbsett)).check(matches(withText("Magenta")));

        onView(withId(R.id.btn_back_ttbsett)).perform(click());
    }

    @Test
    public void testBlockColorDisabledAndVisibility() {
        onView(withId(R.id.btn_settings_ttb)).perform(click());

        int correct_counter = 0;

        onView(withId(R.id.btn_b_green_ttbsett)).perform(click());

        Button btn_green = activity_test_rule.getActivity().findViewById(R.id.btn_b_green_ttbsett);
        Button btn_blue = activity_test_rule.getActivity().findViewById(R.id.btn_b_blue_ttbsett);
        Button btn_red = activity_test_rule.getActivity().findViewById(R.id.btn_b_red_ttbsett);
        Button btn_magenta = activity_test_rule.getActivity().findViewById(R.id.btn_b_magenta_ttbsett);

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

        onView(withId(R.id.btn_back_ttbsett)).perform(click());
        assertEquals(8, correct_counter);
    }

    @Test
    public void testBackgroundColorDisabledAndVisibility() {
        onView(withId(R.id.btn_settings_ttb)).perform(click());

        int correct_counter = 0;

        onView(withId(R.id.btn_s_magenta_ttbsett)).perform(click());

        Button btn_black = activity_test_rule.getActivity().findViewById(R.id.btn_s_black_ttbsett);
        Button btn_grey = activity_test_rule.getActivity().findViewById(R.id.btn_s_grey_ttbsett);
        Button btn_white = activity_test_rule.getActivity().findViewById(R.id.btn_s_white_ttbsett);
        Button btn_magenta = activity_test_rule.getActivity().findViewById(R.id.btn_s_magenta_ttbsett);

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

        onView(withId(R.id.btn_back_ttbsett)).perform(click());
        assertEquals(8, correct_counter);
    }

    @Test
    public void testColoredBlocks() {
        onView(withId(R.id.btn_settings_ttb)).perform(click());

        onView(withId(R.id.btn_s_magenta_ttbsett)).perform(click());
        onView(withId(R.id.btn_b_red_ttbsett)).perform(click());

        onView(withId(R.id.btn_ok_ttbsett)).perform(click());
        onView(withId(R.id.btn_play_ttb)).perform(click());

        Button btn_block = activity_test_rule.getActivity().findViewById(R.id.btn_moving_block_ttb);
        ColorDrawable color_block = (ColorDrawable) btn_block.getBackground();
        Button btn_background = activity_test_rule.getActivity().findViewById(R.id.btn_background_ttb);
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

        onView(withId(R.id.btn_s_magenta_ttbsett)).perform(click());
        onView(withId(R.id.btn_b_red_ttbsett)).perform(click());

        onView(withId(R.id.btn_back_ttbsett)).perform(click());
        onView(withId(R.id.btn_play_ttb)).check(matches(isDisplayed()));
    }

    @Test
    public void testTimerTextView() {
        onView(withId(R.id.btn_play_ttb)).perform(click());

        CountDownTimer cdt = this.activity_test_rule.getActivity().cdt_play_time;
        cdt.cancel();

        onView(withId(R.id.textv_timer_ttb)).check(matches(isDisplayed()));
    }

    @Test
    public void testContinueButton() {
        onView(withId(R.id.btn_play_ttb)).perform(click());
        clickBackground();

        int score = Score.getScore(context);
        if (score >= 10) {
            onView(withId(R.id.btn_continue_ttb)).check(matches((isEnabled())));
        } else {
            onView(withId(R.id.btn_continue_ttb)).check(matches(not(isEnabled())));
        }
    }
}