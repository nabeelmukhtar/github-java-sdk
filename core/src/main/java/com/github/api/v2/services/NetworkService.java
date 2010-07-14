/**
 * 
 */
package com.github.api.v2.services;

import java.util.List;

import com.github.api.v2.schema.Commit;
import com.github.api.v2.schema.Network;

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
	public Network getNetworkMeta(String userName, String repositoryName);
	
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
	public List<Commit> getNetworkData(String userName, String repositoryName, String networkHash);
	
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
	public List<Commit> getNetworkData(String userName, String repositoryName, String networkHash, int startIndex, int endIndex);
}
