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
 * The Class Label.
 */
public class Label extends SchemaEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 9155892708485181542L;
	
	/** The name. */
	private String name;
	
	/** The color. */
	private String color;

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
	 * Gets the color.
	 * 
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Sets the color.
	 * 
	 * @param color
	 *            the new color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Label [color=" + color + ", name=" + name + "]";
	}
}
