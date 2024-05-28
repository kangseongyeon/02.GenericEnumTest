package kr.or.ddit.basic;

/**
 * 제한된 파라미터 예제
 *
 */

public class T04BoundedParmaeterTest {
	public static void main(String[] args) {
		int result = Util2.compare(10, 20);
		System.out.println(result);			// -1
		
		result = Util2.compare(3.14, 3);
		System.out.println(result);			// 1
		
		// compare한 메서드에 number나 number 하위 타입이 아닌 경우가 오면? -> 컴파일 오류
		// result = Util2.compare("JAVA", 3);
	}
}

class Util2 {
	// 타입에 대한 제한을 두고 싶음 -> extends 타입
	//						=> number나 number의 하위 타입만 올 수 있도록 제한을 걸어 둠
	public static <T extends Number> int compare (T t1, T t2) {
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();
		
		// 앞에 있는 것이 크면 양수, 뒤가 크면 음수, 같으면 0
		return Double.compare(v1, v2);
	}
}
