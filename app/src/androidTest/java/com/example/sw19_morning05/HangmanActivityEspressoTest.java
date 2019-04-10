package com.example.sw19_morning05;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsNot.not;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class HangmanActivityEspressoTest
{

    private final Context context = InstrumentationRegistry.getTargetContext();

    private static String alphabet[] = {"q", "w", "e", "r", "t", "z", "u", "i",
            "o", "p", "a", "s", "d", "f", "g", "h", "j", "k", "l", "y", "x", "c", "v",
            "b", "n", "m"};

    @Rule
    public ActivityTestRule<HangmanActivity> activityTestRule =
            new ActivityTestRule<>(HangmanActivity.class);


    //tests if the header "Hangman" is displayed
    @Test
    public void testIfTitleExists()
    {
        onView(withId(R.id.title)).check(matches(isDisplayed()));
    }

    //tests if all keyboard-buttons are displayed
    @Test
    public void testIfButtonsExist()
    {
        //onView(withId(R.id.button_q)).check(matches(isDisplayed()));
        //....

        for (int i = 0; i < 26; i++) {
            // String resourceID = "button_" + alphabet[i];
            String buttonID = "button_" + alphabet[i];
            int resourceID = context.getResources().getIdentifier(
                    buttonID, "id", context.getPackageName());

            onView(withId(resourceID)).check(matches(isDisplayed()));
        }
    }

    @Test
    public void testButtonPressedGoesDisabledQ()
    {
        onView(withId(R.id.button_q)).perform(click());
        onView(withId(R.id.button_q)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledW()
    {
        onView(withId(R.id.button_w)).perform(click());
        onView(withId(R.id.button_w)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledE()
    {
        onView(withId(R.id.button_e)).perform(click());
        onView(withId(R.id.button_e)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledR()
    {
        onView(withId(R.id.button_r)).perform(click());
        onView(withId(R.id.button_r)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledT()
    {
        onView(withId(R.id.button_t)).perform(click());
        onView(withId(R.id.button_t)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledZ()
    {
        onView(withId(R.id.button_z)).perform(click());
        onView(withId(R.id.button_z)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledU()
    {
        onView(withId(R.id.button_u)).perform(click());
        onView(withId(R.id.button_u)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledI()
    {
        onView(withId(R.id.button_i)).perform(click());
        onView(withId(R.id.button_i)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledO()
    {
        onView(withId(R.id.button_o)).perform(click());
        onView(withId(R.id.button_o)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledP()
    {
        onView(withId(R.id.button_p)).perform(click());
        onView(withId(R.id.button_p)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledA()
    {
        onView(withId(R.id.button_a)).perform(click());
        onView(withId(R.id.button_a)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledS()
    {
        onView(withId(R.id.button_s)).perform(click());
        onView(withId(R.id.button_s)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledD()
    {
        onView(withId(R.id.button_d)).perform(click());
        onView(withId(R.id.button_d)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledF()
    {
        onView(withId(R.id.button_f)).perform(click());
        onView(withId(R.id.button_f)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledG()
    {
        onView(withId(R.id.button_g)).perform(click());
        onView(withId(R.id.button_g)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledH()
    {
        onView(withId(R.id.button_h)).perform(click());
        onView(withId(R.id.button_h)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledJ()
    {
        onView(withId(R.id.button_j)).perform(click());
        onView(withId(R.id.button_j)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledK()
    {
        onView(withId(R.id.button_k)).perform(click());
        onView(withId(R.id.button_k)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledL()
    {
        onView(withId(R.id.button_l)).perform(click());
        onView(withId(R.id.button_l)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledY()
    {
        onView(withId(R.id.button_y)).perform(click());
        onView(withId(R.id.button_y)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledX()
    {
        onView(withId(R.id.button_x)).perform(click());
        onView(withId(R.id.button_x)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledC()
    {
        onView(withId(R.id.button_c)).perform(click());
        onView(withId(R.id.button_c)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledV()
    {
        onView(withId(R.id.button_v)).perform(click());
        onView(withId(R.id.button_v)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledB()
    {
        onView(withId(R.id.button_b)).perform(click());
        onView(withId(R.id.button_b)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledN()
    {
        onView(withId(R.id.button_n)).perform(click());
        onView(withId(R.id.button_n)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledM()
    {
        onView(withId(R.id.button_m)).perform(click());
        onView(withId(R.id.button_m)).check(matches(not(isEnabled())));
    }

    @Test
    public void testIfWordExists()
    {
        onView(withId(R.id.word)).check(matches(isDisplayed()));
    }

    @Test
    public void testWordShown()
    {
        onView(withId(R.id.word)).check(matches(not(withText("word"))));
    }

    @Test
    public void testCheckIfNoUnderlinesAnymore()
    {
        //onView(withId(R.id.button_q)).perform(click());
        //....

        for (int i = 0; i < 26; i++) {
            // String resourceID = "button_" + alphabet[i];
            String buttonID = "button_" + alphabet[i];
            int resourceID = context.getResources().getIdentifier(
                    buttonID, "id", context.getPackageName());

            onView(withId(resourceID)).perform(click());
        }
        onView(withId((R.id.word)))
                .check(matches(not(withText(containsString("_")))));
    }

    @Test
    public void testWinMessage()
    {
        for (int i = 0; i < 26; i++) {
            // String resourceID = "button_" + alphabet[i];
            String buttonID = "button_" + alphabet[i];
            int resourceID = context.getResources().getIdentifier(
                    buttonID, "id", context.getPackageName());

            onView(withId(resourceID)).perform(click());
        }

        onView(withId(R.id.button_reset)).check(matches(isDisplayed()));
        onView(withId(R.id.button_reset)).perform(click());

        for (int i = 0; i < 26; i++) {
            // String resourceID = "button_" + alphabet[i];
            String buttonID = "button_" + alphabet[i];
            int resourceID = context.getResources().getIdentifier(
                    buttonID, "id", context.getPackageName());

            onView(withId(resourceID)).perform(click());
        }

        onView(withId(R.id.button_exit)).check(matches(isDisplayed()));
        onView(withId(R.id.button_exit)).perform(click());
    }


    @Test
    public void testIncrementPointsOnWin(){
        int score = Score.getScore(context);
        int points = 1;

        for (int i = 0; i < 26; i++) {
            String id = "button_" + alphabet[i];
            int resourceID = context.getResources().getIdentifier( id, "id", context.getPackageName());
            onView(withId(resourceID)).perform(click());
        }

        Assert.assertEquals((score + points), Score.getScore(context));
    }

    @Test
    public void testDecrementPoints(){ // 8 wrong guesses
        int score = Score.getScore(context);

        for (int i = 0; i < 8; i++) {
            String id = "button_" + alphabet[i];
            int resourceID = context.getResources().getIdentifier( id, "id", context.getPackageName());
            onView(withId(resourceID)).perform(click());
        }

        Assert.assertEquals((score - 2), Score.getScore(context));
    }
}