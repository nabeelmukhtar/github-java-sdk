/**
 * 
 */
package com.github.api.v2.services;

import java.util.List;

import com.github.api.v2.schema.Key;
import com.github.api.v2.schema.Repository;
import com.github.api.v2.schema.User;

/**
 * The Interface UserService.
 */
public interface UserService extends GitHubService {
	
	/**
	 * Search users by name.
	 * 
	 * @param name
	 *            the name
	 * 
	 * @return the list< user>
	 */
	public List<User> searchUsersByName(String name);
	
	/**
	 * Gets the user by email.
	 * 
	 * @param email
	 *            the email
	 * 
	 * @return the user by email
	 */
	public User getUserByEmail(String email);
	
	/**
	 * Gets the user by username.
	 * 
	 * @param userName
	 *            the user name
	 * 
	 * @return the user by username
	 */
	public User getUserByUsername(String userName);
	
	/**
	 * Gets the current user.
	 * 
	 * @return the current user
	 */
	public User getCurrentUser();
	
	/**
	 * Update user.
	 * 
	 * @param user
	 *            the user
	 */
	public void updateUser(User user);
	
	/**
	 * Gets the user followers.
	 * 
	 * @param userName
	 *            the user name
	 * 
	 * @return the user followers
	 */
	public List<String> getUserFollowers(String userName);
	
	/**
	 * Gets the user following.
	 * 
	 * @param userName
	 *            the user name
	 * 
	 * @return the user following
	 */
	public List<String> getUserFollowing(String userName);
	
	/**
	 * Follow user.
	 * 
	 * @param userName
	 *            the user name
	 */
	public void followUser(String userName);
	
	/**
	 * Unfollow user.
	 * 
	 * @param userName
	 *            the user name
	 */
	public void unfollowUser(String userName);
	
	/**
	 * Gets the watched repositories.
	 * 
	 * @param userName
	 *            the user name
	 * 
	 * @return the watched repositories
	 */
	public List<Repository> getWatchedRepositories(String userName);
	
	/**
	 * Gets the keys.
	 * 
	 * @return the keys
	 */
	public List<Key> getKeys();
	
	/**
	 * Adds the key.
	 * 
	 * @param title
	 *            the title
	 * @param key
	 *            the key
	 */
	public void addKey(String title, String key);
	
	/**
	 * Removes the key.
	 * 
	 * @param id
	 *            the id
	 */
	public void removeKey(String id);
	
	/**
	 * Gets the emails.
	 * 
	 * @return the emails
	 */
	public List<String> getEmails();
	
	/**
	 * Adds the email.
	 * 
	 * @param email
	 *            the email
	 */
	public void addEmail(String email);
	
	/**
	 * Removes the email.
	 * 
	 * @param email
	 *            the email
	 */
	public void removeEmail(String email);
}
