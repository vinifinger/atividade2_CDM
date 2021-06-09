package com.example.Atividade2.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Atividade2.DetalheAlbum;
import com.example.Atividade2.R;
import com.example.Atividade2.model.Album;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter{
    private List<Album> albums;

    public AlbumAdapter(List<Album> albums) {
        this.albums = albums;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycler_view_obj, parent, false);

        return new AlbumAdapter.AlbumViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextView tv = holder.itemView.findViewById(R.id.textviewtitulo);
        tv.setText(albums.get(position).getTitle());

        Button btn = holder.itemView.findViewById(R.id.button4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) v;
                Album album = albums.get(position);
                Intent intent = new Intent(btn.getContext(), DetalheAlbum.class);
                intent.putExtra("objAlbum", album);
                btn.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }


    public class AlbumViewHolder extends RecyclerView.ViewHolder {

        public View viewAlbum;

        public AlbumViewHolder(View view) {
            super(view);
            this.viewAlbum = view;
        }
    }
}
