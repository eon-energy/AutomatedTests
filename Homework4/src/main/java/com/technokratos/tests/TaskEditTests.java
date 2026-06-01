package com.technokratos.tests;

import com.technokratos.model.AccountData;
import com.technokratos.model.TaskData;
import org.junit.Assert;
import org.junit.Test;

public class TaskEditTests extends TestBase {

    @Test
    public void userCanEditTask() {
        AccountData account = new AccountData(
                "www.ion83@gmail.com",
                "ion515151"
        );

        TaskData editedTask = new TaskData(
                "Тестовое задание",
                "тестовое задание отредактировали",
                "тестовое задание отредактировали"
        );

        app.navigation().openLoginPage();
        app.login().login(account);

        app.navigation().openDashboardPage();

        app.task().openTasksPage();
        app.task().openTaskEditForm();
        app.task().editTask(editedTask);

        Assert.assertTrue(app.task().isTaskEdited(editedTask));
    }
}