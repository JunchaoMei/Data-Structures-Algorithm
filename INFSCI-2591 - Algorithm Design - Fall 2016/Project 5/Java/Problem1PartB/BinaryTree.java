import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class BinaryTree
{
	Node a,b;
	static boolean isMirror(Node a, Node b)
	{
		if(a == null && b == null)
		{ return true;}

		if(a == null || b == null)
		{ return false;}
		
		return a.data == b.data && isMirror(a.left, b.right) && isMirror(a.right, b.left);
	}//end isMirror
	
	public static Node buildTree(Node root, int[] nums, int index)
	{
		if (index>=nums.length)
		{ return null;}
		
        root = new Node(nums[index]);
        root.left = buildTree(root.left, nums, 2*index+1);
        root.right = buildTree(root.right, nums, 2*index+2);
        return root;
	}//end buildTree
	
	public static Node createTree(int n)
	{
		int[] arr = new int[n];

		for(int i=0; i<arr.length; i++)
		{
			Random rand = new Random();
			int k = rand.nextInt(50);
			arr[i] = k;
		}//end for loop i

		Node root = new Node(arr[0]);
		root = buildTree(root, arr, 0);
		System.out.println("\nThe number of nodes is: "+n/1000000+" million.");
		return root;
	}//end createTree
}//end class BinaryTree