package com.fastcampus.ch2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Hello")
public class HelloServlet extends HttpServlet {
	
	
	// Source - Override/Implenment Methods로 가져와줌
	
	// Servlet의 (최초 1번) 초기화를 담당함
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("Servlet의 init() 호출");
	}
	
	// Servlet의 작업을 담당함
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
		// 1. 입력
		// 2. 처리
		// 3. 출력 
		System.out.println("Servlet의 service() 호출");

	}

	// Servlet의 메모리 상 제거를 담당함
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("Servlet의 destroy() 호출");

		
	}
}
