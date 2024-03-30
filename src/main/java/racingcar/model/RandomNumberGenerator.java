package racingcar.model;

public class RandomNumberGenerator implements NumberGenerator{
	private static final int RANDOM_NUMBER_RANGE = 9;

	public RandomNumberGenerator(){
	}

	public int createNumber(){
		return (int)(Math.random() * RANDOM_NUMBER_RANGE);
	}
}
