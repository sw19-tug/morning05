package com.example.sw19_morning05;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.ListView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressBack;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.StringEndsWith.endsWith;

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
        int count = listview_hm_words.getAdapter().getCount();
        Assert.assertTrue(count > 0);
    }

    @Test
    public void testIfListviewOfWordsisUpdatedAfterAdding() {
        ListView listview_hm_words = extend_words_activity_test_rule.getActivity().findViewById(R.id.listview_hm_words);
        int old_count = listview_hm_words.getAdapter().getCount();

        onView(withId(R.id.btn_hm_extend_words_add)).perform(click());
        onView(allOf(withClassName(endsWith("EditText")))).perform(replaceText("SOMETESTY"));
        onView(withId(android.R.id.button1)).perform(click());

        int new_count = listview_hm_words.getAdapter().getCount();
        Assert.assertNotEquals(old_count, new_count);
    }

    @Test
    public void testShouldNotAddEmptyWord() {
        ListView listview_hm_words = extend_words_activity_test_rule.getActivity().findViewById(R.id.listview_hm_words);
        int old_count = listview_hm_words.getAdapter().getCount();
        onView(withId(R.id.btn_hm_extend_words_add)).perform(click());
        onView(withId(android.R.id.button1)).perform(click());
        int new_count = listview_hm_words.getAdapter().getCount();
        Assert.assertEquals(old_count, new_count);
    }

    @Test
    public void testShouldNotAddInvalidCharacters() {
        ListView listview_hm_words = extend_words_activity_test_rule.getActivity().findViewById(R.id.listview_hm_words);
        int old_count = listview_hm_words.getAdapter().getCount();
        onView(withId(R.id.btn_hm_extend_words_add)).perform(click());
        onView(allOf(withClassName(endsWith("EditText")))).perform(replaceText("Should fail!"));
        onView(withId(android.R.id.button1)).perform(click());
        int new_count = listview_hm_words.getAdapter().getCount();
        Assert.assertEquals(old_count, new_count);
    }

    @Test
    public void testIfListviewOfWordsisUpdatedAfterDeleting() {
        ListView listview_hm_words = extend_words_activity_test_rule.getActivity().findViewById(R.id.listview_hm_words);

        onView(withId(R.id.btn_hm_extend_words_add)).perform(click());
        onView(allOf(withClassName(endsWith("EditText")))).perform(replaceText("SOMETESTY"));
        onView(withId(android.R.id.button1)).perform(click());

        int old_count = listview_hm_words.getAdapter().getCount();

        onData(anything()).inAdapterView(withId(R.id.listview_hm_words))
                .atPosition(old_count - 1)
                .onChildView(withId(R.id.imagev_hm_word))
                .perform(click());

        int new_count = listview_hm_words.getAdapter().getCount();
        Assert.assertNotEquals(old_count, new_count);
    }

    public static Matcher<View> withIndex(final Matcher<View> matcher, final int index) {
        return new TypeSafeMatcher<View>() {
            int currentIndex = 0;

            @Override
            public void describeTo(Description description) {
                description.appendText("with index: ");
                description.appendValue(index);
                matcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                return matcher.matches(view) && currentIndex++ == index;
            }
        };
    }
}
