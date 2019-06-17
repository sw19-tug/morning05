package com.example.sw19_morning05;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.ImageView;
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
        onView(withId(R.id.textv_title_hm)).check(matches(isDisplayed()));
    }

    @Test
    public void testIfButtonsExist() {
        for (int count = 0; count < 26; count++) {
            String button_id = "btn_" + alphabet[count] + "_hm";
            int resource_id = context.getResources().getIdentifier(button_id, "id", context.getPackageName());

            onView(withId(resource_id)).check(matches(isDisplayed()));
        }
    }

    @Test
    public void testIfStartImageIsDisplay() {
        onView(withId(R.id.image_hang_hm)).check(matches(isDisplayed()));
        ImageView image = activityTestRule.getActivity().findViewById(R.id.image_hang_hm);
        Assert.assertNotNull(image.getDrawable());
    }

    @Test
    public void testButtonPressedGoesDisabledQWERTZ() {
        onView(withId(R.id.btn_q_hm)).perform(click());
        onView(withId(R.id.btn_q_hm)).check(matches(not(isEnabled())));
        onView(withId(R.id.btn_w_hm)).perform(click());
        onView(withId(R.id.btn_w_hm)).check(matches(not(isEnabled())));
        onView(withId(R.id.btn_e_hm)).perform(click());
        onView(withId(R.id.btn_e_hm)).check(matches(not(isEnabled())));
        onView(withId(R.id.btn_r_hm)).perform(click());
        onView(withId(R.id.btn_r_hm)).check(matches(not(isEnabled())));
        onView(withId(R.id.btn_t_hm)).perform(click());
        onView(withId(R.id.btn_t_hm)).check(matches(not(isEnabled())));
        onView(withId(R.id.btn_z_hm)).perform(click());
        onView(withId(R.id.btn_z_hm)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledUIOPASD() {
        onView(withId(R.id.btn_u_hm)).perform(click());
        onView(withId(R.id.btn_u_hm)).check(matches(not(isEnabled())));
        onView(withId(R.id.btn_i_hm)).perform(click());
        onView(withId(R.id.btn_i_hm)).check(matches(not(isEnabled())));
        onView(withId(R.id.btn_o_hm)).perform(click());
        onView(withId(R.id.btn_o_hm)).check(matches(not(isEnabled())));
        onView(withId(R.id.btn_p_hm)).perform(click());
        onView(withId(R.id.btn_p_hm)).check(matches(not(isEnabled())));
        onView(withId(R.id.btn_a_hm)).perform(click());
        onView(withId(R.id.btn_a_hm)).check(matches(not(isEnabled())));
        onView(withId(R.id.btn_s_hm)).perform(click());
        onView(withId(R.id.btn_s_hm)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledDFGHJK() {
        onView(withId(R.id.btn_d_hm)).perform(click());
        onView(withId(R.id.btn_d_hm)).check(matches(not(isEnabled())));
        onView(withId(R.id.btn_f_hm)).perform(click());
        onView(withId(R.id.btn_f_hm)).check(matches(not(isEnabled())));
        onView(withId(R.id.btn_g_hm)).perform(click());
        onView(withId(R.id.btn_g_hm)).check(matches(not(isEnabled())));
        onView(withId(R.id.btn_h_hm)).perform(click());
        onView(withId(R.id.btn_h_hm)).check(matches(not(isEnabled())));
        onView(withId(R.id.btn_j_hm)).perform(click());
        onView(withId(R.id.btn_j_hm)).check(matches(not(isEnabled())));
        onView(withId(R.id.btn_k_hm)).perform(click());
        onView(withId(R.id.btn_k_hm)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledLYXCVB() {
        onView(withId(R.id.btn_l_hm)).perform(click());
        onView(withId(R.id.btn_l_hm)).check(matches(not(isEnabled())));
        onView(withId(R.id.btn_y_hm)).perform(click());
        onView(withId(R.id.btn_y_hm)).check(matches(not(isEnabled())));
        onView(withId(R.id.btn_x_hm)).perform(click());
        onView(withId(R.id.btn_x_hm)).check(matches(not(isEnabled())));
        onView(withId(R.id.btn_c_hm)).perform(click());
        onView(withId(R.id.btn_c_hm)).check(matches(not(isEnabled())));
        onView(withId(R.id.btn_v_hm)).perform(click());
        onView(withId(R.id.btn_v_hm)).check(matches(not(isEnabled())));
        onView(withId(R.id.btn_b_hm)).perform(click());
        onView(withId(R.id.btn_b_hm)).check(matches(not(isEnabled())));
    }

    @Test
    public void testButtonPressedGoesDisabledNM() {
        onView(withId(R.id.btn_n_hm)).perform(click());
        onView(withId(R.id.btn_n_hm)).check(matches(not(isEnabled())));
        onView(withId(R.id.btn_m_hm)).perform(click());
        onView(withId(R.id.btn_m_hm)).check(matches(not(isEnabled())));
    }

    @Test
    public void testIfWordExists() {
        onView(withId(R.id.textv_word_to_guess_hm)).check(matches(isDisplayed()));
    }

    @Test
    public void testWordShown() {
        onView(withId(R.id.textv_word_to_guess_hm)).check(matches(not(withText("word"))));
    }

    @Test
    public void testCheckIfNoUnderlinesAnymore() {

        String right_word = activityTestRule.getActivity().word_to_guess;

        for (int i = 0; i < right_word.length(); i++) {
            String id = "btn_" + right_word.charAt(i) + "_hm";
            id = id.toLowerCase();
            int resourceID = context.getResources().getIdentifier(id, "id", context.getPackageName());

            onView(withId(resourceID)).perform(click());
        }
        onView(withId((R.id.textv_word_to_guess_hm))).check(matches(not(withText(containsString("_")))));
    }

    @Test
    public void testWinMessage() {
        String right_word = activityTestRule.getActivity().word_to_guess;

        for (int i = 0; i < right_word.length(); i++) {
            String id = "btn_" + right_word.charAt(i) + "_hm";
            id = id.toLowerCase();
            int resourceId = context.getResources().getIdentifier(id, "id", context.getPackageName());
            onView(withId(resourceId)).perform(click());
        }

        onView(withId(R.id.btn_reset_hm)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_reset_hm)).perform(click());

        String right_word2 = activityTestRule.getActivity().word_to_guess;
        for (int i = 0; i < right_word2.length(); i++) {
            String id = "btn_" + right_word2.charAt(i) + "_hm";
            id = id.toLowerCase();
            int resourceID = context.getResources().getIdentifier(id, "id", context.getPackageName());
            onView(withId(resourceID)).perform(click());
        }
        onView(withId(R.id.btn_exit_hm)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_exit_hm)).perform(click());
    }

    @Test
    public void testLoseMessage() {
        String right_word = activityTestRule.getActivity().word_to_guess;

        for (int i = 0, j = 0; i < 8; i++, j++) {
            if (right_word.contains(alphabet[j].toUpperCase())) {
                i--;
                continue;
            }
            String id = "btn_" + alphabet[j] + "_hm";
            int resourceID = context.getResources().getIdentifier(id, "id", context.getPackageName());
            onView(withId(resourceID)).perform(click());
        }

        onView(withId(R.id.btn_reset_hm)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_exit_hm)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_exit_hm)).perform(click());
    }


    @Test
    public void testIncrementPointsOnWin() {
        int score = Score.getScore(context);
        int points = 1;

        String right_word = activityTestRule.getActivity().word_to_guess;

        for (int i = 0; i < right_word.length(); i++) {
            String id = "btn_" + right_word.charAt(i) + "_hm";
            id = id.toLowerCase();
            int resourceID = context.getResources().getIdentifier(id, "id", context.getPackageName());
            onView(withId(resourceID)).perform(click());
        }
        Assert.assertEquals((score + points), Score.getScore(context));
    }

    @Test
    public void testShouldShowNextImageAfterWrongGuess() {
        ImageView image = activityTestRule.getActivity().findViewById(R.id.image_hang_hm);
        CharSequence contentPrevious = image.getContentDescription();
        String right_word = activityTestRule.getActivity().word_to_guess;

        for (int i = 0, j = 0; i < 8; i++, j++) {
            if (right_word.contains(alphabet[j].toUpperCase())) {
                i--;
                continue;
            }
            String id = "btn_" + alphabet[j] + "_hm";
            int resourceID = context.getResources().getIdentifier(id, "id", context.getPackageName());
            onView(withId(resourceID)).perform(click());
            break;
        }

        onView(withId(R.id.image_hang_hm)).check(matches(isDisplayed()));
        ImageView imageNext = activityTestRule.getActivity().findViewById(R.id.image_hang_hm);
        Assert.assertNotEquals(contentPrevious, imageNext.getContentDescription());
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
            String id = "btn_" + alphabet[j] + "_hm";
            int resourceID = context.getResources().getIdentifier(id, "id", context.getPackageName());
            onView(withId(resourceID)).perform(click());
        }

        int have = Score.getScore(context);
        Assert.assertEquals(want, have);
    }

    @Test
    public void getHint() {
        int score = Score.getScore(context);
        TextView title = activityTestRule.getActivity().findViewById(R.id.textv_word_to_guess_hm);
        String actual_word = title.getText().toString();
        onView(withId(R.id.btn_hint_hm)).perform(click());
        TextView new_title = activityTestRule.getActivity().findViewById(R.id.textv_word_to_guess_hm);
        String new_word = new_title.getText().toString();
        Assert.assertNotEquals(actual_word, new_word);
        Assert.assertEquals((score - 3), Score.getScore(context));
    }

    @Test
    public void testNavigateExtendWords() {
        onView(withId(R.id.btn_hm_extend_words)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_hm_extend_words)).perform(click());
        onView(withId(R.id.textv_title_hm_ew)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_back_hm_ew)).perform(click());
    }
}