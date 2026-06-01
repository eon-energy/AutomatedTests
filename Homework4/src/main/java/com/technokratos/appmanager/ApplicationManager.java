package com.technokratos.appmanager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ApplicationManager {
    private static final ThreadLocal<ApplicationManager> app = new ThreadLocal<>();

    private WebDriver driver;
    private JavascriptExecutor js;
    private WebDriverWait wait;

    private NavigationHelper navigation;
    private LoginHelper login;
    private TaskHelper task;

    private ApplicationManager() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        navigation = new NavigationHelper(this);
        login = new LoginHelper(this);
        task = new TaskHelper(this);
    }

    public static ApplicationManager getInstance() {
        if (app.get() == null) {
            ApplicationManager newInstance = new ApplicationManager();
            app.set(newInstance);
        }

        return app.get();
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

    public NavigationHelper navigation() {
        return navigation;
    }

    public LoginHelper login() {
        return login;
    }

    public TaskHelper task() {
        return task;
    }

    public void stop() {
        driver.quit();
    }
}