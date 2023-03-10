package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class PrivateMethodCall {

	public static void main(String[] args) throws Exception {
		
//		Hello hello = new Hello();
//		
//		hello.main();  // public, 호출 가능
//		hello.main3(); // private, 호출 불가능
		
		// Reflection API를 사용하기 때문임
		// 클래스 정보를 얻고 다룰 수 있는 강력한 가능을 제공하는 API
		// java.lang.reflect 패키지을 제공
		
		// Reflection API 활용 Main 에서드 호출
		
		// 1. Hello 클래스의 Class 객체(클래스의 정볼르 담고 있는 객체)를 얻어온다
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
		// 2. 해당 클래스의 객체 생성
		Hello hello1 = (Hello)helloClass.newInstance();
		// 3. Hello 클래스가 가지고 있는 main메서드를 가져옴
		Method main = helloClass.getDeclaredMethod("main");
		Method main3 = helloClass.getDeclaredMethod("main3");
		// 4. main 메서드를 접근 가능하게 함 (private인 메서드도 호출 가능)
		main.setAccessible(true);
		main3.setAccessible(true);
		
		// 5. 메서드 실행 (hello1.main 객체.메서드와 같은 의미)
		main.invoke(hello1);
		main3.invoke(hello1);
		
		// private은 원래 내부에서만 쓸 수 있는데
		// Reflection API를 활용해서 외부에서도 이용할 수 있게 함
		
		
	}

}
