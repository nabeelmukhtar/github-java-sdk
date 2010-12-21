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

import java.util.List;

import com.github.api.v2.schema.NetworkCommit;
import com.github.api.v2.schema.NetworkMeta;

/**
 * The Interface NetworkService.
 */
public interface NetworkService extends GitHubService {
	
	/**
	 * Gets the network meta.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * 
	 * @return the network meta
	 */
	public NetworkMeta getNetworkMeta(String userName, String repositoryName);
	
	/**
	 * Gets the network data.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param networkHash
	 *            the network hash
	 * 
	 * @return the network data
	 */
	public List<NetworkCommit> getNetworkData(String userName, String repositoryName, String networkHash);
	
	/**
	 * Gets the network data.
	 * 
	 * @param userName
	 *            the user name
	 * @param repositoryName
	 *            the repository name
	 * @param networkHash
	 *            the network hash
	 * @param startIndex
	 *            the start index
	 * @param endIndex
	 *            the end index
	 * 
	 * @return the network data
	 */
	public List<NetworkCommit> getNetworkData(String userName, String repositoryName, String networkHash, int startIndex, int endIndex);
}
