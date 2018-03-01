package com.epam.movieFinder.action;

import java.util.List;

import com.epam.movieFinder.internalException.InternalException;
import com.epam.movieFinder.storage.MovieStorage;

public class ShowMovieCount extends DefaultAction {

	public ShowMovieCount(MovieStorage movieStorage) {
		super(movieStorage);
	}

	@Override
	public void execute(List<String> args) throws InternalException {
		System.out.println("Current movies count: " + movieStorage.returnInfoList().size());
	}
}
