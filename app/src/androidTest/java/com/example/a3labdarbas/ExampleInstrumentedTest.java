package com.example.a3labdarbas;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.a3labdarbas", appContext.getPackageName());
    }

    @Rule
    public ExampleInstrumentedTest<MainActivity> activityRule = new ExampleInstrumentedTest<>(MainActivity.class);

    @Test
    public void testButtonClicks() {
        Espresso.onView(ViewMatchers.withId(R.id.n1)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.n2)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.plus)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.n3)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.result)).perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.calculatorScreen))
                .check(ViewAssertions.matches(ViewMatchers.withText("15")));
    }
}