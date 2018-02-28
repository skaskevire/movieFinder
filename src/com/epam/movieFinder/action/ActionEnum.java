package com.epam.movieFinder.action;

public enum ActionEnum {
	EXTRACT_MOVIES("extract"), FILTER_BY_RATING_BETTER_THAN("FilterByRatingBetterThan"), FILTER_BY_YEAR_OF_PRODUCTION(
			"FilterByYearOfProduction"), FILTER_BY_RATING_COUNT_MORE_THAN("FilterByRatingCountMoreThan"), EXIT("exit"), ShowMovieCount("ShowMovieCount"), ShowTitles("ShowTitles"), Reset("Reset");
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
