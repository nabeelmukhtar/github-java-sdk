/**
 * 
 */
package com.github.api.v2.schema;

import java.util.Date;
import java.util.List;

/**
 * @author nmukhtar
 *
 */
public class Network extends SchemaEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9155892708485181542L;
	
	private int focus;
	private String nethash;
	private List<Date> dates;
	/**
	 * @return the focus
	 */
	public int getFocus() {
		return focus;
	}
	/**
	 * @param focus the focus to set
	 */
	public void setFocus(int focus) {
		this.focus = focus;
	}
	/**
	 * @return the nethash
	 */
	public String getNethash() {
		return nethash;
	}
	/**
	 * @param nethash the nethash to set
	 */
	public void setNethash(String nethash) {
		this.nethash = nethash;
	}
	/**
	 * @return the dates
	 */
	public List<Date> getDates() {
		return dates;
	}
	/**
	 * @param dates the dates to set
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
