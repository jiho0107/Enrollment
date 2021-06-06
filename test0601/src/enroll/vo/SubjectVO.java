package enroll.vo;

public class SubjectVO {
	private String id;
	private String name;
	private int count;
	private int num;
	public SubjectVO() {}
	public SubjectVO(String id,String name,int count) 
	{
		this.id = id;
		this.name = name;
		this.count = count;
	}
	public SubjectVO(String id,String name) 
	{
		this.id = id;
		this.name = name;
	}
	public SubjectVO(String id,String name,int count,int num) 
	{
		this.id = id;
		this.name = name;
		this.count = count;
		this.num = num;
	}
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getCount()
	{
		return count;
	}
	public void setCount(int count)
	{
		this.count = count;
	}
	public int getNum()
	{
		return num;
	}
	public void setNum(int num)
	{
		this.num = num;
	}
	
}
