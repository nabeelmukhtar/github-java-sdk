/**
 *
 */
package com.github.api.v2.services.constant;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Class ApplicationConstants.
 */
public final class ApplicationConstants {

    /** The Constant APP_CONSTANTS_FILE. */
    public static final String APP_CONSTANTS_FILE = "ApplicationConstants.properties";

    /** The Constant LOG. */
    private static final Logger LOG = Logger.getLogger(ApplicationConstants.class.getCanonicalName());
    
    /** The Constant applicationConstants. */
    private static final Properties applicationConstants = new Properties();

    static {
        try {
            applicationConstants.load(
                ApplicationConstants.class.getResourceAsStream(APP_CONSTANTS_FILE));
        } catch (IOException e) {
            LOG.log(Level.SEVERE, "An error occurred while loading properties.", e);
        }
    }

    /** The Constant CONTENT_ENCODING. */
    public static final String CONTENT_ENCODING = getProperty("com.github.api.v2.services.encoding");

    /** The Constant DEFAULT_API_VERSION. */
    public static final String DEFAULT_API_VERSION = getProperty("com.github.api.v2.services.defaultApiVersion");
    
    /** The Constant DEFAULT_API_VERSION. */
    public static final String DEFAULT_FORMAT = getProperty("com.github.api.v2.services.defaultFormat");
    
    /** The Constant RFC822DATEFORMAT. */
    public static final String DATE_FORMAT = getProperty("com.github.api.v2.services.dateFormat");
    
    /** The Constant CONNECT_TIMEOUT. */
    public static final int CONNECT_TIMEOUT = getIntProperty("com.github.api.v2.services.connectTimeout");
    
    /** The Constant READ_TIMEOUT. */
    public static final int READ_TIMEOUT = getIntProperty("com.github.api.v2.services.readTimeout");
    
    /**
     * Instantiates a new application constants.
     */
    private ApplicationConstants() {}

    /**
     * Gets the property.
     * 
     * @param key the key
     * 
     * @return the property
     */
    public static String getProperty(String key) {
        return applicationConstants.getProperty(key);
    }

    /**
     * Gets the int property.
     * 
     * @param key the key
     * 
     * @return the int property
     */
    public static int getIntProperty(String key) {
        String property = applicationConstants.getProperty(key);

        if (isNullOrEmpty(property)) {
            return 0;
        } else {
            return Integer.parseInt(property);
        }
    }

    /**
     * Gets the boolean property.
     * 
     * @param key the key
     * 
     * @return the boolean property
     */
    public static boolean getBooleanProperty(String key) {
        String property = applicationConstants.getProperty(key);

        if (isNullOrEmpty(property)) {
            return false;
        } else {
            return Boolean.parseBoolean(property);
        }
    }

    /**
     * Gets the double property.
     * 
     * @param key the key
     * 
     * @return the double property
     */
    public static double getDoubleProperty(String key) {
        String property = applicationConstants.getProperty(key);

        if (isNullOrEmpty(property)) {
            return 0;
        } else {
            return Double.parseDouble(property);
        }
    }

    /**
     * Gets the long property.
     * 
     * @param key the key
     * 
     * @return the long property
     */
    public static long getLongProperty(String key) {
        String property = applicationConstants.getProperty(key);

        if (isNullOrEmpty(property)) {
            return 0;
        } else {
            return Long.parseLong(property);
        }
    }

    /**
     * Checks if is null or empty.
     * 
     * @param s the s
     * 
     * @return true, if is null or empty
     */
    private static boolean isNullOrEmpty(String s) {
        return ((s == null) || s.length() == 0);
    }
}
