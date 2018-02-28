package com.epam.movieFinder.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import com.epam.movieFinder.action.converter.Converter;
import com.epam.movieFinder.action.converter.StringToMovieConverter;
import com.epam.movieFinder.action.validator.MovieStringValidator;
import com.epam.movieFinder.action.validator.Validator;
import com.epam.movieFinder.cache.MovieStorageStackedStateCache;
import com.epam.movieFinder.internalException.InternalException;
import com.epam.movieFinder.storage.Movie;
import com.epam.movieFinder.storage.MovieStorage;

public class ExtractMovies extends DefaultAction {
	private final Converter<String[], Movie> stringToMovieConverter;
	private final Validator<String[]> movieStringValidator;
	private static final String LINE_SPLITTING_PATTERN = ",";

	public ExtractMovies(MovieStorageStackedStateCache storage) {
		super(storage);
		stringToMovieConverter = new StringToMovieConverter();
		movieStringValidator = new MovieStringValidator();
	}

	@Override
	public void execute(List<String> args) throws InternalException {

		File file = new File(args.get(0));
		if (!file.exists()) {
			throw new InternalException("Specified wrong path to file or wrong filename");
		}
		try {

			Scanner sc = new Scanner(file);
			MovieStorage ms = new MovieStorage();
			int count = 0;
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] ideoms = line.substring(1, line.length() - 1).split(LINE_SPLITTING_PATTERN);

				if (( !line.startsWith("(") || !line.endsWith(")") ) || !movieStringValidator.validate(ideoms)) {
					System.out.println("Can't parse this line, Skipping. Line: " + count+1);
					continue;
				}
				ms.addInfo(stringToMovieConverter.convert(ideoms));
				count++;
			}
			sc.close();

			storage.pushMovieStorageStateSnapshot(ms);
			System.out.println("Number of scanned movies: " + count);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
