package com.epam.movieFinder.storage;

import java.util.List;

/**
 * Storage
 * 
 * @author Raman_Skaskevich@epam.com
 */
public interface Storage<T> {
	List<T> returnInfoList();

	void addInfo(T t);
}
