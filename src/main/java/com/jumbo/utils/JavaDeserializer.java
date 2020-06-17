package com.jumbo.utils;

import java.io.*;

public class JavaDeserializer {
    public static void main(String[] args) throws Exception{
        System.out.println("Starting");
        FileInputStream fis = new FileInputStream("c:/temp/normalObj.serial");
        ObjectInputStream ois = new ObjectInputStream(fis);

        VulnObj unuserObj = (VulnObj) ois.readObject();
        unuserObj.divide();
        ois.close();
    }
}

