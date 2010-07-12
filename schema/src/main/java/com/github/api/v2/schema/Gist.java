/**
 * 
 */
package com.github.api.v2.schema;

import java.util.Date;
import java.util.List;

import com.github.api.v2.schema.Repository.Visibility;

/**
 * @author nmukhtar
 *
 */
public class Gist extends SchemaEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9155892708485181542L;
	private String description;
	private String repo;
	private Visibility visibility;
	private Date createdAt;
	private List<String> files;
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the repo
	 */
	public String getRepo() {
		return repo;
	}
	/**
	 * @param repo the repo to set
	 */
	public void setRepo(String repo) {
		this.repo = repo;
	}
	/**
	 * @return the visibility
	 */
	public Visibility getVisibility() {
		return visibility;
	}
	/**
	 * @param visibility the visibility to set
	 */
	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}
	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}
	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	/**
	 * @return the files
	 */
	public List<String> getFiles() {
		return files;
	}
	/**
	 * @param files the files to set
	 */
	public void setFiles(List<String> files) {
		this.files = files;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Gist [createdAt=" + createdAt + ", description=" + description
				+ ", files=" + files + ", repo=" + repo + ", visibility="
				+ visibility + "]";
	}
}
