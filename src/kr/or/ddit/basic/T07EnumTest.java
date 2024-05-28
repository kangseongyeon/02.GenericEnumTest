package kr.or.ddit.basic;

class Flower {
	static final int ROSE = 1; 	// 장미
	static final int TULIP = 2; // 튤립
}

class Animal {
	static final int LION = 1;
	static final int TIGER = 2;
}

public class T07EnumTest {

/**
 * 열거형 => 상수값들을 선언하는 방법
 * 
 * 선언방법 : enum 열거형 이름 {상수값1, 상수값2, ....., 상수값n}
 */
 
	public enum HomeTown {광주, 부산, 평양, 제주도, 대구, 대전};
	
	
	// City 열거형 객체 선언 (기본값을 이용하는 열거형)
	public enum City {서울, 부산, 대구, 광주, 대전};
	
	// 데이터 값을 임의로 지정한 열거형 객체 선언
	// 데이터 값을 정해줄 경우에는 생성자를 이용하여 제공해 주면 된다
	public enum Season {
		// 객체를 많이 만든다는 것은 메모리를 많이 사용한다는 뜻으로, 불필요함
		// 상수 => 여러개를 만들 필요가 없음 -> 총 4개의 객체를 만들면 됨
		봄("3월부터 5월까지"), 여름("6월부터 8월까지"), 가을("9월부터 11월까지"), 겨울("12월부터 2월까지");
		
		// 괄호안의 값이 저장될 변수 선언
		private String data;
		
		// 생성자 만들기 (열거형의 생성자는 제어자가 묵시적으로 'private'이다)
		// 외부에서 객체를 만들 수 없음
		// private을 작성하지 않아도 묵시적으로 private 처리가 됨 (=> 생략 가능)
		private Season (String data) {
			this.data = data;
		}
		
		
		// getter 메서드
		public String getData() {
			return data;
		}
	}
	
	public static void main(String[] args) {
		
		
	/*
	열거형에서 사용하는 주요 메서드
		 	
	1. name() => 열거형 상수의 이름을 문자열로 반환한다.
	2. valueOf("열거형 상수이름") => '열거형 상수이름'과 일치하는 열거형 상수 객체를 반환한다
	3. ordinal() => 열거형 상수가 정의된 순서값을 반환한다 (기본적으로 0부터 시작) 
	*/
		
		City myCity1;	// 열거형 객체변수 선언
		City myCity2;	// 열거형 객체변수 선언
		
		myCity1 = City.서울;
		myCity2 = City.valueOf("서울");
		System.out.println("myCity1 : " + myCity1.name());
		System.out.println("myCity1의  ordinal : " + myCity1.ordinal());
		System.out.println();
		
		System.out.println("myCity2 : " + myCity2.name());
		System.out.println("myCity2의  ordinal : " + myCity2.ordinal());
		System.out.println("==================================");
		
		Season ss = Season.valueOf("여름");
		System.out.println("name => " + ss.name());
		System.out.println("ordinal => " + ss.ordinal());
		System.out.println("getter 메서드 호출값 => " + ss.getData());
		System.out.println("-----------------------------------");
		
		// 열거형이름.values() => 열거형 배열값을 반환함
		Season[] ssArr = Season.values();
		for(Season s : ssArr) {
			System.out.println(s.name() + " : " + s.getData());
		}
		System.out.println();
		
		for(City city : City.values()) {
			System.out.println(city.name() + " : " + city.ordinal());
		}
		
		City city = City.대구;
		System.out.println(city == City.대구);
		System.out.println(city == City.대전);
		
		// 타입이 같지 않기 때문에 비교 불가능
		// 즉, type까지 비교한다는 것을 확인할 수 있음
		// System.out.println(city == HomeTown.대구);
		
		///////////////////////////////////////
		
		// enum => compareTo 타입이기도 하다
		// ordinal 정보를 통해 비교함
		System.out.println("대구 => " + city.compareTo(City.대구));
		System.out.println("서울 => " + city.compareTo(City.서울));
		System.out.println("대전 => " + city.compareTo(City.대전));
	}
}
