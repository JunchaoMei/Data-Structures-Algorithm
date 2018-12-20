import java.util.*;

public class VectorQueue<T>
{
	private Vector<T> queue; // queue¡¯s front entry is first in the vector

	//constructors
	public VectorQueue()
	{ queue = new Vector<T>();} // vector doubles in size if necessary
	public VectorQueue(int initialCapacity)
	{ queue = new Vector<T>(initialCapacity);}

	//add to the back
	public void enqueue(T newEntry)
	{ queue.add(newEntry);}

	//retrieve the front
	public T getFront()
	{
		T front = null;
		if (!isEmpty())
			front = queue.get(0);
		return front;
	}//end getFront

	//remove the front
	public T dequeue()
	{
		T front = null;
		if (!isEmpty())
			front = queue.remove(0);
		return front;
	}//end dequeue

	//the rest of the class
	public boolean isEmpty()
	{ return queue.isEmpty();}
	public void clear()
	{ queue.clear();}
}//end class VectorQueue