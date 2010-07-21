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
package com.github.api.v2.services;

import java.util.concurrent.Future;


/**
 * The Class AsyncResponseHandler.
 */
public abstract class AsyncResponseHandler<T> {
	
	/** The future. */
	private Future<T> future;
	
    /**
	 * Sets the future.
	 * 
	 * @param future
	 *            the new future
	 */
	public void setFuture(Future<T> future) {
		this.future = future;
	}
	
    /**
	 * Gets the future.
	 * 
	 * @return the future
	 */
	public Future<T> getFuture() {
		return future;
	}

    /**
	 * Handle response.
	 * 
	 * @param response
	 *            the response
	 */
    public abstract void handleResponse(T response);
}
