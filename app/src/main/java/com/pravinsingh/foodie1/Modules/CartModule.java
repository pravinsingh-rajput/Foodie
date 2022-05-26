package com.pravinsingh.foodie1.Modules;

public class CartModule {

   private String Name,Price,Quantity,Image;

    public CartModule(String name, String price, String quantity, String image) {
        Name = name;
        Price = price;
        Quantity = quantity;
        Image = image;
    }

    public CartModule(){}

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
