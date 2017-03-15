package by.epam.l07.example;

interface ObjectFactory
{
	public static Object getInstance(String type)
	{
		return new Object();
	}
}

public class FactoryInspector
{
	public static void main(String[] args)
	{
		Object obj;
		obj = ObjectFactory.getInstance("stub");
		System.out.println(obj.toString());
		
	}
}