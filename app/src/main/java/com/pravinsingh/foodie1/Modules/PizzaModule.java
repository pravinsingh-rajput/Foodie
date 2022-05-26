package com.pravinsingh.foodie1.Modules;

public class PizzaModule {

    String CVPImg,CVPName,CVPPrice,CVPResturant,CVPPreptime,CVPRating,CVPdescription;

    public PizzaModule(String CVPImg, String CVPName, String CVPPrice, String CVPResturant, String CVPPreptime, String CVPRating, String CVPdescription) {
        this.CVPImg = CVPImg;
        this.CVPName = CVPName;
        this.CVPPrice = CVPPrice;
        this.CVPResturant = CVPResturant;
        this.CVPPreptime = CVPPreptime;
        this.CVPRating = CVPRating;
        this.CVPdescription = CVPdescription;
    }

    public  PizzaModule() {};

    public String getCVPImg() { return CVPImg; }

    public void setCVPImg(String CVPImg) {
        this.CVPImg = CVPImg;
    }

    public String getCVPName() {
        return CVPName;
    }

    public void setCVPName(String CVPName) {
        this.CVPName = CVPName;
    }

    public String getCVPPrice() {
        return CVPPrice;
    }

    public void setCVPPrice(String CVPPrice) {
        this.CVPPrice = CVPPrice;
    }

    public String getCVPResturant() {
        return CVPResturant;
    }

    public void setCVPResturant(String CVPResturant) {
        this.CVPResturant = CVPResturant;
    }

    public String getCVPPreptime() {
        return CVPPreptime;
    }

    public void setCVPPreptime(String CVPPreptime) {
        this.CVPPreptime = CVPPreptime;
    }

    public String getCVPRating() {
        return CVPRating;
    }

    public void setCVPRating(String CVPRating) {
        this.CVPRating = CVPRating;
    }

    public String getCVPdescription() {
        return CVPdescription;
    }

    public void setCVPdescription(String CVPdescription) {
        this.CVPdescription = CVPdescription;
    }
}
