/**
 * 
 */
package com.github.api.v2.schema;

import java.util.Date;
import java.util.List;

/**
 * The Class Network.
 */
public class Network extends SchemaEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 9155892708485181542L;
	
	/** The focus. */
	private int focus;
	
	/** The nethash. */
	private String nethash;
	
	/** The dates. */
	private List<Date> dates;
	
	/**
	 * Gets the focus.
	 * 
	 * @return the focus
	 */
	public int getFocus() {
		return focus;
	}
	
	/**
	 * Sets the focus.
	 * 
	 * @param focus
	 *            the new focus
	 */
	public void setFocus(int focus) {
		this.focus = focus;
	}
	
	/**
	 * Gets the nethash.
	 * 
	 * @return the nethash
	 */
	public String getNethash() {
		return nethash;
	}
	
	/**
	 * Sets the nethash.
	 * 
	 * @param nethash
	 *            the new nethash
	 */
	public void setNethash(String nethash) {
		this.nethash = nethash;
	}
	
	/**
	 * Gets the dates.
	 * 
	 * @return the dates
	 */
	public List<Date> getDates() {
		return dates;
	}
	
	/**
	 * Sets the dates.
	 * 
	 * @param dates
	 *            the new dates
	 */
	public void setDates(List<Date> dates) {
		this.dates = dates;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Network [dates=" + dates + ", focus=" + focus + ", nethash="
				+ nethash + "]";
	}
}
