package by.epam.l07.example;

public class SquareInspector
{
	public static void main(String[] args)
	{
		Quadrate box = new Quadrate(4);
		Rectangle rectangle = new Rectangle(2, 3);
		Circle circle = new Circle(3);
		box.print();
		rectangle.print();
		circle.print();
		System.out.println("Box: " + box.square());
		System.out.println("Rectangle: " + rectangle.square());
		System.out.println("Circle: " + circle.square());
	}
}

interface Square
{
	double PI = 3.1415926;

	double square();
}

class Quadrate implements Square
{
	private int a;

	public Quadrate(int a)
	{
		this.a = a;
	}

	public double square()
	{
		return a * a;
	}

	public void print()
	{
		System.out.println("Square box: " + square());
	}
}

class Circle implements Square
{
	private int r;

	public Circle(int r)
	{
		this.r = r;
	}

	public double square()
	{
		return r * r * Square.PI;
	}

	public void print()
	{
		System.out.println("Square circle: " + square());
	}
}

class Rectangle implements Square
{
	private int a, b;

	public Rectangle(int a, int b)
	{
		this.a = a;
		this.b = b;
	}

	public double square()
	{
		return a * b;
	}

	public void print()
	{
		System.out.println("Square rectangle: " + square());
	}
}
