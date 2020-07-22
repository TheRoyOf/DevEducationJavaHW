package com.progress_bar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip extends AbstractOperation {

    @Override
    public void operation(String sourceDirPath, String zipFilePath) {
        checkArgs(sourceDirPath, zipFilePath);
        ProgressBarUtils.createLog(Paths.get(zipFilePath).getParent().toString());

        long startTime = System.currentTimeMillis();
        Path zipFile = ProgressBarUtils.checkExistence(zipFilePath);

        ProgressCallback progressCallBack = (rbc, progress) ->
                ProgressBarUtils.printProgress(startTime, rbc.getSize(), rbc.getReadSoFar(), (int) progress);

        try {
            assert zipFile != null;
            try (ZipOutputStream zs = new ZipOutputStream(Files.newOutputStream(zipFile))) {
                Path source = Paths.get(sourceDirPath);
                zip(zipFile, progressCallBack, zs, source);
                System.out.println(ProgressBarUtils.doneState);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void checkArgs(String sourceDirPath, String zipFilePath) {
        if (sourceDirPath == null || zipFilePath == null) {
            throw new IllegalArgumentException("Paths and filenames cannot be null");
        }
    }

    private void zip(Path zipFile, ProgressCallback progressCallBack, ZipOutputStream zs, Path source) throws IOException {
        Files.walk(source)
                .filter(path -> !Files.isDirectory(path))
                .forEach(path -> {
                    ZipEntry zipEntry = new ZipEntry(source.relativize(path).toString());
                    long copyStartTime = System.currentTimeMillis();
                    System.out.println(path.getFileName());
                    try {
                        zs.putNextEntry(zipEntry);
                        ProgressBarUtils.copyCallback(path.toString(), zs.toString(), progressCallBack);
                        System.out.println();
                        ProgressBarUtils.updateLog(path.toString(), zipFile.getParent().toString(), copyStartTime);
                        zs.closeEntry();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }
}
