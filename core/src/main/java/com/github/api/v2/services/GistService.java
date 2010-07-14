/**
 * 
 */
package com.github.api.v2.services;

import java.io.InputStream;
import java.util.List;

import com.github.api.v2.schema.Gist;

/**
 * The Interface GistService.
 */
public interface GistService extends GitHubService {
	
	/**
	 * Gets the gist.
	 * 
	 * @param gistId
	 *            the gist id
	 * 
	 * @return the gist
	 */
	public Gist getGist(String gistId);
	
	/**
	 * Gets the gist content.
	 * 
	 * @param gistId
	 *            the gist id
	 * @param fileName
	 *            the file name
	 * 
	 * @return the gist content
	 */
	public InputStream getGistContent(String gistId, String fileName);
	
	/**
	 * Gets the user gists.
	 * 
	 * @param userName
	 *            the user name
	 * 
	 * @return the user gists
	 */
	public List<Gist> getUserGists(String userName);
}
