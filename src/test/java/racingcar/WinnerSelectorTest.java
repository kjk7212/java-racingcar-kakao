package racingcar;

import static org.assertj.core.api.SoftAssertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.controller.RacingController;
import racingcar.model.CustomNumberGenerator;
import racingcar.model.RacingGame;
import racingcar.model.WinnerSelector;

public class WinnerSelectorTest {
	RacingGame racingGame;
	RacingController racingController;

	@BeforeEach
	void setUp(){
		racingController = new RacingController();
	}

	@Test
	@DisplayName("우승자 테스트")
	void winnerTest() {
		racingGame = new RacingGame(racingController.createCarNamesFromUserInput("fre,bas,123"), 3, new CustomNumberGenerator(4));
		racingGame.move();

		WinnerSelector winnerSelector = new WinnerSelector(racingGame.getCars());

		List<String> winners = winnerSelector.selectWinners();

		assertSoftly(softly -> {
				softly.assertThat(winners.get(0)).isEqualTo("fre");
				softly.assertThat(winners.get(1)).isEqualTo("bas");
				softly.assertThat(winners.get(2)).isEqualTo("123");
		});



	}
}
