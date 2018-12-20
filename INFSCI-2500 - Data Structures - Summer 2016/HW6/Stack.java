/*
This stack is pushed(inserted) backwards and popped(deleted) forwards, just like a real stack acting LIFO.
We test this script by entering command i/d/p/l/h/s
i - insert into stack (push)\n"+
d - delete from stack (pop)\n"+
p - print stack physical\n"+
l - print stack logical\n"+
h - help information for stack commands\n"+
s - stop using stack");
*/

import java.util.Scanner;

public class Stack
{	
	private int top, bottom;
	private static final int N = 5; // N: The maximum number of elements on the stack
	private String[] s = new String[N];
	private String item;

	Scanner inScan = new Scanner(System.in);
	
	//constructor begin
	public Stack()
	{
		top = N; // initialize
		bottom = N;
	}//constructor end

	public boolean isStackEmpty() //when stack is empty, bottom==N
	{
		return (bottom == N);
	}

	public boolean isStackFull() //when stack is full, top==0
	{
		return (top == 0);
	}

	private String getItem()
	{
		System.out.print("Enter an item: ");
		return inScan.nextLine();
	}

	public void insertStack()
	{
		if(isStackFull())
			System.out.println("Stack Overflow");//exit
		else
		{
			item = getItem();
			if(isStackEmpty())
				bottom--;//end if [bottom==(N-1)]
			s[--top] = item;
		}//end else
	}//end insertStack

	public void deleteStack()
	{
		if(isStackEmpty())
			System.out.println("Stack Underflow");//exit
		else //if not empty
		{
			if(top == N-1) //just emptying the Stack
				bottom++;//end if [bottom==N]
			System.out.println("Popping s["+top+"] == "+s[top]);
			top++;
		}//end else
	}//end deleteStack

	public void printStackPhysical()
	{
		for(int i=0; i<N; i++)
			System.out.println("s[" + i +"]= " + s[i]);
	}

	public void printStackLogical()
	{
		if(isStackEmpty())
			System.out.println("Stack Underflow"); //exit
		else //print Stack
		{
			for(int i=top; i<N; i++)
				System.out.println("s[" + i +"]= " + s[i]);
		}//end else
	}//end printStackLogical

	public void printStackHelpInfo()//print help information for stack commands
	{
		System.out.println
			("i - insert into stack (push)\n"+
			 "d - delete from stack (pop)\n"+
			 "p - print stack physical\n"+
			 "l - print stack logical\n"+
			 "h - help information for stack commands\n"+
			 "s - stop using stack");
	}//end printStackHelpInfo
}//end Stack

class TestStack
{
	public static void main(String[] args) 
	{
		Stack s =new Stack();
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
					s.insertStack();
					break;
				case 'd':
					s.deleteStack();
					break;
				case 'p':
					s.printStackPhysical();
					break;
				case 'l':
					s.printStackLogical();
					break;
				case 'h':
					s.printStackHelpInfo();
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
}//end TestStack