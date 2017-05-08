package com.fichardu.todo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.fichardu.todo.data.TodoLocalDataSource;
import com.fichardu.todo.data.TodoRepository;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TodoContract.View {

    private View addTodoBtn;
    private EditText addTodoEdit;
    private RecyclerView todoList;
    private TextView summaryText;
    private View allBtn;
    private View activeBtn;
    private View completedBtn;

    private TodoAdapter adapter;
    private TodoContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addTodoBtn = findViewById(R.id.mail_add_todo_btn);
        addTodoEdit = (EditText) findViewById(R.id.main_new_todo_edit);
        summaryText = (TextView) findViewById(R.id.mail_summary_text);
        allBtn = findViewById(R.id.mail_category_all);
        activeBtn = findViewById(R.id.mail_category_active);
        completedBtn = findViewById(R.id.mail_category_completed);

        initRecyclerView();

        addTodoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = addTodoEdit.getText().toString();
                if (!TextUtils.isEmpty(content)) {
                    presenter.addTodo(content);
                }
            }
        });
        allBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setFilter(TodoFilterType.ALL);
            }
        });
        activeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setFilter(TodoFilterType.ACTIVE);
            }
        });
        completedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setFilter(TodoFilterType.COMPLETED);
            }
        });

        presenter = new TodoPresenter(this,
                new TodoRepository(TodoLocalDataSource.getInstance(this)));
        presenter.setFilter(TodoFilterType.ALL);
        presenter.loadTodos();
    }

    private void initRecyclerView() {
        todoList = (RecyclerView) findViewById(R.id.main_todo_list);
        todoList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TodoAdapter();
        adapter.setActionListener(new TodoAdapter.ActionListener() {
            @Override
            public void onStateChange(String id, boolean complete) {
                if (complete) {
                    presenter.completeTodo(id);
                } else {
                    presenter.activeTodo(id);
                }
            }
        });
        todoList.setAdapter(adapter);
        ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                                  RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                presenter.deleteTodo(((TodoAdapter.VH) viewHolder).getTodoId());
            }
        };
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(todoList);
    }

    @Override
    public void showTodos(List<TodoItemVO> todos) {
        adapter.setData(todos);
    }

    @Override
    public void showNoTodo() {
        adapter.setData(Collections.<TodoItemVO>emptyList());
    }

    @Override
    public void switchFilterState() {
        TodoFilterType type = presenter.getFilterType();
        allBtn.setSelected(type == TodoFilterType.ALL);
        activeBtn.setSelected(type == TodoFilterType.ACTIVE);
        completedBtn.setSelected(type == TodoFilterType.COMPLETED);
    }
}
