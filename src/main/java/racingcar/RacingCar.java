package racingcar;

import java.util.Objects;
import java.util.regex.Pattern;

public class RacingCar {
	private static final int MIN_NAME_LENGTH = 0;
	private static final int MAX_NAME_LENGTH = 5;
	public static final String REGEX_TARGET = "^[0-9a-zA-Z]*$";

	private String name;
	private int movedDisdantce;

	public RacingCar(String name) {
		this.name = name;
		nameLengthRangeValidation();
		nameCharacterValidation();
	}

	public void move() {
		RandomNo randomNo = new RandomNo();

		if (randomNo.getNo() >= 4) {
			this.movedDisdantce++;
		}
	}

	public void move(int number) {
		RandomNo randomNo = new RandomNo(number);

		if (randomNo.getNo() >= 4) {
			this.movedDisdantce++;
		}
	}

	public int getMovedDisdantce() {
		return this.movedDisdantce;
	}

	public String getName() {
		return this.name;
	}

	private void nameLengthRangeValidation() {
		if (this.name.length() <= MIN_NAME_LENGTH || this.name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException();
		}
	}

	private void nameCharacterValidation() {
		Pattern pattern = Pattern.compile(REGEX_TARGET);

		if (!pattern.matcher(this.name).find()) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getName());
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof RacingCar)) {
			return false;
		}

		return this.getName().equals(((RacingCar)obj).getName());
	}
}
