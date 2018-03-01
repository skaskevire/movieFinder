package com.epam.movieFinder.invoker;

import java.util.List;
import java.util.Map;

import com.epam.movieFinder.Response;
import com.epam.movieFinder.action.ActionEnum;
import com.epam.movieFinder.action.DefaultAction;

/**
 * Decides which command from internal list needed for execution
 * 
 * @author Raman_Skaskevich@epam.com
 */
public interface Invoker {
	Response executeAction(ActionEnum action, List<String> args);
	Map<String, DefaultAction> getHandledActions();
}
