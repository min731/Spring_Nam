package com.fastcampus.ch2;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.StringJoiner;


// �޼������ ������ �˷���
public class MethodInfo {
	public static void main(String[] args) throws Exception{
		
		// 1. YoilTeller Ŭ���� ��ü ����
		Class clazz = Class.forName("com.fastcampus.ch2.YoilTellerMVC");
		Object obj = clazz.newInstance();
		
		// 2. ��� �޼��� ���� ������
		Method[] methodArr = clazz.getDeclaredMethods();
		
		// 3. �޼��� ������ ���
		for(Method m : methodArr) {
			
			// �޼��� �̸�
			String name = m.getName();
			
			// �޼��� �Ű�����
			Parameter[] paramArr = m.getParameters();
//			Class[] paramTypeArr = m.getParameterTypes();
			
			// �޼��� ��ȣ�� Ÿ��
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