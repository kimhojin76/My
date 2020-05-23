package com.example.myapplication7;

public class Food {

    String name;
    String Kcal;
    String car;
    String pro;
    String fat;

    public Food(String name, String kcal, String car, String pro, String fat) {
        this.name = name;
        this.Kcal = kcal;
        this.car = car;
        this.pro = pro;
        this.fat = fat;
    }


    public String getName() {
        return name;
    }

    public String getKcal() {
        return Kcal;
    }

    public String getCar() {
        return car;
    }

    public String getPro() {
        return pro;
    }

    public String getFat() {
        return fat;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKcal(String kcal) {
        this.Kcal = kcal;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public void setPro(String pro) {
        this.pro = pro;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }
}
