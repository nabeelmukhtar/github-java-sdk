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

import com.github.api.v2.services.impl.CommitServiceImpl;
import com.github.api.v2.services.impl.FeedServiceImpl;
import com.github.api.v2.services.impl.GistServiceImpl;
import com.github.api.v2.services.impl.IssueServiceImpl;
import com.github.api.v2.services.impl.JobServiceImpl;
import com.github.api.v2.services.impl.NetworkServiceImpl;
import com.github.api.v2.services.impl.OAuthServiceImpl;
import com.github.api.v2.services.impl.ObjectServiceImpl;
import com.github.api.v2.services.impl.OrganizationServiceImpl;
import com.github.api.v2.services.impl.PullRequestServiceImpl;
import com.github.api.v2.services.impl.RepositoryServiceImpl;
import com.github.api.v2.services.impl.UserServiceImpl;




/**
 * A factory for creating GitHubService objects.
 */
public class GitHubServiceFactory {

    /**
	 * Instantiates a new git hub service factory.
	 */
	private GitHubServiceFactory() {
    }
	
    /**
	 * New instance.
	 * 
	 * @return the git hub service factory
	 */
    public static GitHubServiceFactory newInstance() {
        return new GitHubServiceFactory();
    }
    
    /**
	 * Creates a new GitHubService object.
	 * 
	 * @return the commit service
	 */
    public CommitService createCommitService() {
    	return new CommitServiceImpl();
    }
    
    /**
	 * Creates a new GitHubService object.
	 * 
	 * @return the gist service
	 */
    public GistService createGistService() {
    	return new GistServiceImpl();
    }
    
    /**
	 * Creates a new GitHubService object.
	 * 
	 * @return the issue service
	 */
    public IssueService createIssueService() {
    	return new IssueServiceImpl();
    }
    
    /**
	 * Creates a new GitHubService object.
	 * 
	 * @return the network service
	 */
    public NetworkService createNetworkService() {
    	return new NetworkServiceImpl();
    }

    /**
	 * Creates a new GitHubService object.
	 * 
	 * @return the object service
	 */
    public ObjectService createObjectService() {
    	return new ObjectServiceImpl();
    }
    
    /**
	 * Creates a new GitHubService object.
	 * 
	 * @return the repository service
	 */
    public RepositoryService createRepositoryService() {
    	return new RepositoryServiceImpl();
    }
    
    /**
	 * Creates a new GitHubService object.
	 * 
	 * @return the organization service
	 */
    public OrganizationService createOrganizationService() {
    	return new OrganizationServiceImpl();
    }
    
    /**
	 * Creates a new GitHubService object.
	 * 
	 * @return the user service
	 */
    public UserService createUserService() {
    	return new UserServiceImpl();
    }
    
    /**
	 * Creates a new GitHubService object.
	 * 
	 * @param clientId
	 *            the client id
	 * @param secret
	 *            the secret
	 * 
	 * @return the o auth service
	 */
    public OAuthService createOAuthService(String clientId, String secret) {
    	return new OAuthServiceImpl(clientId, secret);    	
    }
    
    /**
	 * Creates a new GitHubService object.
	 * 
	 * @return the feed service
	 */
    public FeedService createFeedService() {
    	return new FeedServiceImpl();    	
    }
    
    /**
	 * Creates a new GitHubService object.
	 * 
	 * @return the pull request service
	 */
    public PullRequestService createPullRequestService() {
    	return new PullRequestServiceImpl();    	
    }
    
    /**
	 * Creates a new GitHubService object.
	 * 
	 * @return the job service
	 */
    public JobService createJobService() {
    	return new JobServiceImpl();    	
    }
}
