package com.fichardu.todo.data;

import android.provider.BaseColumns;

public final class TodoDbContract {

    private TodoDbContract() {}

    public static abstract class TodoEntry implements BaseColumns {
        public static final String TABLE_NAME = "task";
        public static final String COLUMN_NAME_ENTRY_ID = "entry_id";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_COMPLETED = "completed";
    }
}
