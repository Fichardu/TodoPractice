package com.fichardu.todo;

/**
 * Created by xf on 2017/5/8
 */

public class TodoItemVO {

    private String id;

    private boolean completed;

    private String content;

    public TodoItemVO(String id, boolean completed, String content) {
        this.id = id;
        this.completed = completed;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
