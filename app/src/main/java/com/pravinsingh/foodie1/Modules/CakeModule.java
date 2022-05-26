package com.pravinsingh.foodie1.Modules;

public class CakeModule {

    String CVCImg,CVCName,CVCPrice,CVCResturant,CVCPreptime,CVCRating,CVCdescription;

    public CakeModule(String CVCImg, String CVCName, String CVCPrice, String CVCResturant, String CVCPreptime, String CVCRating, String CVCdescription) {
        this.CVCImg = CVCImg;
        this.CVCName = CVCName;
        this.CVCPrice = CVCPrice;
        this.CVCResturant = CVCResturant;
        this.CVCPreptime = CVCPreptime;
        this.CVCRating = CVCRating;
        this.CVCdescription = CVCdescription;
    }

    public CakeModule(){};

    public String getCVCImg() {
        return CVCImg;
    }

    public void setCVCImg(String CVCImg) {
        this.CVCImg = CVCImg;
    }

    public String getCVCName() {
        return CVCName;
    }

    public void setCVCName(String CVCName) {
        this.CVCName = CVCName;
    }

    public String getCVCPrice() {
        return CVCPrice;
    }

    public void setCVCPrice(String CVCPrice) {
        this.CVCPrice = CVCPrice;
    }

    public String getCVCResturant() {
        return CVCResturant;
    }

    public void setCVCResturant(String CVCResturant) {
        this.CVCResturant = CVCResturant;
    }

    public String getCVCPreptime() {
        return CVCPreptime;
    }

    public void setCVCPreptime(String CVCPreptime) {
        this.CVCPreptime = CVCPreptime;
    }

    public String getCVCRating() {
        return CVCRating;
    }

    public void setCVCRating(String CVCRating) {
        this.CVCRating = CVCRating;
    }

    public String getCVCdescription() {
        return CVCdescription;
    }

    public void setCVCdescription(String CVCdescription) {
        this.CVCdescription = CVCdescription;
    }
}
