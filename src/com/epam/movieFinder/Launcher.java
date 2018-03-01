package com.epam.movieFinder;

import java.util.Scanner;

import com.epam.movieFinder.invoker.Invoker;
import com.epam.movieFinder.util.ActionParser;

public class Launcher {
	private boolean running;
	private Invoker invoker;
	private ActionParser parser;

	public Launcher(Invoker invoker) {
		super();
		this.invoker = invoker;
		parser = new ActionParser();
		running = true;
	}

	public void run(String moviePath)
	{		
		Scanner scanner = new Scanner(System.in);
		String input = "extract " + moviePath;
		while(running)
		{
			Command command = parser.extractCommand(input);
			Response response = invoker.executeAction(command.getName(), command.getArgs());
			if(response.isContainsError())
			{
				System.out.println(response.getErrorMessage());
			}
			if(running)
			{
				input = scanner.nextLine();
			}			
		}

		scanner.close();
	}

	public void setRunning(boolean running)
	{
		this.running = running;
	}
}
