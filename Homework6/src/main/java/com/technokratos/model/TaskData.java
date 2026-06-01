package com.technokratos.model;

public class TaskData {
    private String title;
    private String description;
    private String answer;

    public TaskData(String title, String description, String answer) {
        this.title = title;
        this.description = description;
        this.answer = answer;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAnswer() {
        return answer;
    }
}