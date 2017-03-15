package by.epam.l07.example;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetWithComparator
{
	public static void main(String[] args)
	{
		Comparator<GeometricObject> comparator = new GeometricObjectComparator();
		Set<GeometricObject> set = new TreeSet<GeometricObject>(comparator);
		set.add(new RectangleGO(4, 5));
		set.add(new CircleGO(40));
		set.add(new CircleGO(40));
		set.add(new RectangleGO(4, 1));
		System.out.println("A sorted set of geometric objects");
		for (GeometricObject elements : set)
		{
			System.out.println("area = " + elements.getArea());
		}
	}
}

abstract class GeometricObject
{
	public abstract double getArea();
}

class RectangleGO extends GeometricObject
{
	private double sideA;
	private double sideB;

	public RectangleGO(double a, double b)
	{
		sideA = a;
		sideB = b;
	}

	@Override
	public double getArea()
	{
		return sideA * sideB;
	}
}

class CircleGO extends GeometricObject
{
	private double radius;

	public CircleGO(double r)
	{
		radius = r;
	}

	@Override
	public double getArea()
	{
		// TODO Auto-generated method stub
		return 2 * 3.14 * radius * radius;
	}
}

class GeometricObjectComparator implements Comparator<GeometricObject>
{
	public int compare(GeometricObject o1, GeometricObject o2)
	{
		double area1 = o1.getArea();
		double area2 = o2.getArea();
		
		return Double.compare(area1, area2);
		
		//return area1 < area2 ? -1 : area1 == area2 ? 0 : 1;
		/*
		if (area1 < area2)
		{
			return -1;
		}
		else if (area1 == area2)
		{
			return 0;
		}
		else
		{
			return 1;
		}
		*/
	}
}
