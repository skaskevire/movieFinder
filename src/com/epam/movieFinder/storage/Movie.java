package com.epam.movieFinder.storage;

/**
 * Movie data object
 * 
 * @author Raman_Skaskevich@epam.com
 */
public class Movie {
	private String name;
	private Integer dateOfIssue;
	private double rating;

	public Movie(String name, Integer dateOfIssue, double rating, Integer val) {
		super();
		this.name = name;
		this.dateOfIssue = dateOfIssue;
		this.rating = rating;
		this.val = val;
	}

	private Integer val;
	public String getName() {
		return name;
	}
	public Integer getDateOfIssue() {
		return dateOfIssue;
	}
	public double getRating() {
		return rating;
	}
	public Integer getVal() {
		return val;
	}
}
