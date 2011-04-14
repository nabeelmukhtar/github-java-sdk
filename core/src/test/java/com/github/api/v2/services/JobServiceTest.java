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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.api.v2.schema.Job;
import com.github.api.v2.services.constant.TestConstants;

/**
 * The Class JobServiceTest.
 */
public class JobServiceTest extends BaseGitHubServiceTest {
	
	/** The service. */
	private JobService service;

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.BaseGitHubServiceTest#setUp()
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
		service = factory.createJobService();
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
	 * Test get job.
	 */
	@Test
	public void testGetJob() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Job Id."), TestConstants.TEST_JOB_ID);
		Job job = service.getJob(TestConstants.TEST_JOB_ID);
		assertNotNull("Job cannot be null", job);
	}

	/**
	 * Test search jobs.
	 */
	@Test
	public void testSearchJobs() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Job Query."), TestConstants.TEST_JOB_QUERY);
    	List<Job> jobs = service.searchJobs(TestConstants.TEST_JOB_QUERY);
		assertNotNullOrEmpty("Jobs cannot be null or empty", jobs);
	}
}
