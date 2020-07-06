package com;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileCopyUtils {

    public static void directoryContentInfo(String dir, String fileInfoName) {
        Path srcPath = Paths.get(dir);
        Path result = srcPath.resolve(fileInfoName);
        List<Path> files = null;
        StringBuilder builder = new StringBuilder();

        try {
            files = Files.list(srcPath).filter(file -> file.getFileName().toString().equals(fileInfoName)).collect(Collectors.toList());

            for (Path file : files) {
                if (Files.isRegularFile(file))
                {
                    builder.append("Path: ")
                    .append(file.toAbsolutePath().toString())
                    .append(" Name: ")
                    .append(file.getFileName().toString())
                    .append(" Creation Date: ")
                    .append(Files.readAttributes(file, BasicFileAttributes.class).creationTime())
                    .append(System.lineSeparator());
                }
            }
            Files.write(result, builder.toString().getBytes(), StandardOpenOption.CREATE);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void copyDir(String srcDir, String destDir) {
        Path srcPath = Paths.get(srcDir);
        Path destPath = Paths.get(destDir);

        try (Stream<Path> walk = Files.walk(srcPath)) {
            walk.forEach(source -> {
                try {
                    Files.copy(source, destPath.resolve(srcPath.relativize(source)), StandardCopyOption.REPLACE_EXISTING);
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void concatFiles(String resultFileName, String... filePaths) {
        List<Path> files = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        for (String filePath : filePaths)
        {
            files.add(Paths.get(filePath));
        }

        for (Path file : files) {
            try {
                builder.append(Files.readAllLines(file))
                        .append(System.lineSeparator());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            Files.write(files.get(0).getParent().resolve(resultFileName), builder.toString().getBytes());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

