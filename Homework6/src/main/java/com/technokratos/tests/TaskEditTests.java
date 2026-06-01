package com.technokratos.tests;

import com.technokratos.model.TaskData;
import org.junit.Assert;
import org.junit.Test;

public class TaskEditTests extends AuthBase {

    @Test
    public void userCanEditTask() {
        TaskData editedTask = new TaskData(
                "Тестовое задание",
                "тестовое задание отредактировали",
                "тестовое задание отредактировали"
        );

        app.navigation().openDashboardPage();

        app.task().openTasksPage();
        app.task().openTaskEditForm();
        app.task().editTask(editedTask);

        Assert.assertTrue(app.task().isTaskEdited(editedTask));
    }
}