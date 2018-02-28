package com.epam.movieFinder.action;

import java.util.List;

import com.epam.movieFinder.cache.MovieStorageStackedStateCache;
import com.epam.movieFinder.internalException.InternalException;

public class Reset extends DefaultAction {

	public Reset(MovieStorageStackedStateCache storage) {
		super(storage);
	}

	@Override
	public void execute(List<String> args) throws InternalException {
		while(storage.popSnapshot() != null);
	}

}
