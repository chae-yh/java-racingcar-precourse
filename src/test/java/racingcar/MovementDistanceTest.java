package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MovementDistanceTest {
	@Test
	@DisplayName("입력 값이 숫자인지 체크함")
	void is_number() {
		assertThat(new MovementDistance("11").getDistance() == 11).isTrue();

		assertThatThrownBy(() -> {
			new MovementDistance("abc");
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("입력 값이 0보다 크고 100보다 작은지 검증")
	void is_inputvaluse_greater_than_0_and_lower_than_100() {
		assertThat(new MovementDistance("10").getDistance() == 10).isTrue();

		assertThatThrownBy(() -> {
			new MovementDistance("0");
		}).isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() -> {
			new MovementDistance("-1");
		}).isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() -> {
			new MovementDistance("100");
		}).isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() -> {
			new MovementDistance("123");
		}).isInstanceOf(IllegalArgumentException.class);
	}
}
