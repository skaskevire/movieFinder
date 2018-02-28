package com.epam.movieFinder.action;

import java.util.List;

import com.epam.movieFinder.cache.MovieStorageStackedStateCache;
import com.epam.movieFinder.internalException.InternalException;

public class Exit extends DefaultAction {

	public Exit(MovieStorageStackedStateCache storage) {
		super(storage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(List<String> args) throws InternalException {
		storage.setRunning(false);

	}

}
