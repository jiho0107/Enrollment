package enroll.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import enroll.service.Service;

public class EnrollSubController implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String profId = (String)session.getAttribute("id");
		String id = request.getParameter("subId");
		String title = request.getParameter("subTitle");
		int num = Integer.parseInt(request.getParameter("stuNum"));
		Service s = Service.getInstance();
		s.enrollSub(id,title,num,profId);
		
		RequestDispatcher rd = request.getRequestDispatcher("/prof_menu.jsp");
		rd.forward(request, response);
	}

}
