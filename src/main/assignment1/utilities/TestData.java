package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestData {
    File file;

    FileInputStream fileInput = null;

    Properties prop;

    public TestData() {
        file = new File("TestData.properties");
        prop = new Properties();
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String getData(String propertyName){

        return prop.getProperty(propertyName);

    }
}
