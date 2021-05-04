package racingcar;

import java.util.regex.Pattern;

public class RacingCarName {
	private static final int MIN_NAME_LENGTH = 0;
	private static final int MAX_NAME_LENGTH = 5;
	public static final String REGEX_TARGET = "^[0-9a-zA-Z]*$";

	private String name;

	public RacingCarName(String name) {
		nameLengthRangeValidation(name);
		nameCharacterValidation(name);
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	private void nameLengthRangeValidation(String name) {
		if (name.length() <= MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException("name's length is over allowed range(min : 1 / max : 5)");
		}
	}

	private void nameCharacterValidation(String name) {
		Pattern pattern = Pattern.compile(REGEX_TARGET);

		if (!pattern.matcher(name).find()) {
			throw new IllegalArgumentException("only number and alphabet are allowed");
		}
	}
}
