package com.pravinsingh.foodie1.Modules;

public class DrinkModule {

    String CVDImg,CVDName,CVDPrice,CVDResturant,CVDPreptime,CVDRating,CVDdescription;

    public DrinkModule(String CVDImg, String CVDName, String CVDPrice, String CVDResturant, String CVDPreptime, String CVDRating, String CVDdescription) {
        this.CVDImg = CVDImg;
        this.CVDName = CVDName;
        this.CVDPrice = CVDPrice;
        this.CVDResturant = CVDResturant;
        this.CVDPreptime = CVDPreptime;
        this.CVDRating = CVDRating;
        this.CVDdescription = CVDdescription;
    }

    public DrinkModule(){};

    public String getCVDImg() {
        return CVDImg;
    }

    public void setCVDImg(String CVDImg) {
        this.CVDImg = CVDImg;
    }

    public String getCVDName() {
        return CVDName;
    }

    public void setCVDName(String CVDName) {
        this.CVDName = CVDName;
    }

    public String getCVDPrice() {
        return CVDPrice;
    }

    public void setCVDPrice(String CVDPrice) {
        this.CVDPrice = CVDPrice;
    }

    public String getCVDResturant() {
        return CVDResturant;
    }

    public void setCVDResturant(String CVDResturant) {
        this.CVDResturant = CVDResturant;
    }

    public String getCVDPreptime() {
        return CVDPreptime;
    }

    public void setCVDPreptime(String CVDPreptime) {
        this.CVDPreptime = CVDPreptime;
    }

    public String getCVDRating() {
        return CVDRating;
    }

    public void setCVDRating(String CVDRating) {
        this.CVDRating = CVDRating;
    }

    public String getCVDdescription() {
        return CVDdescription;
    }

    public void setCVDdescription(String CVDdescription) {
        this.CVDdescription = CVDdescription;
    }
}
