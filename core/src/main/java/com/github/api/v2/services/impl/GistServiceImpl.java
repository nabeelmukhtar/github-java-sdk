/**
 * 
 */
package com.github.api.v2.services.impl;

import java.io.InputStream;
import java.util.List;

import com.github.api.v2.schema.Gist;
import com.github.api.v2.services.GistService;

/**
 * @author nmukhtar
 *
 */
public class GistServiceImpl extends BaseGitHubService implements
		GistService {

	public GistServiceImpl(String applicationId) {
		super(applicationId);
	}

	@Override
	public Gist getGist(String gistId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputStream getGistContent(String gistId, String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Gist> getUserGists(String userName) {
		// TODO Auto-generated method stub
		return null;
	}
}
