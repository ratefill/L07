package by.epam.l07.example;

import java.util.HashSet;
import java.util.TreeSet;

public class ComparableDemo
{
	public static void main(String[] args)
	{
		Person p1 = new Person("Ivan", "Ivanov", 1987);
		Person p2 = new Person("Petr", "Petrov", 1985);
		Person p3 = new Person("Sidor", "Sidorov", 1967);
		Person p4 = new Person("Ilya", "Myrometz", 1731);
		HashSet<Person> personSet = new HashSet<>();
		personSet.add(p1);
		personSet.add(p2);
		personSet.add(p3);
		personSet.add(p4);
		System.out.println(personSet);
		
		TreeSet<Person> personTreeSet = new TreeSet<>();
		personTreeSet.add(p1);
		personTreeSet.add(p2);
		personTreeSet.add(p3);
		personTreeSet.add(p4);
		System.out.println(personTreeSet);
	}
}

class Person implements Comparable<Person>
{
	private String firstName;
	private String lastName;
	private int age;

	public Person(String firstName, String lastName, int age)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public int getAge()
	{
		return age;
	}

	public int compareTo(Person anotherPerson)
	{
		int anotherPersonAge = anotherPerson.getAge();
		return this.age - anotherPersonAge;
	}

	public String toString()
	{
		return "[" + getClass().getSimpleName() + ": firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ "]\n";
	}
}