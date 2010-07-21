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

import com.github.api.v2.schema.Issue;
import com.github.api.v2.services.GitHubServiceFactory;
import com.github.api.v2.services.IssueService;

/**
 * The Class IssueApiSample.
 */
public class IssueApiSample {

    /**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		GitHubServiceFactory factory = GitHubServiceFactory.newInstance();
		IssueService service = factory.createIssueService();
		List<Issue> issues = service.searchIssues("facebook", "tornado", Issue.State.OPEN, "type");
		for (Issue issue : issues) {
			printResult(issue);
		}
		Issue issue = service.getIssue("facebook", "tornado", 1);
		printResult(issue);
	}
    
	/**
	 * Prints the result.
	 * 
	 * @param issue
	 *            the issue
	 */
	private static void printResult(Issue issue) {
		System.out.println(issue);
	}
}
