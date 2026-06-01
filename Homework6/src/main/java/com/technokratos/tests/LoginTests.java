package com.technokratos.tests;

import com.technokratos.appmanager.Settings;
import com.technokratos.model.AccountData;
import org.junit.Assert;
import org.junit.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginWithValidData() {
        app.login().logout();

        AccountData account = new AccountData(
                Settings.getLogin(),
                Settings.getPassword()
        );

        app.login().login(account);

        Assert.assertTrue(app.login().isLoggedIn());
    }

    @Test
    public void loginWithInvalidData() {
        app.login().logout();

        AccountData account = new AccountData(
                Settings.getLogin(),
                "wrong_password"
        );

        app.login().login(account);

        Assert.assertTrue(app.login().isLoginFailed());
    }
}