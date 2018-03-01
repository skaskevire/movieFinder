package com.epam.movieFinder.action;

import java.util.List;

import com.epam.movieFinder.internalException.InternalException;
import com.epam.movieFinder.storage.MovieStorage;

import static com.epam.movieFinder.util.Messages.*;

/**
 * Implementation of {@DefaultAction} Filter movies with rating better arg
 * 
 * @author Raman_Skaskevich@epam.com
 */
public class FilterByRatingBetterThan extends DefaultAction {

	public FilterByRatingBetterThan(MovieStorage movieStorage) {
		super(movieStorage);
	}

	@Override
	public void execute(List<String> args) throws InternalException {
		if (args.size() != 1) {
			throw new InternalException(EX_WRONG_ARG_SIZE);
		}
		validateDoubleArgument(args.get(0));
		movieStorage.applyFilter(movie -> Double.valueOf(args.get(0)) < movie.getRating());
	}

}
