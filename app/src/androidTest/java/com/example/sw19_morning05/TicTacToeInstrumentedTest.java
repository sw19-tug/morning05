package com.example.sw19_morning05;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Rule;
import android.support.test.rule.ActivityTestRule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.app.PendingIntent.getActivity;
import static android.support.test.espresso.Espresso.onView;
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
        onView(withId(R.id.tv_currentPlayer)).check(matches(isDisplayed()));
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

        onView(withId(R.id.bt_reset)).check(matches(isDisplayed()));
        onView(withId(R.id.bt_reset)).perform(click());
        onView(withId(R.id.tv_currentPlayer)).check(matches(withText("Player X turn!")));
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
                    onView(withId(R.id.tv_currentPlayer)).check(matches(withText("Player O turn!")));
                } else { //player 2
                    onView(withId(R.id.tv_currentPlayer)).check(matches(withText("Player X turn!")));
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

        onView(withId(R.id.tv_currentPlayer)).check(matches(withText("Player X turn!")));
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

        onView(withId(R.id.tv_currentPlayer)).check(matches(withText("Draw!")));
    }

    @Test
    public void testPlayer01Winner01(){
        onView(withId(R.id.bt_field00)).perform(click());
        onView(withId(R.id.bt_field10)).perform(click());
        onView(withId(R.id.bt_field01)).perform(click());
        onView(withId(R.id.bt_field11)).perform(click());
        onView(withId(R.id.bt_field02)).perform(click());

        onView(withId(R.id.tv_currentPlayer)).check(matches(withText("Player X wins!")));
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

        onView(withId(R.id.tv_currentPlayer)).check(matches(withText("Player O wins!")));
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
        onView(withId(R.id.bt_backTicTacToe)).check(matches(isDisplayed()));
        onView(withId(R.id.bt_backTicTacToe)).perform(click());
    }

    @Test
    public void testNavigateWelcomeScreen() {
        onView(withId(R.id.tv_header)).check(matches(isDisplayed()));
        onView(withId(R.id.bt_backTicTacToe)).perform(click());
        onView(withId(R.id.bt_tictactoe)).check(matches(isDisplayed()));
        onView(withId(R.id.bt_tictactoe)).perform(click());
    }

    @Test
    public void testCheckBoxClickable(){
        onView(withId(R.id.cb_autoplayer)).check(matches(isDisplayed()));
        onView(withId(R.id.cb_autoplayer)).perform(click());
    }
    

}
