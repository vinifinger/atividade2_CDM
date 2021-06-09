package com.example.Atividade2.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Post implements Parcelable {
    private int id;
    private int userId;
    private String title;
    private String body;
    protected Post(Parcel in) {
        this.userId = in.readInt();
        this.id = in.readInt();
        this.title = in.readString();
        this.body = in.readString();
    }

    public Post(int id, int userId, String title, String body) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.userId);
        dest.writeString(this.title);
        dest.writeString(this.body);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Post> CREATOR = new Creator<Post>() {
        @Override
        public Post createFromParcel(Parcel in) {
            return new Post(in);
        }

        @Override
        public Post[] newArray(int size) {
            return new Post[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString()
    {
        return String.format(String.valueOf(this.userId) + "\n" + String.valueOf(this.id) + "\n" + this.title + "\n" + this.body);
    }
}
