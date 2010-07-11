package com.github.api.v2.services;

import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.api.v2.schema.Key;
import com.github.api.v2.schema.Language;
import com.github.api.v2.schema.Repository;
import com.github.api.v2.schema.Tag;
import com.github.api.v2.schema.User;

public class RepositoryServiceTest extends BaseGitHubServiceTest {
	private RepositoryService service;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		service = factory.createRepositoryService();
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		service = null;
	}

	@Test
	public void testAddCollaborator() {
		service.addCollaborator("", "");
	}

	@Test
	public void testAddKey() {
		service.addDeployKey("", "", "");
	}

	@Test
	public void testChangeVisibility() {
		service.changeVisibility("", Repository.Visibility.PRIVATE);
	}

	@Test
	public void testCreateRepository() {
		service.createRepository("", "", "", Repository.Visibility.PUBLIC);
	}

	@Test
	public void testDeleteRepository() {
		service.deleteRepository("");
	}

	@Test
	public void testForkRepository() {
		service.forkRepository("", "");
	}

	@Test
	public void testGetBranches() {
		List<Tag> branches = service.getBranches("", "");
		assertNotNullOrEmpty("Branches cannot be null or empty.", branches);
	}

	@Test
	public void testGetCollaborators() {
		List<User> collaborators = service.getCollaborators("", "");
		assertNotNullOrEmpty("Collaborators cannot be null or empty.", collaborators);
	}

	@Test
	public void testGetContributors() {
		List<User> contributors = service.getContributors("", "");
		assertNotNullOrEmpty("Contributors cannot be null or empty.", contributors);
	}

	@Test
	public void testGetForks() {
		List<Repository> forks = service.getForks("", "");
		assertNotNullOrEmpty("Forks cannot be null or empty.", forks);
	}

	@Test
	public void testGetKeys() {
		List<Key> keys = service.getDeployKeys("");
		assertNotNullOrEmpty("Keys cannot be null or empty.", keys);
	}

	@Test
	public void testGetLanguageBreakdown() {
		Map<Language, Long> languageBreakdown = service.getLanguageBreakdown("", "");
		assertFalse("Language breakdon vannot be null or empty.", (languageBreakdown == null || languageBreakdown.isEmpty()));
	}

	@Test
	public void testGetPushableRepositories() {
		List<Repository> repositories = service.getPushableRepositories();
		assertNotNullOrEmpty("Pushable repositories cannot be null or empty.", repositories);
	}

	@Test
	public void testGetRepositories() {
		List<Repository> repositories = service.getRepositories("");
		assertNotNullOrEmpty("Repositories cannot be null or empty.", repositories);
	}

	@Test
	public void testGetRepository() {
		Repository repository = service.getRepository("", "");
		assertNotNull("Repository cannot be null.", repository);
	}

	@Test
	public void testGetTags() {
		List<Tag> tags = service.getTags("", "");
		assertNotNullOrEmpty("Tags cannot be null or empty.", tags);
	}

	@Test
	public void testGetWatchers() {
		List<User> watchers = service.getWatchers("", "");
		assertNotNullOrEmpty("Watchers cannot be null or empty.", watchers);
	}

	@Test
	public void testRemoveCollaborator() {
		service.removeCollaborator("", "");
	}

	@Test
	public void testRemoveKey() {
		service.removeDeployKey("", "");
	}

	@Test
	public void testSearchRepositoriesString() {
		List<Repository> repositories = service.searchRepositories("");
		assertNotNullOrEmpty("Repositories cannot be null or empty.", repositories);
	}

	@Test
	public void testSearchRepositoriesStringString() {
		List<Repository> repositories = service.searchRepositories("", Language.Java);
		assertNotNullOrEmpty("Repositories cannot be null or empty.", repositories);
	}

	@Test
	public void testSearchRepositoriesStringInt() {
		List<Repository> repositories = service.searchRepositories("", 1);
		assertNotNullOrEmpty("Repositories cannot be null or empty.", repositories);
	}

	@Test
	public void testSearchRepositoriesStringStringInt() {
		List<Repository> repositories = service.searchRepositories("", Language.Java, 1);
		assertNotNullOrEmpty("Repositories cannot be null or empty.", repositories);
	}

	@Test
	public void testUnwatchRepository() {
		service.unwatchRepository("", "");
	}

	@Test
	public void testUpdateRepository() {
//		service.updateRepository(repository);
	}

	@Test
	public void testWatchRepository() {
		service.watchRepository("", "");
	}

}
