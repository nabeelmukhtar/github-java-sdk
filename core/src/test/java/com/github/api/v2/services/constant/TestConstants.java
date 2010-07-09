/**
 *
 */
package com.github.api.v2.services.constant;
import java.io.IOException;
import java.util.Properties;

/**
 * The Class TestConstants.
 */
public final class TestConstants {

    /** The Constant TEST_CONSTANTS_FILE. */
    public static final String TEST_CONSTANTS_FILE = "TestConstants.properties";

    /** The Constant testConstants. */
    private static final Properties testConstants = new Properties();

    static {
        try {
            testConstants.load(TestConstants.class.getResourceAsStream(TEST_CONSTANTS_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /** The Constant TEST_API_KEY. */
    public static final String TEST_API_KEY =
        testConstants.getProperty("com.github.api.v2.services.apiKey");
    
    /** The Constant TEST_REFERRER. */
    public static final String TEST_REFERRER =
        testConstants.getProperty("com.github.api.v2.services.referrer");
    
    /** The Constant TEST_QUERY. */
    public static final String TEST_QUERY =
        testConstants.getProperty("com.github.api.v2.services.testQuery");
    
    /** The Constant TEST_USER_NAME. */
    public static final String TEST_USER_NAME =
        testConstants.getProperty("com.github.api.v2.services.testUserName");

    /** The Constant TEST_REPOSITORY_NAME. */
    public static final String TEST_REPOSITORY_NAME =
        testConstants.getProperty("com.github.api.v2.services.testRepositoryName");

    /** The Constant TEST_REPOSITORY_NAME. */
    public static final String TEST_EMAIL =
        testConstants.getProperty("com.github.api.v2.services.testEmail");
    
    /** The Constant TEST_REPOSITORY_NAME. */
    public static final String TEST_ISSUE_NUMBER =
        testConstants.getProperty("com.github.api.v2.services.testIssueNo");
    /** The Constant TEST_REPOSITORY_NAME. */
    public static final String TEST_COMMIT_HASH =
        testConstants.getProperty("com.github.api.v2.services.testCommitHash");
    /**
     * Instantiates a new test constants.
     */
    private TestConstants() {}
}
