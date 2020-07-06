package com;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ArchiverUtils {

    public static void zip(String sourceFolderPath, String destFolderPath, String zipFileName) {

        if (sourceFolderPath == null || destFolderPath == null || zipFileName == null){
            throw new IllegalArgumentException("Paths and filenames cannot be null");
        }

        try {
            Path temp = Files.createTempDirectory("temp");
            final Path src = Paths.get(sourceFolderPath);
            Path tempZip = temp.resolve(zipFileName);
            Path dest = Paths.get(destFolderPath);
            final ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(tempZip.toFile()));

            
            Files.walkFileTree(src, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    zos.putNextEntry(new ZipEntry(src.relativize(file).toString()));
                    Files.copy(file, zos);
                    zos.closeEntry();
                    return FileVisitResult.CONTINUE;
                }
            });

            zos.close();
            Files.copy(tempZip, dest.resolve(tempZip.getParent().relativize(tempZip)), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void unzip(String zipFilePath, String destinationFolder) {

        if (zipFilePath == null || destinationFolder == null){
            throw new IllegalArgumentException("Paths and filenames cannot be null");
        }

        Path dest = Paths.get(destinationFolder);

        try {
            try (ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath))) {

                for (ZipEntry ze; (ze = zipIn.getNextEntry()) != null; ) {
                    Path resolvedPath = dest.resolve(ze.getName());
                    if (ze.isDirectory()) {
                        Files.createDirectories(resolvedPath);
                    } else {
                        Files.createDirectories(resolvedPath.getParent());
                        Files.copy(zipIn, resolvedPath, StandardCopyOption.REPLACE_EXISTING);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
