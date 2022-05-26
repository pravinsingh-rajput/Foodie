package com.pravinsingh.foodie1.Modules;

public class FriesModule {

    String CVFImg,CVFName,CVFPrice,CVFResturant,CVFPreptime,CVFRating,CVFdescription;

    public FriesModule(String CVFImg, String CVFName, String CVFPrice, String CVFResturant, String CVFPreptime, String CVFRating, String CVFdescription) {
        this.CVFImg = CVFImg;
        this.CVFName = CVFName;
        this.CVFPrice = CVFPrice;
        this.CVFResturant = CVFResturant;
        this.CVFPreptime = CVFPreptime;
        this.CVFRating = CVFRating;
        this.CVFdescription = CVFdescription;
    }

    public FriesModule(){};

    public String getCVFImg() {
        return CVFImg;
    }

    public void setCVFImg(String CVFImg) {
        this.CVFImg = CVFImg;
    }

    public String getCVFName() {
        return CVFName;
    }

    public void setCVFName(String CVFName) {
        this.CVFName = CVFName;
    }

    public String getCVFPrice() {
        return CVFPrice;
    }

    public void setCVFPrice(String CVFPrice) {
        this.CVFPrice = CVFPrice;
    }

    public String getCVFResturant() {
        return CVFResturant;
    }

    public void setCVFResturant(String CVFResturant) {
        this.CVFResturant = CVFResturant;
    }

    public String getCVFPreptime() {
        return CVFPreptime;
    }

    public void setCVFPreptime(String CVFPreptime) {
        this.CVFPreptime = CVFPreptime;
    }

    public String getCVFRating() {
        return CVFRating;
    }

    public void setCVFRating(String CVFRating) {
        this.CVFRating = CVFRating;
    }

    public String getCVFdescription() {
        return CVFdescription;
    }

    public void setCVFdescription(String CVFdescription) {
        this.CVFdescription = CVFdescription;
    }
}
