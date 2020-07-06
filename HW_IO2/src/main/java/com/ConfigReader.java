package com;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class ConfigReader {
    ConfigData configData = new ConfigData();

    public String readFromFile(String path) {
        File file = new File(path);
        if (!file.exists()) {
            return null;
        }

        try (FileReader reader = new FileReader(file)) {
            int c;
            StringBuilder str = new StringBuilder();
            while ((c = reader.read()) != -1) {
                str.append((char) c);
            }

            return str.toString();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }

    public boolean writeToFile(String data, String path) {
        File file = new File(path);
        if (!file.exists()) {
            try {
                if (!file.createNewFile()) {
                    return false;
                }
            } catch (IOException exception) {
                System.out.println(exception.getMessage());
            }
        }

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(data);
            writer.flush();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        return true;
    }

    public String makeStringProperty(String source, String destination, String props) {
        return "Source=" + source + "\nDestination=" + destination + "\nProperty=" + props;
    }

    public ConfigData getPropertyFromString(String props) {
        ConfigData configData = new ConfigData();
        String[] lines = props.split("\n");

        for (String line : lines) {
            String[] data = line.split("=");
            switch (data[0]) {
                case ("Source"):
                    configData.source = data[1];
                    break;
                case ("Destination"):
                    configData.destination = data[1];
                    break;
                case ("Property"):
                    configData.props = data[1];
                    break;
            }
        }

        return configData;
    }

    public String getParam(String propsName, String configFileName) {

        try {
            return Files.lines(Paths.get(configFileName)).filter(s -> s.startsWith(propsName))
                    .map(s -> s.substring(s.length())).collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getSource() {
        return configData.source;
    }

    public String getDestination() {
        return configData.destination;
    }

    public String getProps() {
        return configData.props;
    }
}
