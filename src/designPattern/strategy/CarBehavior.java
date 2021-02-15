package designPattern.strategy;

class UpMoveCar implements CarMove {

	@Override
	public void action() {
		System.out.println("Up Move!");
	}	
}

class DownMoveCar implements CarMove {

	@Override
	public void action() {
		System.out.println("Down Move!");
	}

}

class RightMoveCar implements CarMove {

	@Override
	public void action() {
		System.out.println("Right Move!");
	}

}
