/**
 * 
 */
package com.github.api.v2.schema;

/**
 * @author nmukhtar
 *
 */
public class Delta extends SchemaEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1779660351774171098L;
	
	private String diff;
	private String filename;
	/**
	 * @return the diff
	 */
	public String getDiff() {
		return diff;
	}
	/**
	 * @param diff the diff to set
	 */
	public void setDiff(String diff) {
		this.diff = diff;
	}
	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}
	/**
	 * @param filename the filename to set
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
