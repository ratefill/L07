package by.epam.l07.example;

import java.util.ArrayList;
import java.util.List;


public class DefaultInspector
{
	public static void main(String[] args)
	{
		DefaultInterfaceImpl ref = new DefaultInterfaceImpl();
		System.out.println(ref.isEmpty());
	}
}

interface Sized
{
	int size();

	default boolean isEmpty()
	{
		return size() == 0;
	}
}

class Fruit
{
};

class Basket implements Sized
{
	private List<Fruit> fruitsList = new ArrayList<>();

	public void addFruit(Fruit fruit)
	{
		fruitsList.add(fruit);
	}

	public int size()
	{
		return fruitsList.size();
	}

	public boolean isBasketEmpty()
	{
		return isEmpty();
	}
}

class DefaultInterfaceImpl implements Sized
{
	@Override
	public int size()
	{
		return 0;
	}
}

interface Sized3D
{
	int size();

	default boolean isEmpty()
	{
		return size() == 0;
	}
}

class Figure implements Sized, Sized3D
{
	@Override
	public int size()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty()
	{
		Sized.super.isEmpty();
		return Sized3D.super.isEmpty();
	}
}