package com.gaegxh.tensor.model;

public class Task {

    private long id;
    private String name;
    private String description;
    private String status;

    // Конструктор без параметров
    public Task() {
    }


    public Task(long id, String name, String description, String status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
    }

    // Геттеры
    public long getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getStatus() { return status; }

    // Сеттеры
    public void setId(long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setStatus(String status) { this.status = status; }
}
