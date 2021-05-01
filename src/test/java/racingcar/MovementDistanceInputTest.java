package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MovementDistanceInputTest {
	@Test
	@DisplayName("입력 값이 숫자인지 체크함")
	void is_number() {
		assertThat(new MovementDistanceInput("11").getInput() == 11).isTrue();

		assertThatThrownBy(() -> {
			new MovementDistanceInput("abc");
		}).isInstanceOf(NumberFormatException.class);
	}

	@Test
	@DisplayName("입력 값이 0보다 크고 100보다 작은지 검증")
	void is_inputvaluse_greater_than_0_and_lower_than_100() {
		assertThat(new MovementDistanceInput("10").getInput() == 10).isTrue();

		assertThatThrownBy(() -> {
			new MovementDistanceInput("0");
		}).isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() -> {
			new MovementDistanceInput("-1");
		}).isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() -> {
			new MovementDistanceInput("100");
		}).isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() -> {
			new MovementDistanceInput("123");
		}).isInstanceOf(IllegalArgumentException.class);
	}
}
