/**
 *
 */
package com.github.api.v2.services;

import com.github.api.v2.services.impl.CommitServiceImpl;
import com.github.api.v2.services.impl.GistServiceImpl;
import com.github.api.v2.services.impl.IssueServiceImpl;
import com.github.api.v2.services.impl.NetworkServiceImpl;
import com.github.api.v2.services.impl.OAuthServiceImpl;
import com.github.api.v2.services.impl.ObjectServiceImpl;
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
}
