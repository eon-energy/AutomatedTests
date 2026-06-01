package com.technokratos.appmanager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ApplicationManager {
    private WebDriver driver;
    private JavascriptExecutor js;
    private WebDriverWait wait;

    private com.technokratos.appmanager.NavigationHelper navigation;
    private com.technokratos.appmanager.LoginHelper login;
    private com.technokratos.appmanager.TaskHelper task;

    public ApplicationManager() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        navigation = new com.technokratos.appmanager.NavigationHelper(this);
        login = new com.technokratos.appmanager.LoginHelper(this);
        task = new com.technokratos.appmanager.TaskHelper(this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public JavascriptExecutor getJs() {
        return js;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public com.technokratos.appmanager.NavigationHelper navigation() {
        return navigation;
    }

    public com.technokratos.appmanager.LoginHelper login() {
        return login;
    }

    public com.technokratos.appmanager.TaskHelper task() {
        return task;
    }

    public void stop() {
        driver.quit();
    }
}