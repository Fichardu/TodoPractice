package com.fichardu.todo.data;

import java.util.List;

/**
 * Created by xf on 2017/5/8
 */

public class TodoRepository implements TodoDataSource {

    private TodoDataSource localDataSource;

    public TodoRepository(TodoDataSource localDataSource) {
        this.localDataSource = localDataSource;
    }

    @Override
    public List<TodoDTO> getTodos() {
        return localDataSource.getTodos();
    }

    @Override
    public void saveTodo(TodoDTO todo) {
        localDataSource.saveTodo(todo);
    }

    @Override
    public void deleteTodo(String todoId) {
        localDataSource.deleteTodo(todoId);
    }

    @Override
    public void activeTodo(String todoId) {
        localDataSource.activeTodo(todoId);
    }

    @Override
    public void completeTodo(String todoId) {
        localDataSource.completeTodo(todoId);
    }
}
