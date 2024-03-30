package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {
	private static final int GAME_END_ROUND = 0;

	private final WinnerSelector winnerSelector;
	private final List<Car> cars;
	private final NumberGenerator numberGenerator;
	private int round;

	public RacingGame(String[] carNames, int round, NumberGenerator numberGenerator) {
		this.cars = generateCars(carNames);
		this.winnerSelector = new WinnerSelector(cars);
		this.numberGenerator = numberGenerator;
		this.round = round;
	}

	private List<Car> generateCars(String[] carNames) {
		return Stream.of(carNames)
			.map(Car::new)
			.collect(Collectors.toList());
	}

	public List<Integer> move() {
		List<Integer> positionList = new ArrayList<>();
		for (Car car : cars) {
			positionList.add(car.moveForwardIfCan(numberGenerator.createNumber()));
		}
		this.round--;

		return positionList;
	}

	public List<String> selectWinners() {
		return this.winnerSelector.selectWinners();
	}

	public int getCarsLength() {
		return this.cars.size();
	}

	public boolean isNotEnd() {
		return this.round > GAME_END_ROUND;
	}

	public List<Car> getCars() {
		return Collections.unmodifiableList(cars);
	}
}
