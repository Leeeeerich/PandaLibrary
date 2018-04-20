package com.betelgeze.lerich.pandalibrary;

import android.net.Uri;

import java.net.URL;

public class Constants {


    public static URL URLIMAGES = getUrlImage();
    private static URL getUrlImage() {
        try {
            URLIMAGES = new URL("http://www.litmir.me/data/Book/0/611000/611533/BC3_1523728705.jpg");
        } catch (Exception e) { e.printStackTrace();}
        return URLIMAGES;
    }

}
