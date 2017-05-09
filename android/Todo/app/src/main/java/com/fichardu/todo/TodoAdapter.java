package com.fichardu.todo;

import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xf on 2017/5/8
 */

public class TodoAdapter extends RecyclerView.Adapter {

    private List<TodoItemVO> data = new ArrayList<>();
    private ActionListener listener;

    public void setData(List<TodoItemVO> data) {
        this.data.clear();
        if (data != null) {
            this.data.addAll(data);
        }
        notifyDataSetChanged();
    }

    public void addData(TodoItemVO itemVO) {
        data.add(itemVO);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_todo_list,
                parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ((VH) holder).bindView(data.get(position));
        ((VH) holder).getStateView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    TodoItemVO vo = data.get(position);
                    listener.onStateChange(vo.getId(), !vo.isCompleted());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class VH extends RecyclerView.ViewHolder {

        TextView contentText;
        View stateView;
        private String todoId;

        public VH(View itemView) {
            super(itemView);

            contentText = (TextView) itemView.findViewById(R.id.item_todo_content);
            stateView = itemView.findViewById(R.id.item_todo_state);
        }

        public void bindView(TodoItemVO model) {
            SpannableString span = new SpannableString(model.getContent());
            if (model.isCompleted()) {
                span.setSpan(new StrikethroughSpan(), 0, span.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);

            }
            contentText.setText(span);
            stateView.setSelected(model.isCompleted());
            todoId = model.getId();
        }

        public View getStateView() {
            return stateView;
        }

        public String getTodoId() {
            return todoId;
        }
    }


    public void setActionListener(ActionListener listener) {
        this.listener = listener;
    }

    interface ActionListener {
        void onStateChange(String id, boolean complete);
    }
}
