class Dijkstra_Adjacency_List
{	//paths starting from vertex-k
	public static void dijkstra_Adjacency_List (AdjacencyList AL, Edge[] F, int k)
	{
		int n = AL.Vertices.length-1;
		int[][] W = new int[n+1][n+1];

		//initialize W using AdjacencyList
		for (int x=1; x<=n; x++)
		{
			for (int y=1; y<=n; y++)
			{
				W[x][y] = AL.getWeight(x,y);
			}//end for loop y
		}//end for loop x

		int i, p=0, vnear=0;//p is the index of F[]
		Edge e;
		int[] touch = new int[n+1];
		int[] length = new int[n+1];

		for (i=1; i<=n; i++)
		{
			if (i!=k)
			{
				touch[i] = k;
				length[i] = W[k][i];
			}
		}//end for loop

		for (int x=1; x<=(n-1); x++)
		{
			int min = 300000;
			for (i=1; i<=n; i++)
			{
				if (i!=k && length[i]>=0 && length[i]<min)
				{
					min = length[i];
					vnear = i;
				}//end if
			}//end foor loop i
			
			e = new Edge(touch[vnear], W[touch[vnear]][vnear], vnear);
			F[p++] = e;

			for (i=1; i<=n; i++)
			{
				if (i!=k && length[vnear]+W[vnear][i] < length[i])
				{
					length[i] = length[vnear] + W[vnear][i];
					touch[i] = vnear;
				}//end if
			}//end foor loop i
			length[vnear] = -1;
		}//end for loop x
	}//end dijkstra_Adjacency_List

	public static void printEdge(Edge e)
	{
		int a = e.getStart();
		int b = e.getEnd();
		int l = e.getDistance();

		System.out.print("v"+a+"--"+l+"-->v"+b+" ");
	}//end printEdge

	public static void printF (Edge[] F)
	{
		for (int i=0; i<F.length; i++)
		{
			if (F[i]!=null)
				printEdge(F[i]);
		}//end for loop i
		System.out.println();
	}//end printF

	//find index y for F[y] starts with v-i and ends with v-j
	public static int index (Edge[] F, int i, int j)
	{	
		int y;
		for (y=0; y<F.length; y++)
		{
			if (F[y]!=null && F[y].getStart()==i && F[y].getEnd()==j)
				return y;
		}//end for loop y
		return -1;
	}//end index
	//find index y for F[y] ends with v-j
	public static int index (Edge[] F, int j)
	{	
		int y;
		for (y=0; y<F.length; y++)
		{
			if (F[y]!=null && F[y].getEnd()==j)
				return y;
		}//end for loop y
		return -1;
	}//end index
	
	//shortest path from vi(fixed) to vj (indices)
	public static int[] shortestPath (Edge[]F, int i, int j)
	{
		int l = F.length;
		int[] sP = new int[l];
		for (int q=0; q<sP.length; q++)
			sP[q] = -1;

		int edgeIndex = index(F, j);
		int backVertex = F[edgeIndex].getStart();
		sP[l-1] = edgeIndex;
		int r=l-2;

		while (backVertex!=i)
		{
			edgeIndex = index(F, backVertex);
			backVertex = F[edgeIndex].getStart();
			sP[r--] = edgeIndex;
		}//end while
		return sP;
	}//end shortestPath

	//print shortest path from vi(fixed) to vj
	public static void printShortestPath (Edge[] F, int i, int j)
	{
		int[] sP = shortestPath(F,i,j);
		System.out.print("The shortest path from v"+i+" to v"+j+":  ");
		for (int q=0; q<sP.length; q++)
		{
			if (sP[q]!=-1)
				printEdge(F[sP[q]]);
		}//end for loop
		System.out.println();
	}//end printShortestPath

	//print shortest path from vi(fixed) to others
	public static void printShortestPaths (Edge[] F, int i)
	{
		int n = (int)Math.sqrt(F.length);
		for (int j=1; j<=n; j++)
		{
			if (j!=i)
				printShortestPath(F,i,j);
		}//end for loop j
	}//end printAll

	public static void main (String[] args) throws Exception
	{
		int[][] W = TableIO.matrix("test-TestCase1.xls");
		int n = W.length-1;
		Edge[] F = new Edge[n*n];
		
		AdjacencyList AL = new AdjacencyList(W);
		dijkstra_Adjacency_List(AL, F, 1);
		printF(F);
		printEdge(F[1]);
		System.out.println(index(F, 4, 1));
		printShortestPath(F, 1, 5);
		System.out.println();

		Edge[] E = new Edge[n*n];
		dijkstra_Adjacency_List(AL, E, 2);
		printF(E);
		printEdge(E[1]);
		System.out.println(index(E, 4, 1));
		printShortestPath(E, 2, 5);
		printShortestPath(E, 2, 1);
		System.out.println();

		for (int k=1; k<=n; k++)
		{
			E = new Edge[n*n];
			dijkstra_Adjacency_List(AL, E, k);
			printShortestPaths(E,k);
		}//end for loop k

	}//end main
}//end Dijkstra_2D_Array