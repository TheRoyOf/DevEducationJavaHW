package HW.homework_11_12_13_read_write.homework_13_compress;

import HW.homework_11_12_13_read_write.config_reader.ConfigReader;
import HW.homework_11_12_13_read_write.config_reader.IConfigReader;

public class Main {

    public static void main(String[] args) {
        IConfigReader configReader = new ConfigReader("config.txt");
        String destFolder = configReader.getDestinationFolder();
        String toUnzip = configReader.getDestinationFolder() + "Zip_File.zip";

//        ArchiverUtils.zip("C:/Users/User/Desktop/a", destFolder, "Zip_File.zip");
//        ArchiverUtils.unzip(toUnzip,destFolder);
    }
}
