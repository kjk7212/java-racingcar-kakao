package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameResult {
	private final List<Integer> gameResult;

	public GameResult() {
		this.gameResult = new ArrayList<>();
	}

	public void addResult(int result) {
		gameResult.add(result);
	}

	public List<Integer> getGameResult() {
		return Collections.unmodifiableList(gameResult);
	}

	public int getGameResultSize() {
		return gameResult.size();
	}
}
