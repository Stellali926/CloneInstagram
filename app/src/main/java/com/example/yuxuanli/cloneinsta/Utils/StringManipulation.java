package com.example.yuxuanli.cloneinsta.Utils;

/**
 * Created by yuxuanli on 4/10/18.
 */

public class StringManipulation {

    public static String expandUsername(String username) {
        return username.replace(".", " ");
    }

    public static String condenseUsername(String username) {
        return username.replace(" ", ".");
    }
}
