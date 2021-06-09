package com.example.Atividade2.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Atividade2.DetalheComment;
import com.example.Atividade2.R;
import com.example.Atividade2.model.Comment;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter{
    private List<Comment> comments;

    public CommentAdapter(List<Comment> posts) {
        this.comments = posts;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycler_view_obj, parent, false);

        return new CommentAdapter.CommentViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextView tv = holder.itemView.findViewById(R.id.textviewtitulo);
        tv.setText(comments.get(position).getBody());

        Button btn = holder.itemView.findViewById(R.id.button4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) v;
                Comment comment = comments.get(position);
                Intent intent = new Intent(btn.getContext(), DetalheComment.class);
                intent.putExtra("objComment", comment);
                btn.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }


    public class CommentViewHolder extends RecyclerView.ViewHolder {

        public View viewComment;

        public CommentViewHolder(View view) {
            super(view);
            this.viewComment = view;
        }
    }
}
