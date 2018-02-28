package com.epam.movieFinder.action;

import java.util.List;

import com.epam.movieFinder.cache.MovieStorageStackedStateCache;
import com.epam.movieFinder.internalException.InternalException;

public class ShowMovieCount extends DefaultAction {


	public ShowMovieCount(MovieStorageStackedStateCache storage) {
		super(storage);
	}

	@Override
	public void execute(List<String> args) throws InternalException {
		System.out.println("Current movies count: " + storage.showLastSnapshot().returnInfoList().size());
	}

}
