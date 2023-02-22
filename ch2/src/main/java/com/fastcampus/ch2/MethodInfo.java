package com.fastcampus.ch2;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.StringJoiner;


// 메서드들의 정보를 알려줌
public class MethodInfo {
	public static void main(String[] args) throws Exception{
		
		// 1. YoilTeller 클래스 객체 생성
		Class clazz = Class.forName("com.fastcampus.ch2.YoilTellerMVC");
		Object obj = clazz.newInstance();
		
		// 2. 모든 메서드 정보 가져옴
		Method[] methodArr = clazz.getDeclaredMethods();
		
		// 3. 메서드 정보들 출력
		for(Method m : methodArr) {
			
			// 메서드 이름
			String name = m.getName();
			
			// 메서드 매개변수
			Parameter[] paramArr = m.getParameters();
//			Class[] paramTypeArr = m.getParameterTypes();
			
			// 메서드 반호나 타입
			Class returnType = m.getReturnType();
			
			StringJoiner paramList = new StringJoiner(", ", "(", ")");
			
			for(Parameter param : paramArr) {
				String paramName = param.getName();
				Class  paramType = param.getType();
				
				paramList.add(paramType.getName() + " " + paramName);
			}
			
			System.out.printf("%s %s%s%n", returnType.getName(), name, paramList);
		}
	} // main
}