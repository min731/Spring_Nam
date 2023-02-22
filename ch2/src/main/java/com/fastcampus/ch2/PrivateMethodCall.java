package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class PrivateMethodCall {

	public static void main(String[] args) throws Exception {
		
//		Hello hello = new Hello();
//		
//		hello.main();  // public, ȣ�� ����
//		hello.main3(); // private, ȣ�� �Ұ���
		
		// Reflection API�� ����ϱ� ������
		// Ŭ���� ������ ��� �ٷ� �� �ִ� ������ ������ �����ϴ� API
		// java.lang.reflect ��Ű���� ����
		
		// Reflection API Ȱ�� Main ������ ȣ��
		
		// 1. Hello Ŭ������ Class ��ü(Ŭ������ ������ ��� �ִ� ��ü)�� ���´�
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
		// 2. �ش� Ŭ������ ��ü ����
		Hello hello1 = (Hello)helloClass.newInstance();
		// 3. Hello Ŭ������ ������ �ִ� main�޼��带 ������
		Method main = helloClass.getDeclaredMethod("main");
		Method main3 = helloClass.getDeclaredMethod("main3");
		// 4. main �޼��带 ���� �����ϰ� �� (private�� �޼��嵵 ȣ�� ����)
		main.setAccessible(true);
		main3.setAccessible(true);
		
		// 5. �޼��� ���� (hello1.main ��ü.�޼���� ���� �ǹ�)
		main.invoke(hello1);
		main3.invoke(hello1);
		
		// private�� ���� ���ο����� �� �� �ִµ�
		// Reflection API�� Ȱ���ؼ� �ܺο����� �̿��� �� �ְ� ��
		
		
	}

}