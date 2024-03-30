package racingcar.model;

public class CustomNumberGenerator implements NumberGenerator{
	private final int num;

	public CustomNumberGenerator(int num){
		this.num = num;
	}

	public int createNumber(){
		return num;
	}
}
