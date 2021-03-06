package com.epam.movieFinder;


/**
 * Respone of performed action.
 *  contains information about system exceptions
 * 
 * @author Raman_Skaskevich@epam.com
 */
public class Response {
	private final String message;
	private final boolean containsError;
	private final String errorMessage;

	public Response(String message, boolean containsError, String errorMessage) {
		super();
		this.message = message;
		this.containsError = containsError;
		this.errorMessage = errorMessage;
	}

	public String getMessage() {
		return message;
	}

	public boolean isContainsError() {
		return containsError;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
