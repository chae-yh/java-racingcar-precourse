package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarsTest {
	Set<RacingCar> candidates;

	@Test
	@DisplayName("가능한 자동차 최소 개수가 1대 이상 10대 미만 인지 검증")
	void is_cars_count_bigger_than_1_and_lower_than_10() {
		candidates = new HashSet<>();
		candidates.add(new RacingCar("1"));

		assertThat(new RacingCars(candidates).getCount() == 1).isTrue();

		candidates = new HashSet<>();

		assertThatThrownBy(() -> {
			new RacingCars(candidates);
		}).isInstanceOf(IllegalArgumentException.class);

		candidates = new HashSet<>();
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

		candidates = new HashSet<>();
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

	@Test
	@DisplayName("같은 이름을 가진 자동차는 한 대로 취급")
	void is_cars_that_have_same_name_considered_to_be_one_car() {
		candidates = new HashSet<>();
		candidates.add(new RacingCar("same"));
		candidates.add(new RacingCar("same"));
		candidates.add(new RacingCar("diff"));

		assertThat(new RacingCars(candidates).getCount() == 2).isTrue();
	}
}
