package com.fichardu.todo.data;

import java.util.UUID;

/**
 * Created by xf on 2017/5/8
 */

public class TodoDTO {

    private String id;
    private String content;
    private boolean completed;

    public TodoDTO(String content, boolean completed) {
        this(UUID.randomUUID().toString(), content, completed);
    }

    public TodoDTO(String id, String content, boolean completed) {
        this.id = id;
        this.content = content;
        this.completed = completed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
