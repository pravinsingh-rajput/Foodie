package com.pravinsingh.foodie1.Modules;

public class Mostorders {

    String mImg;
    String mName;
    String mPrice;
    String mResturant;
    String preptime;
    String Rating;
    String fdescription;

    public Mostorders(String mImg, String mName, String mPrice,String mResturant,String preptime,String rating,String fdescription ) {
        this.mImg = mImg;
        this.mName = mName;
        this.mPrice = mPrice;
        this.mResturant = mResturant;
        this.preptime = preptime;
        this.Rating = rating ;
        this.fdescription = fdescription;
    }


    public Mostorders(){

    }

    public String getmImg() { return mImg; }

    public void setmImg(String mImg) {
        this.mImg = mImg;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPrice() {
        return mPrice;
    }

    public void setmPrice(String mPrice) {
        this.mPrice = mPrice;
    }

    public String getmResturant() {
        return mResturant;
    }

    public void setmResturant(String mResturant) {
        this.mResturant = mResturant;
    }

    public String getPreptime() {
        return preptime;
    }

    public void setPreptime(String preptime) {
        this.preptime = preptime;
    }

    public String getRating() {
        return Rating;
    }

    public void setRating(String rating) {
        Rating = rating;
    }

    public String getFdescription() {
        return fdescription;
    }

    public void setFdescription(String fdescription) {
        this.fdescription = fdescription;
    }
}
