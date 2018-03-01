package com.epam.movieFinder;

import java.util.HashMap;
import java.util.Map;

import com.epam.movieFinder.action.DefaultAction;
import com.epam.movieFinder.action.Exit;
import com.epam.movieFinder.action.ExtractMovies;
import com.epam.movieFinder.action.FilterByRatingBetterThan;
import com.epam.movieFinder.action.FilterByRatingCountMoreThan;
import com.epam.movieFinder.action.FilterByYearOfProduction;
import com.epam.movieFinder.action.Reset;
import com.epam.movieFinder.action.ShowMovieCount;
import com.epam.movieFinder.action.ShowTitles;
import com.epam.movieFinder.invoker.Invoker;
import com.epam.movieFinder.invoker.impl.InvokerImpl;
import com.epam.movieFinder.storage.MovieStorage;

import static com.epam.movieFinder.action.ActionEnum.*;
import static com.epam.movieFinder.util.Messages.*;

/**
 * Application entry point.
 * 
 * @author Raman_Skaskevich@epam.com
 */
public class Main {
	public static void main(String[] args) {
		if(args.length == 0)
		{
			System.out.println(MSG_MUST_SPECIFY_PATH_TO_FILE);
			return;
		}
		MovieStorage storage = new MovieStorage();
		Map<String, DefaultAction> actions = new HashMap<>();
		Invoker invoker = new InvokerImpl(actions);
		Launcher launcher = new Launcher(invoker);		
		invoker.getHandledActions().putAll(initSystemActions(storage, launcher));

		launcher.run(args[0]);
	}

	private static Map<String, DefaultAction> initSystemActions(MovieStorage operator, Launcher launcher)
	{
		Map<String, DefaultAction> actions = new HashMap<>();
		actions.put(EXTRACT_MOVIES.getName(), new ExtractMovies(operator));
		actions.put(FILTER_BY_RATING_BETTER_THAN.getName(), new FilterByRatingBetterThan(operator));
		actions.put(FILTER_BY_YEAR_OF_PRODUCTION.getName(), new FilterByYearOfProduction(operator));
		actions.put(FILTER_BY_RATING_COUNT_MORE_THAN.getName(), new FilterByRatingCountMoreThan(operator));
		actions.put(SHOW_MOVIE_COUNT.getName(), new ShowMovieCount(operator));
		actions.put(SHOW_TITLES.getName(), new ShowTitles(operator));
		actions.put(RESET.getName(), new Reset(operator));
		actions.put(EXIT.getName(), new Exit(operator, launcher));
		return actions;		
	}
}
