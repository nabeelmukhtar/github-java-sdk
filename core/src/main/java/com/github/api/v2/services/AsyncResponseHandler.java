/**
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
     * @param future the new future
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
     * @param response the response
     */
    public abstract void handleResponse(T response);
}
