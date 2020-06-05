package com.jumbo.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class JavaDeserializer {
    public static void main(String[] args) throws Exception{
        System.out.println("Starting");
        FileInputStream fis = new FileInputStream("/tmp/normalObj.serial");
        ObjectInputStream ois = new ObjectInputStream(fis);

        NormalObj unuserObj = (NormalObj) ois.readObject();
        ois.close();


    }
}

class NormalObj implements Serializable{
    public String name;
    public NormalObj(String name){
        this.name = name;
    }
    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException{
        in.defaultReadObject();
        System.out.println(this.name);
    }
}
