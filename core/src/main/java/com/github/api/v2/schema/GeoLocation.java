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
 * The Class GeoLocation.
 */
public class GeoLocation {
	
	/** The latitude. */
	private double latitude;
	
	/** The longitude. */
	private double longitude;

	/**
	 * Instantiates a new geo location.
	 * 
	 * @param latitude
	 *            the latitude
	 * @param longitude
	 *            the longitude
	 */
	public GeoLocation(double latitude, double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	/**
	 * Gets the latitude.
	 * 
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}
	
	/**
	 * Sets the latitude.
	 * 
	 * @param latitude
	 *            the new latitude
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	/**
	 * Gets the longitude.
	 * 
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}
	
	/**
	 * Sets the longitude.
	 * 
	 * @param longitude
	 *            the new longitude
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
}
