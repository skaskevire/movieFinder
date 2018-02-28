package com.epam.movieFinder.storage;

import java.util.ArrayList;
import java.util.List;

public class MovieStorage implements Storage<Movie>{
	private List<Movie> movies;

	public MovieStorage() {
		movies = new ArrayList<>();
	}
	@Override
	public List<Movie> returnInfoList() {
		return movies;
	}
	
	public void addInfo(Movie movie)
	{
		movies.add(movie);
	}
}
