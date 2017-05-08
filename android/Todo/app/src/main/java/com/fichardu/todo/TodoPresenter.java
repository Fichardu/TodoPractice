package com.fichardu.todo;

import com.fichardu.todo.data.TodoDTO;
import com.fichardu.todo.data.TodoRepository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by xf on 2017/5/8
 */

public class TodoPresenter implements TodoContract.Presenter {

    private TodoContract.View view;
    private TodoRepository repository;
    private LinkedHashMap<String, TodoItemVO> todoVOs;
    private TodoFilterType filterType;

    public TodoPresenter(TodoContract.View view, TodoRepository repository) {
        this.view = view;
        this.repository = repository;

        todoVOs = new LinkedHashMap<>();
        filterType = TodoFilterType.ALL;
    }

    @Override
    public void loadTodos() {
        List<TodoDTO> todoDTOs = repository.getTodos();
        todoVOs.clear();

        for (TodoDTO item : todoDTOs) {
            TodoItemVO vo = new TodoItemVO(item.getId(), item.isCompleted(), item.getContent());
            todoVOs.put(item.getId(), vo);
        }

        if (view != null) {
            showTodos();
        }
    }

    @Override
    public void addTodo(String content) {
        TodoDTO todoDTO = new TodoDTO(content, false);
        repository.saveTodo(todoDTO);
        TodoItemVO todoItemVO = new TodoItemVO(todoDTO.getId(), todoDTO.isCompleted(),
                todoDTO.getContent());
        todoVOs.put(todoItemVO.getId(), todoItemVO);

        showTodos();
    }

    @Override
    public void completeTodo(String todoId) {
        repository.completeTodo(todoId);
        todoVOs.get(todoId).setCompleted(true);

        showTodos();
    }

    @Override
    public void activeTodo(String todoId) {
        repository.activeTodo(todoId);
        todoVOs.get(todoId).setCompleted(false);

        showTodos();
    }

    @Override
    public void deleteTodo(String todoId) {
        repository.deleteTodo(todoId);
        todoVOs.remove(todoId);

        showTodos();
    }

    @Override
    public void setFilter(TodoFilterType filter) {
        if (filter != filterType) {
            filterType = filter;
            showTodos();

            if (view != null) {
                view.switchFilterState();
            }
        }
    }

    @Override
    public TodoFilterType getFilterType() {
        return filterType;
    }

    private void showTodos() {
        if (view != null) {
            if (filterType == TodoFilterType.ALL) {
                if (todoVOs.isEmpty()) {
                    view.showNoTodo();
                } else {
                    view.showTodos(new ArrayList<>(todoVOs.values()));
                }
            } else if (filterType == TodoFilterType.ACTIVE) {
                List<TodoItemVO> todos = new ArrayList<>();
                for (TodoItemVO vo : todoVOs.values()) {
                    if (!vo.isCompleted()) {
                        todos.add(vo);
                    }
                }
                view.showTodos(todos);

            } else if (filterType == TodoFilterType.COMPLETED) {
                List<TodoItemVO> todos = new ArrayList<>();
                for (TodoItemVO vo : todoVOs.values()) {
                    if (vo.isCompleted()) {
                        todos.add(vo);
                    }
                }
                view.showTodos(todos);
            }
        }
    }
}
