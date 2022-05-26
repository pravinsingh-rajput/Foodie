package com.pravinsingh.foodie1.Modules;

public class CategoriesModules {


    int cat_Image;
    String cat_name;

    public CategoriesModules(int cat_Image, String cat_name) {
        this.cat_Image = cat_Image;
        this.cat_name = cat_name;
    }

    public int getCat_Image() {
        return cat_Image;
    }

    public void setCat_Image(int cat_Image) {
        this.cat_Image = cat_Image;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }
}

