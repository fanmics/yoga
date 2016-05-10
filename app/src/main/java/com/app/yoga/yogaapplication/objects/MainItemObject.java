package com.app.yoga.yogaapplication.objects;

/**
 * Created by Lenovo on 5/9/2016.
 */
public class MainItemObject {
    String name;
    int photo;

    public MainItemObject(String name, int photo){
        this.name=name;
        this.photo=photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
