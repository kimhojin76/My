package com.example.myapplication7;

public class reple {
    public reple(String nickname, String date, String contents) {
        this.nickname = nickname;
        this.date = date;
        this.contents = contents;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getNickname() {
        return nickname;
    }

    public String getDate() {
        return date;
    }

    public String getContents() {
        return contents;
    }



    String nickname;
    String date;
    String contents;

}









