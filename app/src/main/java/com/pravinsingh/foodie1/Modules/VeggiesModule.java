package com.pravinsingh.foodie1.Modules;

public class VeggiesModule {

    String VeggieImg, VeggieName,VeggiePrice;

    public VeggiesModule(String veggieImg, String veggieName, String veggiePrice) {
        VeggieImg = veggieImg;
        VeggieName = veggieName;
        VeggiePrice = veggiePrice;
    }

    public VeggiesModule(){}

    public String getVeggieImg() {
        return VeggieImg;
    }

    public void setVeggieImg(String veggieImg) {
        VeggieImg = veggieImg;
    }

    public String getVeggieName() {
        return VeggieName;
    }

    public void setVeggieName(String veggieName) {
        VeggieName = veggieName;
    }

    public String getVeggiePrice() {
        return VeggiePrice;
    }

    public void setVeggiePrice(String veggiePrice) {
        VeggiePrice = veggiePrice;
    }
}
