package com.technokratos.tests;

import com.technokratos.appmanager.ApplicationManager;
import org.junit.Before;

public class TestBase {
    protected ApplicationManager app;

    @Before
    public void setUp() {
        app = ApplicationManager.getInstance();
        app.navigation().openHomePage();
    }
}