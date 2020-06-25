package com.jumbo.utils;

public class BuggyUtils {

    public static long multiply(int i){
        System.out.println("useless method");

        return i*i;
    }
}
