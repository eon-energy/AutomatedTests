package com.technokratos.appmanager;

import com.technokratos.model.AccountData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginHelper extends HelperBase {

    public LoginHelper(ApplicationManager app) {
        super(app);
    }

    public void login(AccountData account) {
        if (isLoggedIn()) {
            if (isLoggedIn(account.getEmail())) {
                return;
            }

            logout();
        }

        app.navigation().openLoginPage();

        typeEmail(account.getEmail());
        clickSubmitButton();

        typePassword(account.getPassword());
        clickSubmitButton();
    }

    public boolean isLoggedIn() {
        try {
            wait.until(driver ->
                    driver.getCurrentUrl().contains("/dashboard")
                            || driver.getPageSource().contains("Задания")
                            || driver.getPageSource().contains("Выйти")
                            || driver.getPageSource().contains("Профиль")
            );

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLoggedIn(String username) {
        if (!isLoggedIn()) {
            return false;
        }

        return driver.getPageSource().contains(username)
                || driver.getPageSource().contains("Задания")
                || driver.getCurrentUrl().contains("/dashboard");
    }

    public void logout() {
        if (!isLoggedIn()) {
            return;
        }

        try {
            wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.id("navbarDropdown")
                    )
            ).click();

            wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.linkText("Выйти")
                    )
            ).click();
        } catch (Exception e) {
            driver.get(Settings.getBaseUrl() + "/logout");
        }
    }

    public boolean isLoginFailed() {
        try {
            wait.until(driver ->
                    driver.getCurrentUrl().contains("/login")
                            || driver.getPageSource().contains("Невер")
                            || driver.getPageSource().contains("Ошибка")
                            || driver.getPageSource().contains("invalid")
                            || driver.getPageSource().contains("Invalid")
            );

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void typeEmail(String email) {
        WebElement emailInput = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("input[type='email']")
                )
        );

        emailInput.clear();
        emailInput.sendKeys(email);
    }

    private void typePassword(String password) {
        WebElement passwordInput = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("input[type='password']")
                )
        );

        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    private void clickSubmitButton() {
        wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector(".btn"))
        ).click();
    }
}