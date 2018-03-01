package com.epam.movieFinder.action;

import java.util.List;

import com.epam.movieFinder.internalException.InternalException;
import com.epam.movieFinder.storage.MovieStorage;

public class Reset extends DefaultAction {

	public Reset(MovieStorage movieStorage) {
		super(movieStorage);
	}

	@Override
	public void execute(List<String> args) throws InternalException {
		movieStorage.resetFilters();
	}

}
