/**
 * 
 */
package com.github.api.v2.schema;

/**
 * @author nmukhtar
 *
 */
public class Plan extends SchemaEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -716103936969784665L;
	
	private String name;
	private int collaborators;
	private long space;
	private int privateRepos;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the collaborators
	 */
	public int getCollaborators() {
		return collaborators;
	}
	/**
	 * @param collaborators the collaborators to set
	 */
	public void setCollaborators(int collaborators) {
		this.collaborators = collaborators;
	}
	/**
	 * @return the space
	 */
	public long getSpace() {
		return space;
	}
	/**
	 * @param space the space to set
	 */
	public void setSpace(long space) {
		this.space = space;
	}
	/**
	 * @return the privateRepos
	 */
	public int getPrivateRepos() {
		return privateRepos;
	}
	/**
	 * @param privateRepos the privateRepos to set
	 */
	public void setPrivateRepos(int privateRepos) {
		this.privateRepos = privateRepos;
	}
}
