package com.technokratos;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class TestBase {
    protected WebDriver driver;
    protected Map<String, Object> vars;
    protected JavascriptExecutor js;
    protected WebDriverWait wait;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<>();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public void openLoginPage() {
        driver.get("https://ion-inf.cloudtext.ru/login");
        driver.manage().window().setSize(new Dimension(1067, 616));
    }

    public void typeEmail(String email) {
        WebElement emailInput = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".form-group:nth-child(4) > .form-control")
                )
        );

        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void typePassword(String password) {
        WebElement passwordInput = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".form-group:nth-child(6) > .form-control")
                )
        );

        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickSubmitButton() {
        WebElement button = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector(".btn"))
        );

        button.click();
    }

    public void login(AccountData account) {
        typeEmail(account.getEmail());
        clickSubmitButton();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector(".form-group:nth-child(6) > .form-control")
                )
        );

        typePassword(account.getPassword());
        clickSubmitButton();
    }

    public void openDashboardPage() {
        driver.get("https://ion-inf.cloudtext.ru/dashboard");
        driver.manage().window().setSize(new Dimension(1070, 617));
    }

    public void openCreateTaskPage() {
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("li:nth-child(2) span")
                )
        ).click();

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".dropdown-toggle-split")
                )
        ).click();

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.linkText("Создать задание")
                )
        ).click();
    }

    public void fillTaskTitle(TaskData task) {
        WebElement titleInput = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("input.form-control")
                )
        );

        titleInput.clear();
        titleInput.sendKeys(task.getTitle());
    }

    public void addTaskDescription(TaskData task) {
        driver.findElement(By.cssSelector(".btn-outline-primary:nth-child(1)")).click();
        driver.findElement(By.cssSelector(".card:nth-child(1) > .card-body:nth-child(1)")).click();

        driver.findElement(By.cssSelector(".wysiwyg-editor")).click();

        WebElement editor = driver.findElement(By.cssSelector(".wysiwyg-editor"));
        js.executeScript(
                "if(arguments[0].contentEditable === 'true') {arguments[0].innerText = arguments[1]}",
                editor,
                task.getDescription()
        );

        driver.findElement(By.cssSelector(".btn-success")).click();
    }

    public void addTaskAnswer(TaskData task) {
        driver.findElement(By.cssSelector(".btn-outline-primary:nth-child(1)")).click();
        driver.findElement(By.cssSelector(".card:nth-child(3) > .card-body")).click();

        driver.findElement(By.cssSelector(".field .wysiwyg-editor")).click();

        WebElement editor = driver.findElement(By.cssSelector(".field .wysiwyg-editor"));
        js.executeScript(
                "if(arguments[0].contentEditable === 'true') {arguments[0].innerText = arguments[1]}",
                editor,
                task.getAnswer()
        );

        driver.findElement(By.cssSelector(".btn-success")).click();
    }

    public void createTask(TaskData task) {
        openCreateTaskPage();
        fillTaskTitle(task);
        addTaskDescription(task);
        addTaskAnswer(task);
    }
}