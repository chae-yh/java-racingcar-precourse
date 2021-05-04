package racingcar;

public class MovementDistance {
	private static final int MIN_VALUE = 0;
	private static final int MAX_VALUE = 100;
	int distance;

	public MovementDistance(String input) {
		this.distance = parseInputValue(input);
		isInAllowedRange();
	}

	public MovementDistance() {
		init();
	}

	private int parseInputValue(String input) {
		int value;

		try {
			value = Integer.parseInt(input);
		} catch (Exception e) {
			throw new IllegalArgumentException("input must be number");
		}

		return value;
	}

	private void init() {
		this.distance = 0;
	}

	private void isInAllowedRange() {
		if (this.distance <= MIN_VALUE || this.distance >= MAX_VALUE) {
			throw new IllegalArgumentException("movement distance is over allowed range(min : 1 / max : 99)");
		}
	}

	public int getDistance() {
		return this.distance;
	}

	public void addOneDistance() {
		this.distance++;
	}
}
