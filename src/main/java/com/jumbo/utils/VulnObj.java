package com.jumbo.utils;

import java.io.Serializable;

public class VulnObj implements Serializable {
    private int number = 1 ;

    public void setNumber(int number){
        if(number > 0){
            this.number = number;
        }else{
            System.out.println("Number should be positive");
        }
    }

    public void divide(){
        int result = 100 / this.number;
        System.out.println("result: " + result);
    }
}
