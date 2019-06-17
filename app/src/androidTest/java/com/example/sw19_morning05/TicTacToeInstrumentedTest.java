package com.example.sw19_morning05;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.Button;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasTextColor;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;


@RunWith(AndroidJUnit4.class)
public class TicTacToeInstrumentedTest {
    private final Context context = InstrumentationRegistry.getTargetContext();
    @Rule
    public ActivityTestRule<TicTacToeActivity> activity_test_rule = new ActivityTestRule<>(TicTacToeActivity.class);

    @Test
    public void testTextViewsVisible() {
        onView(withId(R.id.textv_header_ttt)).check(matches(isDisplayed()));
        onView(withId(R.id.textv_header_ttt)).check(matches(withText("Tic Tac Toe")));
        onView(withId(R.id.textv_current_player_ttt)).check(matches(isDisplayed()));
    }

    @Test
    public void testFieldbuttonClickable() {
        onView(withId(R.id.btn_field_00_ttt)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_field_00_ttt)).perform(click());
    }

    @Test
    public void testResetbutton() {
        onView(withId(R.id.btn_field_00_ttt)).perform(click());
        onView(withId(R.id.btn_field_01_ttt)).perform(click());
        onView(withId(R.id.btn_field_02_ttt)).perform(click());
        onView(withId(R.id.btn_field_12_ttt)).perform(click());
        onView(withId(R.id.btn_field_10_ttt)).perform(click());
        onView(withId(R.id.btn_field_20_ttt)).perform(click());
        onView(withId(R.id.btn_field_11_ttt)).perform(click());
        onView(withId(R.id.btn_field_22_ttt)).perform(click());
        onView(withId(R.id.btn_field_21_ttt)).perform(click());

        onView(withId(R.id.btn_reset_ttt)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_reset_ttt)).perform(click());
        onView(withId(R.id.textv_current_player_ttt)).check(matches(withText("Player X turn!")));
        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {
                String button_id = "btn_field_" + col + "" + row + "_ttt";
                int resource_id = context.getResources().getIdentifier(
                        button_id, "id", context.getPackageName());
                onView(withId(resource_id)).check(matches(isEnabled()));
                onView(withId(resource_id)).check(matches(withText("")));
            }
        }
    }

    @Test
    public void testNoTextInFields() {
        onView(withId(R.id.btn_field_00_ttt)).check(matches(withText("")));
    }

    @Test
    public void testBoardOnStart() {
        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {

                String button_id = "btn_field_" + col + "" + row + "_ttt";
                int resource_id = context.getResources().getIdentifier(
                        button_id, "id", context.getPackageName());

                onView(withId(resource_id)).check(matches(withText("")));
            }
        }
    }

    @Test
    public void staticTestIfRightSignIsPlacedOnClick() {
        int counter = 0;
        for (int col = 1; col < 3; col++) {
            for (int row = 0; row < 3; row++) {
                String button_id = "btn_field_" + col + "" + row + "_ttt";
                int resource_id = context.getResources().getIdentifier(
                        button_id, "id", context.getPackageName());
                onView(withId(resource_id)).perform(click());
                if ((counter % 2) == 0) {
                    onView(withId(resource_id)).check(matches(withText("X")));
                } else {
                    onView(withId(resource_id)).check(matches(withText("O")));
                }
                counter = counter + 1;

                if (counter == 6) {
                    break;
                }
            }
        }
    }


    @Test
    public void testIfTextViewCorrect() {
        int counter = 0;
        onView(withId(R.id.textv_header_ttt)).check(matches(isDisplayed()));
        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {
                String button_id = "btn_field_" + col + "" + row + "_ttt";
                int resource_id = context.getResources().getIdentifier(
                        button_id, "id", context.getPackageName());
                onView(withId(resource_id)).perform(click());
                if ((counter % 2) == 0) {
                    onView(withId(R.id.textv_current_player_ttt)).check(matches(withText("Player O turn!")));
                } else {
                    onView(withId(R.id.textv_current_player_ttt)).check(matches(withText("Player X turn!")));
                }
                counter = counter + 1;

                if (counter == 4) {
                    break;
                }
            }
        }
    }

    @Test
    public void testIfButtonsAreDisabledAfterClicked() {
        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {
                String button_id = "btn_field_" + col + "" + row + "_ttt";
                int resource_id = context.getResources().getIdentifier(
                        button_id, "id", context.getPackageName());
                onView(withId(resource_id)).perform(click());
            }
        }

        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {
                String button_id = "btn_field_" + col + "" + row + "_ttt";
                int resource_id = context.getResources().getIdentifier(
                        button_id, "id", context.getPackageName());
                onView(withId(resource_id)).check(matches(not(isEnabled())));
            }
        }
    }

    @Test
    public void testNoWinnerYet() {
        onView(withId(R.id.btn_field_00_ttt)).perform(click());
        onView(withId(R.id.btn_field_11_ttt)).perform(click());

        onView(withId(R.id.textv_current_player_ttt)).check(matches(withText("Player X turn!")));
    }

    @Test
    public void testDraw() {
        onView(withId(R.id.btn_field_00_ttt)).perform(click());
        onView(withId(R.id.btn_field_01_ttt)).perform(click());
        onView(withId(R.id.btn_field_02_ttt)).perform(click());
        onView(withId(R.id.btn_field_12_ttt)).perform(click());
        onView(withId(R.id.btn_field_10_ttt)).perform(click());
        onView(withId(R.id.btn_field_20_ttt)).perform(click());
        onView(withId(R.id.btn_field_11_ttt)).perform(click());
        onView(withId(R.id.btn_field_22_ttt)).perform(click());
        onView(withId(R.id.btn_field_21_ttt)).perform(click());

        onView(withId(R.id.textv_current_player_ttt)).check(matches(withText("Draw!")));
    }

    @Test
    public void testPlayer01Winner01() {
        onView(withId(R.id.btn_field_00_ttt)).perform(click());
        onView(withId(R.id.btn_field_10_ttt)).perform(click());
        onView(withId(R.id.btn_field_01_ttt)).perform(click());
        onView(withId(R.id.btn_field_11_ttt)).perform(click());
        onView(withId(R.id.btn_field_02_ttt)).perform(click());

        onView(withId(R.id.textv_current_player_ttt)).check(matches(withText("Player X wins!")));
    }

    @Test
    public void testButtonsDisabledAfterWin() {
        onView(withId(R.id.btn_field_00_ttt)).perform(click());
        onView(withId(R.id.btn_field_10_ttt)).perform(click());
        onView(withId(R.id.btn_field_01_ttt)).perform(click());
        onView(withId(R.id.btn_field_11_ttt)).perform(click());
        onView(withId(R.id.btn_field_02_ttt)).perform(click());

        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {
                String button_id = "btn_field_" + col + "" + row + "_ttt";
                int resource_id = context.getResources().getIdentifier(
                        button_id, "id", context.getPackageName());
                onView(withId(resource_id)).check(matches(not(isEnabled())));
            }
        }
    }

    @Test
    public void testPlayer02Winner01() {
        onView(withId(R.id.btn_field_12_ttt)).perform(click());
        onView(withId(R.id.btn_field_10_ttt)).perform(click());
        onView(withId(R.id.btn_field_11_ttt)).perform(click());
        onView(withId(R.id.btn_field_20_ttt)).perform(click());
        onView(withId(R.id.btn_field_21_ttt)).perform(click());
        onView(withId(R.id.btn_field_00_ttt)).perform(click());

        onView(withId(R.id.textv_current_player_ttt)).check(matches(withText("Player O wins!")));
    }

    @Test
    public void testPlayer01Winner01IncrementPoints() {
        int score = Score.getScore(context);
        int points = 1;

        onView(withId(R.id.btn_field_00_ttt)).perform(click());
        onView(withId(R.id.btn_field_10_ttt)).perform(click());
        onView(withId(R.id.btn_field_01_ttt)).perform(click());
        onView(withId(R.id.btn_field_11_ttt)).perform(click());
        onView(withId(R.id.btn_field_02_ttt)).perform(click());

        Assert.assertEquals((score + points), Score.getScore(context));
    }

    @Test
    public void testPlayer02Winner01DecrementPoints() {
        int score = Score.getScore(context);
        int points = 2;

        onView(withId(R.id.btn_field_12_ttt)).perform(click());
        onView(withId(R.id.btn_field_10_ttt)).perform(click());
        onView(withId(R.id.btn_field_11_ttt)).perform(click());
        onView(withId(R.id.btn_field_20_ttt)).perform(click());
        onView(withId(R.id.btn_field_21_ttt)).perform(click());
        onView(withId(R.id.btn_field_00_ttt)).perform(click());

        Assert.assertEquals((score - points), Score.getScore(context));
    }

    @Test
    public void testButtonBackToWelcomeScreen() {
        onView(withId(R.id.btn_back_ttt)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_back_ttt)).perform(click());
    }

    @Test
    public void testNavigateWelcomeScreen() {
        onView(withId(R.id.textv_header_ttt)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_back_ttt)).perform(click());
        onView(withId(R.id.btn_ttt_m)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_ttt_m)).perform(click());
    }

    @Test
    public void testCheckBoxClickable() {
        onView(withId(R.id.cbox_autoplayer_easy_ttt)).check(matches(isDisplayed()));
        onView(withId(R.id.cbox_autoplayer_easy_ttt)).perform(click());
    }

    @Test
    public void testAutoplayer() {
        onView(withId(R.id.cbox_autoplayer_easy_ttt)).perform(click());
        onView(withId(R.id.btn_field_11_ttt)).perform(click());

        int count_disabled = 0;
        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {
                String button_id = "btn_field_" + col + "" + row + "_ttt";
                int resource_id = context.getResources().getIdentifier(
                        button_id, "id", context.getPackageName());
                Button button = activity_test_rule.getActivity().findViewById(resource_id);

                if (!button.isEnabled()) {
                    count_disabled++;
                }
            }
        }
        Assert.assertEquals(2, count_disabled);
    }

    @Test
    public void testSettingButtonClickable() {
        onView(withId(R.id.btn_settings_ttt)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_settings_ttt)).perform(click());
    }

    @Test
    public void testSettingsMenuVisible() {
        onView(withId(R.id.btn_settings_ttt)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_settings_ttt)).perform(click());

        onView(withId(R.id.textv_title_tttsett)).check(matches(isDisplayed()));
        onView(withId(R.id.textv_sign_tttsett)).check(matches(isDisplayed()));
        onView(withId(R.id.ly_color_tttsett)).check(matches(isDisplayed()));

        onView(withId(R.id.btn_sign_x_tttsett)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_sign_o_tttsett)).check(matches(isDisplayed()));

        onView(withId(R.id.btn_color_01_tttsett)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_color_02_tttsett)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_color_03_tttsett)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_color_04_tttsett)).check(matches(isDisplayed()));
    }

    @Test
    public void testSettingsButtonBehaviourSigns() {
        onView(withId(R.id.btn_settings_ttt)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_settings_ttt)).perform(click());

        onView(withId(R.id.btn_sign_o_tttsett)).check(matches(isEnabled()));
        onView(withId(R.id.btn_sign_x_tttsett)).check(matches(not(isEnabled())));

        onView(withId(R.id.btn_sign_o_tttsett)).perform(click());

        onView(withId(R.id.btn_sign_x_tttsett)).check(matches(isEnabled()));
        onView(withId(R.id.btn_sign_o_tttsett)).check(matches(not(isEnabled())));
    }

    @Test
    public void testSettingsButtonBehaviourColors() {
        onView(withId(R.id.btn_settings_ttt)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_settings_ttt)).perform(click());

        onView(withId(R.id.btn_color_01_tttsett)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_color_02_tttsett)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_color_03_tttsett)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_color_04_tttsett)).check(matches(isDisplayed()));

        onView(withId(R.id.btn_color_02_tttsett)).check(matches(isEnabled()));
        onView(withId(R.id.btn_color_03_tttsett)).check(matches(isEnabled()));
        onView(withId(R.id.btn_color_04_tttsett)).check(matches(isEnabled()));
        onView(withId(R.id.btn_color_01_tttsett)).check(matches(not(isEnabled())));

        onView(withId(R.id.btn_color_03_tttsett)).perform(click());

        onView(withId(R.id.btn_color_02_tttsett)).check(matches(isEnabled()));
        onView(withId(R.id.btn_color_01_tttsett)).check(matches(isEnabled()));
        onView(withId(R.id.btn_color_04_tttsett)).check(matches(isEnabled()));
        onView(withId(R.id.btn_color_03_tttsett)).check(matches(not(isEnabled())));
    }

    @Test
    public void testSettingsBackButton() {
        onView(withId(R.id.btn_settings_ttt)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_settings_ttt)).perform(click());

        onView(withId(R.id.btn_back_tttsett)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_back_tttsett)).perform(click());

        onView(withId(R.id.textv_header_ttt)).check(matches(isDisplayed()));
        onView(withId(R.id.textv_header_ttt)).check(matches(withText("Tic Tac Toe")));
    }

    @Test
    public void testSignAndColorChoice() {
        onView(withId(R.id.btn_settings_ttt)).perform(click());
        onView(withId(R.id.btn_sign_o_tttsett)).perform(click());
        onView(withId(R.id.btn_color_02_tttsett)).perform(click());
        onView(withId(R.id.btn_back_tttsett)).perform(click());

        onView(withId(R.id.btn_field_00_ttt)).perform(click());
        onView(withId(R.id.btn_field_00_ttt)).check(matches(withText("O")));
        onView(withId(R.id.btn_field_00_ttt)).check(matches(hasTextColor(R.color.colorRed)));
    }

    @Test
    public void testIntelligentAPMiddle() {
        onView(withId(R.id.cbox_autoplayer_hard_ttt)).perform(click());
        onView(withId(R.id.btn_field_11_ttt)).perform(click());

        onView(withId(R.id.btn_field_00_ttt)).check(matches(not(isEnabled())));
    }

    @Test
    public void testIntelligentAPCorner() {
        onView(withId(R.id.cbox_autoplayer_hard_ttt)).perform(click());
        onView(withId(R.id.btn_field_00_ttt)).perform(click());

        onView(withId(R.id.btn_field_11_ttt)).check(matches(not(isEnabled())));
    }

    @Test
    public void testIntelligentAPBorder() {
        onView(withId(R.id.cbox_autoplayer_hard_ttt)).perform(click());
        onView(withId(R.id.btn_field_01_ttt)).perform(click());

        onView(withId(R.id.btn_field_11_ttt)).check(matches(not(isEnabled())));
    }

    @Test
    public void testIntelligentAPSecondTurn()
    {
        onView(withId(R.id.cbox_autoplayer_hard_ttt)).perform(click());
        onView(withId(R.id.btn_field_22_ttt)).perform(click());
        onView(withId(R.id.btn_field_02_ttt)).perform(click());

        onView(withId(R.id.btn_field_12_ttt)).check(matches(not(isEnabled())));
    }
}