package com.epam.movieFinder.invoker;

import java.util.List;

import com.epam.movieFinder.Response;
import com.epam.movieFinder.action.ActionEnum;

public interface Invoker {
	public Response executeAction(ActionEnum action, List<String> args);
}
