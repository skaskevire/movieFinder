package com.epam.movieFinder.action.converter;

import com.epam.movieFinder.internalException.InternalException;

/**
 * Converter
 * 
 * @author Raman_Skaskevich@epam.com
 */
public interface Converter<I, O> {
	O convert(I i) throws InternalException;
}
