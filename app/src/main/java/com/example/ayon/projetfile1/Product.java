package com.example.ayon.projetfile1;

import android.sax.StartElementListener;

/**
 * Created by Bj on 30-05-17.
 */

public class Product {

    private String dist;
    private String place;
    private String image;
    private String details;
   private String latitude;
   private String longitude;




    public Product(String dist, String place, String image , String details, String latitude,String  longitude) {
        this.dist=dist;
        this.place=place;
        this.image=image;
        this.details=details;
        this.latitude=latitude;
        this.longitude=longitude;

    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }

    public String getDist() {
        return dist;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPlace() {
        return place;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDetails() {
        return details;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLongitude() {
        return longitude;
    }
}
