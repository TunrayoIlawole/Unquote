package com.sample.unquote;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class MainActivityUnitTest {

    MainActivity mainActivity;

    @Before
    public void setup() {
        mainActivity = new MainActivity();
    }

    @Test
    public void testGetGameOverMessage_allCorrect() {
        int totalCorrect = 45;
        int totalQuestions = 45;

        String result = mainActivity.getGameOverMessage(totalCorrect, totalQuestions);
        assertEquals("You got all 45 right! You won!", result);
    }

    @Test
    public void testGetGameOverMessage_notAllCorrect() {
        int totalCorrect = 40;
        int totalQuestions = 45;

        String result = mainActivity.getGameOverMessage(totalCorrect, totalQuestions);
        assertEquals("You got 40 right out of 45. Better luck next time!", result);
    }

    @Test
    public void testGenerateRandomNumber_withinBounds() {
        int max = 10;
        int randomNumber = mainActivity.generateRandomNumber(max);
        assertTrue("Random number should be within bounds", randomNumber >= 0 && randomNumber < max);
    }
}
