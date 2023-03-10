package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 1. 원격 호출 가능한 프로그램으로 등록
@Controller
public class Hello {
		
	int iv = 10;
	static int cv = 20;
	
	// 2. URL과 메서드를 연결
	@RequestMapping("/hello")
	public void main() {
		System.out.println("Hello-Instance");
		System.out.println(cv);
		System.out.println(iv);

		// Instance 메서드는 iv, cv 둘 다 사용가능
	}
	
	public static void main2() {
		
//		System.out.println(cv);
//		System.out.println(iv);
		// static 메서드는 cv만 사용 가능 
	}
	
	@RequestMapping("/hello2")
	private void main3() {
		System.out.println("Hello-private");
		System.out.println(cv);
		System.out.println(iv);

		// private도 됌 iv, cv 둘 다 사용가능
		// RequestMapping 되어있기 떄문에 외부에서 호출할 수 있음
		// 내부에서는 안됌
	}
}
