package com.epam.movieFinder.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.epam.movieFinder.Command;
import com.epam.movieFinder.action.ActionEnum;

public class ActionParser {
	private static final String IDEOM_DELIMETERS = " ";
	
	public Command extractCommand(String line )
	{	
		String [] ideoms  = line.split(IDEOM_DELIMETERS);
		ActionEnum action = ActionEnum.getByName(ideoms[0]);
		List<String> parameters = IntStream.range(1,  ideoms.length).mapToObj(index -> ideoms[index]).collect(Collectors.toList());
		return new Command(action, parameters);
	}
}
