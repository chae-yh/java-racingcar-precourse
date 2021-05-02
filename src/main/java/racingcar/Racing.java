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

	public Winners start() {
		Set<RacingCar> winnersSet = new HashSet<>();

		while (!status.equals(RacingStatus.FINISH)) {
			racingCarsMove(winnersSet);
		}

		return new Winners(winnersSet);
	}

	private void racingCarsMove(Set<RacingCar> winnersSet) {
		for (RacingCar racingCar : racingCars.getRacingCars()) {
			racingCar.move();
			checkWinners(winnersSet, racingCar);
		}
	}

	public Winners start(int number) {
		Set<RacingCar> winnersSet = new HashSet<>();

		while (!status.equals(RacingStatus.FINISH)) {
			racingCarsMove(number, winnersSet);
		}

		return new Winners(winnersSet);
	}

	private void racingCarsMove(int number, Set<RacingCar> winnersSet) {
		for (RacingCar racingCar : racingCars.getRacingCars()) {
			racingCar.move(number);
			checkWinners(winnersSet, racingCar);
		}
	}

	private void checkWinners(Set<RacingCar> winnersSet, RacingCar racingCar) {
		if (racingCar.getMovedDisdantce() >= movementDistanceInput.getInput()) {
			winnersSet.add(racingCar);
			status = RacingStatus.FINISH;
		}
	}
}
