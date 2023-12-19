package com.example.a3labdarbas;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import android.widget.Button;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    private MainActivity mainActivity;

    @Before
    public void setUp() {
        mainActivity = new MainActivity();
    }

    @Test
    public void testAddition() {
        String result = mainActivity.getResult("2+3");
        assertEquals("5", result);
    }

    @Test
    public void testSubtraction() {
        String result = mainActivity.getResult("5-3");
        assertEquals("2", result);
    }

    @Test
    public void testMultiplication() {
        String result = mainActivity.getResult("2*3");
        assertEquals("6", result);
    }

    @Test
    public void testDivision() {
        String result = mainActivity.getResult("6/3");
        assertEquals("2", result);
    }

    @Test
    public void testComplexExpression() {
        String result = mainActivity.getResult("2+3*4-2");
        assertEquals("12", result);
    }

    @Test
    public void testInvalidExpression() {
        String result = mainActivity.getResult("2+*3");
        assertEquals("ERROR", result);
    }

    @Test
    public void testClearEverything() {
        mainActivity.onClick(mockButtonWithText("CE"));
        assertEquals("", mainActivity.calculatorScreen.getText().toString());
    }

    @Test
    public void testDeleteLastCharacter() {
        mainActivity.calculatorScreen.setText("123");
        mainActivity.onClick(mockButtonWithText("DEL"));
        assertEquals("12", mainActivity.calculatorScreen.getText().toString());
    }

    private Button mockButtonWithText(String text) {
        Button button = new Button(mainActivity);
        button.setText(text);
        return button;
    }
}