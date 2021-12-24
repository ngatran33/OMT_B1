package com.example.api;

public class Coffee {
    private String title;
    private String description;
    private Integer id;

    public Coffee(String title, String description, Integer id) {
        this.title = title;
        this.description = description;
        this.id = id;
    }

    public Coffee() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
