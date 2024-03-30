package racingcar.model;

public class RandomNumberGenerator implements NumberGenerator{

	public RandomNumberGenerator(){
	}

	public int createNumber(){
		return (int)(Math.random() * 9);
	}
}
