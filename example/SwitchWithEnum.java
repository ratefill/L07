package by.epam.l07.example;

enum Faculty2 {
	MMF, FPMI, GEO
}

public class SwitchWithEnum
{
	public static void main(String[] args)
	{
		Faculty2 current;
		current = Faculty2.GEO;
		switch (current)
		{
		case GEO:
			System.out.print(current);
			break;
		case MMF:
			System.out.print(current);
			break;
		// case LAW : System.out.print(current);//ошибка компиляции!
		default:
			System.out.print("вне case: " + current);
		}
	}
}
