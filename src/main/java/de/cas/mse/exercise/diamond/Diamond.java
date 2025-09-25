package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	public String print(int numberOfRows) {
		if (numberOfRows <= 0 || numberOfRows % 2 == 0) {
			return "";
		}
		
		StringBuilder builder = new StringBuilder(new String(makeRow(numberOfRows, numberOfRows)));
		for (int numberOfStars = numberOfRows - 2; numberOfStars > 0; numberOfStars -= 2) {
			char[] row = makeRow(numberOfRows, numberOfStars);
			builder.insert(0, row);
			builder.append(row);
		}
		return builder.toString();
	}

	private char[] makeRow(int length, int numberOfStars) {
		int leftPadding = ((length - numberOfStars) / 2);
		char[] row = new char[leftPadding + numberOfStars + 1];
		if (leftPadding > 0) {
			Arrays.fill(row, 0, leftPadding, ' ');
		}
		Arrays.fill(row, leftPadding, leftPadding + numberOfStars, '*');
		row[row.length - 1] = '\n';
		return row;
	}

}
