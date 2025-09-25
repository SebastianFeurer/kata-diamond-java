package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	public String createDiamond(int size) {
		if (size <= 0 || size % 2 == 0) {
			return null;
		}
		StringBuilder diamondBuilder = new StringBuilder(new String(createLine(size, size)));
		for (int i = size - 2; i > 0; i -= 2) {
			char[] line = createLine(size, i);
			diamondBuilder.insert(0, line);
			diamondBuilder.append(line);
		}
		return diamondBuilder.toString();
	}

	private char[] createLine(int size, int lineIndex) {
		int amountWhitespaces = ((size - lineIndex) / 2);
		char[] line = new char[amountWhitespaces + lineIndex + 1];
		if (amountWhitespaces > 0) {
			Arrays.fill(line, 0, amountWhitespaces, ' ');
		}
		Arrays.fill(line, amountWhitespaces, amountWhitespaces + lineIndex, '*');
		line[line.length - 1] = '\n';
		return line;
	}

}
