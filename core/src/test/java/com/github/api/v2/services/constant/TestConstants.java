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
    public static final String TEST_GIST_ID =
        testConstants.getProperty("com.github.api.v2.services.testGistId");
    public static final String TEST_GIST_FILE =
        testConstants.getProperty("com.github.api.v2.services.testGistFile");
    public static final String TEST_ISSUE_COMMENT =
        testConstants.getProperty("com.github.api.v2.services.testIssueComment");
    public static final String TEST_ISSUE_LABEL =
        testConstants.getProperty("com.github.api.v2.services.testIssueLabel");
    public static final String TEST_ISSUE_TITLE =
        testConstants.getProperty("com.github.api.v2.services.testIssueTitle");
    public static final String TEST_ISSUE_BODY =
        testConstants.getProperty("com.github.api.v2.services.testIssueBody");
	public static final String TEST_NETWORK_HASH =
    	testConstants.getProperty("com.github.api.v2.services.testNetworkHash");
	public static final String TEST_TREE_SHA =
    	testConstants.getProperty("com.github.api.v2.services.testTreeHash");
	public static final String TEST_FILE_PATH =
    	testConstants.getProperty("com.github.api.v2.services.testFilePath");
	public static final String TEST_KEY_TITLE =
		testConstants.getProperty("com.github.api.v2.services.testKeyTitle");
	public static final String TEST_KEY =
		testConstants.getProperty("com.github.api.v2.services.testKey");
	public static final String TEST_REPOSITORY_DESC = 
		testConstants.getProperty("com.github.api.v2.services.testRepositoryDesc");
	public static final String TEST_REPOSITORY_PAGE = 
		testConstants.getProperty("com.github.api.v2.services.testRepositoryPage");
	public static final String TEST_KEY_ID = 
		testConstants.getProperty("com.github.api.v2.services.testKeyId");
    /**
     * Instantiates a new test constants.
     */
    private TestConstants() {}
}
