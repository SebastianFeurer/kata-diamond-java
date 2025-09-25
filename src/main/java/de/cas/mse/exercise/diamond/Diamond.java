package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	public String print(int thickness) {
		if (thickness <= 0 || (thickness % 2) == 0) {
			return null;
		}

		StringBuilder builder = new StringBuilder(new String(fillRow(thickness, thickness)));
		for (int spaces = thickness - 2; spaces > 0; spaces -= 2) {
			char[] row = fillRow(thickness, spaces);
			builder.insert(0, row);
			builder.append(row);
		}
		return builder.toString();
	}

	private char[] fillRow(int spaces, int stars) {
		int starBegin = ((spaces - stars) / 2);
		int starEnd = starBegin + stars;
		char[] line = new char[starEnd + 1];
		if (starBegin > 0) {
			Arrays.fill(line, 0, starBegin, ' ');
		}
		Arrays.fill(line, starBegin, starEnd, '*');
		line[line.length - 1] = '\n';
		return line;
	}

}
