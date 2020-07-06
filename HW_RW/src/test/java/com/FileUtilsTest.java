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

class FileUtilsTest {

    @Test
    void WriteSortLines_TEST(@TempDir Path tempDir1, @TempDir Path tempDir2) throws IOException {
        Path strings = tempDir1.resolve("testData.txt");
        List<String> lines = Arrays.asList("tests", "line", "work with files");
        Files.write(strings, lines);

        FileUtils.WriteSortLines(strings.toString(), tempDir2.toString(), SortDirection.ASCENDING);

        List<String> expected = Arrays.asList("line", "tests", "work with files");

        assertTrue(Files.exists(tempDir2.resolve("testData.txt")));
        assertLinesMatch(expected, Files.readAllLines(tempDir2.resolve("testData.txt")));

    }

    @Test
    void writeToFiles_TEST(@TempDir Path tempDir) throws IOException {
        Path strings = tempDir.resolve("testData.txt");
        List<String> lines = Arrays.asList("line", "test", "work with files");
        Files.write(strings, lines);

        FileUtils.writeToFiles(strings.toString(), SortDirection.ASCENDING);

        Path l = tempDir.resolve("l.txt");
        Path t = tempDir.resolve("t.txt");
        Path w = tempDir.resolve("w.txt");
        Path f = tempDir.resolve("f.txt");

        assertLinesMatch(Collections.singletonList("line "), Files.readAllLines(l));
        assertLinesMatch(Collections.singletonList("test "), Files.readAllLines(t));
        assertLinesMatch(Collections.singletonList("work with "), Files.readAllLines(w));
        assertLinesMatch(Collections.singletonList("files "), Files.readAllLines(f));
    }
}