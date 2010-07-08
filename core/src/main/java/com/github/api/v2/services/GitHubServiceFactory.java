/**
 *
 */
package com.github.api.v2.services;

import com.github.api.v2.services.impl.CommitServiceImpl;
import com.github.api.v2.services.impl.GistServiceImpl;
import com.github.api.v2.services.impl.IssueServiceImpl;
import com.github.api.v2.services.impl.NetworkServiceImpl;
import com.github.api.v2.services.impl.ObjectServiceImpl;
import com.github.api.v2.services.impl.RepositoryServiceImpl;
import com.github.api.v2.services.impl.UserServiceImpl;




/**
 * A factory for creating GoogleSearchQuery objects.
 */
public class GitHubServiceFactory {

    /** The application key. */
    private String applicationKey;

    /**
     * Instantiates a new google search query factory.
     * 
     * @param applicationKey the application key
     */
	private GitHubServiceFactory(String applicationKey) {
        this.applicationKey = applicationKey;
    }
	
    /**
     * New instance.
     * 
     * @param applicationKey the application key
     * 
     * @return the google search query factory
     */
    public static GitHubServiceFactory newInstance(String applicationKey) {
        return new GitHubServiceFactory(applicationKey);
    }
    
    /**
     * New blog search query.
     * 
     * @return the blog search query
     */
    public CommitService createCommitService() {
    	return new CommitServiceImpl(applicationKey);
    }
    
    /**
     * New book search query.
     * 
     * @return the book search query
     */
    public GistService createGistService() {
    	return new GistServiceImpl(applicationKey);
    }
    
    /**
     * New image search query.
     * 
     * @return the image search query
     */
    public IssueService createIssueService() {
    	return new IssueServiceImpl(applicationKey);
    }
    
    /**
     * New local search query.
     * 
     * @return the local search query
     */
    public NetworkService createNetworkService() {
    	return new NetworkServiceImpl(applicationKey);
    }

    /**
     * New news search query.
     * 
     * @return the news search query
     */
    public ObjectService createObjectService() {
    	return new ObjectServiceImpl(applicationKey);
    }
    
    /**
     * New patent search query.
     * 
     * @return the patent search query
     */
    public RepositoryService createRepositoryService() {
    	return new RepositoryServiceImpl(applicationKey);
    }
    
    /**
     * New video search query.
     * 
     * @return the video search query
     */
    public UserService createUserService() {
    	return new UserServiceImpl(applicationKey);
    }
}
