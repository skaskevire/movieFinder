package com.epam.movieFinder.cache;

import java.util.LinkedList;

import com.epam.movieFinder.storage.MovieStorage;

public class MovieStorageStackedStateCache{
	private LinkedList<MovieStorage> movieStorageStateSnapshot = new LinkedList<MovieStorage>();
	private boolean isRunning = true;

	public void pushMovieStorageStateSnapshot(MovieStorage t) {
		movieStorageStateSnapshot.push(t);
	}
	
	public MovieStorage popSnapshot() {
		if (movieStorageStateSnapshot.size() > 1) {
			return movieStorageStateSnapshot.pop();
		}

		return null;
	}
	
	public MovieStorage showLastSnapshot() {

			return movieStorageStateSnapshot.peek();
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
}
