package com.example.myapplication7;

public class ACT {
    String actname;
    String act_pal;
    String hour;


    public ACT(String actname, String act_pal) {
        this.actname = actname;
        this.act_pal = act_pal;
    }


    public void setActname(String actname) {
        this.actname = actname;
    }

    public void setAct_pal(String act_pal) {
        this.act_pal = act_pal;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }



    public String getActname() {
        return actname;
    }

    public String getAct_pal() {
        return act_pal;
    }

    public String getHour() {
        return hour;
    }
}


