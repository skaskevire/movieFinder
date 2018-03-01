package com.epam.movieFinder.action;

public enum ActionEnum {
	EXTRACT_MOVIES("extract"),
	FILTER_BY_RATING_BETTER_THAN("FilterByRatingBetterThan"),
	FILTER_BY_YEAR_OF_PRODUCTION("FilterByYearOfProduction"),
	FILTER_BY_RATING_COUNT_MORE_THAN("FilterByRatingCountMoreThan"),
	SHOW_MOVIE_COUNT("ShowMovieCount"),
	SHOW_TITLES("ShowTitles"),
	RESET("Reset"),
	EXIT("exit");

	String name;

	ActionEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static ActionEnum getByName(String name) {
		for (ActionEnum action : ActionEnum.values()) {
			if (action.getName().equals(name)) {
				return action;
			}
		}

		return null;
	}
}
