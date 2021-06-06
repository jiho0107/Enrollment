package enroll.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	HashMap<String,Controller> map = null;
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		map = new HashMap<String,Controller>();
		map.put("/login.do", new LoginController());
		map.put("/enrollSub.do", new EnrollSubController()); //교수 과목등록
		map.put("/showSub.do", new ShowSubController()); // 교수 등록과목리스트
		map.put("/subSearch.do", new SubSearchController()); //학생 과목검색
		map.put("/enroll.do", new EnrollController()); // 학생 과목등록
		map.put("/showClass.do", new ShowClassController()); // 학생 등록과목리스트
		map.put("/stuInfo.do", new StuInfoController()); // 교수 등록과목 중 수강학생 정보
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String path = uri.substring(contextPath.length());
		
		Controller cont = map.get(path);
		cont.execute(req, resp);
	}
}
