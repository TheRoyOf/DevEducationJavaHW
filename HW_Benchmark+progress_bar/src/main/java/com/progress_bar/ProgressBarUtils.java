package com.progress_bar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.CharacterIterator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.StringCharacterIterator;
import java.util.Collections;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ProgressBarUtils
{
    public static final String doneState = "\n" + "      [===========================================100% Done" +
            "=================================================]";


    public static void copyCallback(String source, String destination, ProgressCallback callBack) throws IOException {
        FileOutputStream fos = null;
        FileChannel sourceChannel = null;

        try {
            sourceChannel = new FileInputStream(new File(source)).getChannel();
            ReadableByteChannel rbc = new CallbackByteChannel(sourceChannel, Files.size(Paths.get(source)), callBack);
            fos = new FileOutputStream(destination);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert sourceChannel != null;
            if (sourceChannel.isOpen()) {
                sourceChannel.close();
            }
            assert fos != null;
            fos.close();
        }
    }

    public static void createLog(String destination) {
        StringBuilder title = new StringBuilder();
        title.append("-----------------+-----------------+-----------------+------------------").append("\n")
                .append("    file name    |    file size    |  modified time  |  copy duration  |").append("\n")
                .append("-----------------+-----------------+-----------------+------------------").append("\n");

        try {
            Files.write(Paths.get(destination).resolve("log.txt"),
                    title.toString().getBytes(),
                    StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateLog(String fileToLog, String destination, long startTime) throws IOException {
        Path file = Paths.get(fileToLog);
        String fileName = file.getFileName().toString();
        fileName = fileName.length() > 17 ? fileName.substring(0, 14) + "..." : fileName;

        DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        String size = humanReadableByteCountSI(Files.size(file));
        String time = (df.format(new Date(file.toFile().lastModified())));
        String pTime = timeFormatter(System.currentTimeMillis() - startTime);
        String result = String.format("%-17s|%-17s|%-17s|%-17s|\n", fileName, size, time, pTime);

        try {
            Files.write(Paths.get(destination).resolve("log.txt"),
                    result.getBytes(),
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Path checkExistence(String zipFilePath) {
        final String ext = ".zip";
        zipFilePath = zipFilePath + ext;
        try {
            if (Files.exists(Paths.get(zipFilePath))) {
                Files.delete(Paths.get(zipFilePath));
            }
            return Files.createFile(Paths.get(zipFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String timeFormatter(long millis) {
        final int millisToSecsDivisor = 1000;
        long minutes = (millis / millisToSecsDivisor) / 60;
        long seconds = (millis / millisToSecsDivisor) % 60;
        return String.format("%dm %ds.", minutes, seconds);
    }

    public static String humanReadableByteCountSI(long bytes) {
        if (-1000 < bytes && bytes < 1000) {
            return bytes + " B";
        }
        CharacterIterator ci = new StringCharacterIterator("kMGTPE");
        while (bytes <= -999_950 || bytes >= 999_950) {
            bytes /= 1000;
            ci.next();
        }
        return String.format("%.1f %cB", bytes / 1000.0, ci.current());
    }

    public static void printProgress(long startTime, long total, long current, int percent) {
        long eta = current == 0 ? 0 :
                (total - current) * (System.currentTimeMillis() - startTime) / current;

        String etaTime = "";

        if (current == 0)
        {
            etaTime = "N/A";
        }
        else
        {
            etaTime = String.format("%02d:%02d:%02d",
                            TimeUnit.MILLISECONDS.toHours(eta),
                            TimeUnit.MILLISECONDS.toMinutes(eta) % TimeUnit.HOURS.toMinutes(1),
                            TimeUnit.MILLISECONDS.toSeconds(eta) % TimeUnit.MINUTES.toSeconds(1));
        }

        String string = '\r' +
                String.join("", Collections.nCopies(percent == 0 ? 2 : 2 - (int) (Math.log10(percent)), " ")) + String.format(" %d%% [", percent) +
                String.join("", Collections.nCopies(percent, "=")) + '>' +
                String.join("", Collections.nCopies(100 - percent, " ")) + ']' +
                String.join("", Collections.nCopies(
                        current == 0 ? (int) (Math.log10(total)) : (int) (Math.log10(total)) - (int) (Math.log10(current)), " ")) +
                String.format(" %d/%d, ETA: %s", current, total, etaTime);
        System.out.print(string);
    }
}
