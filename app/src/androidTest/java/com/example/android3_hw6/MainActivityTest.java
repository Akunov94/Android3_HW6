package com.example.android3_hw6;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.example.android3_hw6.ui.MainActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityScenarioRule rule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void simpleTest() {
        onView(withId(R.id.btn_add)).perform(click());
        onView(withId(R.id.btn_minus)).check(matches(not(isDisplayed())));
    }
    @Test
    public void editTextInputMethod(){

    }

    @Test
    public void addTest() {
        onView(withId(R.id.et_oper1)).perform(typeText("2"));
        onView(withId(R.id.et_oper2)).perform(typeText("4"));
        onView(withId(R.id.btn_add)).perform(click());
        onView(withId(R.id.tv_result)).check(matches(withText("6")));
    }
    @Test
    public void minusTest() {
        onView(withId(R.id.et_oper1)).perform(typeText("25"));
        onView(withId(R.id.et_oper2)).perform(typeText("5"));
        onView(withId(R.id.btn_minus)).perform(click());
        onView(withId(R.id.tv_result)).check(matches(withText("20")));
    }
    @Test
    public void divisionTest() {
        onView(withId(R.id.et_oper1)).perform(typeText("50"));
        onView(withId(R.id.et_oper2)).perform(typeText("2"));
        onView(withId(R.id.btn_division)).perform(click());
        onView(withId(R.id.tv_result)).check(matches(withText("25")));
    }
    @Test
    public void multiplicationTest() {
        onView(withId(R.id.et_oper1)).perform(typeText("8"));
        onView(withId(R.id.et_oper2)).perform(typeText("8"));
        onView(withId(R.id.btn_multiplication)).perform(click());
        onView(withId(R.id.tv_result)).check(matches(withText("64")));
    }
}
