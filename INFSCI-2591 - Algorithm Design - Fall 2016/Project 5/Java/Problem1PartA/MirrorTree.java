class MirrorTree
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		//System.out.print("Hello World");
        
        BinaryTree tree = new BinaryTree();
        tree.root = new Node("3");
        tree.root.left = new Node("9");
        tree.root.right = new Node("20");
        tree.root.left.left = new Node("null");
        tree.root.left.right = new Node("null");
        tree.root.right.left = new Node("15");
        tree.root.right.right = new Node("7");
        
        BinaryTree tree2 = new BinaryTree();
        tree2.root = new Node("5");
        tree2.root.left = new Node("14");
        tree2.root.right = new Node("15");
        tree2.root.left.left = new Node("null");
        tree2.root.left.right = new Node("3");
        tree2.root.right.left = new Node("6");
        tree2.root.right.right = new Node("9");
        tree2.root.left.left.left = new Node("null");
        tree2.root.left.left.right = new Node("null");
        tree2.root.left.right.left = new Node("1");
        tree2.root.left.right.right = new Node("null");
        tree2.root.right.left.left = new Node("null");
        tree2.root.right.left.right = new Node("null");
        tree2.root.right.right.left = new Node("null");
        tree2.root.right.right.right = new Node("null");
        
        BinaryTree t = new BinaryTree();
        t.root = new Node("3");
        t.root.left = new Node("20");
        t.root.right = new Node("9");
        t.root.left.left = new Node("null");
        t.root.left.right = new Node("null");
        t.root.right.left = new Node("1");
        t.root.right.right = new Node("5");
        t.root.left.left.left = new Node("null");
        t.root.left.left.right = new Node("null");
        t.root.left.right.left = new Node("null");
        t.root.left.right.right = new Node("null");
        t.root.right.left.left = new Node("2");
        t.root.right.left.right = new Node("4");
        t.root.right.right.left = new Node("null");
        t.root.right.right.right = new Node("null");
        t.root.left.left.left.left = new Node("null");
        t.root.left.left.left.right = new Node("null");
        t.root.left.left.right.left = new Node("null");
        t.root.left.left.right.right = new Node("null");
        t.root.left.right.left.left = new Node("null");
        t.root.left.right.left.right = new Node("null");
        t.root.left.right.right.left = new Node("null");
        t.root.left.right.right.right = new Node("null");
        t.root.right.left.left.left = new Node("15");
        t.root.right.left.left.right = new Node("null");
        t.root.right.left.right.left = new Node("null");
        t.root.right.left.right.right = new Node("null");
        t.root.right.right.left.left = new Node("null");
        t.root.right.right.left.right = new Node("null");
        t.root.right.right.right.left = new Node("null");
        t.root.right.right.right.right = new Node("null");
        
        System.out.print("\nTime experiments:\n");
        
        BinaryTree test = BinaryTree.createTree(15);
        System.out.println("Level order traverse the input tree:");
        test.levelOrder();
        System.out.println("\n");
        
        long start_time = System.currentTimeMillis();
        test.mirror();
        long end_time = System.currentTimeMillis();
        long duration = end_time - start_time;
        
        System.out.println("Level order traverse the mirrored binary tree:");
        test.levelOrder();
        System.out.println("\nThe time for generating the mirror tree is "+duration+" milliseconds.");
    }//end main
}//end class MirrorTree