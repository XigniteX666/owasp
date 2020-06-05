package com.jumbo.utils;

import java.io.File;
import java.io.IOException;

public class FileUtils {

    private void readConfig(File testFile) {

        if (!testFile.exists()) {
            try {
                testFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            testFile.setWritable(true, false);
        }

    }
}
