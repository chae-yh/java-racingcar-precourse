package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNoTest {
	@Test
	@DisplayName("랜덤 값이 0이상 9이하 인지 검증")
	void is_random_number_in_allowed_range() {
		assertThat(new RandomNo(3).getNo() == 3).isTrue();

		assertThat(new RandomNo(0).getNo() == 0).isTrue();

		assertThat(new RandomNo(9).getNo() == 9).isTrue();

		assertThatThrownBy(() -> {
			new RandomNo(-1);
		}).isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() -> {
			new RandomNo(10);
		}).isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() -> {
			new RandomNo(31);
		}).isInstanceOf(IllegalArgumentException.class);
	}
}
