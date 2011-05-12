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

import com.github.api.v2.schema.Organization;
import com.github.api.v2.schema.Repository;
import com.github.api.v2.schema.User;
import com.github.api.v2.services.GitHubServiceFactory;
import com.github.api.v2.services.OrganizationService;

/**
 * The Class OrganizationApiSample.
 */
public class OrganizationApiSample {

    /**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public static void main(String[] args) throws Exception {
		GitHubServiceFactory factory = GitHubServiceFactory.newInstance();
		OrganizationService service = factory.createOrganizationService();
		Organization organization = service.getOrganization("github");
		printResult(organization);
		List<User> publicMembers = service.getPublicMembers("github");
		for (User user : publicMembers) {
			printResult(user);
		}
		List<Repository> publicRepositories = service.getPublicRepositories("github");
		for (Repository repository : publicRepositories) {
			printResult(repository);			
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

	/**
	 * Prints the result.
	 * 
	 * @param user
	 *            the user
	 */
	private static void printResult(User user) {
		System.out.println(user);
	}

	/**
	 * Prints the result.
	 * 
	 * @param organization
	 *            the organization
	 */
	private static void printResult(Organization organization) {
		System.out.println(organization);
	}
}
