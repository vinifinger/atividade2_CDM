package com.example.Atividade2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.Atividade2.model.Comment;

public class DetalheComment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_comment);

        Intent intent = getIntent();

        Comment comment = intent.getParcelableExtra("objComment");

        TextView name = findViewById(R.id.tvCommentName);
        TextView email = findViewById(R.id.tvCommentEmail);
        TextView body = findViewById(R.id.tvCommentBody);
        TextView id = findViewById(R.id.tvCommentId);
        TextView userId = findViewById(R.id.tvCommentPostId);

        name.setText("Name: " + comment.getName());
        email.setText("Email: " + comment.getEmail());
        body.setText("Body: " + comment.getBody());
        id.setText("Id: " + String.valueOf(comment.getId()));
        userId.setText("UserId: " + String.valueOf(comment.getPostId()));
    }
}