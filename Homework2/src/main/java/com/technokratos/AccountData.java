package com.technokratos;

public class AccountData {
    private String email;
    private String password;

    public AccountData(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}