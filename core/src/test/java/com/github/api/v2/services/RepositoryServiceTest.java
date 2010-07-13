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

public class RepositoryServiceTest extends BaseGitHubServiceTest {
	private RepositoryService service;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		service = factory.createRepositoryService();
		service.setAuthentication(authentication);
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		service = null;
	}

	@Test
	public void testAddCollaborator() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
		service.addCollaborator(TestConstants.TEST_REPOSITORY_NAME, TestConstants.TEST_USER_NAME);
	}

	@Test
	public void testAddKey() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Key Title."), TestConstants.TEST_KEY_TITLE);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Key."), TestConstants.TEST_KEY);
		service.addDeployKey(TestConstants.TEST_REPOSITORY_NAME, TestConstants.TEST_KEY_TITLE, TestConstants.TEST_KEY);
	}

	@Test
	public void testChangeVisibility() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
		service.changeVisibility(TestConstants.TEST_REPOSITORY_NAME, Repository.Visibility.PRIVATE);
	}

	@Test
	public void testCreateRepository() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository Description."), TestConstants.TEST_REPOSITORY_DESC);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository Homepage."), TestConstants.TEST_REPOSITORY_PAGE);
		service.createRepository(TestConstants.TEST_REPOSITORY_NAME, TestConstants.TEST_REPOSITORY_DESC, TestConstants.TEST_REPOSITORY_PAGE, Repository.Visibility.PUBLIC);
	}

	@Test
	public void testDeleteRepository() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
		service.deleteRepository(TestConstants.TEST_REPOSITORY_NAME);
	}

	@Test
	public void testForkRepository() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
		service.forkRepository(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME);
	}

	@Test
	public void testGetBranches() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	Map<String, String> branches = service.getBranches(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME);
		assertFalse("Branches cannot be null or empty.", branches == null || branches.isEmpty());
	}

	@Test
	public void testGetCollaborators() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
		List<String> collaborators = service.getCollaborators(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME);
		assertNotNullOrEmpty("Collaborators cannot be null or empty.", collaborators);
	}

	@Test
	public void testGetContributors() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
		List<User> contributors = service.getContributors(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME);
		assertNotNullOrEmpty("Contributors cannot be null or empty.", contributors);
	}

	@Test
	public void testGetForks() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
		List<Repository> forks = service.getForks(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME);
		assertNotNullOrEmpty("Forks cannot be null or empty.", forks);
	}

	@Test
	public void testGetKeys() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
		List<Key> keys = service.getDeployKeys(TestConstants.TEST_REPOSITORY_NAME);
		assertNotNullOrEmpty("Keys cannot be null or empty.", keys);
	}

	@Test
	public void testGetLanguageBreakdown() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
		Map<Language, Long> languageBreakdown = service.getLanguageBreakdown(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME);
		assertFalse("Language breakdown vannot be null or empty.", (languageBreakdown == null || languageBreakdown.isEmpty()));
	}

	@Test
	public void testGetPushableRepositories() {
		List<Repository> repositories = service.getPushableRepositories();
		assertNotNullOrEmpty("Pushable repositories cannot be null or empty.", repositories);
	}

	@Test
	public void testGetRepositories() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
		List<Repository> repositories = service.getRepositories(TestConstants.TEST_USER_NAME);
		assertNotNullOrEmpty("Repositories cannot be null or empty.", repositories);
	}

	@Test
	public void testGetRepository() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
		Repository repository = service.getRepository(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME);
		assertNotNull("Repository cannot be null.", repository);
	}

	@Test
	public void testGetTags() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	Map<String, String> tags = service.getTags(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME);
		assertFalse("Tags cannot be null or empty.", tags == null || tags.isEmpty());
	}

	@Test
	public void testGetWatchers() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
		List<String> watchers = service.getWatchers(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME);
		assertNotNullOrEmpty("Watchers cannot be null or empty.", watchers);
	}

	@Test
	public void testRemoveCollaborator() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
		service.removeCollaborator(TestConstants.TEST_REPOSITORY_NAME, TestConstants.TEST_USER_NAME);
	}

	@Test
	public void testRemoveKey() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Key Id."), TestConstants.TEST_KEY_ID);
		service.removeDeployKey(TestConstants.TEST_REPOSITORY_NAME, TestConstants.TEST_KEY_ID);
	}

	@Test
	public void testSearchRepositoriesString() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Query."), TestConstants.TEST_QUERY);
		List<Repository> repositories = service.searchRepositories(TestConstants.TEST_QUERY);
		assertNotNullOrEmpty("Repositories cannot be null or empty.", repositories);
	}

	@Test
	public void testSearchRepositoriesStringString() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Query."), TestConstants.TEST_QUERY);
		List<Repository> repositories = service.searchRepositories(TestConstants.TEST_QUERY, Language.Java);
		assertNotNullOrEmpty("Repositories cannot be null or empty.", repositories);
	}

	@Test
	public void testSearchRepositoriesStringInt() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Query."), TestConstants.TEST_QUERY);
		List<Repository> repositories = service.searchRepositories(TestConstants.TEST_QUERY, 1);
		assertNotNullOrEmpty("Repositories cannot be null or empty.", repositories);
	}

	@Test
	public void testSearchRepositoriesStringStringInt() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Query."), TestConstants.TEST_QUERY);
		List<Repository> repositories = service.searchRepositories(TestConstants.TEST_QUERY, Language.Java, 1);
		assertNotNullOrEmpty("Repositories cannot be null or empty.", repositories);
	}

	@Test
	public void testUnwatchRepository() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
		service.unwatchRepository(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME);
	}

	@Test
	public void testUpdateRepository() {
//		service.updateRepository(repository);
	}

	@Test
	public void testWatchRepository() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
		service.watchRepository(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME);
	}

}
