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

public class ExtractMovies extends DefaultAction {


	private final Converter<String, Movie> stringToMovieConverter;

	public ExtractMovies(MovieStorage movieStorage) {
		super(movieStorage);
		stringToMovieConverter = new StringToMovieConverter();
	}

	@Override
	public void execute(List<String> args) throws InternalException {

		File file = null;
		if(args.size() == 1)
		{
			file = new File(args.get(0));
		}
		else
		{
			StringBuilder sb = new StringBuilder();
			for(String arg : args)
			{
				sb.append(arg).append(" ");
			}
			file = new File(sb.toString());
		}
		if (!file.exists()) {
			throw new InternalException("Specified wrong path to file or wrong filename");
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
					System.out.println("Can't parse this line, Skipping. Line: " + count + 1);
					continue;
				}
			}
			sc.close();

			System.out.println("Number of scanned movies: " + count);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
