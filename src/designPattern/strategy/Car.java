package designPattern.strategy;

public class Car {
	private CarMove carmove;
	
	public Car(CarMove carMove) {
		this.carmove = carMove;
	}
	
	
	public void move() {
		carmove.action();
	}

}
