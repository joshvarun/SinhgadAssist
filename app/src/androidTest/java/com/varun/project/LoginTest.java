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
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class LoginTest {

    @Rule
    public IntentsTestRule<Login> LoginTestRule =
            new IntentsTestRule<>(Login.class, true, true);

    @Test
    public void LoginTest(){
        //Espresso.onView(withId(R.id.signin)).perform(click());
        Espresso.onView(withId(R.id.loginEmail)).perform(typeText("varunjoshi995@gmail.com"),closeSoftKeyboard());
        Espresso.onView(withId(R.id.loginPassword)).perform(typeText("abc123"),closeSoftKeyboard());
        Espresso.onView(withId(R.id.login)).perform(click());
        intended(hasComponent(new ComponentName(getTargetContext(), MainActivity.class)));
    }
}
