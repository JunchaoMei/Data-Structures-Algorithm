class TestMirrorTree
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		//Test Case 2.1
		
		Node a = new Node(3);
		a.left = new Node(9);
		a.right = new Node(20);
		a.right.left = new Node(15);
		a.right.right = new Node(7);
		Node b = new Node(3);
		b.left = new Node(20);
		b.right = new Node(9);
		b.left.left = new Node(7);
		b.left.right = new Node(15);
		
		System.out.println("\nTest Case-2.1\n");
	
		//Test Case-2.2

		Node c = new Node(5);
		c.left = new Node(14);
		c.right = new Node(15);
		c.left.right = new Node(3);
		c.right.left = new Node(6);
		c.right.right = new Node(9);
		c.left.right.left = new Node(1);
		Node d = new Node(5);
		d.left = new Node(15);
		d.right = new Node(14);
		d.left.left = new Node(9);
		d.left.right = new Node(6);
		d.right.left = new Node(3);
		d.left.right.right = new Node(1);
		//d.right.left.right = new Node(1);
		
		//Test Case 2.3 
		
		Node e = new Node(3);
		e.left = new Node(20);
		e.right = new Node(9);
		e.right.left = new Node(1);
		e.right.right = new Node(5);
		e.right.left.left = new Node(2);
		e.right.left.right = new Node(4);
		e.right.left.left.left = new Node(15);
		Node f = new Node(3);
		f.left = new Node(9);
		f.right = new Node(20);
		f.left.left = new Node(5);
		f.left.right = new Node(1);
		f.left.right.left = new Node(4);
		f.left.right.right = new Node(2);
		f.left.right.left.right = new Node(15);
		
		/*
		System.out.println("\nTime experiments:\n");
		Node g = BinaryTree.createTree(5000000);
		Node h = BinaryTree.createTree(5000000);
		*/
		System.out.println("\nThe result of testing is: ");
		
		long start = System.currentTimeMillis();
		if(BinaryTree.isMirror(a, b))
			System.out.println("Yes, mirror images");
		else
			System.out.println("No, not mirror images");
		long end = System.currentTimeMillis();
		long duration = end - start;
		System.out.println("The time is "+duration+" milliseconds.");
	}//end main
}//end class TestMirrorTree