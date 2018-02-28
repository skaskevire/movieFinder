package com.epam.movieFinder.action.converter;

import com.epam.movieFinder.internalException.InternalException;

public interface Converter<I, O> {
	O convert(I i) throws InternalException;
}
