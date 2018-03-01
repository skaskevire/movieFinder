package com.epam.movieFinder.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import com.epam.movieFinder.action.converter.Converter;
import com.epam.movieFinder.action.converter.StringToMovieConverter;
import com.epam.movieFinder.internalException.InternalException;
import com.epam.movieFinder.storage.Movie;
import com.epam.movieFinder.storage.MovieStorage;

import static com.epam.movieFinder.util.Messages.*;

/**
 * Implementation of {@DefaultAction}
 * Extracts all movies from file
 * 
 * @author Raman_Skaskevich@epam.com
 */
public class ExtractMovies extends DefaultAction {

	private final Converter<String, Movie> stringToMovieConverter;

	public ExtractMovies(MovieStorage movieStorage) {
		super(movieStorage);
		stringToMovieConverter = new StringToMovieConverter();
	}

	@Override
	public void execute(List<String> filePath) throws InternalException {
		File file = openFile(filePath);
		if (!file.exists()) {
			throw new InternalException(EX_WRONG_PATH_SPECIFIED);
		}
		try {

			Scanner sc = new Scanner(file);
			int count = 0;
			while (sc.hasNextLine()) {
				Movie movie = stringToMovieConverter.convert(sc.nextLine());

				if (movie != null) {
					movieStorage.addInfo(movie);
					count++;
				} else {
					System.out.println(String.format(MSG_PARSE_FAILED, count + 1));
					continue;
				}
			}
			sc.close();

			System.out.println("Number of scanned movies: " + count);
		} catch (FileNotFoundException e) {
			throw new InternalException(EX_WRONG_PATH_SPECIFIED);
		}
	}

	private File openFile(List<String> path) {
		File file = null;
		if (path.size() == 1) {
			file = new File(path.get(0));
		} else {
			StringBuilder sb = new StringBuilder();
			for (String arg : path) {
				sb.append(arg).append(" ");
			}
			file = new File(sb.toString());
		}

		return file;
	}
}
