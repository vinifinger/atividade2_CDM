package com.example.Atividade2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.Atividade2.model.Post;

public class DetalhePost extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_post);
        Intent intent = getIntent();

        Post post = intent.getParcelableExtra("objPost");
        TextView title = findViewById(R.id.tvPostTitle);
        TextView body = findViewById(R.id.tvPostBody);
        TextView id = findViewById(R.id.tvPostId);
        TextView userId = findViewById(R.id.tvPostUserId);

        title.setText("Title: " + post.getTitle());
        body.setText("Body: " + post.getBody());
        id.setText("Id: " + String.valueOf(post.getId()));
        userId.setText("UserId: " + String.valueOf(post.getUserId()));
    }
}