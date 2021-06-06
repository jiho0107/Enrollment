package enroll.vo;

public class EnrollVO {
	private String subId;
	private String stuId;
	public EnrollVO() {}
	public EnrollVO(String subId,String stuId) 
	{
		this.subId = subId;
		this.stuId = stuId;
	}
	public String getSubId()
	{
		return subId;
	}
	public void setSubId(String subId)
	{
		this.subId = subId;
	}
	public String getStuId()
	{
		return stuId;
	}
	public void setStuId(String stuId)
	{
		this.stuId = stuId;
	}
}
