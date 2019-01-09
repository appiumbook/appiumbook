/**
 * Year: 2018-2019
 * Pratik Patel
 */
package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * This class is used to get the configuration properties from the .properties file
 */
public class PropertyUtils {

    private static PropertyUtils INSTANCE = null;
    private final Properties props = new Properties();

    private PropertyUtils() {
        this.loadProperties("configuration.properties");
        this.props.putAll(System.getProperties());
    }

    private static PropertyUtils getInstance() {
        if (PropertyUtils.INSTANCE == null) {
            PropertyUtils.INSTANCE = new PropertyUtils();
        }
        return PropertyUtils.INSTANCE;
    }

    /**
     * This method can read Property value for any given key
     *
     * @param key
     * @return
     */
    public static String getProperty(final String key) {
        return PropertyUtils.getInstance().props.getProperty(key);
    }

    /**
     * This method will read any integer property value
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public static int getIntegerProperty(final String key, final int defaultValue) {
        int integerValue = 0;
        final String value = PropertyUtils.getInstance().props.getProperty(key);
        if (value == null) {
            return defaultValue;
        }
        integerValue = Integer.parseInt(value);
        return integerValue;
    }

    /**
     * If key couldn't be found then it will return default value
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getProperty(final String key, final String defaultValue) {
        return PropertyUtils.getInstance().props.getProperty(key, defaultValue);
    }

    /**
     * This method will load properties file in Properties object
     *
     * @param path
     */
    public void loadProperties(final String path) {
        InputStream inputStream = null;
        try {
            inputStream = ClassLoader.getSystemResourceAsStream(path);
            System.out.println(inputStream);
            if (inputStream != null) {
                this.props.load(inputStream);
            } else {
                throw new UnableToLoadPropertiesException("property file '" + path + "' not found in the classpath");
            }
        } catch (final Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }

        return;
    }

    /**
     * @return Properties
     */
    public static Properties getProps() {
        return PropertyUtils.getInstance().props;
    }

}

class UnableToLoadPropertiesException extends RuntimeException {

    UnableToLoadPropertiesException(final String s) {
        super(s);
    }

    public UnableToLoadPropertiesException(final String string, final Exception ex) {
        super(string, ex);
    }
}