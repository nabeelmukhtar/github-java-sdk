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
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.api.v2.schema.Key;
import com.github.api.v2.schema.Language;
import com.github.api.v2.schema.Repository;
import com.github.api.v2.schema.User;
import com.github.api.v2.services.constant.TestConstants;

/**
 * The Class RepositoryServiceTest.
 */
public class RepositoryServiceTest extends BaseGitHubServiceTest {
	
	/** The service. */
	private RepositoryService service;

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.BaseGitHubServiceTest#setUp()
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
		service = factory.createRepositoryService();
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
	 * Test create repository.
	 */
	@Test
	public void testCreateRepository() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository Description."), TestConstants.TEST_REPOSITORY_DESC);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository Homepage."), TestConstants.TEST_REPOSITORY_PAGE);
		service.createRepository(TestConstants.TEST_REPOSITORY_NAME, TestConstants.TEST_REPOSITORY_DESC, TestConstants.TEST_REPOSITORY_PAGE, Repository.Visibility.PUBLIC);
	}

	
	/**
	 * Test add collaborator.
	 */
	@Test
	public void testAddCollaborator() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
		service.addCollaborator(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME, TestConstants.TEST_USER_NAME);
	}

	/**
	 * Test add key.
	 */
	@Test
	public void testAddKey() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Key Title."), TestConstants.TEST_KEY_TITLE);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Key."), TestConstants.TEST_KEY);
		service.addDeployKey(TestConstants.TEST_REPOSITORY_NAME, TestConstants.TEST_KEY_TITLE, TestConstants.TEST_KEY);
	}

	/**
	 * Test change visibility.
	 */
	@Test
	public void testChangeVisibility() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
		service.changeVisibility(TestConstants.TEST_REPOSITORY_NAME, Repository.Visibility.PRIVATE);
	}

	/**
	 * Test fork repository.
	 */
	@Test
	public void testForkRepository() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
		service.forkRepository(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME);
	}

	/**
	 * Test get branches.
	 */
	@Test
	public void testGetBranches() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	Map<String, String> branches = service.getBranches(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME);
		assertFalse("Branches cannot be null or empty.", branches == null || branches.isEmpty());
	}

	/**
	 * Test get collaborators.
	 */
	@Test
	public void testGetCollaborators() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
		List<String> collaborators = service.getCollaborators(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME);
		assertNotNullOrEmpty("Collaborators cannot be null or empty.", collaborators);
	}

	/**
	 * Test get contributors.
	 */
	@Test
	public void testGetContributors() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
		List<User> contributors = service.getContributors(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME);
		assertNotNullOrEmpty("Contributors cannot be null or empty.", contributors);
	}

	/**
	 * Test get forks.
	 */
	@Test
	public void testGetForks() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
		List<Repository> forks = service.getForks(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME);
		assertNotNullOrEmpty("Forks cannot be null or empty.", forks);
	}

	/**
	 * Test get keys.
	 */
	@Test
	public void testGetKeys() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
		List<Key> keys = service.getDeployKeys(TestConstants.TEST_REPOSITORY_NAME);
		assertNotNullOrEmpty("Keys cannot be null or empty.", keys);
	}

	/**
	 * Test get language breakdown.
	 */
	@Test
	public void testGetLanguageBreakdown() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
		Map<Language, Long> languageBreakdown = service.getLanguageBreakdown(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME);
		assertFalse("Language breakdown vannot be null or empty.", (languageBreakdown == null || languageBreakdown.isEmpty()));
	}

	/**
	 * Test get pushable repositories.
	 */
	@Test
	public void testGetPushableRepositories() {
		List<Repository> repositories = service.getPushableRepositories();
		assertNotNullOrEmpty("Pushable repositories cannot be null or empty.", repositories);
	}

	/**
	 * Test get repositories.
	 */
	@Test
	public void testGetRepositories() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
		List<Repository> repositories = service.getRepositories(TestConstants.TEST_USER_NAME);
		assertNotNullOrEmpty("Repositories cannot be null or empty.", repositories);
	}

	/**
	 * Test get repository.
	 */
	@Test
	public void testGetRepository() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
		Repository repository = service.getRepository(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME);
		assertNotNull("Repository cannot be null.", repository);
	}

	/**
	 * Test get tags.
	 */
	@Test
	public void testGetTags() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	Map<String, String> tags = service.getTags(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME);
		assertFalse("Tags cannot be null or empty.", tags == null || tags.isEmpty());
	}

	/**
	 * Test get watchers.
	 */
	@Test
	public void testGetWatchers() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
		List<String> watchers = service.getWatchers(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME);
		assertNotNullOrEmpty("Watchers cannot be null or empty.", watchers);
	}

	/**
	 * Test remove collaborator.
	 */
	@Test
	public void testRemoveCollaborator() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
		service.removeCollaborator(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME, TestConstants.TEST_USER_NAME);
	}

	/**
	 * Test remove key.
	 */
	@Test
	public void testRemoveKey() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Key Id."), TestConstants.TEST_KEY_ID);
		service.removeDeployKey(TestConstants.TEST_REPOSITORY_NAME, TestConstants.TEST_KEY_ID);
	}

	/**
	 * Test search repositories string.
	 */
	@Test
	public void testSearchRepositoriesString() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Query."), TestConstants.TEST_QUERY);
		List<Repository> repositories = service.searchRepositories(TestConstants.TEST_QUERY);
		assertNotNullOrEmpty("Repositories cannot be null or empty.", repositories);
	}

	/**
	 * Test search repositories string string.
	 */
	@Test
	public void testSearchRepositoriesStringString() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Query."), TestConstants.TEST_QUERY);
		List<Repository> repositories = service.searchRepositories(TestConstants.TEST_QUERY, Language.Java);
		assertNotNullOrEmpty("Repositories cannot be null or empty.", repositories);
	}

	/**
	 * Test search repositories string int.
	 */
	@Test
	public void testSearchRepositoriesStringInt() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Query."), TestConstants.TEST_QUERY);
		List<Repository> repositories = service.searchRepositories(TestConstants.TEST_QUERY, 1);
		assertNotNullOrEmpty("Repositories cannot be null or empty.", repositories);
	}

	/**
	 * Test search repositories string string int.
	 */
	@Test
	public void testSearchRepositoriesStringStringInt() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Query."), TestConstants.TEST_QUERY);
		List<Repository> repositories = service.searchRepositories(TestConstants.TEST_QUERY, Language.Java, 1);
		assertNotNullOrEmpty("Repositories cannot be null or empty.", repositories);
	}

	/**
	 * Test unwatch repository.
	 */
	@Test
	public void testUnwatchRepository() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
		service.unwatchRepository(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME);
	}

	/**
	 * Test update repository.
	 */
	@Test
	public void testUpdateRepository() {
//		service.updateRepository(repository);
	}

	/**
	 * Test watch repository.
	 */
	@Test
	public void testWatchRepository() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
		service.watchRepository(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME);
	}

	/**
	 * Test delete repository.
	 */
	@Test
	public void testDeleteRepository() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
//		service.deleteRepository(TestConstants.TEST_REPOSITORY_NAME);
	}
}
