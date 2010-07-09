/**
 * 
 */
package com.github.api.v2.services;

import java.util.List;

import com.github.api.v2.schema.Key;
import com.github.api.v2.schema.Repository;
import com.github.api.v2.schema.User;

/**
 * @author nmukhtar
 *
 */
public interface UserService extends GitHubService {
	public List<User> searchUsersByName(String name);
	public List<User> searchUsersByEmail(String email);
	public User getUser(String userName);
	public User getCurrentUser();
	public void updateUser(User user);
	public List<String> getUserFollowers(String userName);
	public List<String> getUserFollowing(String userName);
	public void followUser(String userName);
	public void unfollowUser(String userName);
	public List<Repository> getWatchedRepositories(String userName);
	public List<Key> getKeys();
	public void addKey(String title, String key);
	public void removeKey(String id);
	public List<String> getEmails();
	public void addEmail(String email);
	public void removeEmail(String email);
}
