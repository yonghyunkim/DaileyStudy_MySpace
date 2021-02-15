package designPattern.strategy;

public class StrategyPattern {
	public static void main(String[] args) {
		System.out.println("Strategy Pattern Start");
		
		Car car = new Car(new UpMoveCar());
		car.move();
		
		car = new Car(new DownMoveCar());
		car.move();
		
	}

}
