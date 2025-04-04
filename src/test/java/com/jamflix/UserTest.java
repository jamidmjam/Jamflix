package com.jamflix;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testUserConstructor() {
        User user = new User("jamil", "password123", "premium");

        assertEquals("jamil", user.username);
        assertEquals("password123", user.password);
        assertEquals("premium", user.group);
    }

    @Test
    public void testIsPremium() {
        User premiumUser = new User("jamil", "password", "premium");
        User freeUser = new User("tom", "123", "free");

        assertTrue(premiumUser.isPremium());
        assertFalse(freeUser.isPremium());
    }
    
}
