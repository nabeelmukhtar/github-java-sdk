/**
 * 
 */
package com.github.api.v2.services.impl;

import java.util.List;

import com.github.api.v2.schema.Commit;
import com.github.api.v2.schema.Network;
import com.github.api.v2.services.NetworkService;

/**
 * @author nmukhtar
 *
 */
public class NetworkServiceImpl extends BaseGitHubService implements
		NetworkService {

	public NetworkServiceImpl(String applicationId) {
		super(applicationId);
	}

	@Override
	public List<Commit> getNetworkData(String userName, String repositoryName,
			String networkHash) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commit> getNetworkData(String userName, String repositoryName,
			String networkHash, int startIndex, int endIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Network getNetworkMeta(String userName, String repositoryName) {
		// TODO Auto-generated method stub
		return null;
	}
}
