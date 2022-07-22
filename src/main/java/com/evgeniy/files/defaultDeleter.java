package com.evgeniy.files;

import java.io.File;

public class defaultDeleter implements FileDeleter {
    @Override
    public void deleteFile(String path) {
        File file = new File(path);
        System.out.println(file.delete());
    }
}
