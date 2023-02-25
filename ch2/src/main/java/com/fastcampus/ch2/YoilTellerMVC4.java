package com.fastcampus.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

// Ctrl+Shift+O �ڵ� import


@Controller
// ��,��,���� �Է��ϸ� ���� �������� �˷��ִ� ���α׷�
public class YoilTellerMVC4 {
	
	@ExceptionHandler(Exception.class)
	public String cathcher(Exception ex) {
		ex.printStackTrace();
		return "yoilError";
	}
	
	// HttpServletRequest ����� param �޴� ��ü
	// HttpServletResponse �������� ������ִ� ��ü
	
	// ��û�޴� ������ ������ �� ��, �ϳ��� ��ġ�� Mydate date
	@RequestMapping("/getYoilMVC4")
	public String main(Mydate date,Model model){
				
		// 0. yoilError�� ���� ��ȿ�� �˻�
		if(!isValid(date))
			return "yoilError";
		
		
		// �Է� ���ɻ� �����ϱ�
		// 1. �Է�
		// main�� �Ű������� �޾ƾ���
//		String year = request.getParameter("year");
//		String month = request.getParameter("month");
//		String day = request.getParameter("day");
//		int yyyy =Integer.parseInt(year);
//		int mm = Integer.parseInt(month);
//		int dd = Integer.parseInt(day);		
		
		
		
		
		
		// Refactor - Extract Method�� ������ ��������
		// 2. �۾�
		

		char yoil = getYoil(date);
		
		model.addAttribute("myDate", date);
		model.addAttribute("yoil", yoil);
		
//		mv.addObject("year", year);
//		mv.addObject("month", month);
//		mv.addObject("day", day);
//		mv.addObject("yoil", yoil);
//		
//		mv.setViewName("yoil");
		
		//mv�� �𵨰� �� �Ѵ� ��ȯ
//		return mv;
		
		// WEB-INF/views/yoil.jsp�� �������!
		return "yoil";
		
		
		
		
		
		
		
		
		// ��� ���ɻ� �и�
		// 3. ���
		
		// 1) �ֿܼ� ���
//		System.out.println(year + "��" + month + "��" + day + "���� ");
//		System.out.println(yoil + "�����Դϴ�.");
//		
//		// 2) �������� ���
//		// �������� ����ϴ� ������ text���� bin���� ��
//		// �� text�� ���ڵ��� ���� �˷���
//		response.setContentType("text/html");
//		response.setCharacterEncoding("utf-8");
//		PrintWriter out = response.getWriter();
//		// �������� ����� �ַ��� out.println
//		out.println(year + "��" + month + "��" + day + "���� ");
//		out.println(yoil + "�����Դϴ�.");
//		// <br> �±װ� ��� �ٹٲ��� �ȉ�		
	}

	private boolean isValid(Mydate date) {
		// TODO Auto-generated method stub
		return isValid(date.getYear(), date.getMonth(), date.getDay());
	}

	private char getYoil(Mydate date) {
		// TODO Auto-generated method stub
		return getYoil(date.getYear(), date.getMonth(), date.getDay());
	}

	private boolean isValid(int year, int month, int day) {
		
		if(year==-1 || month==-1 || day==-1)
			return false;
		return (1<=month && month<=12) && (1<=day && day<=31);
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1 ,day);
		
		// 1:�Ͽ��� , 2:������
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		return " �Ͽ�ȭ�������".charAt(dayOfWeek);
	}

}