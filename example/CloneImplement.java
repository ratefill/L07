package by.epam.l07.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;



class Department implements Cloneable
{
	//private Integer name;
	private Date date = new Date();

	public Object clone() throws CloneNotSupportedException
	{
		Department obj = null;
		obj = (Department) super.clone();
		if (null != this.date)
		{
			obj.date = (Date) this.date.clone();
		}
		return obj;
	}
}

class Faculty implements Cloneable
{
	//private String name;
	//private int numberDepartments;
	private List<Department> departmentList;

	public Object clone() throws CloneNotSupportedException
	{
		Faculty obj = null;
		obj = (Faculty) super.clone();
		if (null != this.departmentList)
		{
			ArrayList<Department> tempList = new ArrayList<Department>(this.departmentList.size());
			for (Department listElem : this.departmentList)
			{
				tempList.add((Department) listElem.clone());
			}
			obj.departmentList = tempList;
		}
		return obj;
	}
}