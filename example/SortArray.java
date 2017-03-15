package by.epam.l07.example;

import java.util.Arrays;

public class SortArray
{
	public static void main(String[] args)
	{
		int[] mas = { 3, 6, 5, 1, 2, 9, 8 };
		printArray(mas);
		Arrays.sort(mas);
		printArray(mas);
	}

	public static void printArray(int[] ar)
	{
		for (int i : ar)
			System.out.print(i + " ");
		System.out.println();
	}
}
