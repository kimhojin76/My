package com.example.myapplication7;

public class member {
    public member(String nickname, String title, String date, String contents) {
        this.nickname = nickname;
        this.title = title;
        this.date = date;
        this.contents = contents;
    }

    String nickname;
    String title;
    String date;
    String contents;






    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
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
}

