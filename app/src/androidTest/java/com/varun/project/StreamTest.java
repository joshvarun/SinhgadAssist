package com.varun.project;

import android.content.ComponentName;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.anything;

/**
 * Created by User on 27-Apr-17.
 */
@RunWith(AndroidJUnit4.class)
public class StreamTest {
    @Rule
    public IntentsTestRule<MainActivity> StreamTestRule =
            new IntentsTestRule<>(MainActivity.class, true, true);

    @Test
    public void DocumentChecklistTest(){
        Espresso.onData(anything()).inAdapterView(withId(R.id.menuList)).atPosition(1).perform(click());

        intended(hasComponent(new ComponentName(getTargetContext(), StreamSuggestor.class)));

        onView(withId(R.id.q1a1)).perform(click());
        onView(withId(R.id.btn1)).perform(click());

        onView(withId(R.id.q2a2)).perform(click());
        onView(withId(R.id.btn2)).perform(click());

        onView(withId(R.id.q3a2)).perform(click());
        onView(withId(R.id.btn3)).perform(click());

        onView(withId(R.id.q4a4)).perform(click());
        onView(withId(R.id.btn4)).perform(click());

        onView(withId(R.id.q5a1)).perform(click());
        onView(withId(R.id.btn5)).perform(click());

        onView(withId(R.id.q6a3)).perform(click());
        onView(withId(R.id.btn6)).perform(click());

        onView(withId(R.id.q7a4)).perform(click());
        onView(withId(R.id.btn7)).perform(click());

        onView(withId(R.id.q8a2)).perform(click());
        onView(withId(R.id.btn8)).perform(click());

        onView(withId(R.id.q9a1)).perform(click());
        onView(withId(R.id.btn9)).perform(click());

        onView(withId(R.id.q10a3)).perform(click());
        onView(withId(R.id.btn10)).perform(click());

        onView(withId(R.id.q11a2)).perform(click());
        onView(withId(R.id.btn11)).perform(click());

        onView(withId(R.id.q12a4)).perform(click());
        onView(withId(R.id.btn12)).perform(click());

        onView(withId(R.id.q13a1)).perform(click());
        onView(withId(R.id.btn13)).perform(click());

        onView(withId(R.id.q14a2)).perform(click());
        onView(withId(R.id.btn14)).perform(click());

        onView(withId(R.id.q15a2)).perform(click());
        onView(withId(R.id.btn15)).perform(click());

        onView(withId(R.id.q16a4)).perform(click());
        onView(withId(R.id.btn16)).perform(click());

        onView(withId(R.id.q17a1)).perform(click());
        onView(withId(R.id.btn17)).perform(click());

        onView(withId(R.id.q18a1)).perform(click());
        onView(withId(R.id.btn18)).perform(click());

        intended(hasComponent(new ComponentName(getTargetContext(), QuizResult.class)));

    }
}
