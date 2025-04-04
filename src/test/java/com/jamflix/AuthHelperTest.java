package com.jamflix;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AuthHelperTest {

    @Test
    public void testValidLogin() {
        assertTrue(AuthHelper.isValid("user1", "password"));
    }

    @Test
    public void testInvalidLogin() {
        assertFalse(AuthHelper.isValid("user1", "wrongpassword"));
        assertFalse(AuthHelper.isValid("unknown", "password"));
    }
}