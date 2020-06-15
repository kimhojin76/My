package com.example.myapplication7;



public class weight {
    public void setDATE(String DATE) {
        this.DATE = DATE;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDATE() {
        return DATE;
    }

    public String getWeight() {
        return weight;
    }

    public weight(String DATE, String weight) {
        this.DATE = DATE;
        this.weight = weight;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.weight).append(" : ");
        sb.append(this.DATE);
        return  sb.toString();
    }
    String DATE;
    String weight;

}