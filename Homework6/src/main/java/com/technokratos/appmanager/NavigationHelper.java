package com.technokratos.appmanager;

import org.openqa.selenium.Dimension;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(ApplicationManager app) {
        super(app);
    }

    public void openHomePage() {
        driver.get(Settings.getBaseUrl());
        driver.manage().window().setSize(new Dimension(1070, 617));
    }

    public void openLoginPage() {
        driver.get(Settings.getBaseUrl() + "/login");
        driver.manage().window().setSize(new Dimension(1070, 617));
    }

    public void openDashboardPage() {
        driver.get(Settings.getBaseUrl() + "/dashboard");
        driver.manage().window().setSize(new Dimension(1070, 617));
    }
}