package com.fastcampus.ch2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Hello")
public class HelloServlet extends HttpServlet {
	
	
	// Source - Override/Implenment Methods�� ��������
	
	// Servlet�� (���� 1��) �ʱ�ȭ�� �����
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("Servlet�� init() ȣ��");
	}
	
	// Servlet�� �۾��� �����
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
		// 1. �Է�
		// 2. ó��
		// 3. ��� 
		System.out.println("Servlet�� service() ȣ��");

	}

	// Servlet�� �޸� �� ���Ÿ� �����
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("Servlet�� destroy() ȣ��");

		
	}
}