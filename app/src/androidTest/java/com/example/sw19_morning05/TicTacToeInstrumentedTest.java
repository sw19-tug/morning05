package com.example.sw19_morning05;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Rule;
import android.support.test.rule.ActivityTestRule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.app.PendingIntent.getActivity;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.action.ViewActions.click;


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
    public void testTextViewVisible() {
        onView(withId(R.id.tv_header)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_header)).check(matches(withText("Tic Tac Toe")));
    }
    @Test
    public void testFieldbuttonClickable(){
        onView(withId(R.id.bt_field00)).check(matches(isDisplayed()));
        onView(withId(R.id.bt_field00)).perform(click());

    }
    @Test
    public void testNoTextInFields(){
       onView(withId(R.id.bt_field00)).check(matches(withText("")));
    }

    @Test
    public void testBoardOnStart(){
        //final Context context = InstrumentationRegistry.getTargetContext();

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
        for(int i = 0; i < 3; i++) {
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
            }
        }
    }
}
