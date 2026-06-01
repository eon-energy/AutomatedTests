package com.technokratos.tests;

import com.technokratos.model.AccountData;
import com.technokratos.model.TaskData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class TaskCreationTests extends AuthBase {

    private final TaskData task;

    public TaskCreationTests(TaskData task) {
        this.task = task;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> taskDataFromXmlFile() throws Exception {
        List<Object[]> result = new ArrayList<>();

        File file = new File("src/test/resources/tasks.xml");

        Document document = DocumentBuilderFactory
                .newInstance()
                .newDocumentBuilder()
                .parse(file);

        NodeList tasks = document.getElementsByTagName("task");

        for (int i = 0; i < tasks.getLength(); i++) {
            String title = document
                    .getElementsByTagName("title")
                    .item(i)
                    .getTextContent();

            String description = document
                    .getElementsByTagName("description")
                    .item(i)
                    .getTextContent();

            String answer = document
                    .getElementsByTagName("answer")
                    .item(i)
                    .getTextContent();

            result.add(new Object[]{
                    new TaskData(title, description, answer)
            });
        }

        return result;
    }

    @Test
    public void userCanCreateTask() {


        app.navigation().openDashboardPage();
        app.task().createTask(task);

        Assert.assertTrue(app.task().isTaskCreated(task));
    }
}