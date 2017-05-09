package com.fichardu.todo;

import java.util.List;

/**
 * Created by xf on 2017/5/8
 */

public interface TodoContract {

    interface Presenter {

        void loadTodos();

        void addTodo(String content);

        void completeTodo(String todoId);

        void activeTodo(String todoId);

        void deleteTodo(String todoId);

        void setFilter(TodoFilterType filter);

        TodoFilterType getFilterType();

    }

    interface View {

        void switchFilterState();

        void refreshSummary(int leftCount);

        void showTodos(List<TodoItemVO> todos);

        void showNoTodo();

    }
}
