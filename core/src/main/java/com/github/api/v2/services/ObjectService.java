/**
 * 
 */
package com.github.api.v2.services;

import java.io.InputStream;
import java.util.List;

import com.github.api.v2.schema.Blob;
import com.github.api.v2.schema.Tree;

/**
 * @author nmukhtar
 *
 */
public interface ObjectService extends GitHubService {
	public List<Tree> getTree(String userName, String repositoryName, String treeSha);
	public Blob getBlob(String userName, String repositoryName, String treeSha, String filePath);
	public List<Blob> getBlobs(String userName, String repositoryName, String treeSha);
	public InputStream getObjectContent(String userName, String repositoryName, String objectSha);
}
