package com.varun.project;

import android.content.ComponentName;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.anything;

@RunWith(AndroidJUnit4.class)
public class AdmissionInfoTest {

    @Rule
    public IntentsTestRule<MainActivity> AdmissionTestRule =
            new IntentsTestRule<>(MainActivity.class, true, true);

    @Test
    public void AdmissionInfoTest(){
        Espresso.onData(anything()).inAdapterView(withId(R.id.menuList)).atPosition(0).perform(click());

        intended(hasComponent(new ComponentName(getTargetContext(), AdmissionInfo.class)));

        Espresso.onView(withId(R.id.eligibility_contents)).check(matches(isClickable()));
        Espresso.onView(withId(R.id.exam_contents)).check(matches(isClickable()));
        Espresso.onView(withId(R.id.reservation_contents)).check(matches(isClickable()));
    }
}
