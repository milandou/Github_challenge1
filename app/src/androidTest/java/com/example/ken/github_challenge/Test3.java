package com.example.ken.github_challenge;

import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressBack;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by Ken on 29/03/2018.
 */

public class Test3 {
    @Rule
    public ActivityTestRule<LoginActivity> activityActivityTestRule=new ActivityTestRule<LoginActivity>(LoginActivity.class);
    private LoginActivity mainActivity=null;

    @Before
    public void setUp() throws Exception {
        mainActivity=activityActivityTestRule.getActivity();
    }

    @Test
    public  void testActivity(){

        assertNotNull(mainActivity.findViewById(R.id.email));
        assertNotNull(mainActivity.findViewById(R.id.password));
        assertNotNull(mainActivity.findViewById(R.id.btn_connect));
        ////////////////////////////////////////////////////////////////////////////////////////////

        onView(withId(R.id.email)).perform(typeText("kibouanga7gmail.com")).toString();

        onView(withId(R.id.password)).perform(typeText("ken_hudene"));

        onView(withId(R.id.btn_connect)).perform(click());

        onView(withId(R.id.email)).perform(clearText());

        pressBack();
    }

    @After
    public void tearDown() throws Exception {
        mainActivity=null;
    }

}


