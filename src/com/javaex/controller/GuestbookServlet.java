package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@WebServlet("/gb")
public class GuestbookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("servlet 진입");
		
		String actionName = request.getParameter("a");
		
		if("add".equals(actionName)) {
			System.out.println("add에 진입");

			String name = request.getParameter("name");
			String password = request.getParameter("pass");
			String content = request.getParameter("content");
			
			GuestbookVo vo = new GuestbookVo();
			vo.setName(name);
			vo.setPassword(password);
			vo.setContent(content);
			
			System.out.println(vo.toString());
			
			GuestbookDao dao = new GuestbookDao();
			dao.insert(vo);
			
			response.sendRedirect("gb?a=list");
			
		} else if("list".equals(actionName)) {
			System.out.println("list 진입");
			
			GuestbookDao dao = new GuestbookDao();
			List<GuestbookVo> list = dao.getList();
				//request 안에 정보를 주입시킬수 있는 setAttribute 메소드가 있다
			request.setAttribute("list", list);
			
			//controller에서 list로 포워드르 하는것 					->대상
			RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
			//request, response를 둘다 포워드 하겠다는 뜻 
			rd.forward(request, response);

		} else if("deleteform".equals(actionName)) {
			System.out.println("deleteForm 진입");
			
			RequestDispatcher rd = request.getRequestDispatcher("deleteform.jsp");
			//request, response를 둘다 포워드 하겠다는 뜻 
			rd.forward(request, response);
			
	
			
		} else if("delete".equals(actionName)) {
			System.out.println("delete 진입");
			
			// 웹에 주소형식으로 넘어갈때 no가 문자열로 넘어가기 때문에 문자열에서 숫자로 변환시켜주어야함
			int no = Integer.valueOf(request.getParameter("no"));
			String password = request.getParameter("password");
			
			GuestbookDao dao = new GuestbookDao();
			dao.delete(no, password);
			
			response.sendRedirect("gb?a=list");		
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
