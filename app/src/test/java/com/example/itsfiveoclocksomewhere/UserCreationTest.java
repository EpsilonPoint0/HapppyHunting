package com.example.itsfiveoclocksomewhere;

import org.junit.Test;
import com.example.itsfiveoclocksomewhere.ui.login.*;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UserCreationTest {
    @Test
    public void DBMethodsTest() {

        User newUser = new User(6, "Username", "password", "uberId", "lyftID");
        User user = new User(6, "Username", "password", "uberId", "lyftID");
        assertEquals(user, newUser);

    }
}