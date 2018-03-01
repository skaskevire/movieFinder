package com.epam.movieFinder;

import java.util.ArrayList;
import java.util.List;

import com.epam.movieFinder.action.ActionEnum;

/**
 * Contains command name and arguments
 * 
 * @author Raman_Skaskevich@epam.com
 */
public class Command {
	private ActionEnum name;
	private List<String> args = new ArrayList<>();

	public Command(ActionEnum name, List<String> args) {
		super();
		this.name = name;
		this.args = args;
	}

	public List<String> getArgs() {
		return args;
	}

	public ActionEnum getName() {
		return name;
	}
}