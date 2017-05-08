package com.fichardu.todo.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xf on 2017/5/8
 */

public class TodoLocalDataSource implements TodoDataSource {

    private static volatile TodoLocalDataSource INSTANCE;

    private TodoDbHelper mDbHelper;

    private TodoLocalDataSource(@NonNull Context context) {
        mDbHelper = new TodoDbHelper(context);
    }

    public static TodoLocalDataSource getInstance(@NonNull Context context) {
        if (INSTANCE == null) {
            INSTANCE = new TodoLocalDataSource(context);
        }
        return INSTANCE;
    }

    @Override
    public List<TodoDTO> getTodos() {
        List<TodoDTO> todos = new ArrayList<>();

        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        String[] projection = {
                TodoDbContract.TodoEntry.COLUMN_NAME_ENTRY_ID,
                TodoDbContract.TodoEntry.COLUMN_NAME_TITLE,
                TodoDbContract.TodoEntry.COLUMN_NAME_COMPLETED
        };
        Cursor c = db.query(
                TodoDbContract.TodoEntry.TABLE_NAME, projection, null, null, null, null, null);

        if (c != null && c.getCount() > 0) {
            int idIndex = c.getColumnIndexOrThrow(TodoDbContract.TodoEntry.COLUMN_NAME_ENTRY_ID);
            int titleIndex = c.getColumnIndexOrThrow(TodoDbContract.TodoEntry.COLUMN_NAME_TITLE);
            int completedIndex = c.getColumnIndexOrThrow(TodoDbContract.TodoEntry
                    .COLUMN_NAME_COMPLETED);
            while (c.moveToNext()) {
                String id = c.getString(idIndex);
                String title = c.getString(titleIndex);
                boolean completed = c.getInt(completedIndex) == 1;
                TodoDTO todo = new TodoDTO(id, title, completed);
                todos.add(todo);
            }
        }
        if (c != null) {
            c.close();
        }
        db.close();

        return todos;
    }

    @Override
    public void saveTodo(TodoDTO todo) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TodoDbContract.TodoEntry.COLUMN_NAME_ENTRY_ID, todo.getId());
        values.put(TodoDbContract.TodoEntry.COLUMN_NAME_TITLE, todo.getContent());
        values.put(TodoDbContract.TodoEntry.COLUMN_NAME_COMPLETED, todo.isCompleted());

        db.insert(TodoDbContract.TodoEntry.TABLE_NAME, null, values);
        db.close();
    }

    @Override
    public void deleteTodo(String todoId) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        String selection = TodoDbContract.TodoEntry.COLUMN_NAME_ENTRY_ID + " = ?";
        String[] selectionArgs = { todoId };

        db.delete(TodoDbContract.TodoEntry.TABLE_NAME, selection, selectionArgs);

        db.close();
    }

    @Override
    public void activeTodo(String todoId) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TodoDbContract.TodoEntry.COLUMN_NAME_COMPLETED, false);

        String selection = TodoDbContract.TodoEntry.COLUMN_NAME_ENTRY_ID + " = ?";
        String[] selectionArgs = { todoId };

        db.update(TodoDbContract.TodoEntry.TABLE_NAME, values, selection, selectionArgs);

        db.close();
    }

    @Override
    public void completeTodo(String todoId) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TodoDbContract.TodoEntry.COLUMN_NAME_COMPLETED, true);

        String selection = TodoDbContract.TodoEntry.COLUMN_NAME_ENTRY_ID + " = ?";
        String[] selectionArgs = { todoId };

        db.update(TodoDbContract.TodoEntry.TABLE_NAME, values, selection, selectionArgs);

        db.close();
    }
}
