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
