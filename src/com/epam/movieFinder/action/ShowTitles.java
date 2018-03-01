package com.epam.movieFinder.action;

import java.util.List;

import com.epam.movieFinder.internalException.InternalException;
import com.epam.movieFinder.storage.Movie;
import com.epam.movieFinder.storage.MovieStorage;

/**
 * Implementation of {@DefaultAction}
 * Shows all titles of movies with / without applied filters
 * 
 * @author Raman_Skaskevich@epam.com
 */
public class ShowTitles extends DefaultAction {

	public ShowTitles(MovieStorage movieStorage) {
		super(movieStorage);
	}

	@Override
	public void execute(List<String> args) throws InternalException {
		for (Movie movie : movieStorage.returnInfoList()) {
			System.out.println(movie.getName());
		}
	}

}
