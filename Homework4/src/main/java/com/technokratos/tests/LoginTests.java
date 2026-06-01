package com.technokratos.tests;

import com.technokratos.model.AccountData;
import org.junit.Assert;
import org.junit.Test;

public class LoginTests extends TestBase {

    @Test
    public void userCanLogin() {
        AccountData account = new AccountData(
                "www.ion83@gmail.com",
                "ion515151"
        );

        app.navigation().openLoginPage();
        app.login().login(account);

        Assert.assertTrue(app.login().isLoggedIn());
    }
}