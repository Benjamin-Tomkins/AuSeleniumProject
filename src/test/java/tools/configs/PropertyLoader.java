package tools.configs;

import tools.Constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * This file loads settings located in config files for use in tests <br>
 * This allows for easy access to variables and allows for tests to be easily changed if new data is required
 */

public class PropertyLoader {

    private static Properties prop = new Properties();
    private static InputStream input;

    public static String getProperty(String propertyKey) {
        String result = "";
        String configFile = System.getProperty("configFile") == null ? "local" : System.getProperty("configFile");
        try {
            input = new FileInputStream(Constants.CONFIG_RESOURCES_PATH + configFile + "-config.properties");
            prop.load(input);
            result = prop.getProperty(propertyKey);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

//    public static String getProperty(String propertyKey) {
//        return getProperty(propertyKey);
//    }
}
