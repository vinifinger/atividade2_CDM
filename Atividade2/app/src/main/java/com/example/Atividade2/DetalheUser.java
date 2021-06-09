package com.example.Atividade2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.Atividade2.model.User;

public class DetalheUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_user);

        Intent intent = getIntent();
        User user = intent.getParcelableExtra("objUser");

        TextView id = findViewById(R.id.tvUserId);
        TextView name = findViewById(R.id.textViewName);
        TextView userName = findViewById(R.id.textViewUserName);
        TextView email = findViewById(R.id.textViewEmail);
        TextView phone = findViewById(R.id.textViewPhone);
        TextView website = findViewById(R.id.textViewWebsite);


        name.setText("Name: " + user.getName());
        userName.setText("Username: " + user.getUsername());
        email.setText("Email: " + user.getEmail());
        phone.setText("Phone: " + user.getPhone());
        website.setText("Website: " + user.getWebsite());
        id.setText("Id: " + String.valueOf(user.getId()));
    }
}