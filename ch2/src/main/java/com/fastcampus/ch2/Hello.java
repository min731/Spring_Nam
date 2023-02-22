package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 1. ���� ȣ�� ������ ���α׷����� ���
@Controller
public class Hello {
		
	int iv = 10;
	static int cv = 20;
	
	// 2. URL�� �޼��带 ����
	@RequestMapping("/hello")
	public void main() {
		System.out.println("Hello-Instance");
		System.out.println(cv);
		System.out.println(iv);

		// Instance �޼���� iv, cv �� �� ��밡��
	}
	
	public static void main2() {
		
//		System.out.println(cv);
//		System.out.println(iv);
		// static �޼���� cv�� ��� ���� 
	}
	
	@RequestMapping("/hello2")
	private void main3() {
		System.out.println("Hello-private");
		System.out.println(cv);
		System.out.println(iv);

		// private�� �� iv, cv �� �� ��밡��
		// RequestMapping �Ǿ��ֱ� ������ �ܺο��� ȣ���� �� ����
		// ���ο����� �ȉ�
	}
}