package enroll.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enroll.service.Service;
import enroll.vo.EnrollVO;
import enroll.vo.SubjectVO;

public class ShowClassController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = (String)request.getSession().getAttribute("id"); //학생의 id
		ArrayList<EnrollVO> lists = Service.getInstance().showClass(id);
		request.setAttribute("lists", lists);
		
		HttpUtil.forward(request, response, "/result/classListResult.jsp");
	}

}
