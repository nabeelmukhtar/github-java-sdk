/**
 * 
 */
package com.github.api.v2.services.example;

import java.util.List;

import com.github.api.v2.schema.User;
import com.github.api.v2.services.GitHubServiceFactory;
import com.github.api.v2.services.UserService;

/**
 * The Class UserApiSample.
 */
public class UserApiSample {
    
    /**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		GitHubServiceFactory factory = GitHubServiceFactory.newInstance();
		UserService service = factory.createUserService();
		List<User> users = service.searchUsersByName("john");
		for (User user : users) {
			printResult(user);			
		}
		User user = service.getUserByEmail("nabeelmukhtar@yahoo.com");
		printResult(user);
	}
    
	/**
	 * Prints the result.
	 * 
	 * @param user
	 *            the user
	 */
	private static void printResult(User user) {
		System.out.println(user);
	}
}
