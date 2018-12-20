import java.util.*;

class Girth
{
	private int[][] AdjacencyMatrix;
	private int n;
	private int girth;
	
	//constructors
	public Girth(String fileName) throws Exception
	{
		AdjacencyMatrix = TableIO.matrix(fileName);
		n = AdjacencyMatrix.length-1;
	}//end Girth(String fileName)
	public Girth(int[][] AdMatrix)
	{
		AdjacencyMatrix = AdMatrix;
		n = AdjacencyMatrix.length-1;
	}//end Girth(int[][] AdMatrix)

	public int getGirth()
	{ return girth;}

	public int visit(Node nod, int girth)
	{	
		int cycle = nod.cycleLength();
		return (cycle<girth ? cycle : girth);
	}//end visit

	public static HashSet union(HashSet set1, HashSet set2)
	{
		HashSet result = new HashSet();
        result.clear();
        result.addAll(set1);
        result.addAll(set2);
		return result;
	}//end union

	public void BFS()
	{
		VectorQueue Q = new VectorQueue();
		Node u, v, root;
		girth=300000;
		//Time Complexity: O(1)

		//create Node root (level-0)
		root = new Node(0,-1,0);
		v = root;
		girth = visit(v,girth);
		Q.enqueue(v);
		//Time Complexity: O(1)
		
		//create Nodes (level-1)
		for (int i=1; i<=n; i++)
		{
			v.addChildVertex(i);
			v.addChild(new Node(i,0,1));
		}//end for loop i
		//Time Complexity: O(n)

		while (!Q.isEmpty() && girth==300000)
		{	
			//override Node v
			v = (Node) Q.getFront();
			//System.out.print("\nv="+v.getVertex()+" ");
			int v_Level = v.getLevel();
			int v_Vertex = v.getVertex();
			int v_Parent = v.getParent();

			//iteration
			HashSet U = v.getChildren();
			Iterator it = U.iterator();
			while (it.hasNext())
			{
				u = (Node) it.next();
				int u_Level = u.getLevel();
				int u_Vertex = u.getVertex();
				int u_Parent = u.getParent();

				//create ancestors
				HashSet parent = new HashSet(); parent.add(v);
				HashSet grands = v.getAncestors();
				u.setAncestors(union(parent,grands));
				Iterator uAncestors = u.getAncestors().iterator();
				while (uAncestors.hasNext())
				{
					Node uAncest = (Node) uAncestors.next();
					u.addAncestorVertex(uAncest.getVertex());
				}//end while loop uAncestors
				//Time Complexity: O(n*m)

				//create children
				for (int j=1; j<=n; j++)
				{
					int weight = AdjacencyMatrix[u_Vertex][j];
					if (weight>0 && weight<300000 && j!=u_Parent)
					{
						u.addChild(new Node(j,u_Vertex,u_Level+1));
						u.addChildVertex(j);
					}//end if
				}//end for loop j
				//Time Complexity: O(n*n)

				girth = visit(u,girth);
				//System.out.print("u="+u.getVertex()+" "+girth);
				Q.enqueue(u);
				//Time Complexity: O(1)
			}//end while loop it
			Q.dequeue();
		}//end while
	}//end BFS
	//Time Complexity of BFS: O(1)+O(n)+O(n*m)+O(n*n) = O(n*(n+m)) = O(n*m)
}//end Girth