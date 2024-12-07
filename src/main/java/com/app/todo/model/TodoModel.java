package com.app.todo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "todo")
public class TodoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String content;

    private Boolean completed = false;

    private LocalDate created_at = LocalDate.now();

    private LocalDate archived_at;

    public TodoModel() {
    }

    public TodoModel(String title, String description, boolean completed) {
        this.name = name;
        this.content = content;
        this.completed= completed;
        this.created_at = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public LocalDate getArchived_at() {
        return archived_at;
    }

    public void setArchived_at(LocalDate archived_at) {
        this.archived_at = archived_at;
    }
}
