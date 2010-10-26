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
