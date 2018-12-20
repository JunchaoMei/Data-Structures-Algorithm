import java.util.*;

class TestVectorQueue
{
	public static void main(String[] args)
	{
    	VectorQueue myQueue = new VectorQueue();
    	String response;
    	char x;
    	Scanner input = new Scanner(System.in);
    	System.out.println("Please enter command: i/d/f/c/q");
    	System.out.println("i: insert\nd: delete\nf: get front\nc: clear queue\nq: quit");
    	response = input.next();
    	x = response.charAt(0);
    	x = Character.toLowerCase(x);
    	
    	while(x != 'q' && x != 'Q')
    	{
    		switch(x)
    		{
    		    case 'i'://insert
					System.out.println("Please enter an element:");
					int a = input.nextInt();
    		    	myQueue.enqueue(a);
    		    	break;
    		    case 'd'://delete
    		    	myQueue.dequeue();
    		    	break;
    		    case 'f'://get front
    		    	System.out.println(myQueue.getFront());
    		    	break;
    		    case 'c'://clear queue
    		    	myQueue.clear();
    		    	break;
    		    default:
    		    	System.out.println("Incorrect input: i/d/f/c/q");
    		    	break;
    		 }//end switch
    	System.out.println("Please enter command: i/d/f/c/q");
    	response = input.next();
    	x = response.charAt(0);
    	x = Character.toLowerCase(x);
    	}//end while
		System.out.println("Done.");
	}//end main
}//end class