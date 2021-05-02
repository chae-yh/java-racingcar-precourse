package racingcar;

import java.util.HashSet;
import java.util.Set;

public class Racing {
	private RacingCars racingCars;
	private MovementDistanceInput movementDistanceInput;
	private RacingStatus status;

	public Racing(RacingCars racingCars, MovementDistanceInput movementDistanceInput) {
		this.racingCars = racingCars;
		this.movementDistanceInput = movementDistanceInput;

		init();
	}

	private void init() {
		status = RacingStatus.READY;
	}

	public void race() {
		if (isFinished()) {
			return;
		}

		for (RacingCar racingCar : racingCars.getRacingCars()) {
			racingCar.move();
			setFinishFlag(racingCar);
		}
	}

	public void race(int number) {
		if (isFinished()) {
			return;
		}

		for (RacingCar racingCar : racingCars.getRacingCars()) {
			racingCar.move(number);
			setFinishFlag(racingCar);
		}
	}

	public RacingCars getWinners() {
		if (!isFinished()) {
			throw new IllegalArgumentException();
		}

		return new RacingCars(getWinnersSet());
	}

	private Set<RacingCar> getWinnersSet() {
		Set<RacingCar> winnersSet = new HashSet<>();

		for (RacingCar racingCar : racingCars.getRacingCars()) {
			setWinners(winnersSet, racingCar);
		}

		return winnersSet;
	}

	private void setWinners(Set<RacingCar> winnersSet, RacingCar racingCar) {
		if (isReachedAtGoal(racingCar)) {
			winnersSet.add(racingCar);
		}
	}

	private void setFinishFlag(RacingCar racingCar) {
		if (!isFinished() && isReachedAtGoal(racingCar)) {
			status = RacingStatus.FINISH;
		}
	}

	public boolean isFinished() {
		return RacingStatus.FINISH.equals(status);
	}

	private boolean isReachedAtGoal(RacingCar racingCar) {
		return racingCar.getMovedDistance() >= movementDistanceInput.getInput();
	}
}
