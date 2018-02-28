package com.epam.movieFinder.internalException;

public class ConvertingFailedException extends InternalException{
	private static final long serialVersionUID = 1L;

	public ConvertingFailedException() {
		super();
	}

	public ConvertingFailedException(String message) {
		super(message);
	}
}
