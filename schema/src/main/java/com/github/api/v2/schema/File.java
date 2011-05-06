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
 * The Class File.
 */
public class File extends SchemaEntity {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 9155892708485181542L;
	
	/** The size. */
	private int size;
	
	/** The filename. */
	private String filename;
	
	/** The raw url. */
	private String rawUrl;
	
	/** The content. */
	private String content;
	
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
	
	/**
	 * Gets the raw url.
	 * 
	 * @return the raw url
	 */
	public String getRawUrl() {
		return rawUrl;
	}
	
	/**
	 * Sets the raw url.
	 * 
	 * @param rawUrl
	 *            the new raw url
	 */
	public void setRawUrl(String rawUrl) {
		this.rawUrl = rawUrl;
	}
	
	/**
	 * Gets the content.
	 * 
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * Sets the content.
	 * 
	 * @param content
	 *            the new content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "File [content=" + content + ", filename=" + filename
				+ ", rawUrl=" + rawUrl + ", size=" + size + "]";
	}
}
