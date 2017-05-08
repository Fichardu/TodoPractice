package com.fichardu.todo.data;

import android.content.Context;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xf on 2017/5/8
 */
public class TodoRepositoryTest {

    private final static String TODO_CONTENT1 = "content1";
    private final static String TODO_CONTENT2 = "content2";
    private final static String TODO_CONTENT3 = "content3";

    private static List<TodoDTO> TODOS = new ArrayList<>();

    private TodoRepository todoRepository;

    @Mock
    private TodoDataSource localDataSource;
    @Mock
    private Context context;

    @Before
    public void setup() {
        TODOS.add(new TodoDTO("Content1", false));
        TODOS.add(new TodoDTO("Content2", false));

        MockitoAnnotations.initMocks(this);
        todoRepository = new TodoRepository(localDataSource);
    }


}