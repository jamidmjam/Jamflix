package com.jamflix;

public class AuthHelper {
    public static boolean isValid(String username, String password) {
        return "user1".equals(username) && "password".equals(password);
    }
}