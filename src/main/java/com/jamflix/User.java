package com.jamflix;

public class User {
    String username;
    String password;
    String group;

    User(String u, String p, String g) {
        this.username = u;
        this.password = p;
        this.group = g;
    }

    // new helper method
    public boolean isPremium() {
        return "premium".equalsIgnoreCase(this.group);
    }
}
