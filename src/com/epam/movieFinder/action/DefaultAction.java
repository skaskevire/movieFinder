package com.epam.movieFinder.action;

import java.util.List;

import com.epam.movieFinder.internalException.InternalException;
import com.epam.movieFinder.storage.MovieStorage;

public abstract class DefaultAction{
	protected MovieStorage movieStorage;

	public DefaultAction(MovieStorage movieStorage) {
		super();
		this.movieStorage = movieStorage;
	}
	
	public abstract void execute(List<String> args) throws InternalException;
}
