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
 * The Class Blob.
 */
public class Blob extends SchemaEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 9155892708485181542L;
	
	/** The name. */
	private String name;
	
	/** The size. */
	private int size;
	
	/** The sha. */
	private String sha;
	
	/** The mode. */
	private String mode;
	
	/** The mime type. */
	private String mimeType;
	
	/** The data. */
	private String data;
	
	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the size.
	 * 
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Sets the size.
	 * 
	 * @param size
	 *            the new size
	 */
	public void setSize(int size) {
		this.size = size;
	}
	
	/**
	 * Gets the sha.
	 * 
	 * @return the sha
	 */
	public String getSha() {
		return sha;
	}
	
	/**
	 * Sets the sha.
	 * 
	 * @param sha
	 *            the new sha
	 */
	public void setSha(String sha) {
		this.sha = sha;
	}
	
	/**
	 * Gets the mode.
	 * 
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}
	
	/**
	 * Sets the mode.
	 * 
	 * @param mode
	 *            the new mode
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	/**
	 * Gets the mime type.
	 * 
	 * @return the mime type
	 */
	public String getMimeType() {
		return mimeType;
	}
	
	/**
	 * Sets the mime type.
	 * 
	 * @param mimeType
	 *            the new mime type
	 */
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	
	/**
	 * Gets the data.
	 * 
	 * @return the data
	 */
	public String getData() {
		return data;
	}
	
	/**
	 * Sets the data.
	 * 
	 * @param data
	 *            the new data
	 */
	public void setData(String data) {
		this.data = data;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Blob [data=" + data + ", mimeType=" + mimeType + ", mode="
				+ mode + ", name=" + name + ", sha=" + sha + ", size=" + size
				+ "]";
	}
}
