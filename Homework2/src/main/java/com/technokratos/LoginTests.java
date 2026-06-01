package com.technokratos;

import org.junit.Test;

public class LoginTests extends TestBase {

    @Test
    public void userCanLogin() {
        AccountData account = new AccountData(
                "www.ion83@gmail.com",
                "ion515151"
        );

        openLoginPage();
        login(account);
    }

    @Test
    public void userCannotLoginWithWrongPassword() {
        AccountData account = new AccountData(
                "www.ion83@gmail.com",
                "wrong_password"
        );

        openLoginPage();
        login(account);
    }
}