package com.epam.movieFinder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.epam.movieFinder.action.ActionEnum;
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
import com.epam.movieFinder.util.ActionParser;

public class Launcher {
	private boolean running = true;
	private Map<String, DefaultAction> handledActions;


	public void run(String moviePath)
	{
		MovieStorage operator = new MovieStorage();

		Invoker invoker = new InvokerImpl(initSystemActions(operator, this));
		
		ActionParser actionParser = new ActionParser();
		
		Response resp = null;
		resp = invoker.executeAction(ActionEnum.getByName("extract"), Arrays.asList(moviePath));
		if(resp.isContainsError())
		{
			System.out.println(resp.getErrorMessage());
			return;
		}

		Scanner scanner = new Scanner(System.in);
		do
		{
			String input = scanner.nextLine();
			Command command = actionParser.extractCommand(input);
			Response response = invoker.executeAction(command.getName(), command.getArgs());
			if(response.isContainsError())
			{
				System.out.println(response.getErrorMessage());
			}
		} while(running);
		
		scanner.close();
	}
	
	private static Map<String, DefaultAction> initSystemActions(MovieStorage operator, Launcher launcher)
	{
		Map<String, DefaultAction> actions = new HashMap<>();
		actions.put("extract", new ExtractMovies(operator));
		actions.put("FilterByRatingBetterThan", new FilterByRatingBetterThan(operator));
		actions.put("FilterByYearOfProduction", new FilterByYearOfProduction(operator));
		actions.put("FilterByRatingCountMoreThan", new FilterByRatingCountMoreThan(operator));
		actions.put("exit", new Exit(operator, launcher));
		actions.put("ShowMovieCount", new ShowMovieCount(operator));
		actions.put("ShowTitles", new ShowTitles(operator));
		actions.put("Reset", new Reset(operator));
		return actions;
		
	}
	
	
	public Map<String, DefaultAction> getHandledActions() {
		return handledActions;
	}

	public void setHandledActions(Map<String, DefaultAction> handledActions) {
		this.handledActions = handledActions;
	}

	public void setRunning(boolean running)
	{
		this.running = running;
	}
}
