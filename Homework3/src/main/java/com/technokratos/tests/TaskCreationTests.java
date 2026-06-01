package com.technokratos.tests;

import com.technokratos.model.AccountData;
import com.technokratos.model.TaskData;
import org.junit.Test;

public class TaskCreationTests extends com.technokratos.tests.TestBase {

    @Test
    public void userCanCreateTask() {
        AccountData account = new AccountData(
                "www.ion83@gmail.com",
                "ion515151"
        );

        TaskData task = new TaskData(
                "Тестовое задание",
                "тестовое задание",
                "тестовое задание"
        );

        app.navigation().openLoginPage();
        app.login().login(account);

        app.navigation().openDashboardPage();
        app.task().createTask(task);
    }
}