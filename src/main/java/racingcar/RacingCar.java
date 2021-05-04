package racingcar;

import java.util.Objects;

public class RacingCar {
	private MovementDistance movedDistance;
	private RacingCarName name;

	public RacingCar(String name) {
		this.name = new RacingCarName(name);
		init();
	}

	private void init() {
		movedDistance = new MovementDistance();
	}

	public void move() {
		RandomNo randomNo = new RandomNo();

		if (randomNo.getNo() >= 4) {
			movedDistance.addOneDistance();
		}
	}

	public void move(int number) {
		RandomNo randomNo = new RandomNo(number);

		if (randomNo.getNo() >= 4) {
			movedDistance.addOneDistance();
		}
	}

	public int getMovedDistance() {
		return movedDistance.getDistance();
	}

	public String getName() {
		return name.getName();
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getName());
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof RacingCar)) {
			return false;
		}

		return this.getName().equals(((RacingCar)obj).getName());
	}
}
