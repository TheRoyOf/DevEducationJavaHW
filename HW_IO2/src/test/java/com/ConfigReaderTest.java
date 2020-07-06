package com;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfigReaderTest {
    static ConfigData configDataTest = new ConfigData();

    @BeforeAll
    static void beforeAll() {
        configDataTest.source = "test Src";
        configDataTest.destination = "test Dest";
        configDataTest.props = "test props";
    }

    @Test
    void readFromFileTest() {
        ConfigReader configReader = new ConfigReader();
        assertEquals("Source=1\n" +
                "Destination=2\n" +
                "Property=3",configReader.readFromFile("src/test/java/com/configFileTest.properties"));
    }

    @Test
    void writeToFileTest() {
        ConfigReader configReader = new ConfigReader();
        assertTrue(configReader.writeToFile("Source=src\n" +
                "Destination=dest\n" +
                "Property=props", "src/test/java/com/configFileWriteToFileTest.properties"));
    }

    @Test
    void makeStringPropertyTest() {
        ConfigReader configReader = new ConfigReader();

        assertEquals("Source=sourse\n" +
                "Destination=destination\n" +
                "Property=properties",configReader.makeStringProperty("sourse", "destination", "properties"));
    }

    @Test
    void getPropertyFromStringTest() {
        ConfigReader configReader = new ConfigReader();

        ConfigData data = new ConfigData();
        data.props = "3";
        data.destination = "2";
        data.source = "1";

        assertEquals(data, configReader.getPropertyFromString("Source=1\n" +
                "Destination=2\n" +
                "Property=3"));
    }
}