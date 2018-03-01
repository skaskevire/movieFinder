package com.epam.movieFinder.action.converter;

import com.epam.movieFinder.internalException.ConvertingFailedException;
import com.epam.movieFinder.storage.Movie;

public class StringToMovieConverter implements Converter<String, Movie> {

	@Override
	public Movie convert(String line) throws ConvertingFailedException {
		String[] ideoms = line.substring(1, line.length() - 1).split(",");
		Movie movie = null;
		if (line.startsWith("(") && line.endsWith(")") && ideoms.length >= 4) {
			try {
				StringBuilder movieNameBuilder = new StringBuilder();
				for (int i = 0; i < ideoms.length - 3; i++) {
					movieNameBuilder.append(ideoms[i]);
				}

				movie = new Movie(movieNameBuilder.toString(), Integer.valueOf(ideoms[ideoms.length - 3].trim()),
						Double.valueOf(ideoms[ideoms.length - 2].trim()),
						Integer.valueOf(ideoms[ideoms.length - 1].trim()));
			} catch (NumberFormatException e) {
				movie = null;
			}
		}

		return movie;
	}
}
