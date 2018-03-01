package com.epam.movieFinder.invoker.impl;

import java.util.List;
import java.util.Map;

import com.epam.movieFinder.Response;
import com.epam.movieFinder.action.ActionEnum;
import com.epam.movieFinder.action.DefaultAction;
import com.epam.movieFinder.internalException.InternalException;
import com.epam.movieFinder.invoker.Invoker;

/**
 * Implementation of {@Invoker}
 * 
 * @author Raman_Skaskevich@epam.com
 */
public class InvokerImpl implements Invoker {
	private Map<String, DefaultAction> handledActions;
	@Override
	public Map<String, DefaultAction> getHandledActions() {
		return handledActions;
	}

	public InvokerImpl(Map<String, DefaultAction> handledActions) {
		this.handledActions = handledActions;
	}
	@Override
	public Response executeAction(ActionEnum action, List<String> args) {
		try {
			if(action == null)
			{
				throw new InternalException("Unknown command");
			}
			handledActions.get(action.getName()).execute(args);
			return new Response(null, false, null);
		} catch (InternalException e) {			
			return new Response(null, true, e.getMessage());
		}
	}
}
