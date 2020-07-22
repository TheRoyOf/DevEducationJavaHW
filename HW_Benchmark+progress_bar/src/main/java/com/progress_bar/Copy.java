package com.progress_bar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Copy extends AbstractOperation {

    @Override
    public void operation(String src, String destination)
    {
        checkArgs(src, destination);
        ProgressBarUtils.createLog(destination);

        long startTime = System.currentTimeMillis();
        ProgressCallback progressCallBack = (rbc, progress) ->
                ProgressBarUtils.printProgress(startTime, rbc.getSize(), rbc.getReadSoFar(), (int) progress);

        try {
            if (Files.isRegularFile(Paths.get(src))) {
                long copyStartTime = System.currentTimeMillis();
                System.out.println(Paths.get(src).getFileName());
                ProgressBarUtils.copyCallback(src, destination, progressCallBack);
                ProgressBarUtils.updateLog(src, Paths.get(destination).getParent().toString(), copyStartTime);
            } else {
                copyDirectory(src, destination, progressCallBack);
            }
            System.out.println(ProgressBarUtils.doneState);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void checkArgs(String src, String destination)
    {
        if (src == null || destination == null)
        {
            throw new IllegalArgumentException("Paths and filenames cannot be null");
        }
    }

    private void copyDirectory(String src, String destination, ProgressCallback progressCallBack) throws IOException
    {
        Files.walk(Paths.get(src)).forEach(path ->
        {
                    long copyStartTime = System.currentTimeMillis();
                    try {
                        if (Files.isDirectory(path)) {
                            Files.createDirectories(Paths.get(destination).
                                    resolve(Paths.get(src).relativize(path)));
                        } else if (Files.isRegularFile(path)) {
                            System.out.println(path.getFileName());
                            ProgressBarUtils.copyCallback(path.toString(),
                                    Paths.get(destination).resolve(Paths.get(src).relativize(path)).toString(),
                                    progressCallBack);
                            System.out.println();
                            ProgressBarUtils.updateLog(path.toString(), destination, copyStartTime);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }
}
