package com.assignment.todo.model;

import javax.persistence.*;

/**
 * Created by sabbir on 11/26/21.
 */

@Entity
@Table(name = "todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50, nullable = false, unique = true)
    private String title;

    @Column(length = 220, nullable = false)
    private String description;

    @Column(length = 50, nullable = false)
    private int priority;

    @Column(length = 20)
    private String status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
