package com.example.myapplication7;

public class reple {
    public void setReple_amount(String reple_amount) {
        this.reple_amount = reple_amount;
    }

    public String getReple_amount() {
        return reple_amount;
    }

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


    String reple_amount;
    String nickname;
    String date;
    String contents;

}









