package com.example.itsfiveoclocksomewhere;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class SpecialCreationTest {
    @Test
    public void DBMethodsTest() {

        Special newSpecial = new Special(6, 6, 2.0, 3.0, 2.0, 3.0, "Miller Light");
        Special special = new Special(6, 6, 2.0, 3.0, 2.0, 3.0, "Miller Light");
        assertEquals(special, newSpecial);

    }
}