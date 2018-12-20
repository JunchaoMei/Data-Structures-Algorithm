import java.util.*;

class Node 
{
	private int vertex;
	private int distance;
	private Node next;//recursive definition

	//constructor
	public Node(int v, int d, Node nx)
	{ vertex=v; distance=d; next=nx;}
	public Node(int v, Node nx)
	{ vertex=v; next=nx;}

	public int getVertex()
	{ return vertex;}

	public int getDistance()
	{ return distance;}

	public Node getNext()
	{ return next;}

	public void setVertex(int nextVertex)
	{ vertex=nextVertex;}

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

	public void addFirst(Node e)
	{
		Node newest = e;
		newest.setNext(head);
		head=newest;
		size++;
	}//end addFirst

	public void addLast(Node e)
	{
		Node newest = e;
		newest.setNext(null);

		if (size==0)
			head=newest;
		else
			tail.setNext(newest);

		tail=newest;
		size++;
	}//end addLast

	//reload method [toString]
	public String toString()
	{
		String output="";
		Node nextItem;
		nextItem=head;

		while (nextItem!=null)
		{
			output = output + nextItem.getVertex() +"	"+ nextItem.getDistance() +"	"+ nextItem.getNext()+ "\n";
			nextItem = nextItem.getNext();
		}//end while
		
		//at the last Node
		output = output + " (done)";
		return output;
	}//end toString

	public long getSize()
	{ return size;}

	public String readNode(long i)
	{
		Node p;
		p = head;
		int j=0;//0-based index

		if (i<0 || i>(size-1))
			return ("the vertex with index of " + i + " does not exist");
		else
		{
			while (j<i)
			{
				p = p.getNext();
				j++;
			}//end while
			
			return ("the vertex with index of " + i +" is " + p.getVertex()+"\nthe distance is "+p.getDistance());
		}//end else
	}//end readNode

	public boolean containVertex(int v)//v is the vertex
	{
		Node p = head;

		for (int i=0; i<size; i++)
		{
			if (p.getVertex()==v)
				return true;
			p = p.getNext();
		}//end for loop
		//no connection
		return false;
	}//end containVertex

	public int vertexIndex(int v)//v is the vertex
	{
		Node p = head;

		for (int i=0; i<size; i++)
		{
			if (p.getVertex()==v)
				return i;
			p = p.getNext();
		}//end for loop
		//no connection
		return -1;
	}//end vertexIndex

	public int readVertex(int i)//i is the index
	{
		Node p;
		p = head;
		int j=0;//0-based index

		//no connection
		if (i<0 || i>(size-1))
			return -1;
		else
		{
			while (j<i)
			{
				p = p.getNext();
				j++;
			}//end while
			
			return p.getVertex();
		}//end else
	}//end readVertex

	public int readDistance(int i)//i is the index
	{
		Node p;
		p = head;
		int j=0;//0-based index

		//no connection
		if (i<0 || i>(size-1))
			return 300000;
		else
		{
			while (j<i)
			{
				p = p.getNext();
				j++;
			}//end while
			
			return p.getDistance();
		}//end else
	}//end readDistance
}//end LinkedList

class TestLinkedList
{
	public static void main(String[] args) 
	{
		Node a = new Node(1, 11, null);
		Node b = new Node(2, null);
		Node c = new Node(3, 33, null);
		Node d = new Node(4, 44, null);
		Node e = new Node(5, 55, null);

		LinkedList myList = new LinkedList();
		myList.addLast(a);
		myList.addLast(b);
		myList.addLast(c);
		myList.addLast(d);
		myList.addLast(e);

		System.out.println(myList);//call method [toString]
		System.out.println("size = " + myList.getSize());

		Scanner inScan = new Scanner(System.in);
/*
		//read an vertex from LinkedList
		System.out.println("please enter an index: ");
		long i = inScan.nextInt();
		System.out.println(myList.readNode(i));
*/
		System.out.println("please enter a vertex: ");
		int v = inScan.nextInt();
		//System.out.println(myList.containVertex(index));
		int i = myList.vertexIndex(v);
		System.out.println("index is "+i);
		System.out.println("vertex of index "+i+" is "+myList.readVertex(i));
		System.out.println("distance of index "+i+" is "+myList.readDistance(i));
	}//end main
}//end TestLInkedList