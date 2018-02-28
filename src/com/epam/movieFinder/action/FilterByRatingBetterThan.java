package com.epam.movieFinder.action;

import java.util.List;

import com.epam.movieFinder.cache.MovieStorageStackedStateCache;
import com.epam.movieFinder.internalException.InternalException;
import com.epam.movieFinder.storage.Movie;
import com.epam.movieFinder.storage.MovieStorage;

public class FilterByRatingBetterThan extends DefaultAction {


	public FilterByRatingBetterThan(MovieStorageStackedStateCache storage) {
		super(storage);
	}

	@Override
	public void execute(List<String> args) throws InternalException {
		if(args.size() > 1)
		{
			throw new InternalException("Wrong arg size");
		}
		String input = args.get(0);
		MovieStorage filteredMovies = new MovieStorage();
		MovieStorage movieStorage = storage.showLastSnapshot();
		for (Movie movie : movieStorage.returnInfoList()) {
			if (Double.valueOf(input) < movie.getRating()) {
				filteredMovies
						.addInfo(new Movie(movie.getName(), movie.getDateOfIssue(), movie.getRating(), movie.getVal()));
			}
		}
		
		
		storage.pushMovieStorageStateSnapshot(filteredMovies);
	}

}