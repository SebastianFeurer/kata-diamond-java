package de.cas.mse.exercise.diamond;


// TODO make diamond factory 💸
public class Diamond {

	public String create(int numberOfRows) {
		if (numberOfRows <= 0 || numberOfRows % 2 == 0) {
			return "";
		}

		StringBuilder builder = new StringBuilder();
		builder.append(makeRow(numberOfRows, numberOfRows));
		
		for (int numberOfStars = numberOfRows - 2; numberOfStars > 0; numberOfStars -= 2) {
			String row = makeRow(numberOfRows, numberOfStars);
			builder.insert(0, row);
			builder.append(row);
		}

		return builder.toString();
	}

	private String makeRow(int length, int numberOfStars) throws IllegalArgumentException {
		if (numberOfStars > length) {
			throw new IllegalArgumentException("Too many stars for row length :(");
		}

		int leftPadding = ((length - numberOfStars) / 2);
		StringBuilder builder = new StringBuilder(leftPadding + numberOfStars + 1);
		if (leftPadding > 0) {
			builder.append(" ".repeat(leftPadding));
		}
		
		builder.append("*".repeat(numberOfStars));
		builder.append("\n");
		return builder.toString();
	}

}
