package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// ��,��,���� �Է��ϸ� ���� �������� �˷��ִ� ���α׷�
public class YoilTeller {
	
	@RequestMapping("/getYoil")
	
	// HttpServletRequest ����� param �޴� ��ü
	// HttpServletResponse �������� ������ִ� ��ü
	public void main(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		// 1. �Է�
		// main�� �Ű������� �޾ƾ���
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		int yyyy =Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		// 2. �۾�
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy, mm-1 ,dd);
		
		// 1:�Ͽ��� , 2:������
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		char yoil = " �Ͽ�ȭ�������".charAt(dayOfWeek);
		
		// 3. ���
		
		// 1) �ֿܼ� ���
		System.out.println(year + "��" + month + "��" + day + "���� ");
		System.out.println(yoil + "�����Դϴ�.");
		
		// 2) �������� ���
		// �������� ����ϴ� ������ text���� bin���� ��
		// �� text�� ���ڵ��� ���� �˷���
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		// �������� ����� �ַ��� out.println
		out.println(year + "��" + month + "��" + day + "���� ");
		out.println(yoil + "�����Դϴ�.");
		// <br> �±װ� ��� �ٹٲ��� �ȉ�		
	}

}