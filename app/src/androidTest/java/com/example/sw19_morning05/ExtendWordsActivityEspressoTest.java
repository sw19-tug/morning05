package com.example.sw19_morning05;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressBack;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsNot.not;

@RunWith(AndroidJUnit4.class)
public class ExtendWordsActivityEspressoTest {

    private final Context context = InstrumentationRegistry.getTargetContext();

    @Rule
    public ActivityTestRule<ExtendWordsActivity> extend_words_activity_test_rule = new ActivityTestRule<>(ExtendWordsActivity.class);

    @Test
    public void testIfTitleExists() {
        onView(withId(R.id.textv_hm_title_extend_words)).check(matches(isDisplayed()));
    }

    @Test
    public void testIfAddButtonShowsDialog() {
        onView(withId(R.id.btn_hm_extend_words_add)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_hm_extend_words_add)).perform(click());
        onView(withText(R.string.str_hm_dialog_title)).check(matches(isDisplayed()));
        onView(withText(R.string.str_cancel)).perform(pressBack());
    }

    @Test
    public void testIfListviewOfWordsisDisplayed() {
        onView(withId(R.id.btn_hm_extend_words_add)).perform(click());
        onView(withText(R.string.str_ok)).perform(pressBack());
        ListView listview_hm_words = extend_words_activity_test_rule.getActivity().findViewById(R.id.listview_hm_words);
        int old_count = listview_hm_words.getAdapter().getCount();
        int new_count = listview_hm_words.getAdapter().getCount();
        Assert.assertEquals(old_count, new_count - 1);
    }
}