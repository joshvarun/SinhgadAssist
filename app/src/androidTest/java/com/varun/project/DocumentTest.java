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
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.core.IsNot.not;

@RunWith(AndroidJUnit4.class)
public class DocumentTest {

    @Rule
    public IntentsTestRule<MainActivity> AdmissionTestRule =
            new IntentsTestRule<>(MainActivity.class, true, true);

    @Test
    public void DocumentChecklistTest(){
        Espresso.onData(anything()).inAdapterView(withId(R.id.menuList)).atPosition(4).perform(click());

        intended(hasComponent(new ComponentName(getTargetContext(), DocumentChecklist.class)));

        onView(withId(R.id.mahaState)).perform(click());
        onView(withId(R.id.allot)).check(matches(not(isChecked())));
        onView(withId(R.id.ssc)).check(matches(not(isChecked())));
        onView(withId(R.id.hsc)).check(matches(not(isChecked())));
        onView(withId(R.id.leaving)).check(matches(not(isChecked())));
        onView(withId(R.id.proforma)).check(matches(not(isChecked())));
        onView(withId(R.id.jeeScore)).check(matches(not(isChecked())));
        onView(withId(R.id.gapCertificate)).check(matches(not(isChecked())));
        onView(withId(R.id.adhaarCard)).check(matches(not(isChecked())));
        onView(withId(R.id.nationalityCer)).check(matches(not(isChecked())));
        onView(withId(R.id.domicile)).check(matches(not(isChecked())));
        onView(withId(R.id.casteCertificate)).check(matches(not(isChecked())));
        onView(withId(R.id.casteValidity)).check(matches(not(isChecked())));
        onView(withId(R.id.nonCreamyLayer)).check(matches(not(isChecked())));


        onView(withId(R.id.outMahaState)).perform(click());
        onView(withId(R.id.allot)).check(matches(not(isChecked())));
        onView(withId(R.id.ssc)).check(matches(not(isChecked())));
        onView(withId(R.id.hsc)).check(matches(not(isChecked())));
        onView(withId(R.id.leaving)).check(matches(not(isChecked())));
        onView(withId(R.id.proforma)).check(matches(not(isChecked())));
        onView(withId(R.id.jeeScore)).check(matches(not(isChecked())));
        onView(withId(R.id.gapCertificate)).check(matches(not(isChecked())));
        onView(withId(R.id.adhaarCard)).check(matches(not(isChecked())));
        onView(withId(R.id.domicile)).check(matches(not(isChecked())));
    }
    @Test
    public void CheckTestMaha(){
        Espresso.onData(anything()).inAdapterView(withId(R.id.menuList)).atPosition(4).perform(click());

        intended(hasComponent(new ComponentName(getTargetContext(), DocumentChecklist.class)));

        onView(withId(R.id.mahaState)).perform(click());
        onView(withId(R.id.allot)).perform(click());
        onView(withId(R.id.jeeScore)).perform(click());
        onView(withId(R.id.gapCertificate)).perform(click());
        onView(withId(R.id.adhaarCard)).perform(click());
    }
    @Test
    public void CheckTestMahaRestart(){
        Espresso.onData(anything()).inAdapterView(withId(R.id.menuList)).atPosition(4).perform(click());

        intended(hasComponent(new ComponentName(getTargetContext(), DocumentChecklist.class)));

        onView(withId(R.id.mahaState)).perform(click());
        onView(withId(R.id.allot)).check(matches(isChecked()));
        onView(withId(R.id.jeeScore)).check(matches(isChecked()));
        onView(withId(R.id.gapCertificate)).check(matches(isChecked()));
        onView(withId(R.id.adhaarCard)).check(matches(isChecked()));
    }
}
