package com.epam.movieFinder.storage;

import java.util.List;

public interface Storage<T> {
	List<T> returnInfoList();

	void addInfo(T t);
}
