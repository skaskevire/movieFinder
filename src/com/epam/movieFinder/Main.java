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

public class Main {
	public static void main(String[] args) {
		if(args.length == 0)
		{
			System.out.println("You must specify path to file with movies");
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
		actions.put("extract", new ExtractMovies(operator));
		actions.put("FilterByRatingBetterThan", new FilterByRatingBetterThan(operator));
		actions.put("FilterByYearOfProduction", new FilterByYearOfProduction(operator));
		actions.put("FilterByRatingCountMoreThan", new FilterByRatingCountMoreThan(operator));
		actions.put("ShowMovieCount", new ShowMovieCount(operator));
		actions.put("ShowTitles", new ShowTitles(operator));
		actions.put("Reset", new Reset(operator));
		actions.put("exit", new Exit(operator, launcher));
		return actions;		
	}
}
