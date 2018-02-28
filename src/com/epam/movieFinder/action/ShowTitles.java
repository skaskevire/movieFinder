package com.epam.movieFinder.action;

import java.util.List;

import com.epam.movieFinder.cache.MovieStorageStackedStateCache;
import com.epam.movieFinder.internalException.InternalException;
import com.epam.movieFinder.storage.Movie;

public class ShowTitles extends DefaultAction {

	public ShowTitles(MovieStorageStackedStateCache storage) {
		super(storage);
	}

	@Override
	public void execute(List<String> args) throws InternalException {
		for(Movie movie: storage.showLastSnapshot().returnInfoList())
		{
			System.out.println(movie.getName());
		}
	}

}
