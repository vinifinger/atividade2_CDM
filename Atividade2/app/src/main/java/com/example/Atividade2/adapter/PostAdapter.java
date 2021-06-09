package com.example.Atividade2.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Atividade2.DetalhePost;
import com.example.Atividade2.R;
import com.example.Atividade2.model.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter {
    private List<Post> posts;

    public PostAdapter(List<Post> posts) {
        this.posts = posts;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycler_view_obj, parent, false);

        return new PostAdapter.PostViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextView tv = holder.itemView.findViewById(R.id.textviewtitulo);
        tv.setText(posts.get(position).getTitle());

        Button btn = holder.itemView.findViewById(R.id.button4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) v;
                //Todo todo = (Todo) btn.getTag();
                Post post = posts.get(position);

                Intent intent = new Intent(btn.getContext(), DetalhePost.class);

                intent.putExtra("objPost", post);
                btn.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }


    public class PostViewHolder extends RecyclerView.ViewHolder {

        public View viewPost;

        public PostViewHolder(View view) {
            super(view);
            this.viewPost = view;
        }
    }
}
