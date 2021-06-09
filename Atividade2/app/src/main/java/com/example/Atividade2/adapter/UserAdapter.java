package com.example.Atividade2.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Atividade2.DetalheUser;
import com.example.Atividade2.R;
import com.example.Atividade2.model.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter {

    private List<User> users;

    public UserAdapter(List<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycler_view_obj, parent, false);

        return new UserAdapter.UserViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextView tv = holder.itemView.findViewById(R.id.textviewtitulo);
        tv.setText(users.get(position).getName());

        Button btn = holder.itemView.findViewById(R.id.button4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) v;
                User user = users.get(position);

                Intent intent = new Intent(btn.getContext(), DetalheUser.class);
                intent.putExtra("objUser", user);
                btn.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }


    public class UserViewHolder extends RecyclerView.ViewHolder {

        public View viewUser;

        public UserViewHolder(View view) {
            super(view);
            this.viewUser = view;
        }
    }
}
