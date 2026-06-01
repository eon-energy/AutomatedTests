package com.technokratos;

import org.junit.Test;

public class TaskCreationTests extends TestBase {

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

        openLoginPage();
        login(account);

        openDashboardPage();
        createTask(task);
    }
}