package com.epam.movieFinder.action.validator;

public interface Validator<T>{
	boolean validate(T t);
}
