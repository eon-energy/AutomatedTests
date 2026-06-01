package com.technokratos.tests;

import com.technokratos.appmanager.ApplicationManager;
import org.junit.After;
import org.junit.Before;

public class TestBase {
    protected ApplicationManager app;

    @Before
    public void setUp() {
        app = new ApplicationManager();
    }

    @After
    public void tearDown() {
        app.stop();
    }
}