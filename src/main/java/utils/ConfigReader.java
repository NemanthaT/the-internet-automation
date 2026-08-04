package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Loads run configuration (base URL, timeouts, browser) from config.properties.
 * Keeping this separate from test code means switching environments (e.g. a
 * staging mirror) is a one-line change, not a find-and-replace across tests.
 */
public class ConfigReader {

    private static Properties properties;

    private static void load() {
        if (properties == null) {
            properties = new Properties();
            try (FileInputStream input = new FileInputStream("src/test/resources/config.properties")) {
                properties.load(input);
            } catch (IOException e) {
                throw new RuntimeException("Could not load config.properties: " + e.getMessage(), e);
            }
        }
    }

    public static String get(String key) {
        load();
        return properties.getProperty(key);
    }

    public static String getBaseUrl() {
        return get("base.url");
    }

    public static int getExplicitWaitSeconds() {
        return Integer.parseInt(get("explicit.wait.seconds"));
    }
}
