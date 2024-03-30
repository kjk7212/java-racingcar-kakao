package racingcar.controller;

import racingcar.model.GameResults;
import racingcar.model.RacingGame;
import racingcar.model.RandomNumberGenerator;
import racingcar.view.View;

public class RacingController {
	private RacingGame racingGame;
	private final View view;

	public RacingController() {
		this.view = new View();
	}

	public void run() {
		gameSetting();
		GameResults gameResult = gameStart();

		this.view.displayResult(gameResult, this.racingGame.getCars());
		this.view.displayWinners(this.racingGame.selectWinners());
	}

	public void gameSetting() {
		String carNames = this.view.requestInputCarName();
		String[] names = createCarNamesFromUserInput(carNames);

		int round = this.view.requestInputTryCount();

		this.racingGame = new RacingGame(names, round, new RandomNumberGenerator());
	}

	private GameResults gameStart() {
		GameResults gameResults = new GameResults();

		this.view.displayStart();
		while (racingGame.isNotEnd()) {
			gameResults.addResult(this.racingGame.move());
		}

		return gameResults;
	}

	public String[] createCarNamesFromUserInput(String input) {
		return input.split(",");
	}

}
