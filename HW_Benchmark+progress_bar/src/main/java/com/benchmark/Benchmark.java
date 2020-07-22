package com.benchmark;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class Benchmark {

    private void createLog(String fileToLog, String destination, long startTime, int bufferSize, String copyType)
    {
        final String fileType = ".txt";
        StringBuilder strBuilder = new StringBuilder();
        Path file = Paths.get(fileToLog);

        try {
            strBuilder.append(System.lineSeparator());
            strBuilder.append("--------------------------------------------------------------------------------\n");
            strBuilder.append("| ").append("CPU: AMD Ryzen 5 3600 3.6GHz");
            strBuilder.append(" | ").append("RAM: HyperX DDR4 3200Mhz 16Gb");
            strBuilder.append(" | ").append("Kingston M2 SSD 968GB");
            strBuilder.append(" | \n");
            strBuilder.append("--------------------------------------------------------------------------------\n");
            strBuilder.append("=== Copy file ===\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Files.write(Paths.get(destination).getParent().resolve("CopyTest_" + copyType + "_" + humanReadableByteCountSI(Files.size(file)) + fileType),
                    strBuilder.toString().getBytes(),
                    StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void logUpdate(String fileToLog, String destination, long startTime, int bufferSize, String copyType)
    {
        final String fileType = ".txt";
        StringBuilder strBuilder = new StringBuilder();
        Path file = Paths.get(fileToLog);

        try {
            strBuilder.append(System.lineSeparator());
            strBuilder.append("File Size:      ");
            strBuilder.append(humanReadableByteCountSI(Files.size(file))).append("\n");
            strBuilder.append("Buffer Size:    ");
            strBuilder.append(humanReadableByteCountSI(bufferSize)).append("\n");
            strBuilder.append("Copy Duration:  ");
            strBuilder.append(timeFormatter((System.currentTimeMillis() - startTime)));
            strBuilder.append("\n");
            strBuilder.append("=================");
            strBuilder.append(System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.write(Paths.get(destination).getParent().resolve("CopyTest" + copyType + humanReadableByteCountSI(Files.size(file)) + fileType),
                    strBuilder.toString().getBytes(),
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copyBenchmarkIO(int bufferSize, String srcFile, String destination)
    {
        final String copyType = "IO";
        long startTime = System.currentTimeMillis();
        File copied = new File(destination);

        try (InputStream in = new BufferedInputStream(new FileInputStream(srcFile));
             OutputStream out = new BufferedOutputStream(new FileOutputStream(copied)))
        {

            byte[] buffer = new byte[bufferSize];
            int lengthRead;
            while ((lengthRead = in.read(buffer)) > 0)
            {
                out.write(buffer, 0, lengthRead);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        createLog(srcFile, destination, startTime, bufferSize, copyType);
        logUpdate(srcFile, destination, startTime, bufferSize, copyType);
    }

    public void copyBenchmarkNIO(int bufferSize, String srcFile, String destination)
    {
        final String copyType = "NIO_ByteBuffer";
        long startTime = System.currentTimeMillis();
        FileInputStream fin;
        FileOutputStream fout;

        try {
            fin = new FileInputStream(srcFile);
            fout = new FileOutputStream(destination);
            FileChannel input = fin.getChannel();
            FileChannel output = fout.getChannel();
            ByteBuffer buffer = ByteBuffer.allocateDirect(bufferSize);
            while (true)
            {
                int position = input.read(buffer);
                if (position == -1)
                    break;
                buffer.flip();
                output.write(buffer);
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        createLog(srcFile, destination, startTime, bufferSize, copyType);
        logUpdate(srcFile, destination, startTime, bufferSize, copyType);
    }

    private String humanReadableByteCountSI(long bytes)
    {
        if (-1000 < bytes && bytes < 1000)
        {
            return bytes + " B";
        }
        CharacterIterator ci = new StringCharacterIterator("kMGTPE");
        while (bytes <= -999_950 || bytes >= 999_950)
        {
            bytes /= 1000;
            ci.next();
        }
        return String.format("%.1f %cB", bytes / 1000.0, ci.current());
    }

    private String timeFormatter(long millis)
    {
        final int millisToSecsDivisor = 1000;
        long minutes = (millis / millisToSecsDivisor) / 60;
        long seconds = (millis / millisToSecsDivisor) % 60;
        return String.format("%dm %ds.", minutes, seconds);
    }
}
