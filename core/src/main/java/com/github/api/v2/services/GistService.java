/**
 * 
 */
package com.github.api.v2.services;

import java.io.InputStream;
import java.util.List;

import com.github.api.v2.schema.Gist;

/**
 * @author nmukhtar
 *
 */
public interface GistService extends GitHubService {
	public Gist getGist(String gistId);
	public InputStream getGistContent(String gistId, String fileName);
	public List<Gist> getUserGists(String userName);
}
