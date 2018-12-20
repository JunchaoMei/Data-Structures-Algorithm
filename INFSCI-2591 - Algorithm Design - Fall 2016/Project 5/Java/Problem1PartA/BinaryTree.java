import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

class BinaryTree
{
	Node root;
    
    void mirror()
	{ root = mirror(root);}

    Node mirror(Node node)
	{
        if(node == null)
            return node;
        
        Node left = mirror(node.left);
        Node right = mirror(node.right);
        node.left = right;
        node.right = left;
        
        return node;
    }//end mirror

    void levelOrder()
	{ levelOrder(root);}

    void levelOrder(Node root)
	{
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> result = new ArrayList<String>();
        Queue<Node> q = new LinkedList<Node>();
        if(root == null)
            return;
        q.add(root);
        while(!q.isEmpty())
		{
            Node n = (Node)q.remove();
            //System.out.print("\t"+n.data);
            list.add(n.data);
            if(n.left != null)
                q.add(n.left);
            
            //else System.out.print("null");
            if(n.right != null)
                q.add(n.right);
            //else System.out.print("null");
        }//end while loop
        
        //int n = findEnd(list);
        for(int i=0; i<list.size(); i++)
            result.add(list.get(i));
        System.out.println(result.toString());
    }//end levelOrder
    
    Node getLeft(Node n)
	{ return n.left;}

    Node getRight(Node n)
	{ return n.right;}
    
    public static Node buildTree(Node root, String[] nums, int index)
	{  
        if (index>=nums.length)
            return null;  
        root = new Node(nums[index]);  
        root.left = buildTree(root.left, nums, 2*index+1);  
        root.right = buildTree(root.right, nums, 2*index+2);  
        return root;  
    }//end buildTree
    
    public static BinaryTree createTree(int n)
	{
    	BinaryTree t = new BinaryTree();
    	String[] arr = new String[n];

    	for(int i=0; i<arr.length; i++)
		{
    		Random rand = new Random();
    		int k = rand.nextInt(50);
    		String r = String.valueOf(k);
    		arr[i] = r;
    	}//end for loop i
/*
        for(int i=0; i<arr.length; i++){
        	System.out.print(arr[i]+" ");
        }
*/
    	System.out.println("\nThe number of nodes in the tree is: "+n/1000000+" million.\n");
    	Node root = new Node(arr[0]);
    	
    	t.root = buildTree(root, arr, 0);
    	return t;
    }//end createTree
}//end class BinaryTree