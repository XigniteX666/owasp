package com.jumbo.utils;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class JavaSerializer {
    public static void main(String[] args) {
        VulnObj vulnObj = new VulnObj();
        vulnObj.setNumber(4);
        try {
            FileOutputStream fos = new FileOutputStream("c:/temp/normalObj.serial");
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(vulnObj);
            os.close();
        } catch (Exception ex) {
        }
    }
}
