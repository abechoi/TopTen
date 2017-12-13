package com.example.sushiko.topten;

/**
 * Created by Sushiko on 11/15/17.
 */

public class ShowModel {
    String title, info;
    int id;

    public ShowModel(){
        id = getId();
        title = getTitle();
        info = getInfo();
    }

    public ShowModel(int id, String title, String info){
        this.id = id;
        this.title = title;
        this.info = info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }
}
