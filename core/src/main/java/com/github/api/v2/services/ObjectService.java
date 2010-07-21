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

import java.io.InputStream;
import java.util.List;

import com.github.api.v2.schema.Blob;
import com.github.api.v2.schema.Tree;

/**
 * The Interface ObjectService.
 */
public interface ObjectService extends GitHubService {
	
	/**
	 * Gets the tree.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param treeSha
	 *            the tree sha
	 * 
	 * @return the tree
	 */
	public List<Tree> getTree(String userName, String repositoryName, String treeSha);
	
	/**
	 * Gets the blob.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param treeSha
	 *            the tree sha
	 * @param filePath
	 *            the file path
	 * 
	 * @return the blob
	 */
	public Blob getBlob(String userName, String repositoryName, String treeSha, String filePath);
	
	/**
	 * Gets the blobs.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param treeSha
	 *            the tree sha
	 * 
	 * @return the blobs
	 */
	public List<Blob> getBlobs(String userName, String repositoryName, String treeSha);
	
	/**
	 * Gets the object content.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param objectSha
	 *            the object sha
	 * 
	 * @return the object content
	 */
	public InputStream getObjectContent(String userName, String repositoryName, String objectSha);
}
