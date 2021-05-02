package racingcar;

import java.util.Set;

public class Winners {
	private Set<RacingCar> racingCars;

	public Winners(Set<RacingCar> winners) {
		this.racingCars = winners;
	}

	public Set<RacingCar> getRacingCars() {
		return this.racingCars;
	}
}
