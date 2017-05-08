package com.fichardu.todo.data;

import java.util.List;

/**
 * Created by xf on 2017/5/8
 */

public interface TodoDataSource {

    List<TodoDTO> getTodos();

    void saveTodo(TodoDTO todo);

    void deleteTodo(String todoId);

    void activeTodo(String todoId);

    void completeTodo(String todoId);


}
