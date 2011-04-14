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

import com.github.api.v2.schema.Job;
import com.github.api.v2.services.GitHubServiceFactory;
import com.github.api.v2.services.JobService;

/**
 * The Class JobApiSample.
 */
public class JobApiSample {

    /**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		GitHubServiceFactory factory = GitHubServiceFactory.newInstance();
		JobService service = factory.createJobService();
		List<Job> jobs = service.searchJobs("python", "new york");
		for (Job job : jobs) {
			printResult(job);
		}
		Job job = service.getJob("82eeae34-65ff-11e0-99be-a34ef36756d3");
		printResult(job);
	}
    
	/**
	 * Prints the result.
	 * 
	 * @param job
	 *            the job
	 */
	private static void printResult(Job job) {
		System.out.println(job);
	}
}
