package com.pravinsingh.foodie1.Modules;

public class VegModule {

    String CVVImg,CVVName,CVVPrice,CVVResturant,CVVPreptime,CVVRating,CVVdescription;

    public VegModule(String CVVImg, String CVVName, String CVVPrice, String CVVResturant, String CVVPreptime, String CVVRating, String CVVdescription) {
        this.CVVImg = CVVImg;
        this.CVVName = CVVName;
        this.CVVPrice = CVVPrice;
        this.CVVResturant = CVVResturant;
        this.CVVPreptime = CVVPreptime;
        this.CVVRating = CVVRating;
        this.CVVdescription = CVVdescription;
    }

    public VegModule(){};

    public String getCVVImg() {
        return CVVImg;
    }

    public void setCVVImg(String CVVImg) {
        this.CVVImg = CVVImg;
    }

    public String getCVVName() {
        return CVVName;
    }

    public void setCVVName(String CVVName) {
        this.CVVName = CVVName;
    }

    public String getCVVPrice() {
        return CVVPrice;
    }

    public void setCVVPrice(String CVVPrice) {
        this.CVVPrice = CVVPrice;
    }

    public String getCVVResturant() {
        return CVVResturant;
    }

    public void setCVVResturant(String CVVResturant) {
        this.CVVResturant = CVVResturant;
    }

    public String getCVVPreptime() {
        return CVVPreptime;
    }

    public void setCVVPreptime(String CVVPreptime) {
        this.CVVPreptime = CVVPreptime;
    }

    public String getCVVRating() {
        return CVVRating;
    }

    public void setCVVRating(String CVVRating) {
        this.CVVRating = CVVRating;
    }

    public String getCVVdescription() {
        return CVVdescription;
    }

    public void setCVVdescription(String CVVdescription) {
        this.CVVdescription = CVVdescription;
    }
}
