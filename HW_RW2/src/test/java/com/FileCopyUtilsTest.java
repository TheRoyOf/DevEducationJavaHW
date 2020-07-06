package com;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileCopyUtilsTest {

    @Test
    void directoryContentInfo_TEST(@TempDir Path tempDir) throws IOException {
        Path aPath = tempDir.resolve("a.txt");
        Path bPath = tempDir.resolve("b.txt");
        Path cPath = tempDir.resolve("c.txt");
        Path dPath = tempDir.resolve("d.txt");

        Files.write(aPath, Collections.singleton("Data string 1"));
        Files.write(bPath, Collections.singleton("Data string 12"));
        Files.write(cPath, Collections.singleton("Data string 123"));
        Files.write(dPath, Collections.singleton("Data string 1234"));

        FileCopyUtils.directoryContentInfo(tempDir.toString(),"dirInfoFile.txt");

        assertTrue(Files.exists(tempDir.resolve("dirInfoFile.txt")));
    }

    @Test
    void copyDir_TEST(@TempDir Path tempDir1, @TempDir Path tempDir2) throws IOException {
        Path aPath = tempDir1.resolve("a.txt");
        Path bPath = tempDir1.resolve("b.txt");
        Path cPath = tempDir1.resolve("c.txt");
        Path dPath = tempDir1.resolve("d.txt");

        Files.write(aPath, Collections.singleton("Data string 1"));
        Files.write(bPath, Collections.singleton("Data string 12"));
        Files.write(cPath, Collections.singleton("Data string 123"));
        Files.write(dPath, Collections.singleton("Data string 1234"));

        FileCopyUtils.copyDir(tempDir1.toString(), tempDir2.toString());


        assertTrue(Files.exists(tempDir2.resolve("a.txt")));
        assertTrue(Files.exists(tempDir2.resolve("b.txt")));
        assertTrue(Files.exists(tempDir2.resolve("c.txt")));
        assertTrue(Files.exists(tempDir2.resolve("d.txt")));

        assertLinesMatch(Collections.singletonList("Data string 1"), Files.readAllLines(tempDir2.resolve("a.txt")));
        assertLinesMatch(Collections.singletonList("Data string 12"), Files.readAllLines(tempDir2.resolve("b.txt")));
        assertLinesMatch(Collections.singletonList("Data string 123"), Files.readAllLines(tempDir2.resolve("c.txt")));
        assertLinesMatch(Collections.singletonList("Data string 1234"), Files.readAllLines(tempDir2.resolve("d.txt")));
    }

    @Test
    void concatFiles_TEST(@TempDir Path tempDir) throws IOException {
        Path aPath = tempDir.resolve("a.txt");
        Path bPath = tempDir.resolve("b.txt");
        Path cPath = tempDir.resolve("c.txt");
        Path dPath = tempDir.resolve("d.txt");

        Files.write(aPath, Collections.singleton("Data string 1"));
        Files.write(bPath, Collections.singleton("Data string 12"));
        Files.write(cPath, Collections.singleton("Data string 123"));
        Files.write(dPath, Collections.singleton("Data string 1234"));

        FileCopyUtils.concatFiles("concat_rez.txt", aPath.toString(), bPath.toString(), cPath.toString(), dPath.toString());

        List<String> expected = Arrays.asList("[Data string 1]", "[Data string 12]", "[Data string 123]", "[Data string 1234]");

        assertTrue(Files.exists(tempDir.resolve("concat_rez.txt")));
        assertLinesMatch(expected, Files.readAllLines(tempDir.resolve("concat_rez.txt")));
    }
}