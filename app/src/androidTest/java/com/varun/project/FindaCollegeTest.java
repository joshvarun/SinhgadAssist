package com.varun.project;

import android.content.ComponentName;
import android.support.test.espresso.Espresso;
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
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

/**
 * Created by User on 27-Apr-17.
 */
@RunWith(AndroidJUnit4.class)
public class FindaCollegeTest {
    @Rule
    public IntentsTestRule<MainActivity> FindCollegeTestRule =
            new IntentsTestRule<>(MainActivity.class, true, true);
    @Test
    public void FindTest() {
        Espresso.onData(anything()).inAdapterView(withId(R.id.menuList)).atPosition(2).perform(click());

        intended(hasComponent(new ComponentName(getTargetContext(), FindACollege.class)));
        onView(withId(R.id.cet)).perform(typeText("97"),closeSoftKeyboard());

        onView(withId(R.id.spinnerStream)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Computers"))).perform(click());
        onView(withId(R.id.spinnerStream)).check(matches(withSpinnerText(containsString("Computers"))));

        onView(withId(R.id.first)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Sinhgad College of Engineering, Vadgoan"))).perform(click());

        onView(withId(R.id.second)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("RMD Sinhgad School of Engineering, Warje"))).perform(click());

        onView(withId(R.id.third)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Smt. Kashibai Navale College of Engineering, Vadgoan"))).perform(click());

        onView(withId(R.id.four)).perform(scrollTo());
        onView(withId(R.id.four)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Sinhgad Institute of Technology, Lonavala"))).perform(click());

        onView(withId(R.id.five)).perform(scrollTo());
        onView(withId(R.id.five)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("SKN Sinhgad Institute of Technology and Science, Lonavala"))).perform(click());

        onView(withId(R.id.six)).perform(scrollTo());
        onView(withId(R.id.six)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("NBN Sinhgad School of Engineering, Ambegoan"))).perform(click());

        onView(withId(R.id.seven)).perform(scrollTo());
        onView(withId(R.id.seven)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Sinhgad Institute of Technology and Science, Narhe"))).perform(click());

        onView(withId(R.id.eight)).perform(scrollTo());
        onView(withId(R.id.eight)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Sinhgad Academy Of Engineering, Kondhwa"))).perform(click());

        onView(withId(R.id.submit)).perform(scrollTo());
        onView(withId(R.id.submit)).perform(click());

        intended(hasComponent(new ComponentName(getTargetContext(), CollegeResult.class)));
        onView(withId(R.id.finalCollege)).check(matches(withText("RMD Sinhgad School of Engineering, Warje")));
    }

}
