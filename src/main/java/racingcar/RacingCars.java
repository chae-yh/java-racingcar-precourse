package racingcar;

import java.util.Set;

public class RacingCars {
	public static final int RACING_CARS_MIN_COUNT = 2;
	public static final int RACING_CARS_MAX_COUNT = 10;
	private Set<RacingCar> racingCars;

	public RacingCars(Set<RacingCar> candidates) {
		this.racingCars = candidates;
		countValidation();
	}

	public int getCount() {
		return this.racingCars.size();
	}

	private void countValidation() {
		if (this.getCount() < RACING_CARS_MIN_COUNT || this.getCount() >= RACING_CARS_MAX_COUNT) {
			throw new IllegalArgumentException();
		}
	}
}
