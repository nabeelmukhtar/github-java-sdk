/**
 * 
 */
package com.github.api.v2.schema;

/**
 * The Class Delta.
 */
public class Delta extends SchemaEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1779660351774171098L;
	
	/** The diff. */
	private String diff;
	
	/** The filename. */
	private String filename;
	
	/**
	 * Gets the diff.
	 * 
	 * @return the diff
	 */
	public String getDiff() {
		return diff;
	}
	
	/**
	 * Sets the diff.
	 * 
	 * @param diff
	 *            the new diff
	 */
	public void setDiff(String diff) {
		this.diff = diff;
	}
	
	/**
	 * Gets the filename.
	 * 
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}
	
	/**
	 * Sets the filename.
	 * 
	 * @param filename
	 *            the new filename
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Delta [diff=" + diff + ", filename=" + filename + "]";
	}
}
