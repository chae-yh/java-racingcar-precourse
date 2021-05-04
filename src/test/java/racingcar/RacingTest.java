package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingTest {
	RacingCars racingCars;

	@BeforeEach
	void setUp() {
		Set<RacingCar> candidates;
		candidates = new HashSet<>();
		candidates.add(new RacingCar("f"));
		candidates.add(new RacingCar("s"));

		racingCars = new RacingCars(candidates);
	}

	@Test
	@DisplayName("한 번의 레이스 후 최대 1만큼 움직임")
	void move_at_most_1_distance_after_one_race() {
		MovementDistance movementDistance = new MovementDistance("10");
		Racing racing = new Racing(racingCars, movementDistance);

		racing.race(5);

		for (RacingCar racingCar : racingCars.getRacingCars()) {
			assertThat(racingCar.getMovedDistance() == 1).isTrue();
		}
	}

	@Test
	@DisplayName("경기가 끝나면 차는 움직이지 않음")
	void when_a_race_is_finished_cars_dont_move() {
		MovementDistance movementDistance = new MovementDistance("1");
		Racing racing = new Racing(racingCars, movementDistance);

		racing.race(5);
		racing.race(5);
		racing.race(5);

		for (RacingCar racingCar : racingCars.getRacingCars()) {
			assertThat(racingCar.getMovedDistance() == 1).isTrue();
		}
	}

	@Test
	@DisplayName("게임 완료 후 누가 우승했는지 알려줌")
	void inform_who_is_the_winner_when_the_racing_is_finished() {
		String winnerName = "";

		MovementDistance movementDistance = new MovementDistance("2");
		Racing racing = new Racing(racingCars, movementDistance);

		racing.race(5);

		assertThatThrownBy(() -> {
			racing.getWinners();
		}).isInstanceOf(IllegalArgumentException.class);

		racing.race(5);
		racing.race(5);

		for (RacingCar racingCar : racing.getWinners().getRacingCars()) {
			winnerName += racingCar.getName();
		}

		assertThat(winnerName.equals("sf")).isTrue();
	}
}
