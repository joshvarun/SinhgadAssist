package com.varun.project;

import android.content.ComponentName;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

/**
 * Created by User on 27-Apr-17.
 */
@RunWith(AndroidJUnit4.class)
public class ProfileTest {
    @Rule
    public IntentsTestRule<MainActivity> ProfileTestRule =
            new IntentsTestRule<>(MainActivity.class, true, true);

    @Test
    public void ProfileEditTest() {
        onData(anything()).inAdapterView(withId(R.id.menuList)).atPosition(5).perform(click());

        intended(hasComponent(new ComponentName(getTargetContext(), Profile.class)));

        onView(withId(R.id.profileName)).perform(typeText("Varun Joshi"),closeSoftKeyboard());

        onView(withId(R.id.sexMale)).perform(click());

        onView(withId(R.id.profileHSC)).perform(typeText("66.50"),closeSoftKeyboard());

        onView(withId(R.id.profileCET)).perform(typeText("97"),closeSoftKeyboard());

        onView(withId(R.id.spinnerProfile)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Open"))).perform(click());
        onView(withId(R.id.spinnerProfile)).check(matches(withSpinnerText(containsString("Open"))));

        onView(withId(R.id.submit)).perform(click());

        intended(hasComponent(new ComponentName(getTargetContext(), MainActivity.class)));
    }
}