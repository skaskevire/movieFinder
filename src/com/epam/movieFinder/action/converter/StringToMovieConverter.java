package com.epam.movieFinder.action.converter;

import com.epam.movieFinder.internalException.ConvertingFailedException;
import com.epam.movieFinder.storage.Movie;

public class StringToMovieConverter implements Converter<String[], Movie> {

	@Override
	public Movie convert(String[] ideoms) throws ConvertingFailedException {
		return new Movie(ideoms[0],
				Integer.valueOf(ideoms[1].trim()),
				Double.valueOf(ideoms[2].trim()),
				Integer.valueOf(ideoms[3].trim()));
	}

}
