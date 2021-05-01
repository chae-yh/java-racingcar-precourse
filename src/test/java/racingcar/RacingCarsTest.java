package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarsTest {
	List<RacingCar> candidates;

	@Test
	@DisplayName("가능한 자동차 최소 개수가 2대 이상 10대 미만 인지 검증")
	void is_cars_count_bigger_than_2_and_lower_than_10() {
		candidates = new ArrayList<>();
		candidates.add(new RacingCar("1"));
		candidates.add(new RacingCar("2"));

		assertThat(new RacingCars(candidates).getCount() == 2).isTrue();

		candidates = new ArrayList<>();

		assertThatThrownBy(() -> {
			new RacingCars(candidates);
		}).isInstanceOf(IllegalArgumentException.class);

		candidates = new ArrayList<>();
		candidates.add(new RacingCar("1"));

		assertThatThrownBy(() -> {
			new RacingCars(candidates);
		}).isInstanceOf(IllegalArgumentException.class);

		candidates = new ArrayList<>();
		candidates.add(new RacingCar("1"));
		candidates.add(new RacingCar("2"));
		candidates.add(new RacingCar("3"));
		candidates.add(new RacingCar("4"));
		candidates.add(new RacingCar("5"));
		candidates.add(new RacingCar("6"));
		candidates.add(new RacingCar("7"));
		candidates.add(new RacingCar("8"));
		candidates.add(new RacingCar("9"));
		candidates.add(new RacingCar("10"));

		assertThatThrownBy(() -> {
			new RacingCars(candidates);
		}).isInstanceOf(IllegalArgumentException.class);

		candidates = new ArrayList<>();
		candidates.add(new RacingCar("1"));
		candidates.add(new RacingCar("2"));
		candidates.add(new RacingCar("3"));
		candidates.add(new RacingCar("4"));
		candidates.add(new RacingCar("5"));
		candidates.add(new RacingCar("6"));
		candidates.add(new RacingCar("7"));
		candidates.add(new RacingCar("8"));
		candidates.add(new RacingCar("9"));
		candidates.add(new RacingCar("10"));
		candidates.add(new RacingCar("11"));

		assertThatThrownBy(() -> {
			new RacingCars(candidates);
		}).isInstanceOf(IllegalArgumentException.class);
	}
}
