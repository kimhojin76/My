package com.example.myapplication7;

public class member {
    String nickname;
    String title;
    String date;
    String contents;
    String uri;

    public member(String nickname, String title, String date, String contents, String uri) {
        this.nickname = nickname;
        this.title = title;
        this.date = date;
        this.contents = contents;
        this.uri = uri;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getNickname() {
        return nickname;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getContents() {
        return contents;
    }

    public String getUri() {
        return uri;
    }
}









