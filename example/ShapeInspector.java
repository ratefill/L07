package by.epam.l07.example;

enum Shape {
	RECTANGLE("red"), TRIANGLE("green"), CIRCLE("blue");
	String color;

	Shape(String color)
	{
		this.color = color;
	}

	public String getColor()
	{
		return color;
	}
}

public class ShapeInspector
{
	public static void main(String[] args)
	{
		//double x = 2, y = 3;
		Shape[] arr = Shape.values();
		for (Shape sh : arr)
			System.out.println(sh + " " + sh.getColor());
	}
}
