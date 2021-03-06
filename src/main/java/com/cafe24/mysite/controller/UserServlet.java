package com.cafe24.mysite.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mysite.action.guestbook.GuestBookActionFactory;
import com.cafe24.mysite.action.user.UserActionFactory;
import com.cafe24.web.mvc.Action;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		request.setCharacterEncoding("utf-8"); // 필터로 등록해두면 신경안써도됨 - web.xml에 필터를 등록하고 Filter 클래스를 만들어 사용함
		
		String actionName = request.getParameter("a");
		Action action = new UserActionFactory().getAction(actionName);
		action.execute(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
