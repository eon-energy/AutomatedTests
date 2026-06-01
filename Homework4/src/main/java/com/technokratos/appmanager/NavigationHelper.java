package com.technokratos.appmanager;

import org.openqa.selenium.Dimension;

public class NavigationHelper extends HelperBase {
    private final String baseUrl = "https://ion-inf.cloudtext.ru";

    public NavigationHelper(ApplicationManager app) {
        super(app);
    }

    public void openLoginPage() {
        driver.get(baseUrl + "/login");
        driver.manage().window().setSize(new Dimension(1070, 617));
    }

    public void openDashboardPage() {
        driver.get(baseUrl + "/dashboard");
        driver.manage().window().setSize(new Dimension(1070, 617));
    }
}