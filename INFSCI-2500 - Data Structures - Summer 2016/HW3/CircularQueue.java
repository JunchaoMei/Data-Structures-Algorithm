/*
We test this script by entering command i/d/p/l/h/s
i - insert into queue
d - delete from queue
p - print queue physical
l - print queue logical
h - help information for queue commands
s - stop using queue
*/

import java.util.Scanner;

public class CircularQueue 
{	
	private int head, tail;
	private static final int N = 5;// N: The maximum number of elements in the queue
	private String[] q = new String[N];
	private String name;

	Scanner inScan = new Scanner(System.in);
	
	//constructor begins
	public CircularQueue()
	{
		head = -1; // initialize
		tail = -1;
	}//constructor ends

	public boolean isQueueEmpty()
	{
		return (head == -1);
	}

	public boolean isQueueFull()
	{
		return ((tail - head + 1) == 0||((tail - head +1) == N));
	}

	private String getName()
	{
		System.out.println("Enter a name: ");
		return inScan.nextLine();
	}

	public void insertQueue()
	{
		if(isQueueFull())
			System.out.println("Queue Overflow");//exit
		else
		{
			name = getName();
			if(isQueueEmpty())
				head = 0;
			if(tail == N - 1)
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
				if(head == N) //warpping
					head = 0;
			}//inner else ends
		}//outer else ends
	}//deleteQueue ends

	public void printQueuePhysical()
	{
		for(int j = 0; j < N; j++)
			System.out.println("q[" + j +"]= " + q[j]);
	}

	public void printQueueLogical()
	{
		if(isQueueEmpty())
			System.out.println("Queue Underflow"); // exit
		else //print queue
		{
			int next = head;
			System.out.println("q[" + next +"]= " + q[next]);
			while(next != tail)
			{
				next++;
				if(next == N)//warp
					next = 0;
				System.out.println("q[" + next +"]= " + q[next]);
			}//while ends
		}//else ends
	}//printQueueLogical ends

	public void printQueueHelpInfo()//print help information for queue commands
	{
		System.out.println
			("i - insert into queue\n"+
			 "d - delete from queue\n"+
			 "p - print queue physical\n"+
			 "l - print queue logical\n"+
			 "h - help information for queue commands\n"+
			 "s - stop using queue");
	}//end printQueueHelpInfo
}//End CircularQueue

class TestCircularQueue2
{
	public static void main(String[] args) 
	{
		CircularQueue q =new CircularQueue();
		String response; // user response
		char C, c;//"c" for "command"
		Scanner inScan = new Scanner (System.in);

		System.out.println("Please enter command - i/d/p/l/h/s");
		response = inScan.next();
		C = response.charAt(0);
		c = Character.toLowerCase(C);

		while (c!='s')
		{
			switch (c)
			{
				case 'i':
					q.insertQueue();
					break;
				case 'd':
					q.deleteQueue();
					break;
				case 'p':
					q.printQueuePhysical();
					break;
				case 'l':
					q.printQueueLogical();
					break;
				case 'h':
					q.printQueueHelpInfo();
					break;
				default:
					System.out.println("incorrect enter - i/d/p/l/h/s");
			}//end switch

			System.out.println("Please enter command - i/d/p/l/h/s");
			response = inScan.next();
			C = response.charAt(0);
			c = Character.toLowerCase(C);
		}//end while
	}//end main
}//end TestCircularQueue2