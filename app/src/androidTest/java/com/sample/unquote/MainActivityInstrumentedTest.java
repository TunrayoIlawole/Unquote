package com.sample.unquote;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testSubmitAnswerButton_shouldDisplayGameOverMessage() {
        activityRule.getScenario().onActivity(activity -> {
            // Clear the list to ensure it's empty
            activity.questions.clear();
            // Add a single question to simulate end-of-game condition
            activity.questions.add(new Question(921238, "How tall is the Eiffel tower?",
                    "1024 ft", "1063 ft", "1124 ft", "1163 ft", 1));
        });

        Espresso.onView(withId(R.id.btn_main_answer_1)).perform(click());
        Espresso.onView(withId((R.id.btn_main_submit_answer))).perform(click());

        Espresso.onView(withText("Game Over!")).check(matches(isDisplayed()));

    }

    @Test
    public void testDisplayQuestionsRemaining() {
        Espresso.onView(withId(R.id.btn_main_answer_1)).perform(click());
        Espresso.onView(withId((R.id.btn_main_submit_answer))).perform(click());

        Espresso.onView(withId(R.id.tv_main_questions_remaining)).check(matches(withText("5")));
    }


}
