package com.varun.project;


import android.content.ComponentName;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class RegisterTest {

    @Rule
    public IntentsTestRule<Register> ResgisterTestRule =
            new IntentsTestRule<>(Register.class, true, true);

    @Test
    public void registerTest() {
        Espresso.onView(withId(R.id.RegEmail)).perform(typeText("varunjoshi995@gmail.com"),closeSoftKeyboard());
        Espresso.onView(withId(R.id.RegPassword)).perform(typeText("abc123"),closeSoftKeyboard());

        Espresso.onView(withId(R.id.ConfirmPassword)).perform(typeText("abc123"),closeSoftKeyboard());

        Espresso.onView(withId(R.id.register)).perform(click());

        intended(hasComponent(new ComponentName(getTargetContext(), MainActivity.class)));

        openActionBarOverflowOrOptionsMenu(getTargetContext());
        Espresso.onView(withText("Sign Out")).perform(click());
    }

}
