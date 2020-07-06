package com;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;
import java.util.Random;


public class FileUtils {

    public static void WriteSortLines(String src, String dest, SortDirection sortDirection) {

        Path srcPath = Paths.get(src);
        Path destPath = Paths.get(dest);

        Comparator<String> comp = compSelector(sortDirection);

        try {
            String lines = Files.lines(srcPath).sorted(comp).collect(Collectors.joining(System.lineSeparator()));
            Files.write(destPath.resolve(srcPath.getFileName()), lines.getBytes(), StandardOpenOption.CREATE);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void writeToFiles(String src, SortDirection sortDirection)
    {
        Path srcPath = Paths.get(src);
        Comparator<String> comparator = compSelector(sortDirection);
        List<String> lines = split(src);
        lines.sort(comparator);

        for (String line : lines) {
            line = line + " ";

            try {
                Files.write(srcPath.getParent().resolve(line.charAt(0) + ".txt"),line.getBytes(),
                        StandardOpenOption.APPEND,StandardOpenOption.CREATE);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void copyAndRename(String src, String dest)
    {
        AtomicInteger index = new AtomicInteger();
        Path srcPath = Paths.get(src);
        Path destPath = Paths.get(dest);
        List<Integer> names = randomFilenames(srcPath);

        try (Stream<Path> walk = Files.walk(srcPath))
        {
            walk.filter(Files::isRegularFile)
                    .forEach(path -> {
                        try {
                            Files.copy(path,destPath.resolve(names.get(index.getAndIncrement()) + ".txt"),REPLACE_EXISTING);
                        }
                        catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static List<Integer> randomFilenames(Path src)
    {
        Random random = new Random();
        List<Integer> rezult = null;

        try {
            int count = (int) Files.list(src).count();
            rezult = random.ints(1, count + 1)
                    .distinct()
                    .limit(count)
                    .boxed()
                    .collect(Collectors.toList());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return rezult;
    }

    private static List<String> split(String path)
    {
        String str = "";

        try
        {
            str = Files.lines(Paths.get(path)).collect(Collectors.joining(" "));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return Stream.of(str.split(" ")).map(String::toLowerCase).collect(Collectors.toList());
    }

    private static Comparator<String> compSelector(SortDirection sortDirection)
    {
        if (sortDirection == SortDirection.ASCENDING)
        {
            return Comparator.comparingInt(String::length);
        }
        else
        {
            return Comparator.comparingInt(String::length).reversed();
        }
    }
}
