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
 * The Class FeedEntry.
 */
public class FeedEntry extends SchemaEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 9155892708485181542L;
	
	/** The title. */
	private String title;
	
	/** The link. */
	private String link;
	
	/** The author. */
	private String author;
	
	/** The published date. */
	private Date publishedDate;
	
	/** The content. */
	private String content;
	
	/** The categories. */
	private List<String> categories;
	
	/**
	 * Gets the title.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Sets the title.
	 * 
	 * @param title
	 *            the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Gets the link.
	 * 
	 * @return the link
	 */
	public String getLink() {
		return link;
	}
	
	/**
	 * Sets the link.
	 * 
	 * @param link
	 *            the new link
	 */
	public void setLink(String link) {
		this.link = link;
	}
	
	/**
	 * Gets the author.
	 * 
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * Sets the author.
	 * 
	 * @param author
	 *            the new author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	/**
	 * Gets the published date.
	 * 
	 * @return the published date
	 */
	public Date getPublishedDate() {
		return publishedDate;
	}
	
	/**
	 * Sets the published date.
	 * 
	 * @param publishedDate
	 *            the new published date
	 */
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
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
	
	/**
	 * Gets the categories.
	 * 
	 * @return the categories
	 */
	public List<String> getCategories() {
		return categories;
	}
	
	/**
	 * Sets the categories.
	 * 
	 * @param categories
	 *            the new categories
	 */
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FeedEntry [author=" + author + ", categories=" + categories
				+ ", content=" + content
				+ ", link=" + link + ", publishedDate=" + publishedDate
				+ ", title=" + title + "]";
	}
}
