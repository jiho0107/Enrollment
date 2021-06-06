package enroll.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enroll.service.Service;
import enroll.vo.SubjectVO;

public class ShowSubController implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = (String)request.getSession().getAttribute("id"); //교수 id
		ArrayList<SubjectVO> subjects = Service.getInstance().showSub(id);
		request.setAttribute("subjects", subjects);
		
		HttpUtil.forward(request, response, "/result/showSubResult.jsp");
	}

}
