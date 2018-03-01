package com.epam.movieFinder.action.converter;

import com.epam.movieFinder.storage.Movie;

/**
 * Implementation of {@Converter}
 * Converts String movie represenation to according object
 * 
 * @author Raman_Skaskevich@epam.com
 */
public class StringToMovieConverter implements Converter<String, Movie> {
	private static final String COMMA_DELIMITER = ",";
	private static final int MOVIE_ENTITY_FIELDS_NUMBER = 4;
	/**
	 * Ideoms number before complex name of movie which can contain extra commas:
	 *  example:
	 *  following line:
	 *  (Promise, The (Versprechen, Das),1994,1.0,1)
	 *  will be separated into following array:
	 *  ["(Promise", "The (Versprechen", "Das)","1994","1.0","1)"]
	 *  "1994","1.0","1)" - simple ideoms
	 *  "(Promise", "The (Versprechen", "Das)" - will be collected into one string
	 * */
	private static final int NUMBER_OF_SIMPLE_IDEOMS = 3;
	@Override
	public Movie convert(String line) {
		String[] ideoms = line.substring(1, line.length() - 1).split(COMMA_DELIMITER);
		Movie movie = null;
		if (line.startsWith("(") && line.endsWith(")") && ideoms.length >= MOVIE_ENTITY_FIELDS_NUMBER) {
			try {
				StringBuilder movieNameBuilder = new StringBuilder();
				String prefix = "";
				for (int i = 0; i < ideoms.length - NUMBER_OF_SIMPLE_IDEOMS; i++) {
					movieNameBuilder.append(prefix);
					prefix = COMMA_DELIMITER;
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
