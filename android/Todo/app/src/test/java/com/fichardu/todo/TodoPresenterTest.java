package com.fichardu.todo;

import com.fichardu.todo.data.TodoDataSource;
import com.fichardu.todo.data.TodoRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;

/**
 * Created by xf on 2017/5/9
 */
public class TodoPresenterTest {

    @Mock
    private TodoContract.View view;

    @Mock
    private TodoDataSource dataSource;

    @Mock
    private TodoRepository repository;

    private TodoPresenter presenter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        presenter = new TodoPresenter(view, repository);
    }

    @Test
    public void loadTodos() {
        presenter.setFilter(TodoFilterType.ALL);
        presenter.loadTodos();

        verify(repository).getTodos();
        verify(view).showNoTodo();
    }

}