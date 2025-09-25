package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	private final static int PREPEND_OFFSET = 0;
	private final static int NUMBER_OF_STARS_TO_REMOVE_PER_LINE = 2;

	public String print(int rowCount) {
		if (validateRowCount(rowCount)) {
			return null;
		}
		StringBuilder builder = new StringBuilder();
		builder.append(createLine(rowCount, rowCount));
		for (int currentRow = rowCount - NUMBER_OF_STARS_TO_REMOVE_PER_LINE; currentRow > 0; currentRow -= NUMBER_OF_STARS_TO_REMOVE_PER_LINE) {
			char[] chars = createLine(rowCount, currentRow);
			builder.insert(PREPEND_OFFSET, chars);
			builder.append(chars);
		}
		return builder.toString();
	}

	private boolean validateRowCount(int rowCount){
		return rowCount <= 0 || rowCount % 2 == 0;
	}

	private char[] createLine(int maxRowCount, int currrentRowCount) {
		int amountOfSpaces = ((maxRowCount - currrentRowCount) / 2);
		char[] chars = new char[amountOfSpaces + currrentRowCount + 1];
		if (amountOfSpaces > 0) {
			Arrays.fill(chars, 0, amountOfSpaces, ' ');
		}
		Arrays.fill(chars, amountOfSpaces, amountOfSpaces + currrentRowCount, '*');
		chars[chars.length - 1] = '\n';
		return chars;
	}

}
