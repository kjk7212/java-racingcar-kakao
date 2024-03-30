package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerSelector {
	private final List<Car> cars;

	public WinnerSelector(List<Car> cars){
		this.cars = cars;
	}

	public List<String> selectWinners() {
		int maxPosition = getMaxPosition();

		return cars.stream()
			.filter(car -> car.getPosition() == maxPosition)
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	private int getMaxPosition() {
		return cars.stream()
			.mapToInt(Car::getPosition)
			.max()
			.orElseThrow(() -> new IllegalStateException("있을 수 없는 상황이다."));
	}
}
