/**
 * 
 */
package com.github.api.v2.services.example;

import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import com.github.api.v2.schema.Language;
import com.github.api.v2.schema.Repository;
import com.github.api.v2.services.GitHubServiceFactory;
import com.github.api.v2.services.RepositoryService;
import com.github.api.v2.services.auth.OAuthAuthentication;
import com.github.api.v2.services.constant.TestConstants;

/**
 * The Class RepositoryApiSample.
 */
public class RepositoryApiSample {

    /**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) throws Exception {
		GitHubServiceFactory factory = GitHubServiceFactory.newInstance();
		RepositoryService service = factory.createRepositoryService();
		List<Repository> repositories = service.searchRepositories("hadoop");
		for (Repository repository : repositories) {
			printResult(repository);
		}
		Map<Language, Long> breakDown = service.getLanguageBreakdown("facebook", "tornado");
		System.out.println(breakDown);
		service.setAuthentication(new OAuthAuthentication(TestConstants.TEST_ACCESS_TOKEN));
		List<Repository> pushableRepositories = service.getPushableRepositories();
		System.out.println(pushableRepositories.size());
		ZipInputStream zip = service.getRepositoryArchive("nabeelmukhtar", "github-java-sdk");
		ZipEntry entry = null;
		while ((entry = zip.getNextEntry()) != null) {
			System.out.println(entry.getName());
		}
	}
    
	/**
	 * Prints the result.
	 * 
	 * @param repository
	 *            the repository
	 */
	private static void printResult(Repository repository) {
		System.out.println(repository);
	}
}
