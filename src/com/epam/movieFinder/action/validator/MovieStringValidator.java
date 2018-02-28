package com.epam.movieFinder.action.validator;

public class MovieStringValidator implements Validator<String[]>{
	private static final String EMPTY_STRING_MSG_PATTERN = "%s must not be empty. ";
	private static final String INV_VALUE_PATTERN = "Invalid %s .";
	@Override
	public boolean validate(String[] ideoms) {		
		return validateIsNotEmpty(ideoms[0], "Name") &&
				validateIsNotEmpty(ideoms[1], "Year") &&
				validateIsNotEmpty(ideoms[2], "Average Rating") &&
				validateIsNotEmpty(ideoms[3], "Count Of Ratings") &&
				validateInt(ideoms[1], "Year") &&
				validateDouble(ideoms[2], "Average Rating") &&
				validateInt(ideoms[3], "Count Of Ratings");
	}
	
	private boolean validateIsNotEmpty(String fieldValue, String fieldName)
	{
		if (fieldValue.length() == 0) {
			System.out.print(String.format(EMPTY_STRING_MSG_PATTERN, fieldName));
			return false;
		}
		
		return true;
	}
	
	private boolean validateDouble(String fieldValue, String fieldName) {
		try {
			Double.valueOf(fieldValue.trim());
		} catch (NumberFormatException ex) {
			System.out.print(String.format(INV_VALUE_PATTERN, fieldName));
			return false;
		}

		return true;
	}
	
	private boolean validateInt(String fieldValue, String fieldName) {
		try {
			Integer.valueOf(fieldValue.trim());
		} catch (NumberFormatException ex) {
			System.out.print(String.format(INV_VALUE_PATTERN, fieldName));
			return false;
		}

		return true;
	}

}
