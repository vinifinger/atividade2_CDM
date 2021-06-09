package com.example.Atividade2.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private int id;
    private String name;
    private String username;
    private String email;
    private String address;
    private String phone;
    private String website;
    //company?

    public User(int id, String name, String username, String email, String phone, String website, String address) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.website = website;
        this.address = address;
    }

    public User(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.username = in.readString();
        this.email = in.readString();
        this.phone = in.readString();
        this.website = in.readString();
        this.address = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.username);
        dest.writeString(this.email);
        dest.writeString(this.phone);
        dest.writeString(this.website);
        dest.writeString(this.address);
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String toString()
    {
        return String.format(String.valueOf(this.id) + "\n" + this.username + "\n" + this.email + "\n" + this.name + "\n" + this.phone + "\n" + this.website+
                "\n" + this.address);
    }
}
