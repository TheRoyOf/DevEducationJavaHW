package com;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class ArchiverUtilsTest {

    @Test
    void zipTest(@TempDir Path tempDir) throws IOException {
        Path a = tempDir.resolve("a.txt");
        Path b = tempDir.resolve("b.txt");
        Path c = tempDir.resolve("c.txt");
        Path d = tempDir.resolve("d.txt");

        Files.write(a, "hello".getBytes());
        Files.write(b, "from".getBytes());
        Files.write(c, "java".getBytes());
        Files.write(d, "how are you?".getBytes());

        ArchiverUtils.zip(tempDir.toString(), tempDir.toString(), "Zip_File.zip");

        assertTrue(Files.exists(tempDir.resolve("Zip_File.zip")));
        assertTrue(Files.exists(a));
        assertTrue(Files.exists(b));
        assertTrue(Files.exists(c));
        assertTrue(Files.exists(d));
    }

    @Test
    void unzipTest(@TempDir Path tempDir) throws IOException {
        Path a = tempDir.resolve("a.txt");
        Path b = tempDir.resolve("b.txt");
        Path c = tempDir.resolve("c.txt");
        Path d = tempDir.resolve("d.txt");

        Files.write(a, "hello".getBytes());
        Files.write(b, "from".getBytes());
        Files.write(c, "java".getBytes());
        Files.write(d, "how are you?".getBytes());

        ArchiverUtils.zip(tempDir.toString(), tempDir.toString(), "Zip_File.zip");

        Files.delete(tempDir.resolve(a));
        Files.delete(tempDir.resolve(b));
        Files.delete(tempDir.resolve(c));
        Files.delete(tempDir.resolve(d));

        assertTrue(Files.exists(tempDir.resolve("Zip_File.zip")));
        assertFalse(Files.exists(a));
        assertFalse(Files.exists(b));
        assertFalse(Files.exists(c));
        assertFalse(Files.exists(d));

        ArchiverUtils.unzip(tempDir.resolve("Zip_File.zip").toString(),tempDir.toString());

        assertTrue(Files.exists(a));
        assertTrue(Files.exists(b));
        assertTrue(Files.exists(c));
        assertTrue(Files.exists(d));

        assertLinesMatch(Collections.singletonList("hello"), Files.readAllLines(a));
        assertLinesMatch(Collections.singletonList("from"), Files.readAllLines(b));
        assertLinesMatch(Collections.singletonList("java"), Files.readAllLines(c));
        assertLinesMatch(Collections.singletonList("how are you?"), Files.readAllLines(d));
    }

}