package com.pravinsingh.foodie1.Modules;

public class BurgerModule {

    String CVBImg,CVBName,CVBPrice,CVBResturant,CVBPreptime,CVBRating,CVBdescription;

    public BurgerModule(String CVBImg, String CVBName, String CVBPrice, String CVBResturant, String CVBPreptime, String CVBRating, String CVBdescription) {
        this.CVBImg = CVBImg;
        this.CVBName = CVBName;
        this.CVBPrice = CVBPrice;
        this.CVBResturant = CVBResturant;
        this.CVBPreptime = CVBPreptime;
        this.CVBRating = CVBRating;
        this.CVBdescription = CVBdescription;
    }

    public BurgerModule(){};

    public String getCVBImg() {
        return CVBImg;
    }

    public void setCVBImg(String CVBImg) {
        this.CVBImg = CVBImg;
    }

    public String getCVBName() {
        return CVBName;
    }

    public void setCVBName(String CVBName) {
        this.CVBName = CVBName;
    }

    public String getCVBPrice() {
        return CVBPrice;
    }

    public void setCVBPrice(String CVBPrice) {
        this.CVBPrice = CVBPrice;
    }

    public String getCVBResturant() {
        return CVBResturant;
    }

    public void setCVBResturant(String CVBResturant) {
        this.CVBResturant = CVBResturant;
    }

    public String getCVBPreptime() {
        return CVBPreptime;
    }

    public void setCVBPreptime(String CVBPreptime) {
        this.CVBPreptime = CVBPreptime;
    }

    public String getCVBRating() {
        return CVBRating;
    }

    public void setCVBRating(String CVBRating) {
        this.CVBRating = CVBRating;
    }

    public String getCVBdescription() {
        return CVBdescription;
    }

    public void setCVBdescription(String CVBdescription) {
        this.CVBdescription = CVBdescription;
    }
}
