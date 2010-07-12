/**
 * 
 */
package com.github.api.v2.schema;

/**
 * @author nmukhtar
 *
 */
public class Blob extends SchemaEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9155892708485181542L;
	
	private String name;
	private int size;
	private String sha;
	private String mode;
	private String mimeType;
	private String data;
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
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}
	/**
	 * @return the sha
	 */
	public String getSha() {
		return sha;
	}
	/**
	 * @param sha the sha to set
	 */
	public void setSha(String sha) {
		this.sha = sha;
	}
	/**
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}
	/**
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	/**
	 * @return the mimeType
	 */
	public String getMimeType() {
		return mimeType;
	}
	/**
	 * @param mimeType the mimeType to set
	 */
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}
}
