package com.epam.movieFinder.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * {@Storage} implementation.
 *  Contains all movies and applied filters to them
 * 
 * @author Raman_Skaskevich@epam.com
 */
public class MovieStorage implements Storage<Movie>{
	private List<Movie> movies;
	private Predicate<Movie> movieFilter = null;
	
	
	public void applyFilter(Predicate<Movie> filter)
	{
		if(movieFilter == null)
		{
			movieFilter = filter;
		}
		else
		{
			movieFilter = movieFilter.and(filter);
		}
	}
	
	public void resetFilters()
	{
		movieFilter = null;
	}

	public MovieStorage() {
		movies = new ArrayList<>();
	}
	@Override
	public List<Movie> returnInfoList() {
		List<Movie> returnList = movies;

		if(movieFilter != null)
		{
			returnList = movies.stream().filter(movieFilter).collect(Collectors.toList());
		}

		return returnList;
	}
	
	public void addInfo(Movie movie)
	{
		movies.add(movie);
	}
}
