class Person 
{	//private member variables
	private String name;
	private int age;
	private String address;
	private String phone;

	//constructor
	public Person(String n, int ag, String ad, String p)
	{ name=n; age=ag; address=ad; phone=p;}

	//print method
	public String toString()
	{ return getName()+", "+getAge()+", "+getPhoneNumber();}

	public String getName()
	{ return name;}

	public int getAge()
	{ return age;}

	public String getAddress()
	{ return address;}

	public String getPhoneNumber()
	{ return phone;}

	public void setAddress(String newAddress)
	{ address=newAddress;}

	public void setPhoneNumber(String newPhone)
	{ phone=newPhone;}
}//end class Person

//inheritance from Person to Student
class Student extends Person
{	//private member variables
	private double gpa;

	//constructor
	public Student(String n, int ag, String ad, String p, double g)
	{	super(n, ag, ad, p);//call constructor of father class Person
		gpa=g;//unique property of class Student
	}
	
	public String toString()//reload method toString
	{	return super.toString() +", "+ getGPA();}

	public double getGPA()
	{	return gpa;}
}//end class Student

//inheritance from Person to Employee
class Employee extends Person
{	//private member variables
	private double salary;

	//constructor
	public Employee(String n, int ag, String ad, String p, double s)
	{	super(n, ag, ad, p);//call constructor of father class Person
		salary=s;//unique property of class Student
	}
	
	public String toString()//reload method toString
	{	return super.toString() +", $"+ getSalary();}

	public double getSalary()
	{	return salary;}

	public void raise(double percentRaise)
	{	salary*=(1+percentRaise);}
}//end class Student
	
class PersonDemo
{	//print info of all people (including Student & Employee)
	public static void printAll(Person[] arr)
	{
		for (int i=0; i<arr.length; i++)
		{
			if (arr[i]!=null)
			{
				System.out.print("["+i+"] ");
				System.out.println(arr[i].toString());
			}//end if
		}//end for
	}//end printAll

	public static void main(String[] args) 
	{
		Person[] p = new Person[4];

		p[0] = new Person("Joe", 25, "New Work", "212-555-1212");
		p[1] = new Student("Jerry", 23, "Chicage", "312-555-1212", 4.0);
		p[2] = new Employee("Bob", 36, "Pittsburgh", "412-555-1212", 100000.0);
		printAll(p);

		((Employee)p[2]).raise(0.234567);//salary raise, force p[2] transform its type to Employee
		System.out.println("After Bob's salary increase by 23.4567%:");
		System.out.print("[2] ");
		System.out.println(p[2].toString());
	}//end main
}//end PersonDemo