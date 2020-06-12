package com.example.myapplication7;

import android.widget.ImageView;

import java.util.ArrayList;

public class signup {
    public void setId(String id) {
        this.id = id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getImage_uri() {
        return image_uri;
    }

    public void setImage_uri(String image_uri) {
        this.image_uri = image_uri;
    }

    public signup(String id, String nickname, String password, String email,String image_uri) {
        this.image_uri = image_uri;
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.email = email;
    }
    public void addItem(signup item){list.add(item);}
    ArrayList<signup> list = new ArrayList<signup>();

    String image_uri;
    String id;
    String nickname;
    String password;
    String email;
}











