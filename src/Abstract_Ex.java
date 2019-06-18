public class Abstract_Ex {
	public static void main(String[] args) {
		Dog happy = new AA();
		Cat julia = new Cat();
		happy.move(); // 오버라이드된 멤버함수 호출
		happy.howl(); // 구현된 멤버함수 호출
		julia.move(); // 일반 멤버함수 호출
		julia.howl(); // 구현된 멤버함수 호출
	}
}


abstract class Animal {
    public String sName;
    public void move() {
        System.out.println("어슬렁 어슬렁");
    }
    abstract void howl();
}

abstract class Dog extends Animal {
    public void move() {
        System.out.println("팔짝 팔짝");
    }

    
}


class AA extends Dog {

	@Override
	void howl() {
		// TODO 자동 생성된 메소드 스텁
		
	}
	
	
}


class Cat extends Animal {
    void howl() {
            System.out.println("냐옹");
    }
}


