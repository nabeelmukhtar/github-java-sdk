/*
 * Copyright 2010 Nabeel Mukhtar 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 */
package com.github.api.v2.schema;

import java.util.Date;
import java.util.List;

/**
 * The Class NetworkMeta.
 */
public class NetworkMeta extends SchemaEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 9155892708485181542L;
	
	/** The focus. */
	private int focus;
	
	/** The nethash. */
	private String nethash;
	
	/** The dates. */
	private List<Date> dates;
	
	/** The users. */
	private List<NetworkUser> users;
	
	/** The blocks. */
	private List<Block> blocks;
	
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
	
	/**
	 * Gets the users.
	 * 
	 * @return the users
	 */
	public List<NetworkUser> getUsers() {
		return users;
	}

	/**
	 * Sets the users.
	 * 
	 * @param users
	 *            the new users
	 */
	public void setUsers(List<NetworkUser> users) {
		this.users = users;
	}

	/**
	 * Gets the blocks.
	 * 
	 * @return the blocks
	 */
	public List<Block> getBlocks() {
		return blocks;
	}

	/**
	 * Sets the blocks.
	 * 
	 * @param blocks
	 *            the new blocks
	 */
	public void setBlocks(List<Block> blocks) {
		this.blocks = blocks;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NetworkMeta [blocks=" + blocks + ", dates=" + dates
				+ ", focus=" + focus + ", nethash=" + nethash + ", users="
				+ users + "]";
	}
}
