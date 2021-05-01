package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {
	@Test
	@DisplayName("자동차 이름이 5자 이하인지 검증")
	void is_name_lenght_shorter_than_5() {
		assertThat(new RacingCar("abcde").getName().length() == 5).isTrue();

		assertThatThrownBy(() -> {
			new RacingCar("abcdef");
		}).isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() -> {
			new RacingCar("");
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("자동차 이름이 영어와 숫자로만 이루어졌는지 검증")
	void is_name_consist_of_only_English_and_numbers() {
		assertThatThrownBy(() -> {
			new RacingCar("abc$");
		}).isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() -> {
			new RacingCar("1bcㄱ");
		}).isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() -> {
			new RacingCar("1b cd");
		}).isInstanceOf(IllegalArgumentException.class);
	}
}
