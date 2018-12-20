/* This script is the demo of creating and using objects. */

class Ticket
{
	//define member variables of class Ticket
	private int serialNumber;
	private static int ticketCount = 0; //static member variable, shared by all objects of Ticket class

	//define member methods of class Ticket
	public Ticket()//create a constructor
	{
		System.out.println("Calling constructor");
		serialNumber = ++ticketCount;
	}

	public int getSerial()//create a "getter" of serialNumber
	{	
		return serialNumber;
	}
	
	public String toString()
	{	
		return "Ticket #" + getSerial();
	}

	public static int getTicketCount()//create a "getter" of ticketCount
	{
		return ticketCount;
	}
}//end class Ticket

public class TestTicket
{
	public static void main(String[] args) 
	{
		Ticket t1; //define variables with class of Ticket
		Ticket t2;

		System.out.println("Ticket count is " + Ticket.getTicketCount());

		t1 = new Ticket(); //create objects for variables and call the constructor
		t2 = new Ticket();

		System.out.println("Ticket count is " + Ticket.getTicketCount());

		System.out.println("Serial Number of t1 is " + t1.getSerial());
		System.out.println("Serial Number of t1 is " + t2.getSerial());
	}//end main
}//end TestTicket 