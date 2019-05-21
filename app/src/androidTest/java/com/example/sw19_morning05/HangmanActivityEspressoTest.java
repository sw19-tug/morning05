package com.example.sw19_morning05;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.TextView;

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

@RunWith(AndroidJUnit4.class)
public class HangmanActivityEspressoTest {

    private final Context context = InstrumentationRegistry.getTargetContext();

    private static String alphabet[] = { "q", "w", "e", "r", "t", "z", "u", "i", "o", "p", "a", "s", "d", "f", "g", "h",
            "j", "k", "l", "y", "x", "c", "v", "b", "n", "m" };

    @Rule
    public ActivityTestRule<HangmanActivity> activityTestRule = new ActivityTestRule<>(HangmanActivity.class);

    @Test
    public void testIfTitleExists() {
        onView(withId(R.id.title)).check(matches(isDisplayed()));
    }

    @Test
    public void testIfButtonsExist() {
        for (int count = 0; count < 26; count++) {
            String button_id = "btn_" + alphabet[count];
            int resource_id = context.getResources().getIdentifier(button_id, "id", context.getPackageName());

            onView(withId(resource_id)).check(matches(isDisplayed()));
        }
    }

    @Test
    public void testButtonPressedGoesDisabledQ() {
        onView(withId(R.id.btn_q)).perform(click());
        onView(withId(R.id.btn_q)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledW() {
        onView(withId(R.id.btn_w)).perform(click());
        onView(withId(R.id.btn_w)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledE() {
        onView(withId(R.id.btn_e)).perform(click());
        onView(withId(R.id.btn_e)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledR() {
        onView(withId(R.id.btn_r)).perform(click());
        onView(withId(R.id.btn_r)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledT() {
        onView(withId(R.id.btn_t)).perform(click());
        onView(withId(R.id.btn_t)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledZ() {
        onView(withId(R.id.btn_z)).perform(click());
        onView(withId(R.id.btn_z)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledU() {
        onView(withId(R.id.btn_u)).perform(click());
        onView(withId(R.id.btn_u)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledI() {
        onView(withId(R.id.btn_i)).perform(click());
        onView(withId(R.id.btn_i)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledO() {
        onView(withId(R.id.btn_o)).perform(click());
        onView(withId(R.id.btn_o)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledP() {
        onView(withId(R.id.btn_p)).perform(click());
        onView(withId(R.id.btn_p)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledA() {
        onView(withId(R.id.btn_a)).perform(click());
        onView(withId(R.id.btn_a)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledS() {
        onView(withId(R.id.btn_s)).perform(click());
        onView(withId(R.id.btn_s)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledD() {
        onView(withId(R.id.btn_d)).perform(click());
        onView(withId(R.id.btn_d)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledF() {
        onView(withId(R.id.btn_f)).perform(click());
        onView(withId(R.id.btn_f)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledG() {
        onView(withId(R.id.btn_g)).perform(click());
        onView(withId(R.id.btn_g)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledH() {
        onView(withId(R.id.btn_h)).perform(click());
        onView(withId(R.id.btn_h)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledJ() {
        onView(withId(R.id.btn_j)).perform(click());
        onView(withId(R.id.btn_j)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledK() {
        onView(withId(R.id.btn_k)).perform(click());
        onView(withId(R.id.btn_k)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledL() {
        onView(withId(R.id.btn_l)).perform(click());
        onView(withId(R.id.btn_l)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledY() {
        onView(withId(R.id.btn_y)).perform(click());
        onView(withId(R.id.btn_y)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledX() {
        onView(withId(R.id.btn_x)).perform(click());
        onView(withId(R.id.btn_x)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledC() {
        onView(withId(R.id.btn_c)).perform(click());
        onView(withId(R.id.btn_c)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledV() {
        onView(withId(R.id.btn_v)).perform(click());
        onView(withId(R.id.btn_v)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledB() {
        onView(withId(R.id.btn_b)).perform(click());
        onView(withId(R.id.btn_b)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledN() {
        onView(withId(R.id.btn_n)).perform(click());
        onView(withId(R.id.btn_n)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledM() {
        onView(withId(R.id.btn_m)).perform(click());
        onView(withId(R.id.btn_m)).check(matches(not(isEnabled())));
    }

    @Test
    public void testIfWordExists() {
        onView(withId(R.id.textv_word_to_guess)).check(matches(isDisplayed()));
    }

    @Test
    public void testWordShown() {
        onView(withId(R.id.textv_word_to_guess)).check(matches(not(withText("word"))));
    }

    @Test
    public void testCheckIfNoUnderlinesAnymore() {

        String right_word = activityTestRule.getActivity().word_to_guess;

        for (int i = 0; i < right_word.length(); i++) {
            String id = "btn_" + right_word.charAt(i);
            id = id.toLowerCase();
            int resourceID = context.getResources().getIdentifier(id, "id", context.getPackageName());

            onView(withId(resourceID)).perform(click());
        }
        onView(withId((R.id.textv_word_to_guess))).check(matches(not(withText(containsString("_")))));
    }

    @Test
    public void testWinMessage() {
        String right_word = activityTestRule.getActivity().word_to_guess;

        for (int i = 0; i < right_word.length(); i++) {
            String id = "btn_" + right_word.charAt(i);
            id = id.toLowerCase();
            int resourceId = context.getResources().getIdentifier(id, "id", context.getPackageName());
            onView(withId(resourceId)).perform(click());
        }

        onView(withId(R.id.btn_reset_hm)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_reset_hm)).perform(click());

        String right_word2 = activityTestRule.getActivity().word_to_guess;
        for (int i = 0; i < right_word2.length(); i++) {
            String id = "btn_" + right_word2.charAt(i);
            id = id.toLowerCase();
            int resourceID = context.getResources().getIdentifier(id, "id", context.getPackageName());
            onView(withId(resourceID)).perform(click());
        }
        onView(withId(R.id.btn_exit)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_exit)).perform(click());
    }

    @Test
    public void testIncrementPointsOnWin() {
        int score = Score.getScore(context);
        int points = 1;

        String right_word = activityTestRule.getActivity().word_to_guess;

        for (int i = 0; i < right_word.length(); i++) {
            String id = "btn_" + right_word.charAt(i);
            id = id.toLowerCase();
            int resourceID = context.getResources().getIdentifier(id, "id", context.getPackageName());
            onView(withId(resourceID)).perform(click());
        }
        Assert.assertEquals((score + points), Score.getScore(context));
    }

    @Test
    public void testDecrementPoints() {
        int want = Score.getScore(context) - 2;

        String right_word = activityTestRule.getActivity().word_to_guess;

        for (int i = 0, j = 0; i < 8; i++, j++) {
            if (right_word.contains(alphabet[j].toUpperCase())) {
                i--;
                continue;
            }
            String id = "btn_" + alphabet[j];
            int resourceID = context.getResources().getIdentifier(id, "id", context.getPackageName());
            onView(withId(resourceID)).perform(click());
        }

        int have = Score.getScore(context);
        Assert.assertEquals(want, have);
    }

    @Test
    public void getHint() {
        int score = Score.getScore(context);
        TextView title = activityTestRule.getActivity().findViewById(R.id.textv_word_to_guess);
        String actual_word = title.getText().toString();
        onView(withId(R.id.btn_hint_hm)).perform(click());
        TextView new_title = activityTestRule.getActivity().findViewById(R.id.textv_word_to_guess);
        String new_word = new_title.getText().toString();
        Assert.assertNotEquals(actual_word, new_word);
        Assert.assertEquals((score - 3), Score.getScore(context));
    }
}