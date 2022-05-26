package com.pravinsingh.foodie1.Modules;

public class ResturantModel {

    String ResNam,ResRat,ResImg,ResDetail;

    public ResturantModel(String resNam, String resRat, String resImg, String resDetail) {
        ResNam = resNam;
        ResRat = resRat;
        ResImg = resImg;
        ResDetail = resDetail;
    }

    public ResturantModel(){}

    public String getResNam() {
        return ResNam;
    }

    public void setResNam(String resNam) {
        ResNam = resNam;
    }

    public String getResRat() {
        return ResRat;
    }

    public void setResRat(String resRat) {
        ResRat = resRat;
    }

    public String getResImg() {
        return ResImg;
    }

    public void setResImg(String resImg) {
        ResImg = resImg;
    }

    public String getResDetail() {
        return ResDetail;
    }

    public void setResDetail(String resDetail) {
        ResDetail = resDetail;
    }
}
