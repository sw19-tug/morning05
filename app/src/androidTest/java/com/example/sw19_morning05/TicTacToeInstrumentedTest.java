package com.example.sw19_morning05;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Rule;
import android.support.test.rule.ActivityTestRule;
import android.widget.Button;

import org.junit.Test;
import org.junit.runner.RunWith;

import static android.app.PendingIntent.getActivity;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.hasTextColor;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.action.ViewActions.click;
import static org.hamcrest.Matchers.not;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class TicTacToeInstrumentedTest {
    final Context context = InstrumentationRegistry.getTargetContext();
    @Rule
    public ActivityTestRule<TicTacToeActivity> activityTestRule = new ActivityTestRule<>(TicTacToeActivity.class);

    @Test
    public void testTextViewsVisible() {
        onView(withId(R.id.tv_header)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_header)).check(matches(withText("Tic Tac Toe")));
        onView(withId(R.id.textv_current_player)).check(matches(isDisplayed()));
    }
    @Test
    public void testFieldbuttonClickable(){
        onView(withId(R.id.bt_field00)).check(matches(isDisplayed()));
        onView(withId(R.id.bt_field00)).perform(click());
    }
    @Test
    public void testResetbutton(){
        onView(withId(R.id.bt_field00)).perform(click());
        onView(withId(R.id.bt_field01)).perform(click());
        onView(withId(R.id.bt_field02)).perform(click());
        onView(withId(R.id.bt_field12)).perform(click());
        onView(withId(R.id.bt_field10)).perform(click());
        onView(withId(R.id.bt_field20)).perform(click());
        onView(withId(R.id.bt_field11)).perform(click());
        onView(withId(R.id.bt_field22)).perform(click());
        onView(withId(R.id.bt_field21)).perform(click());

        onView(withId(R.id.btn_reset_ttt)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_reset_ttt)).perform(click());
        onView(withId(R.id.textv_current_player)).check(matches(withText("Player X turn!")));
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonID = "bt_field" + i + "" + j;
                int resourceID = context.getResources().getIdentifier(
                        buttonID, "id", context.getPackageName());
                onView(withId(resourceID)).check(matches(isEnabled()));
                onView(withId(resourceID)).check(matches(withText("")));
            }
        }
    }
    @Test
    public void testNoTextInFields(){
       onView(withId(R.id.bt_field00)).check(matches(withText("")));
    }

    @Test
    public void testBoardOnStart(){
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++){

               String buttonID = "bt_field" + i + "" + j;
                int resourceID = context.getResources().getIdentifier(
                        buttonID, "id", context.getPackageName());

                onView(withId(resourceID)).check(matches(withText("")));
            }
    }

    @Test
    public void staticTestIfRightSignIsPlacedOnClick(){
        int counter = 0;
        for(int i = 1; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonID = "bt_field" + i + "" + j;
                int resourceID = context.getResources().getIdentifier(
                        buttonID, "id", context.getPackageName());
                onView(withId(resourceID)).perform(click());
                if ((counter % 2) == 0) { //player 1
                    onView(withId(resourceID)).check(matches(withText("X")));
                } else { //player 2
                    onView(withId(resourceID)).check(matches(withText("O")));
                }
                counter = counter + 1;

                if(counter == 6)
                {
                    break;
                }


            }
        }
    }


    @Test
    public void testIfTextViewCorrect(){
        int counter = 0;
        onView(withId(R.id.tv_header)).check(matches(isDisplayed()));
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonID = "bt_field" + i + "" + j;
                int resourceID = context.getResources().getIdentifier(
                        buttonID, "id", context.getPackageName());
                onView(withId(resourceID)).perform(click());
                if ((counter % 2) == 0) { //player 1
                    onView(withId(R.id.textv_current_player)).check(matches(withText("Player O turn!")));
                } else { //player 2
                    onView(withId(R.id.textv_current_player)).check(matches(withText("Player X turn!")));
                }
                counter = counter + 1;

                if(counter == 4)
                {
                    break;
                }
            }
        }
    }

    @Test
    public void testIfButtonsAreDisabledAfterClicked(){
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonID = "bt_field" + i + "" + j;
                int resourceID = context.getResources().getIdentifier(
                        buttonID, "id", context.getPackageName());
                onView(withId(resourceID)).perform(click());
            }
        }

        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonID = "bt_field" + i + "" + j;
                int resourceID = context.getResources().getIdentifier(
                        buttonID, "id", context.getPackageName());
                onView(withId(resourceID)).check(matches(not(isEnabled())));
            }
        }
    }

    @Test
    public void testNoWinnerYet(){
        onView(withId(R.id.bt_field00)).perform(click());
        onView(withId(R.id.bt_field11)).perform(click());

        onView(withId(R.id.textv_current_player)).check(matches(withText("Player X turn!")));
    }

    @Test
    public void testDraw(){
        onView(withId(R.id.bt_field00)).perform(click());
        onView(withId(R.id.bt_field01)).perform(click());
        onView(withId(R.id.bt_field02)).perform(click());
        onView(withId(R.id.bt_field12)).perform(click());
        onView(withId(R.id.bt_field10)).perform(click());
        onView(withId(R.id.bt_field20)).perform(click());
        onView(withId(R.id.bt_field11)).perform(click());
        onView(withId(R.id.bt_field22)).perform(click());
        onView(withId(R.id.bt_field21)).perform(click());

        onView(withId(R.id.textv_current_player)).check(matches(withText("Draw!")));
    }

    @Test
    public void testPlayer01Winner01(){
        onView(withId(R.id.bt_field00)).perform(click());
        onView(withId(R.id.bt_field10)).perform(click());
        onView(withId(R.id.bt_field01)).perform(click());
        onView(withId(R.id.bt_field11)).perform(click());
        onView(withId(R.id.bt_field02)).perform(click());

        onView(withId(R.id.textv_current_player)).check(matches(withText("Player X wins!")));
    }

    @Test
    public void testButtonsDisabledAfterWin(){
        onView(withId(R.id.bt_field00)).perform(click());
        onView(withId(R.id.bt_field10)).perform(click());
        onView(withId(R.id.bt_field01)).perform(click());
        onView(withId(R.id.bt_field11)).perform(click());
        onView(withId(R.id.bt_field02)).perform(click());

        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonID = "bt_field" + i + "" + j;
                int resourceID = context.getResources().getIdentifier(
                        buttonID, "id", context.getPackageName());
                onView(withId(resourceID)).check(matches(not(isEnabled())));
            }
        }
    }

    @Test
    public void testPlayer02Winner01(){
        onView(withId(R.id.bt_field12)).perform(click());
        onView(withId(R.id.bt_field10)).perform(click());
        onView(withId(R.id.bt_field11)).perform(click());
        onView(withId(R.id.bt_field20)).perform(click());
        onView(withId(R.id.bt_field21)).perform(click());
        onView(withId(R.id.bt_field00)).perform(click());

        onView(withId(R.id.textv_current_player)).check(matches(withText("Player O wins!")));
    }

    @Test
    public void testPlayer01Winner01IncrementPoints(){
        int score = Score.getScore(context);
        int points = 1;

        onView(withId(R.id.bt_field00)).perform(click());
        onView(withId(R.id.bt_field10)).perform(click());
        onView(withId(R.id.bt_field01)).perform(click());
        onView(withId(R.id.bt_field11)).perform(click());
        onView(withId(R.id.bt_field02)).perform(click());

        Assert.assertEquals((score + points), Score.getScore(context));
    }

    @Test
    public void testPlayer02Winner01DecrementPoints(){
        int score = Score.getScore(context);
        int points = 2;

        onView(withId(R.id.bt_field12)).perform(click());
        onView(withId(R.id.bt_field10)).perform(click());
        onView(withId(R.id.bt_field11)).perform(click());
        onView(withId(R.id.bt_field20)).perform(click());
        onView(withId(R.id.bt_field21)).perform(click());
        onView(withId(R.id.bt_field00)).perform(click());

        Assert.assertEquals((score - points), Score.getScore(context));
    }

    @Test
    public void testButtonBackToWelcomeScreen() {
        onView(withId(R.id.btn_back_ttt)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_back_ttt)).perform(click());
    }

    @Test
    public void testNavigateWelcomeScreen() {
        onView(withId(R.id.tv_header)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_back_ttt)).perform(click());
        onView(withId(R.id.bt_tictactoe)).check(matches(isDisplayed()));
        onView(withId(R.id.bt_tictactoe)).perform(click());
    }

    @Test
    public void testCheckBoxClickable(){
        onView(withId(R.id.cbox_autoplayer_ttt)).check(matches(isDisplayed()));
        onView(withId(R.id.cbox_autoplayer_ttt)).perform(click());
    }

    @Test
    public void testAutoplayer(){
        onView(withId(R.id.cbox_autoplayer_ttt)).perform(click());
        onView(withId(R.id.bt_field11)).perform(click());

        int countDisabled = 0;
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonID = "bt_field" + i + "" + j;
                int resourceID = context.getResources().getIdentifier(
                        buttonID, "id", context.getPackageName());
                Button button = activityTestRule.getActivity().findViewById(resourceID);

                if(!button.isEnabled())
                {
                    countDisabled++;
                }
            }
        }

        Assert.assertEquals(2, countDisabled);
    }

    @Test
    public void testSettingButtonClickable(){
        onView(withId(R.id.btn_settings_ttt)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_settings_ttt)).perform(click());
    }

    @Test
    public void testSettingsMenuVisible(){
        onView(withId(R.id.btn_settings_ttt)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_settings_ttt)).perform(click());

        onView(withId(R.id.set_title)).check(matches(isDisplayed()));
        onView(withId(R.id.set_sign)).check(matches(isDisplayed()));
        onView(withId(R.id.set_color)).check(matches(isDisplayed()));

        onView(withId(R.id.btn_sign_x_ttt)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_sign_o_ttt)).check(matches(isDisplayed()));

        onView(withId(R.id.btn_color_01_ttt)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_color_02_ttt)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_color_03_ttt)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_color_04_ttt)).check(matches(isDisplayed()));
    }

    @Test
    public void testSettingsButtonBehaviourSigns(){
        onView(withId(R.id.btn_settings_ttt)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_settings_ttt)).perform(click());

        onView(withId(R.id.btn_sign_o_ttt)).check(matches(isEnabled()));
        onView(withId(R.id.btn_sign_x_ttt)).check(matches(not(isEnabled())));

        onView(withId(R.id.btn_sign_o_ttt)).perform(click());

        onView(withId(R.id.btn_sign_x_ttt)).check(matches(isEnabled()));
        onView(withId(R.id.btn_sign_o_ttt)).check(matches(not(isEnabled())));
    }


    @Test
    public void testSettingsButtonBehaviourColors(){
        onView(withId(R.id.btn_settings_ttt)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_settings_ttt)).perform(click());

        onView(withId(R.id.btn_color_01_ttt)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_color_02_ttt)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_color_03_ttt)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_color_04_ttt)).check(matches(isDisplayed()));

        onView(withId(R.id.btn_color_02_ttt)).check(matches(isEnabled()));
        onView(withId(R.id.btn_color_03_ttt)).check(matches(isEnabled()));
        onView(withId(R.id.btn_color_04_ttt)).check(matches(isEnabled()));
        onView(withId(R.id.btn_color_01_ttt)).check(matches(not(isEnabled())));

        onView(withId(R.id.btn_color_03_ttt)).perform(click());

        onView(withId(R.id.btn_color_02_ttt)).check(matches(isEnabled()));
        onView(withId(R.id.btn_color_01_ttt)).check(matches(isEnabled()));
        onView(withId(R.id.btn_color_04_ttt)).check(matches(isEnabled()));
        onView(withId(R.id.btn_color_03_ttt)).check(matches(not(isEnabled())));
    }

    @Test
    public void  testSettingsBackButton()
    {
        onView(withId(R.id.btn_settings_ttt)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_settings_ttt)).perform(click());

        onView(withId(R.id.btn_settings_back_ttt)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_settings_back_ttt)).perform(click());

        onView(withId(R.id.tv_header)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_header)).check(matches(withText("Tic Tac Toe")));
    }

    @Test
    public void  testSignAndColorChoice()
    {
        onView(withId(R.id.btn_settings_ttt)).perform(click());
        onView(withId(R.id.btn_sign_o_ttt)).perform(click());
        onView(withId(R.id.btn_color_02_ttt)).perform(click());
        onView(withId(R.id.btn_settings_back_ttt)).perform(click());

        onView(withId(R.id.bt_field00)).perform(click());
        onView(withId(R.id.bt_field00)).check(matches(withText("O")));
        onView(withId(R.id.bt_field00)).check(matches(hasTextColor(R.color.colorRed)));
    }
}