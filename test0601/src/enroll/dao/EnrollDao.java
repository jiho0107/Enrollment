package enroll.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import enroll.vo.EnrollVO;
import enroll.vo.StudentVO;
import enroll.vo.SubjectVO;

public class EnrollDao {
	private static EnrollDao dao = new EnrollDao();
	private EnrollDao() {}
	public static EnrollDao getInstance()
	{
		return dao;
	}
	public Connection connect()
	{
		Connection conn = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","1234");
		}catch(Exception e) {
			System.out.print("MDAO:connect"+e);
		}
		return conn;
	}
	
	public void close(Connection conn,PreparedStatement pstmt)
	{
		if(pstmt != null)
		{
			try {
				pstmt.close();
			}catch(Exception e) {
				System.out.print("Pstmt close error"+e);
			}
		}
		if(conn != null)
		{
			try {
				conn.close();
			}catch(Exception e) {
				System.out.print("Conn close error"+e);
			}
		}
	}
	
	public void close(Connection conn,PreparedStatement pstmt,ResultSet rs) 
	{
		if(rs != null)
		{
			try
			{
				rs.close();
			}catch(Exception e)
			{
				System.out.print("rs close error"+e);
			}
		}
		close(conn,pstmt);
	}
	public void close(Connection conn,PreparedStatement pstmt,ResultSet rs,ResultSet rs2) 
	{
		if(rs2 != null)
		{
			try
			{
				rs2.close();
			}catch(Exception e)
			{
				System.out.print("rs2 close error"+e);
			}
		}
		close(conn,pstmt,rs);
	}
	public boolean login(String id, String pwd, String person) {
		// TODO Auto-generated method stub
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			conn = connect();
			if(person.equals("prof"))
			{
				pstmt = conn.prepareStatement("select * from prof where id = ? and pwd = ?;");
				pstmt.setString(1, id);
				pstmt.setString(2, pwd);
				rs = pstmt.executeQuery();
			}
			else if(person.equals("student"))
			{
				pstmt = conn.prepareStatement("select * from student where id = ? and pwd = ?;");
				pstmt.setString(1, id);
				pstmt.setString(2, pwd);
				rs = pstmt.executeQuery();
			}
			if(rs.next())
			{
				result = true;
			}
		} catch(Exception e) {
			System.out.print("login error"+e);
		} finally {
			close(conn,pstmt,rs);
		}
		return result;
	}
	public void enrollSub(String id, String title, int num,String profId) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("insert into subject values(?,?,?,?);");
			pstmt.setString(1, id);
			pstmt.setString(2, title);
			pstmt.setInt(3, num);
			pstmt.setString(4, profId);
			pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.print("enrollSub error"+e);
		} finally {
			close(conn,pstmt);
		}
	}
	public ArrayList<SubjectVO> showSub(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		SubjectVO subject = null;
		ArrayList<SubjectVO> list = new ArrayList<SubjectVO>();
		int num = 0; //과목에 등록한 학생수
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select id,name,count from subject where prof=?;");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				String sId = rs.getString(1); //과목id
				String sName = rs.getString(2); //과목명
				int sCount = rs.getInt(3); //과목 최대인원
				
				pstmt = conn.prepareStatement("select count(subject) from enroll where subject=?;");
				pstmt.setString(1, sId);
				rs2 = pstmt.executeQuery();
				if(rs2.next())
				{
					num = rs2.getInt(1);
				}
				subject = new SubjectVO(sId,sName,sCount,num);
				list.add(subject);
			}
		} catch(Exception e) {
			System.out.print("showSub error"+e);
		} finally {
			close(conn,pstmt,rs,rs2);
		}
		return list;
	}
	public SubjectVO subSearch(String subId) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SubjectVO subject = null;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select * from subject where id=?;");
			pstmt.setString(1, subId);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				String id = rs.getString(1);
				String name = rs.getString(2);
				subject = new SubjectVO(id,name);
			}
		} catch(Exception e) {
			System.out.print("subSearch error"+e);
		} finally {
			close(conn,pstmt,rs);
		}
		return subject;
	}
	public void enroll(String subId, String id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("insert into enroll values(?,?);");
			pstmt.setString(1, subId);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.print("enroll error"+e);
		} finally {
			close(conn,pstmt);
		}
	}
	public ArrayList<EnrollVO> showClass(String id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EnrollVO enroll = null;
		ArrayList<EnrollVO> lists = new ArrayList<EnrollVO>();
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select enroll.subject as 과목번호,"
					+ "subject.name as 과목명 from enroll,subject where enroll.student=? "
					+ "and subject.id = enroll.subject;");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				String sId = rs.getString(1);
				String sName = rs.getString(2);
				enroll = new EnrollVO(sId,sName);
				lists.add(enroll);
			}
		} catch(Exception e) {
			System.out.print("showClass error"+e);
		} finally {
			close(conn,pstmt,rs);
		}
		return lists;
	}
	public ArrayList<StudentVO> stuInfo(String id,String subId) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String stuId = null;
		String stuName = null;
		StudentVO student = null;
		ArrayList<StudentVO> list = new ArrayList<StudentVO>();
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select student.id, student.name "
					+ "from student,subject,enroll where enroll.subject=? "
					+ "and subject.id=enroll.subject and enroll.student=student.id;");
			pstmt.setString(1, subId);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				stuId = rs.getString(1);
				stuName = rs.getString(2);
				student = new StudentVO(stuId,stuName);
				list.add(student);
			}
		} catch(Exception e) {
			System.out.print("stuInfo error"+e);
		} finally {
			close(conn,pstmt,rs);
		}
		return list;
	}
	
}
