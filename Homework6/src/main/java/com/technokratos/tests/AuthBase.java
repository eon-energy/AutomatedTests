package com.technokratos.tests;

import com.technokratos.appmanager.Settings;
import com.technokratos.model.AccountData;
import org.junit.Before;

public class AuthBase extends TestBase {

    @Before
    public void login() {
        AccountData account = new AccountData(
                Settings.getLogin(),
                Settings.getPassword()
        );

        app.login().login(account);
    }
}