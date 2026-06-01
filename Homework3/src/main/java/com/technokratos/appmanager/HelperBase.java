package com.technokratos.appmanager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {
    protected com.technokratos.appmanager.ApplicationManager app;
    protected WebDriver driver;
    protected JavascriptExecutor js;
    protected WebDriverWait wait;

    public HelperBase(ApplicationManager app) {
        this.app = app;
        this.driver = app.getDriver();
        this.js = app.getJs();
        this.wait = app.getWait();
    }
}