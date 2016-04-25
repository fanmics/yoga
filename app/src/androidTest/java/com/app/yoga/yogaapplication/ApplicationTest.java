package com.app.yoga.yogaapplication;

import android.app.Application;
import android.content.Intent;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.LargeTest;

import com.app.yoga.yogaapplication.Activity.LoginMainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.ComponentNameMatchers.hasClassName;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    @Rule
    public final ActivityTestRule<LoginMainActivity> rule =
            new ActivityTestRule<>(LoginMainActivity.class, true, false);

    @Test
    public void testFirstShowLoginMainActivity(){
        Intents.init();
        rule.launchActivity(new Intent());
        intended(hasComponent(LoginMainActivity.class.getName()));
        Intents.release();
    }
}