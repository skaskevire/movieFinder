package com.epam.movieFinder.action;

import java.util.List;

import com.epam.movieFinder.internalException.InternalException;
import com.epam.movieFinder.storage.MovieStorage;

public class FilterByRatingBetterThan extends DefaultAction {

	public FilterByRatingBetterThan(MovieStorage movieStorage) {
		super(movieStorage);
	}

	@Override
	public void execute(List<String> args) throws InternalException {
		if (args.size() != 1) {
			throw new InternalException("Wrong arg size");
		}
		movieStorage.applyFilter(movie -> Double.valueOf(args.get(0)) < movie.getRating());
	}

}
