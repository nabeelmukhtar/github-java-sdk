/**
 * 
 */
package com.github.api.v2.schema;

/**
 * @author nmukhtar
 *
 */
public class Id extends SchemaEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9155892708485181542L;
	
	private String id;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Id [id=" + id + "]";
	}
}
