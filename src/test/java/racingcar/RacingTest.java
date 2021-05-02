package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingTest {
	@Test
	@DisplayName("게임 완료 후 누가 우승했는지 알려줌")
	void inform_who_is_the_winner_when_the_racing_is_finished() {
		Set<RacingCar> candidates;
		candidates = new HashSet<>();
		candidates.add(new RacingCar("f"));
		candidates.add(new RacingCar("s"));

		RacingCars racingCars = new RacingCars(candidates);
		MovementDistanceInput movementDistanceInput = new MovementDistanceInput("10");
		Racing racing = new Racing(racingCars, movementDistanceInput);
		Winners winners = racing.start(5);

		String winnerName = "";

		for (RacingCar racingCar : winners.getRacingCars()) {
			winnerName += racingCar.getName();
		}

		assertThat(winnerName.equals("sf")).isTrue();
	}
}
