package com.example.myapplication7;

public class ACT {
    public void setActname(String actname) {
        this.actname = actname;
    }

    public void setAct_pal(String act_pal) {
        this.act_pal = act_pal;
    }

    public void setAct_hour(String act_hour) {
        this.act_hour = act_hour;
    }

    public String getActname() {
        return actname;
    }

    public String getAct_pal() {
        return act_pal;
    }

    public String getAct_hour() {
        return act_hour;
    }

    String actname;
    String act_pal;
    String act_hour;


    public ACT(String actname, String act_pal, String act_hour) {
        this.actname = actname;
        this.act_pal = act_pal;
        this.act_hour = act_hour;
    }
}




