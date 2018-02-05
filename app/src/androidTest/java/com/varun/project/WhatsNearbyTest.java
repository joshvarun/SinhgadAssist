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
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

/**
 * Created by User on 27-Apr-17.
 */

@RunWith(AndroidJUnit4.class)
public class WhatsNearbyTest {
    @Rule
    public IntentsTestRule<MainActivity> NearbyTestRule =
            new IntentsTestRule<>(MainActivity.class, true, true);

    @Test
    public void WhatsNearbyTest() {
        onData(anything()).inAdapterView(withId(R.id.menuList)).atPosition(3).perform(click());
        intended(hasComponent(new ComponentName(getTargetContext(), WhatsNearby.class)));
        onView(withId(R.id.spinner)).perform(click());

        onData(allOf(is(instanceOf(String.class)), is("Sinhgad College of Engineering (SCOE)"))).perform(click());

        intended(hasComponent(new ComponentName(getTargetContext(), DisplayCollegeInfo.class)));

        onView(withId(R.id.placements)).perform(click());
        intended(hasComponent(new ComponentName(getTargetContext(), DisplayPlacements.class)));
        pressBack();
    }

}
