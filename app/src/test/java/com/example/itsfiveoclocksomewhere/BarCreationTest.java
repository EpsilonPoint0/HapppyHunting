package com.example.itsfiveoclocksomewhere;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class BarCreationTest {
    @Test
    public void DBMethodsTest() {

        Bar newBar = new Bar(6, "Threes", "High Street", "5", "5", "5", "5", "5", "5", "5");
        Bar bar = new Bar(6, "Threes", "High Street", "5", "5", "5", "5", "5", "5", "5");
        assertEquals(bar, newBar);

    }
}