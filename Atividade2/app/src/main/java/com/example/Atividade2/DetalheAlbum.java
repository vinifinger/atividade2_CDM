package com.example.Atividade2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.Atividade2.model.Album;

public class DetalheAlbum extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_album);

        Intent intent = getIntent();

        Album album = intent.getParcelableExtra("objAlbum");

        TextView name = findViewById(R.id.tvAlbumTitle);
        TextView id = findViewById(R.id.tvAlbumId);
        TextView userId = findViewById(R.id.tvAlbumUserId);

        name.setText("Title: " + album.getTitle());
        id.setText("Id: " + String.valueOf(album.getId()));
        userId.setText("UserId: " + String.valueOf(album.getUserId()));
    }
}