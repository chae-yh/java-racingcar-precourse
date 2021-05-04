package racingcar;

public class MovementDistanceInput {
	private static final int MIN_VALUE = 0;
	private static final int MAX_VALUE = 100;
	int input;

	public MovementDistanceInput(String input) {
		this.input = parseInputValue(input);
		isInAllowedRange();
	}

	private int parseInputValue(String input) {
		return Integer.parseInt(input);
	}

	private void isInAllowedRange() {
		if (this.input <= MIN_VALUE || this.input >= MAX_VALUE) {
			throw new IllegalArgument();
		}
	}

	public int getInput() {
		return this.input;
	}
}
