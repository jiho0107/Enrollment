package enroll.service;

import java.util.ArrayList;

import enroll.dao.EnrollDao;
import enroll.vo.EnrollVO;
import enroll.vo.StudentVO;
import enroll.vo.SubjectVO;

public class Service {
	private static Service service = new Service();
	private Service() {}
	private EnrollDao dao = EnrollDao.getInstance();
	public static Service getInstance() 
	{
		return service;
	}
	public boolean login(String id, String pwd, String person) {
		// TODO Auto-generated method stub
		return dao.login(id,pwd,person);
	}
	public void enrollSub(String id, String title, int num,String profId) {
		// TODO Auto-generated method stub
		dao.enrollSub(id,title,num,profId);
	}
	public ArrayList<SubjectVO> showSub(String id) {
		// TODO Auto-generated method stub
		return dao.showSub(id);
	}
	public SubjectVO subSearch(String subId) {
		// TODO Auto-generated method stub
		return dao.subSearch(subId);
	}
	public void enroll(String subId, String id) {
		// TODO Auto-generated method stub
		dao.enroll(subId,id);
	}
	public ArrayList<EnrollVO> showClass(String id) {
		// TODO Auto-generated method stub
		return dao.showClass(id);
	}
	public ArrayList<StudentVO> stuInfo(String id,String subId) {
		// TODO Auto-generated method stub
		return dao.stuInfo(id,subId);
	}
	
}
