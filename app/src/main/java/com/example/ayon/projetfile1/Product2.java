package com.example.ayon.projetfile1;

/**
 * Created by Bj on 17-09-17.
 */

public class Product2 {

    private String name;
    private String location;
    private String comment;




    public Product2 (String name, String location, String commnet ) {

        this.name=name;
        this.location=location;
        this.comment=commnet;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}