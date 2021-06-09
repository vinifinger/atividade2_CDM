package com.example.Atividade2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.Atividade2.adapter.AlbumAdapter;
import com.example.Atividade2.adapter.CommentAdapter;
import com.example.Atividade2.adapter.PostAdapter;
import com.example.Atividade2.adapter.UserAdapter;
import com.example.Atividade2.model.Album;
import com.example.Atividade2.model.Comment;
import com.example.Atividade2.model.Post;
import com.example.Atividade2.model.User;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class main_activity extends AppCompatActivity {

    private ArrayList<Post> posts = new ArrayList<Post>();
    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<Comment> comments = new ArrayList<Comment>();
    private ArrayList<Album> albums = new ArrayList<Album>();

    public enum Query {
        posts, comments, albums, users;
    }

    Query currentQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity);

        QueryRequest("https://jsonplaceholder.typicode.com/users", Query.users);
        QueryRequest("https://jsonplaceholder.typicode.com/posts", Query.posts);
        QueryRequest("https://jsonplaceholder.typicode.com/comments", Query.comments);
        QueryRequest("https://jsonplaceholder.typicode.com/albums", Query.albums);
    }

    public void QueryRequest(String url, Query query) {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        RecyclerView rc;
                        LinearLayoutManager llm;
                        int orientation = RecyclerView.HORIZONTAL;
                        switch (query) {
                            case users:
                                try {
                                    for (int i = 0; i < response.length(); i++) {
                                        JSONObject json = response.getJSONObject(i);
                                        User obj = new User(json.getInt("id"), json.getString("name"),
                                                json.getString("username"), json.getString("email"),
                                                json.getString("phone"), json.getString("website"), json.getString("address"));
                                        users.add(obj);
                                    }
                                } catch (Exception e) {

                                }
                                rc = findViewById(R.id.recyclerView2);
                                llm = new LinearLayoutManager(getApplicationContext(), orientation, false);
                                rc.setLayoutManager(llm);
                                UserAdapter userAdapter = new UserAdapter(users);
                                rc.setAdapter(userAdapter);
                                break;
                            case posts:
                                try {
                                    for (int i = 0; i < response.length(); i++) {
                                        JSONObject json = response.getJSONObject(i);
                                        Post obj = new Post(json.getInt("userId"), json.getInt("id"), json.getString("title"), json.getString("body"));
                                        posts.add(obj);
                                    }
                                } catch (Exception e) {

                                }
                                rc = findViewById(R.id.recyclerView3);
                                llm = new LinearLayoutManager(getApplicationContext(), orientation, false);
                                rc.setLayoutManager(llm);
                                PostAdapter postAdapter = new PostAdapter(posts);
                                rc.setAdapter(postAdapter);
                                break;
                            case comments:
                                try {
                                    for (int i = 0; i < response.length(); i++) {
                                        JSONObject json = response.getJSONObject(i);
                                        Comment obj = new Comment(json.getInt("postId"), json.getInt("id"), json.getString("name"), json.getString("email"), json.getString("body"));
                                        comments.add(obj);
                                    }
                                } catch (Exception e) {

                                }
                                rc = findViewById(R.id.recyclerView4);
                                llm = new LinearLayoutManager(getApplicationContext(), orientation, false);
                                rc.setLayoutManager(llm);
                                CommentAdapter commentAdapter = new CommentAdapter(comments);
                                rc.setAdapter(commentAdapter);
                                break;
                            case albums:
                                try {
                                    for (int i = 0; i < response.length(); i++) {
                                        JSONObject json = response.getJSONObject(i);
                                        Album obj = new Album(json.getInt("userId"), json.getInt("id"), json.getString("title"));
                                        albums.add(obj);
                                    }
                                } catch (Exception e) {

                                }
                                rc = findViewById(R.id.recyclerView5);
                                llm = new LinearLayoutManager(getApplicationContext(), orientation, false);
                                rc.setLayoutManager(llm);
                                AlbumAdapter albumAdapter = new AlbumAdapter(albums);
                                rc.setAdapter(albumAdapter);
                                break;
                        }


                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        Volley.newRequestQueue(getApplicationContext()).add(jsonArrayRequest);
    }
}