package com.epam.movieFinder.action;

import java.util.List;

import com.epam.movieFinder.internalException.InternalException;
import com.epam.movieFinder.storage.MovieStorage;

public class FilterByRatingCountMoreThan extends DefaultAction {

	public FilterByRatingCountMoreThan(MovieStorage movieStorage) {
		super(movieStorage);
	}

	@Override
	public void execute(List<String> args) throws InternalException {
		if (args.size() != 1) {
			throw new InternalException("Wrong arg size");
		}

		movieStorage.applyFilter(movie -> Integer.valueOf(args.get(0)) < movie.getVal());
	}

}
