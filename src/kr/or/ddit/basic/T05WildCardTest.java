package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T05WildCardTest {
	/**
	 * 와일드 카드에 대하여... 와일드 카드(?)는 제너릭 타입을 지정하기 위해 사용되는 특별한 종류의 인수 (Argument) 변수선언,
	 * 객체생성 및 메서드를 정의할 때 사용된다
	 * 
	 * ? 타입 => 아직 타입이 정해지지 않았다 (구체화 되지 않았다)
	 * 
	 * <? extends T> => 와일드 카드의 상한 제한. T와 그 자손들만 가능 <? super T> => 와일드 카드의 하한 제한. T와
	 * 그 조상들만 가능 <?> => 허용가능한 모든 타입 가능.
	 * 
	 */
	public static void main(String[] args) {

		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
		FruitBox<Apple> appleBox = new FruitBox<>();

		fruitBox.add(new Apple());
		fruitBox.add(new Grape());

		appleBox.add(new Apple());
		appleBox.add(new Apple());

		// grape 담기지 않음 -> why? appleBox는 Apple만 들어올 수 있도록 타입을 지정해 줬기 때문에
		// appleBox.add(new Grape());
		Juicer.makeJucie(fruitBox);

		// FruitBox가 담고 있는 타입 => Fruit 타입이기 때문에 Fruit 타입이 아닌 Apple은 오류가 남
		// 문제 => 제너릭 타입을 하나로만 지정했기 때문
		// 해결 => 제너릭 메서드로 만들면 됨
		Juicer.makeJucie(appleBox);
	}
}

class Juicer {
	// Instance 메서드 → 객체를 먼저 만들어야 호출 가능
	// static 메소드 → 객체를 만들지 않아도 손쉽게 호출해서 기능 사용 가능

	// 제너릭 사용
	/*
	static <T extends Fruit> void makeJuice(FruitBox<T> box) {
		String fruitListstr = ""; // 과일 목록
		int cnt = 0;
		for (T f : box.getFruitList()) {
			if (cnt == 0) {
				fruitListstr += f;
			} else {
				fruitListstr += ", " + f;
			}
			cnt++;
		}
		System.out.println(fruitListstr + " => 쥬스 완성~~!!");
	}
	*/

	// 와일드카드 사용
	static void makeJucie(FruitBox<? extends Fruit> box) {
		String fruitListstr = ""; // 과일 목록
		int cnt = 0;
		for (Object f : box.getFruitList()) {
			if (cnt == 0) {
				fruitListstr += f;
			} else {
				fruitListstr += ", " + f;
			}
			cnt++;
		}
		System.out.println(fruitListstr + " => 쥬스 완성~~!!");
	}
}

class Fruit {
	private String name;

	public Fruit(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "과일 (" + name + ")";

	}
}

class Apple extends Fruit {

	public Apple() {
		super("사과");
	}
}

class Grape extends Fruit {

	public Grape() {
		super("포도");
	}
}

class FruitBox<T>{
	private List<T> fruitList;
	
	public FruitBox() {
		fruitList = new ArrayList<>();
	}

	public List<T> getFruitList() {
		return fruitList;
	}
	
	public void add(T fruit) {
		fruitList.add(fruit);
	}

	
}