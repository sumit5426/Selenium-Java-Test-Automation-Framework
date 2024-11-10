package uiutility;

import Constants.Env;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
    public static String readProperty(Env env, String propertyName) {
        File propFile = new File(System.getProperty("user.dir") + "\\config\\"+env+".properties");
        FileReader fileReader = null;
        Properties properties = new Properties();

        try {
            fileReader = new FileReader(propFile);
            properties.load(fileReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String value = properties.getProperty(propertyName.toUpperCase());
        return value;
    }
}
