package com.epam.movieFinder.action;

import java.util.List;

import com.epam.movieFinder.internalException.InternalException;
import com.epam.movieFinder.storage.MovieStorage;


/**
 * Abstract action, contains movie storage.
 * 
 * @author Raman_Skaskevich@epam.com
 */
public abstract class DefaultAction{
	protected MovieStorage movieStorage;

	public DefaultAction(MovieStorage movieStorage) {
		super();
		this.movieStorage = movieStorage;
	}
	
	public abstract void execute(List<String> args) throws InternalException;
	
	protected void validateDoubleArgument(String argument) throws InternalException
	{
		try {
			Double.valueOf(argument);
		} catch (NumberFormatException e) {
			throw new InternalException("Wrong argument format");
		}
	}
	
	protected void validateIntegerArgument(String argument) throws InternalException
	{
		try {
			Integer.valueOf(argument);
		} catch (NumberFormatException e) {
			throw new InternalException("Wrong argument format");
		}
	}
}
