/**
 * 
 */
package com.github.api.v2.services.impl;

import java.io.InputStream;
import java.util.List;

import com.github.api.v2.schema.Blob;
import com.github.api.v2.schema.Tree;
import com.github.api.v2.services.ObjectService;

/**
 * @author nmukhtar
 *
 */
public class ObjectServiceImpl extends BaseGitHubService implements
		ObjectService {

	public ObjectServiceImpl(String applicationId) {
		super(applicationId);
	}

	@Override
	public Blob getBlob(String userName, String repositoryName, String treeSha,
			String filePath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Blob> getBlobs(String userName, String repositoryName,
			String treeSha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputStream getObjectContent(String userName, String repositoryName,
			String objectSha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tree> getTree(String userName, String repositoryName,
			String treeSha) {
		// TODO Auto-generated method stub
		return null;
	}

}
