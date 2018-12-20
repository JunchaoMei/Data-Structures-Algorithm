import java.util.*;

class Node 
{
	private String element;
	private Node next;//recursive definition

	//constructor
	public Node(String elt, Node nx)
	{ element=elt; next=nx;}

	public String getElement()
	{ return element;}

	public Node getNext()
	{ return next;}

	public void setElement(String nextElement)
	{ element=nextElement;}

	public void setNext(Node nextNode)
	{ next=nextNode;}
}//end Node

class LinkedList
{
	protected Node head;
	protected Node tail;
	protected long size;

	//constructor
	public LinkedList()
	{ head=null; tail=null; size=0;}

	public void addFirst(Node newNode)
	{
		newNode.setNext(head);
		head=newNode;
		size++;
	}//end addFirst

	//reload method [toString]
	public String toString()
	{
		String output="";
		Node nextItem;
		nextItem=head;

		while (nextItem!=null)
		{
			output = output + nextItem.getElement() +"		"+ nextItem.getNext() + "\n";
			nextItem = nextItem.getNext();
		}//end while
		
		//at the last Node
		output = output + " (done)";
		return output;
	}//end toString

	public long getSize()
	{ return size;}
}//end LinkedList

class TestLinkedList
{
	public static void main(String[] args) 
	{
		Node a = new Node("Amy", null);
		Node b = new Node("Bob", null);
		Node c = new Node("Chris", null);
		Node d = new Node("David", null);
		Node e = new Node("Eva", null);

		LinkedList myList = new LinkedList();
		myList.addFirst(a);
		myList.addFirst(b);
		myList.addFirst(c);
		myList.addFirst(d);
		myList.addFirst(e);

		System.out.println(myList);//call method [toString]
		System.out.println("size = " + myList.getSize());

		//read an element from LinkedList
		Scanner inScan = new Scanner(System.in);
		long i = inScan.nextInt();
		System.out.println(readElement(myList, i));
	}//end main

	public static String readElement(LinkedList LL, long i)
	{
		Node p;
		p = LL.head;
		int j=0;//0-based index

		if (i<0 || i>(LL.getSize()-1))
			return ("the element with index of " + i + " does not exist");
		else
		{
			while (j<i)
			{
				p = p.getNext();
				j++;
			}//end while
			
			return ("the element with index of " + i +" is " + p.getElement());
		}//end else
	}//end readElement
}//end TestLInkedList