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

    /**
     * Instantiates a new google search query factory.
     * 
     * @param applicationKey the application key
     */
	private GitHubServiceFactory() {
    }
	
    /**
     * New instance.
     * 
     * @param applicationKey the application key
     * 
     * @return the google search query factory
     */
    public static GitHubServiceFactory newInstance() {
        return new GitHubServiceFactory();
    }
    
    /**
     * New blog search query.
     * 
     * @return the blog search query
     */
    public CommitService createCommitService() {
    	return new CommitServiceImpl();
    }
    
    /**
     * New book search query.
     * 
     * @return the book search query
     */
    public GistService createGistService() {
    	return new GistServiceImpl();
    }
    
    /**
     * New image search query.
     * 
     * @return the image search query
     */
    public IssueService createIssueService() {
    	return new IssueServiceImpl();
    }
    
    /**
     * New local search query.
     * 
     * @return the local search query
     */
    public NetworkService createNetworkService() {
    	return new NetworkServiceImpl();
    }

    /**
     * New news search query.
     * 
     * @return the news search query
     */
    public ObjectService createObjectService() {
    	return new ObjectServiceImpl();
    }
    
    /**
     * New patent search query.
     * 
     * @return the patent search query
     */
    public RepositoryService createRepositoryService() {
    	return new RepositoryServiceImpl();
    }
    
    /**
     * New video search query.
     * 
     * @return the video search query
     */
    public UserService createUserService() {
    	return new UserServiceImpl();
    }
}
