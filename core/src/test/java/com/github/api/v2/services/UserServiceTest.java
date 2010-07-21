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
package com.github.api.v2.services;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.api.v2.schema.Key;
import com.github.api.v2.schema.Repository;
import com.github.api.v2.schema.User;
import com.github.api.v2.services.constant.TestConstants;

/**
 * The Class UserServiceTest.
 */
public class UserServiceTest extends BaseGitHubServiceTest {
	
	/** The service. */
	private UserService service;

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.BaseGitHubServiceTest#setUp()
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
		service = factory.createUserService();
		service.setAuthentication(authentication);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.BaseGitHubServiceTest#tearDown()
	 */
	@After
	public void tearDown() throws Exception {
		super.tearDown();
		service = null;
	}

	/**
	 * Test add email.
	 */
	@Test
	public void testAddEmail() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Email."), TestConstants.TEST_EMAIL);
		service.addEmail(TestConstants.TEST_EMAIL);
	}

	/**
	 * Test add key.
	 */
	@Test
	public void testAddKey() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Key Title."), TestConstants.TEST_KEY_TITLE);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Key."), TestConstants.TEST_KEY);
		service.addKey(TestConstants.TEST_KEY_TITLE, TestConstants.TEST_KEY);
	}

	/**
	 * Test follow user.
	 */
	@Test
	public void testFollowUser() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
		service.followUser(TestConstants.TEST_USER_NAME);
	}

	/**
	 * Test get current user.
	 */
	@Test
	public void testGetCurrentUser() {
		User user = service.getCurrentUser();
		assertNotNull("User cannot be null.", user);
	}

	/**
	 * Test get emails.
	 */
	@Test
	public void testGetEmails() {
		List<String> emails = service.getEmails();
		assertNotNullOrEmpty("Emails cannot be null or empty.", emails);
	}

	/**
	 * Test get keys.
	 */
	@Test
	public void testGetKeys() {
		List<Key> keys = service.getKeys();
		assertNotNullOrEmpty("Keys cannot be null or empty.", keys);
	}

	/**
	 * Test get user by username.
	 */
	@Test
	public void testGetUserByUsername() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
		User user = service.getUserByUsername(TestConstants.TEST_USER_NAME);
		assertNotNull("User cannot be null.", user);
	}

	/**
	 * Test get user followers.
	 */
	@Test
	public void testGetUserFollowers() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
		List<String> userFollowers = service.getUserFollowers(TestConstants.TEST_USER_NAME);
		assertNotNullOrEmpty("User followers cannot be null or empty.", userFollowers);
	}

	/**
	 * Test get user following.
	 */
	@Test
	public void testGetUserFollowing() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
		List<String> userFollowing = service.getUserFollowing(TestConstants.TEST_USER_NAME);
		assertNotNullOrEmpty("User followering cannot be null or empty.", userFollowing);
	}

	/**
	 * Test get watched repositories.
	 */
	@Test
	public void testGetWatchedRepositories() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
		List<Repository> repositories = service.getWatchedRepositories(TestConstants.TEST_USER_NAME);
		assertNotNullOrEmpty("Repositories cannot be null or empty.", repositories);
	}

	/**
	 * Test remove email.
	 */
	@Test
	public void testRemoveEmail() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Email."), TestConstants.TEST_EMAIL);
		service.removeEmail(TestConstants.TEST_EMAIL);
	}

	/**
	 * Test remove key.
	 */
	@Test
	public void testRemoveKey() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Key Id."), TestConstants.TEST_KEY_ID);
		service.removeKey(TestConstants.TEST_KEY_ID);
	}

	/**
	 * Test get user by email.
	 */
	@Test
	public void testGetUserByEmail() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Email."), TestConstants.TEST_EMAIL);
		User user = service.getUserByEmail(TestConstants.TEST_EMAIL);
		assertNotNull("User cannot be null or empty.", user);
	}

	/**
	 * Test search users by name.
	 */
	@Test
	public void testSearchUsersByName() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
		List<User> users = service.searchUsersByName(TestConstants.TEST_USER_NAME);
		assertNotNullOrEmpty("Users cannot be null or empty.", users);
	}

	/**
	 * Test unfollow user.
	 */
	@Test
	public void testUnfollowUser() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
		service.unfollowUser(TestConstants.TEST_USER_NAME);
	}

	/**
	 * Test update user.
	 */
	@Test
	public void testUpdateUser() {
//		service.updateUser(user);
	}
}
