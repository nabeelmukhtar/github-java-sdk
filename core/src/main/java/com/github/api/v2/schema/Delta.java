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
