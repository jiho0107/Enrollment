package enroll.vo;

public class StudentVO {
	private String stuId;
	private String stuName;
	public StudentVO() {}
	public StudentVO(String stuId,String stuName) 
	{
		this.stuId = stuId;
		this.stuName = stuName;
	}
	public String getStuId()
	{
		return stuId;
	}
	public void setStuId(String stuId)
	{
		this.stuId = stuId;
	}
	public String getStuName()
	{
		return stuName;
	}
	public void setStuName(String stuName)
	{
		this.stuName = stuName;
	}
}
