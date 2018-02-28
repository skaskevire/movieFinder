package com.epam.movieFinder.action;

import java.util.List;

import com.epam.movieFinder.cache.MovieStorageStackedStateCache;
import com.epam.movieFinder.internalException.InternalException;

public abstract class DefaultAction{

	protected MovieStorageStackedStateCache storage;

	public DefaultAction(MovieStorageStackedStateCache storage) {
		super();
		this.storage = storage;
	}
	
	public abstract void execute(List<String> args) throws InternalException;
}
