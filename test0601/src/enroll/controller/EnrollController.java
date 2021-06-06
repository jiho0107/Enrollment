package enroll.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enroll.service.Service;
import enroll.vo.SubjectVO;

public class EnrollController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String subId = request.getParameter("subId");
		String id = (String)request.getSession().getAttribute("id"); //학생 id
		Service.getInstance().enroll(subId,id);
		
		HttpUtil.forward(request, response, "/stu_menu.jsp");
	}

}
