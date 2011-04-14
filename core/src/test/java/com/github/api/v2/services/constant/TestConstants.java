/*
 * Copyright 2010 Nabeel Mukhtar 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
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
    
    /** The Constant TEST_CLIENT_ID. */
    public static final String TEST_CLIENT_ID = testConstants.getProperty("com.github.api.v2.services.clientId");
    
    /** The Constant TEST_CLIENT_SECRET. */
    public static final String TEST_CLIENT_SECRET = testConstants.getProperty("com.github.api.v2.services.clientSecret");
    
    /** The Constant TEST_CODE. */
    public static final String TEST_CODE = testConstants.getProperty("com.github.api.v2.services.code");
    
    /** The Constant TEST_ACCESS_TOKEN. */
    public static final String TEST_ACCESS_TOKEN = testConstants.getProperty("com.github.api.v2.services.accessToken");
    
    /** The Constant TEST_CALLBACK_URL. */
    public static final String TEST_CALLBACK_URL = testConstants.getProperty("com.github.api.v2.services.callbackUrl");
    
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

    /** The Constant TEST_EMAIL. */
    public static final String TEST_EMAIL =
        testConstants.getProperty("com.github.api.v2.services.testEmail");
    
    /** The Constant TEST_ISSUE_NUMBER. */
    public static final String TEST_ISSUE_NUMBER =
        testConstants.getProperty("com.github.api.v2.services.testIssueNo");
    
    /** The Constant TEST_COMMIT_HASH. */
    public static final String TEST_COMMIT_HASH =
        testConstants.getProperty("com.github.api.v2.services.testCommitHash");
    
    /** The Constant TEST_GIST_ID. */
    public static final String TEST_GIST_ID =
        testConstants.getProperty("com.github.api.v2.services.testGistId");
    
    /** The Constant TEST_GIST_FILE. */
    public static final String TEST_GIST_FILE =
        testConstants.getProperty("com.github.api.v2.services.testGistFile");
    
    /** The Constant TEST_ISSUE_COMMENT. */
    public static final String TEST_ISSUE_COMMENT =
        testConstants.getProperty("com.github.api.v2.services.testIssueComment");
    
    /** The Constant TEST_ISSUE_LABEL. */
    public static final String TEST_ISSUE_LABEL =
        testConstants.getProperty("com.github.api.v2.services.testIssueLabel");
    
    /** The Constant TEST_ISSUE_TITLE. */
    public static final String TEST_ISSUE_TITLE =
        testConstants.getProperty("com.github.api.v2.services.testIssueTitle");
    
    /** The Constant TEST_ISSUE_BODY. */
    public static final String TEST_ISSUE_BODY =
        testConstants.getProperty("com.github.api.v2.services.testIssueBody");
	
	/** The Constant TEST_NETWORK_HASH. */
	public static final String TEST_NETWORK_HASH =
    	testConstants.getProperty("com.github.api.v2.services.testNetworkHash");
	
	/** The Constant TEST_TREE_SHA. */
	public static final String TEST_TREE_SHA =
    	testConstants.getProperty("com.github.api.v2.services.testTreeHash");
	
	/** The Constant TEST_FILE_PATH. */
	public static final String TEST_FILE_PATH =
    	testConstants.getProperty("com.github.api.v2.services.testFilePath");
	
	/** The Constant TEST_KEY_TITLE. */
	public static final String TEST_KEY_TITLE =
		testConstants.getProperty("com.github.api.v2.services.testKeyTitle");
	
	/** The Constant TEST_KEY. */
	public static final String TEST_KEY =
		testConstants.getProperty("com.github.api.v2.services.testKey");
	
	/** The Constant TEST_REPOSITORY_DESC. */
	public static final String TEST_REPOSITORY_DESC = 
		testConstants.getProperty("com.github.api.v2.services.testRepositoryDesc");
	
	/** The Constant TEST_REPOSITORY_PAGE. */
	public static final String TEST_REPOSITORY_PAGE = 
		testConstants.getProperty("com.github.api.v2.services.testRepositoryPage");
	
	/** The Constant TEST_KEY_ID. */
	public static final String TEST_KEY_ID = 
		testConstants.getProperty("com.github.api.v2.services.testKeyId");

	/** The Constant TEST_BASE_SHA. */
	public static final String TEST_BASE_SHA = testConstants.getProperty("com.github.api.v2.services.testBaseSha");
	
	/** The Constant TEST_HEAD_SHA. */
	public static final String TEST_HEAD_SHA = testConstants.getProperty("com.github.api.v2.services.testHeadSha");
	
	/** The Constant TEST_ORGANIZATION_NAME. */
	public static final String TEST_ORGANIZATION_NAME = testConstants.getProperty("com.github.api.v2.services.testOrgName");

	/** The Constant TEST_TEAM_NAME. */
	public static final String TEST_TEAM_NAME = testConstants.getProperty("com.github.api.v2.services.testTeamName");
    
	/** The Constant TEST_PULL_REQUEST_NUMBER. */
	public static final String TEST_PULL_REQUEST_NUMBER = testConstants.getProperty("com.github.api.v2.services.testPullRequestNumber");

	/** The Constant TEST_JOB_ID. */
	public static final String TEST_JOB_ID = testConstants.getProperty("com.github.api.v2.services.testJobId");

	/** The Constant TEST_JOB_QUERY. */
	public static final String TEST_JOB_QUERY = testConstants.getProperty("com.github.api.v2.services.testJobQuery");
	
    /**
	 * Instantiates a new test constants.
	 */
    private TestConstants() {}
}
