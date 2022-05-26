package com.pravinsingh.foodie1.Modules;

public class NonVegModule {
    String CVNVImg,CVNVName,CVNVPrice,CVNVResturant,CVNVPreptime,CVNVRating,CVNVdescription;

    public NonVegModule(String CVNVImg, String CVNVName, String CVNVPrice, String CVNVResturant, String CVNVPreptime, String CVNVRating, String CVNVdescription) {
        this.CVNVImg = CVNVImg;
        this.CVNVName = CVNVName;
        this.CVNVPrice = CVNVPrice;
        this.CVNVResturant = CVNVResturant;
        this.CVNVPreptime = CVNVPreptime;
        this.CVNVRating = CVNVRating;
        this.CVNVdescription = CVNVdescription;
    }

    public NonVegModule(){};

    public String getCVNVImg() {
        return CVNVImg;
    }

    public void setCVNVImg(String CVNVImg) {
        this.CVNVImg = CVNVImg;
    }

    public String getCVNVName() {
        return CVNVName;
    }

    public void setCVNVName(String CVNVName) {
        this.CVNVName = CVNVName;
    }

    public String getCVNVPrice() {
        return CVNVPrice;
    }

    public void setCVNVPrice(String CVNVPrice) {
        this.CVNVPrice = CVNVPrice;
    }

    public String getCVNVResturant() {
        return CVNVResturant;
    }

    public void setCVNVResturant(String CVNVResturant) {
        this.CVNVResturant = CVNVResturant;
    }

    public String getCVNVPreptime() {
        return CVNVPreptime;
    }

    public void setCVNVPreptime(String CVNVPreptime) {
        this.CVNVPreptime = CVNVPreptime;
    }

    public String getCVNVRating() {
        return CVNVRating;
    }

    public void setCVNVRating(String CVNVRating) {
        this.CVNVRating = CVNVRating;
    }

    public String getCVNVdescription() {
        return CVNVdescription;
    }

    public void setCVNVdescription(String CVNVdescription) {
        this.CVNVdescription = CVNVdescription;
    }
}
