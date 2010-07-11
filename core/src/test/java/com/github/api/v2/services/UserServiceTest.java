/**
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

/**
 * @author nmukhtar
 *
 */
public class UserServiceTest extends BaseGitHubServiceTest {
	private UserService service;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		service = factory.createUserService();
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		service = null;
	}

	@Test
	public void testAddEmail() {
		service.addEmail("");
	}

	@Test
	public void testAddKey() {
		service.addKey("", "");
	}

	@Test
	public void testFollowUser() {
		service.followUser("");
	}

	@Test
	public void testGetCurrentUser() {
		User user = service.getCurrentUser();
		assertNotNull("User cannot be null.", user);
	}

	@Test
	public void testGetEmails() {
		List<String> emails = service.getEmails();
		assertNotNullOrEmpty("Emails cannot be null or empty.", emails);
	}

	@Test
	public void testGetKeys() {
		List<Key> keys = service.getKeys();
		assertNotNullOrEmpty("Keys cannot be null or empty.", keys);
	}

	@Test
	public void testGetUser() {
		User user = service.getUser("");
		assertNotNull("User cannot be null.", user);
	}

	@Test
	public void testGetUserFollowers() {
		List<String> userFollowers = service.getUserFollowers("");
		assertNotNullOrEmpty("User followers cannot be null or empty.", userFollowers);
	}

	@Test
	public void testGetUserFollowing() {
		List<String> userFollowing = service.getUserFollowing("");
		assertNotNullOrEmpty("User followering cannot be null or empty.", userFollowing);
	}

	@Test
	public void testGetWatchedRepositories() {
		List<Repository> repositories = service.getWatchedRepositories("");
		assertNotNullOrEmpty("Repositories cannot be null or empty.", repositories);
	}

	@Test
	public void testRemoveEmail() {
		service.removeEmail("");
	}

	@Test
	public void testRemoveKey() {
		service.removeKey("");
	}

	@Test
	public void testSearchUsersByEmail() {
		List<User> users = service.searchUsersByEmail("");
		assertNotNullOrEmpty("Users cannot be null or empty.", users);
	}

	@Test
	public void testSearchUsersByName() {
		List<User> users = service.searchUsersByName("");
		assertNotNullOrEmpty("Users cannot be null or empty.", users);
	}

	@Test
	public void testUnfollowUser() {
		service.unfollowUser("");
	}

	@Test
	public void testUpdateUser() {
//		service.updateUser(user);
	}
}
