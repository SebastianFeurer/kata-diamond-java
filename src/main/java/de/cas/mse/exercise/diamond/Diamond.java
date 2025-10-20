package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	private static final char WHITESPACE = ' ';
	private static final char LINEBREAK = '\n';
	private static final char STAR = '*';

	public String print(int width) {
		if (isInvalidWidth(width)) {
			return null;
		}
		StringBuilder builder = generateBuilderWithMiddleRowInserted(width);
		for (int i = width - 2; i > 0; i -= 2) {
			char[] row = generateRow(width, i);
			builder.insert(0, row);
			builder.append(row);
		}
		return builder.toString();
	}

	private StringBuilder generateBuilderWithMiddleRowInserted(int width) {
		return new StringBuilder(new String(generateRow(width, width)));
	}

	private boolean isInvalidWidth(int width) {
		return isNegativ(width) || isEven(width);
	}

	private boolean isEven(int width) {
		return width % 2 == 0;
	}

	private boolean isNegativ(int width) {
		return width <= 0;
	}

	private char[] generateRow(int maxRowWidth, int starCountForRow) {
		int frontPaddingSize = ((maxRowWidth - starCountForRow) / 2);
		char[] row = new char[frontPaddingSize + starCountForRow + 1];
		insertFrontPadding(frontPaddingSize, row);
		insertStars(starCountForRow, frontPaddingSize, row);
		insertLineBreak(row);
		return row;
	}

	private void insertLineBreak(char[] row) {
		row[row.length - 1] = LINEBREAK;
	}

	private void insertStars(int starCountForRow, int offset, char[] row) {
		int toIndex = offset + starCountForRow;
		Arrays.fill(row, offset, toIndex, STAR);
	}

	private void insertFrontPadding(int whitespaceCount, char[] row) {
		if (whitespaceCount > 0) {
			Arrays.fill(row, 0, whitespaceCount, WHITESPACE);
		}
	}

}
