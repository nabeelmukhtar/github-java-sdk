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
import java.util.Map;

import com.github.api.v2.schema.Comment;
import com.github.api.v2.schema.Gist;
import com.github.api.v2.schema.Gist.Visibility;

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
	
	/**
	 * Gets the owned gists.
	 * 
	 * @return the owned gists
	 */
	public List<Gist> getOwnedGists();
	
	/**
	 * Gets the public gists.
	 * 
	 * @return the public gists
	 */
	public List<Gist> getPublicGists();
	
	/**
	 * Gets the starred gists.
	 * 
	 * @return the starred gists
	 */
	public List<Gist> getStarredGists();
	
	/**
	 * Creates the gist.
	 * 
	 * @param userName
	 *            the user name
	 * @param description
	 *            the description
	 * @param visibility
	 *            the visibility
	 * @param contents
	 *            the contents
	 * 
	 * @return the gist
	 */
	public Gist createGist(String userName, String description, Visibility visibility, Map<String, String> contents);
	
	/**
	 * Update gist.
	 * 
	 * @param gistId
	 *            the gist id
	 * @param description
	 *            the description
	 * @param contents
	 *            the contents
	 * 
	 * @return the gist
	 */
	public Gist updateGist(String gistId, String description, Map<String, String> contents);
	
	/**
	 * Star gist.
	 * 
	 * @param gistId
	 *            the gist id
	 */
	public void starGist(String gistId);
	
	/**
	 * Unstar gist.
	 * 
	 * @param gistId
	 *            the gist id
	 */
	public void unstarGist(String gistId);
	
	/**
	 * Checks if is gist starred.
	 * 
	 * @param gistId
	 *            the gist id
	 * 
	 * @return true, if is gist starred
	 */
	public boolean isGistStarred(String gistId);
	
	/**
	 * Fork gist.
	 * 
	 * @param gistId
	 *            the gist id
	 */
	public void forkGist(String gistId);
	
	/**
	 * Delete gist.
	 * 
	 * @param gistId
	 *            the gist id
	 */
	public void deleteGist(String gistId);
	
	/**
	 * Gets the gist comments.
	 * 
	 * @param gistId
	 *            the gist id
	 * 
	 * @return the gist comments
	 */
	public List<Comment> getGistComments(String gistId);
	
	/**
	 * Gets the gist comment.
	 * 
	 * @param commentId
	 *            the comment id
	 * 
	 * @return the gist comment
	 */
	public Comment getGistComment(String commentId);
	
	/**
	 * Creates the gist comment.
	 * 
	 * @param gistId
	 *            the gist id
	 * @param commentText
	 *            the comment text
	 * 
	 * @return the comment
	 */
	public Comment createGistComment(String gistId, String commentText);
	
	/**
	 * Update gist comment.
	 * 
	 * @param commentId
	 *            the comment id
	 * @param commentText
	 *            the comment text
	 * 
	 * @return the comment
	 */
	public Comment updateGistComment(String commentId, String commentText);
	
	/**
	 * Delete gist comment.
	 * 
	 * @param commentId
	 *            the comment id
	 */
	public void deleteGistComment(String commentId);
}
