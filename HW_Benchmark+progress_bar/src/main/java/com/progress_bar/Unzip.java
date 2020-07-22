package com.progress_bar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Unzip extends AbstractOperation {

    @Override
    public void operation(String zipFile, String destinationDir) {
        try {
            Path temp = Files.createTempDirectory("tempZip");
            ArchiverUtils.unzip(zipFile, temp.toString());
            Copy c = new Copy();
            c.operation(temp.toString(), destinationDir);
            temp.toFile().deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
