/**
 * 
 */
package com.github.api.v2.services.impl;

import java.util.List;

import com.github.api.v2.schema.Key;
import com.github.api.v2.schema.Repository;
import com.github.api.v2.schema.User;
import com.github.api.v2.services.UserService;

/**
 * @author nmukhtar
 *
 */
public class UserServiceImpl extends BaseGitHubService implements
		UserService {

	public UserServiceImpl(String applicationId) {
		super(applicationId);
	}

	@Override
	public void addEmail(String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addKey(String title, String key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void followUser(String userName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getCurrentUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getEmails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Key> getKeys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUserFollowers(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUserFollowing(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Repository> getWatchedRepositories(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeEmail(String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeKey(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> searchUsersByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> searchUsersByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void unfollowUser(String userName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

}
