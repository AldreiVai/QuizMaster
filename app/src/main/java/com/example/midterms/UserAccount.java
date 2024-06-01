package com.example.midterms;

public class UserAccount {
    private int userId;
    private String username;

    public UserAccount(int userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }
}
