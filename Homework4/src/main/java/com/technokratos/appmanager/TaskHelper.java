package com.technokratos.appmanager;

import com.technokratos.model.TaskData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TaskHelper extends HelperBase {

    public TaskHelper(ApplicationManager app) {
        super(app);
    }

    public void createTask(TaskData task) {
        openCreateTaskPage();
        fillTaskTitle(task);
        addTaskDescription(task);
        addTaskAnswer(task);
    }

    private void openCreateTaskPage() {
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

    private void fillTaskTitle(TaskData task) {
        WebElement titleInput = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//input[@type='text']")
                )
        );

        titleInput.clear();
        titleInput.sendKeys(task.getTitle());
    }

    private void addTaskDescription(TaskData task) {
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".btn-outline-primary:nth-child(1)")
                )
        ).click();

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".card:nth-child(1) > .card-body:nth-child(1)")
                )
        ).click();

        WebElement editor = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".wysiwyg-editor")
                )
        );

        js.executeScript(
                "if(arguments[0].contentEditable === 'true') {arguments[0].innerText = arguments[1]}",
                editor,
                task.getDescription()
        );

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".btn-success")
                )
        ).click();
    }

    private void addTaskAnswer(TaskData task) {
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".btn-outline-primary:nth-child(1)")
                )
        ).click();

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".card:nth-child(3) > .card-body")
                )
        ).click();

        WebElement editor = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".field .wysiwyg-editor")
                )
        );

        js.executeScript(
                "if(arguments[0].contentEditable === 'true') {arguments[0].innerText = arguments[1]}",
                editor,
                task.getAnswer()
        );

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".btn-success")
                )
        ).click();
    }

    public boolean isTaskCreated(TaskData task) {
        try {
            app.navigation().openDashboardPage();

            wait.until(driver ->
                    driver.getPageSource().contains(task.getTitle())
                            || driver.getPageSource().contains(task.getDescription())
                            || driver.getPageSource().contains(task.getAnswer())
            );

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void openTasksPage() {
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.linkText("Задания")
                )
        ).click();
    }

    public void openTaskEditForm() {
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".item:nth-child(8) .menu-toggle")
                )
        ).click();

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.linkText("Редактировать")
                )
        ).click();
    }

    public void editTask(TaskData task) {
        WebElement descriptionEditor = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".textarea > .wysiwyg-editor")
                )
        );

        js.executeScript(
                "if(arguments[0].contentEditable === 'true') {arguments[0].innerText = arguments[1]}",
                descriptionEditor,
                task.getDescription()
        );

        WebElement answerEditor = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".field .wysiwyg-editor")
                )
        );

        js.executeScript(
                "if(arguments[0].contentEditable === 'true') {arguments[0].innerText = arguments[1]}",
                answerEditor,
                task.getAnswer()
        );

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".btn-success")
                )
        ).click();
    }

    public boolean isTaskEdited(TaskData task) {
        try {
            wait.until(driver ->
                    driver.getPageSource().contains(task.getDescription())
                            || driver.getPageSource().contains(task.getAnswer())
                            || driver.getPageSource().contains("отредактировали")
            );

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}