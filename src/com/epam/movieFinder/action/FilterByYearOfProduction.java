package com.epam.movieFinder.action;

import java.util.List;

import com.epam.movieFinder.internalException.InternalException;
import com.epam.movieFinder.storage.MovieStorage;

/**
 * Implementation of {@DefaultAction} Filter movies with year of production
 * equal arg
 * 
 * @author Raman_Skaskevich@epam.com
 */
public class FilterByYearOfProduction extends DefaultAction {

	public FilterByYearOfProduction(MovieStorage movieStorage) {
		super(movieStorage);
	}

	@Override
	public void execute(List<String> args) throws InternalException {
		if (args.size() != 1) {
			throw new InternalException("Wrong arg size");
		}
		validateIntegerArgument(args.get(0));
		movieStorage.applyFilter(movie -> Integer.valueOf(args.get(0)).equals(movie.getDateOfIssue()));
	}

}
