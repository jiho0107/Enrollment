package enroll.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enroll.service.Service;
import enroll.vo.StudentVO;

public class StuInfoController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = (String)request.getSession().getAttribute("id"); //교수id
		String subId = request.getParameter("subId"); //과목id
		ArrayList<StudentVO> list = Service.getInstance().stuInfo(id,subId);
		request.setAttribute("list", list);
		
		HttpUtil.forward(request, response, "/result/stuInfoResult.jsp");
	}

}
