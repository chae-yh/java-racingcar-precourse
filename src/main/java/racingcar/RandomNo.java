package racingcar;

public class RandomNo {
	int number;

	public RandomNo() {
		this.number = generateRandomNo();
		numberRangeValidation();
	}

	private int generateRandomNo() {
		return (int)(Math.random() * 10);
	}

	public RandomNo(int number) {
		this.number = number;
		numberRangeValidation();
	}

	private void numberRangeValidation() {
		if (this.number < 0 || this.number >= 10) {
			throw new IllegalArgumentException();
		}
	}

	public int getNo() {
		return this.number;
	}
}
