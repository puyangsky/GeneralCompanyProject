package com.company.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2016/7/22.
 */
public class UploadedFile {
    byte[] bytes;
    int length;
    String type;
    String name;

    public UploadedFile() {
    }

    public UploadedFile(byte[] bytes, String name, String type, int length) {
        this.bytes = bytes;
        this.name = name;
        this.type = type;
        this.length = length;
        File file = new File(Constant.IMGDIR + name);
        if (file.exists()) {
            file.delete();
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(this.bytes, 0, this.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}