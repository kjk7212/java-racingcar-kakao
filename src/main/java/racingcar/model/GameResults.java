package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameResults {
	private List<GameResult> gameResults;

	public GameResults() {
		this.gameResults = new ArrayList<>();
	}

	public void addResult(GameResult gameResult) {
		this.gameResults.add(gameResult);
	}

	public List<GameResult> getGameResults() {
		return Collections.unmodifiableList(gameResults);
	}
}
