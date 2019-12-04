# DI ( Dependency Injection ) - 의존성 주입

객체를 setter로 받아서 작업하는 것.  

의존성 : 사용할 작업 클래스에 의존하는 성격.  
         보통 사람이 다른사람에게 의존한다, 의지하다, 종속적이다라는 개념
         다른사람이 변하면 자기도 변하게 되는걸 말한다.
         
```
public class ClassA{
	public void show(String str){
		System.out.println("ClassA : " + str);    
	}
}

public class ClassB{
	public void show(String str){
		System.out.println("ClassB : " + str);
	}
}

public class WorkClass{
	public void showMain(){
		ClassA work = new ClassA();
		work.show("hello!")
	}
}

```
WorkClasss는 ClassA 클래스에 의존적이다.
만일 다른작업을 한다면, ClassA의 내용을 바꾸거나 ClassB의 일을 하려면 객체를 새로 생성하여 작업을 해야한다.

```
public class WorkClass{
	public void showMain(){
		ClassB work_b = new ClassB();
		work_b.show("hello!")
	}
}
```

OOP **Object Oriented Programming**(객체지향)의 개념 중 `객체를 부품처럼 사용한다`가 있다.
만일 WorkClass가 다른 클래스를 사용하게 된다면, 객체를 바꾸거나 객체를 새로 생성하여 의존성을 낮춰야한다.

## 의존성을 낮추는 방법 - Interface
```
public interface ClassInter{
	void show(String str);
}

public class ClassA implements ClassInter{
	@Override
	public void show(String str){
		System.out.println("ClassA : " + str);
	}
}

public class ClassB implements ClassInte{
	@Override
	public void show(String str){
		System.out.println("ClassB : " + str);
	}
}

public class WorkClass{
	public void showMain(){
		ClassInter inter = new ClassA();
		inter.show("hello");
	}
}

```
다형성을 통해서 WorkClass에서 ClassB로 갈아 끼우고 싶다면 생성자 부분만 new ClassB()로 바꾸어서 의존성을 낮춘다.

*하지만 ClassA 및 ClassB가 WorkClass에 종속되어있다.*

```
public class WorkClass{
	private ClassInter inter;
	public void setInter(ClassInter inter) {
		this.inter = inter;
	}
	public void showMain(){
		inter.show("hello");
	}
}
```

그러므로 WorkClass에 setter로 주입해준다.   


```
public static void main(String[] args) {
	ClassInte inter = new ClassA();
	WorkClass work = new WorkClass();
	work.setInter(inter);
	work.showMain();
}
```

이런식으로 주입해준다.

## Spring에서의 DI

```
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"

	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"

	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

	<!-- ClassA classA = new ClassA() -->

	<bean id="classA" class="simple_java.ClassA"/>

	<!-- ClassB classB = new ClassB() -->a

	<bean id="classB" class="simple_java.ClassB"/>

	<!-- 
		WorkClass workClass = new WorkClass()

		workClass.setInter(classA);
	-->

	<bean id="workClass" class="simple_java.WorkClass">

		<property name="inter" ref="classA"/>

	</bean>

</beans>

```

스프링에서는 xml 설정으로 객체생성 및 변수를 주입한다.




















