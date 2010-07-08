/**
 * 
 */
package com.github.api.v2.services;

import java.util.List;

import com.github.api.v2.schema.Commit;
import com.github.api.v2.schema.Network;

/**
 * @author nmukhtar
 *
 */
public interface NetworkService extends GitHubService {
	public Network getNetworkMeta(String userName, String repositoryName);
	public List<Commit> getNetworkData(String userName, String repositoryName, String networkHash);
	public List<Commit> getNetworkData(String userName, String repositoryName, String networkHash, int startIndex, int endIndex);
}
