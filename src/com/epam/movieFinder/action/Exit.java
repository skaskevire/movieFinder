package com.epam.movieFinder.action;

import java.util.List;

import com.epam.movieFinder.Launcher;
import com.epam.movieFinder.internalException.InternalException;
import com.epam.movieFinder.storage.MovieStorage;

public class Exit extends DefaultAction {
	private Launcher launcher;
	public Exit(MovieStorage movieStorage, Launcher launcher) {
		this(movieStorage);
		this.launcher = launcher;
	}
	public Exit(MovieStorage movieStorage) {
		super(movieStorage);
	}

	@Override
	public void execute(List<String> args) throws InternalException {
		launcher.setRunning(false);
	}

}
