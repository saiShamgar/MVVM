package com.sairaa.mvvm.Model;

public class Image_List {

    String image_url;
    String image_name;

    public Image_List(String image_url, String image_name) {
        this.image_url = image_url;
        this.image_name = image_name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }
}
