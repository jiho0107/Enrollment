package enroll.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enroll.service.Service;
import enroll.vo.SubjectVO;

public class SubSearchController implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String subId = request.getParameter("subId");
		SubjectVO subject = Service.getInstance().subSearch(subId);
		String msg;
		if(subject != null)
			msg = "true";
		else
			msg = "false";
		request.setAttribute("subject", subject);
		request.setAttribute("msg", msg);
		
		HttpUtil.forward(request, response, "/enrollInClass.jsp");
	}

}
