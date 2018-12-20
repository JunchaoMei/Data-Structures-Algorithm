/*
We test this script by setting size=5 and increasing queue from 0 to 6
size: the capacity of this circular queue
queue: the number of people waiting in queue
*/

import java.util.Scanner;

public class CircularQueue 
{	
	private int head, tail;
	private static final int size = 5;
	private String[] q = new String[size];
	private String name;

	Scanner input = new Scanner(System.in);
	
	//constructor begins
	public CircularQueue()
	{
		head = -1; // initialize
		tail = -1;
	}//constructor ends
	
	public void insertQueue()
	{
		if(isQueueFull())
			System.out.println("Overflow");
		else
		{
			name = getName();
			if(isQueueEmpty())
				head = 0;
			if(tail == size - 1)
				tail = -1;
			q[++tail] = name;
		}
	}

	public void deleteQueue()
	{
		String x; //hold name
		if(isQueueEmpty())
			System.out.println("Underflow");
		else // inner case begins
		{
			x = q[head];
			System.out.println("Serving " + x);
			if(head == tail) // just emptying the queue
			{
				head = -1;
				tail = -1;
			}
			else
			{
				head++;
				if(head == size) //warpping
					head = 0;
			}//inner else ends
		}//outer else ends
	}//deleteQueue ends

	public void deleteQueueWithoutPrint()
	{
		String x; //hold name
		if(isQueueEmpty())
			System.out.println("Underflow");
		else // inner case begins
		{
			x = q[head];
			if(head == tail) // just emptying the queue
			{
				head = -1;
				tail = -1;
			}
			else
			{
				head++;
				if(head == size) //warpping
					head = 0;
			}//inner else ends
		}//outer else ends
	}//deleteQueue ends

	public void printQueuePhysical()
	{
		for(int j = 0; j < size; j++)
			System.out.println("q[" + j +"]= " + q[j]);
	}

	public void printQueueLogical()
	{
		int next;
		if(isQueueEmpty())
			System.out.println("Underflow"); // exit
		else //print queue
		{
			next = head;
			System.out.println("q[" + next +"]= " + q[next]);
			while(next != tail)
			{
				next++;
				if(next == size) //warpping
					next = 0;
				System.out.println("q[" + next +"]= " + q[next]);
			}//while ends
		}//else ends
	}//printQueueLogical ends

	private String getName()
	{
		System.out.println("Enter name ");
		return input.nextLine();
	}

	public boolean isQueueEmpty()
	{
		return (head == -1);
	}

	public boolean isQueueFull()
	{
		return ((tail - head + 1) == 0||((tail - head +1) == size));
	}
}// CircularQueue ends

class TestCircularQueue
{
	public static void main(String[] args) 
	{
		System.out.println("Size = 5");
		System.out.println("Test:\n");
		CircularQueue m = new CircularQueue();
		for(int queue = 0; queue < 7; queue++)
		{
			System.out.println("when queue = "+queue);
			for(int j = 0; j < queue; j++)
				m.insertQueue();
			m.deleteQueue();
			m.printQueueLogical();
			for(int k = 0; k < queue-1; k++)
				m.deleteQueueWithoutPrint();
			System.out.println();
		}
	}
}//Test CircularQueue end