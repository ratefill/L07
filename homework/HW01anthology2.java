package by.epam.l07.homework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/*
Сборник литературных произведений. Реализовать приложение, позволяющее
создавать сборники произведений (объект, представляющий собой сборник).
Составляющими сборника являются литературные произведения(стихи, проза и
т.д.) и форма сборника(журнал, книга и т.д.). Реализуйте возможность
определения, есть ли конкретное произведение в сборнике.
Реализуйте минимум три компаратора, для сортировки списка произведений, и
добавьте в код возможность такой сортировки.
*/

class SortByDate implements Comparator<Paper>
{
	@Override
	public int compare(Paper p1, Paper p2)
	{
		return p1.getDateCreated().compareTo(p2.getDateCreated());

	}
}

public class HW01anthology2
{

	// компаратор сортирует по автору
	public static Comparator<Paper> SortByAuthor = new Comparator<Paper>() {
		@Override
		public int compare(Paper p1, Paper p2)
		{
			return (p1.getAuthor().compareTo(p2.getAuthor()));
		}
	};

	public static void main(String[] args) throws ParseException
	{
		anthology a = new anthology();
		a.print();
		a.sort();// сортировка по умолчанию (по названию)
		System.out.println();
		a.print();
		System.out.println();

		SimpleDateFormat sdf = new SimpleDateFormat("dd.mm.yyyy");

		Science s = new Science("Инверсные токи", "Калобанов А.В.", sdf.parse("16.12.1975"), 4);
		System.out.println("входит ли в сборник: " + a.exist(s));// должен быть
																	// true
		System.out.println("входит ли в сборник (hash): " + a.existByHash(s));// должен
																				// быть
																				// true

		Biography b = new Biography("Пушкин А.С", "Дмитров А.Д.", sdf.parse("17.01.1928"), "старость");
		System.out.println("входит ли в сборник: " + a.exist(b));// должен быть
																	// false
		System.out.println("входит ли в сборник (hash): " + a.existByHash(b));// должен
																				// быть
																				// false

		System.out.println("Сортировать по автору: ");
		a.sort(SortByAuthor);
		a.print();

		System.out.println("Сортировать по типу: ");

		a.sort(new Comparator<Paper>() {
			@Override
			public int compare(Paper p1, Paper p2)
			{
				int p1_type = p1 instanceof Science ? 1 : 0;
				int p2_type = p2 instanceof Science ? 1 : 0;
				return (int) (p1_type - p2_type);
			}			
		});
		
		a.print();
		
		System.out.println("Сортировать по дате: ");
		a.sort(new SortByDate());
		
		a.print();
		

	}
};

class anthology
{
	private Paper[] an;

	public anthology() throws ParseException
	{
		super();
		this.an = new Paper[4];
		SimpleDateFormat sdf = new SimpleDateFormat("dd.mm.yyyy");

		an[0] = new Science("2. Инверсные токи", "8. Калобанов А.В.", sdf.parse("16.12.1975"), 4);
		an[1] = new Science("4. Термодинамика", "3. Гордан Д.Д.", sdf.parse("17.01.1968"), 1);
		an[2] = new Biography("1. Пушкин А.С", "5. Дмитров А.Д.", sdf.parse("17.01.1928"), "детство");
		an[3] = new Biography("3. Пушкин А.С", "2. Дмитров А.Д.", sdf.parse("17.07.1928"), "юношество");
	}

	public boolean exist(Paper p)
	{
		boolean result = false;
		for (Paper paper : an)
		{
			if (paper.equals(p))
			{
				result = true;
				break;
			}
		}
		return result;
	}

	public boolean existByHash(Paper p)
	{
		boolean result = false;
		for (Paper paper : an)
		{
			if (paper.hashCode() == p.hashCode())
			{
				result = true;
				break;
			}
		}
		return result;
	}

	public void print()
	{
		for (Paper paper : an)
		{
			System.out.println(paper.toString());
		}

	};

	public void sort()
	{
		Arrays.sort(an);
	}

	public void sortbydate()
	{

	}

	public void sort(Comparator<Paper> c)
	{
		Arrays.sort(an, c);
	}
}

abstract class Paper implements Comparable<Paper>
{
	private String name;
	private String author;

	private Date dateCreated;

	public Paper(String name, String author, Date dateCreated)
	{
		super();
		this.name = name;
		this.author = author;
		this.dateCreated = dateCreated;
	}

	public int compareTo(Paper p)
	{
		return this.name.compareTo(p.name);
	}

	@Override
	public String toString()
	{
		String result;
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		result = getAuthor() + ", \"" + getName() + "\", " + sdf.format(getDateCreated());
		return result;

	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public Date getDateCreated()
	{
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated)
	{
		this.dateCreated = dateCreated;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paper other = (Paper) obj;
		if (author == null)
		{
			if (other.author != null)
				return false;
		}
		else if (!author.equals(other.author))
			return false;
		if (dateCreated == null)
		{
			if (other.dateCreated != null)
				return false;
		}
		else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (name == null)
		{
			if (other.name != null)
				return false;
		}
		else if (!name.equals(other.name))
			return false;
		return true;
	}
}

class Science extends Paper
{
	private int version;

	public Science(String name, String author, Date dateCreated, int version)
	{
		super(name, author, dateCreated);
		this.version = version;
	}

	public int getVersion()
	{
		return version;
	}

	public void setVersion(int version)
	{
		this.version = version;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + version;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Science other = (Science) obj;
		if (version != other.version)
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Science [version=" + version + ", toString()=" + super.toString() + "]";
	}

}

class Biography extends Paper
{
	private String interval;

	public String getInterval()
	{
		return interval;
	}

	public void setInterval(String interval)
	{
		this.interval = interval;
	}

	public Biography(String name, String author, Date dateCreated, String interval)
	{
		super(name, author, dateCreated);
		this.interval = interval;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((interval == null) ? 0 : interval.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Biography other = (Biography) obj;
		if (interval == null)
		{
			if (other.interval != null)
				return false;
		}
		else if (!interval.equals(other.interval))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "biography [interval=" + interval + ", " + super.toString() + "]";
	}

}
