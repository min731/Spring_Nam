package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// 년,월,일을 입력하면 무슨 요일인지 알려주는 프로그램
public class YoilTeller {
	
	@RequestMapping("/getYoil")
	
	// HttpServletRequest 사용자 param 받는 객체
	// HttpServletResponse 브라우저에 출력해주는 객체
	public void main(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		// 1. 입력
		// main의 매개변수로 받아야함
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		int yyyy =Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		// 2. 작업
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy, mm-1 ,dd);
		
		// 1:일요일 , 2:월요일
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		char yoil = " 일월화수목금토".charAt(dayOfWeek);
		
		// 3. 출력
		
		// 1) 콘솔에 출력
		System.out.println(year + "년" + month + "월" + day + "일은 ");
		System.out.println(yoil + "요일입니다.");
		
		// 2) 브라우저에 출력
		// 브라우저는 출력하는 정보가 text인지 bin인지 모름
		// 또 text의 인코딩이 뭔지 알려줌
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		// 브라우저에 결과를 주려면 out.println
		out.println(year + "년" + month + "월" + day + "일은 ");
		out.println(yoil + "요일입니다.");
		// <br> 태그가 없어서 줄바꿈은 안됌		
	}

}
