package com.technokratos.appmanager;

import com.technokratos.model.AccountData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginHelper extends com.technokratos.appmanager.HelperBase {

    public LoginHelper(com.technokratos.appmanager.ApplicationManager app) {
        super(app);
    }

    public void login(AccountData account) {
        typeEmail(account.getEmail());
        clickSubmitButton();

        typePassword(account.getPassword());
        clickSubmitButton();
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