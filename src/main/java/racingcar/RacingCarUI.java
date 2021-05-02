package racingcar;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RacingCarUI {
	public void print() {
		Scanner scanner = new Scanner(System.in);

		Racing racing = new Racing(askRacingCarsName(scanner), askMovementDistance(scanner));
		printRacing(racing);
		printRacingResult(racing);
	}

	private RacingCars askRacingCarsName(Scanner scanner) {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String racingCarsInput = scanner.nextLine();

		Set<RacingCar> candidates = new HashSet<>();

		for (String racingCarName : racingCarsInput.split(",")) {
			candidates.add(new RacingCar(racingCarName));
		}

		return new RacingCars(candidates);
	}

	private MovementDistanceInput askMovementDistance(Scanner scanner) {
		System.out.println("시도할 회수는 몇회인가요?");
		return new MovementDistanceInput(scanner.nextLine());
	}

	private void printRacing(Racing racing) {
		System.out.println();
		System.out.println("실행 결과");

		while (!racing.isFinished()) {
			racing.race();

			printRacingSituation(racing);
		}
	}

	private void printRacingResult(Racing racing) {
		String winners = "";

		for (RacingCar racingCar : racing.getWinners().getRacingCars()) {
			winners += racingCar.getName() + ", ";
		}

		System.out.println(tidyUpResult(winners) + "가 최종 우승했습니다.");
	}

	private String tidyUpResult(String winners) {
		return winners.substring(0, winners.lastIndexOf(", "));
	}

	private void printRacingSituation(Racing racing) {
		for (RacingCar racingCar : racing.getRacingcarsOnRace().getRacingCars()) {
			System.out.println(racingCar.getName() + ":" + getMovementDistanceInLine(racingCar));
		}

		System.out.println();
	}

	private String getMovementDistanceInLine(RacingCar racingCar) {
		String distance = "";

		for (int i = 0; i < racingCar.getMovedDistance(); i++) {
			distance += "-";
		}

		return distance;
	}
}
