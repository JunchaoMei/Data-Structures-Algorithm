class AdjacencyList
{
	public LinkedList[] Vertices;

	//vertex-k has adjacent vertex-e
	public void addLast(int k, Node e)
	{
		Vertices[k].addLast(e);
	}//end addLast

	//get D[i][j]
	public int getWeight(int i, int j)
	{
		if (i==j)
			return 0;
		else
		{
			int k = Vertices[i].vertexIndex(j);
			return Vertices[i].readDistance(k);
		}//end else
	}//end getWeight

	//constructor using the number of nodes n
	public AdjacencyList(int n)
	{
		Vertices = new LinkedList[n+1];
		for (int i=1; i<=n; i++)
			Vertices[i] = new LinkedList();
	}//end constructor-1

	//constructor using a matrix
	public AdjacencyList(int[][] W)
	{
		int n = W.length-1;
		Vertices = new LinkedList[n+1];
		for (int i=1; i<=n; i++)
			Vertices[i] = new LinkedList();

		for (int i=1; i<=n; i++)
		{
			for (int j=1; j<=n; j++)
			{	//distance is 1~30
				if (W[i][j]>0 && W[i][j]<=30)
				{
					Node e = new Node(j, W[i][j], null);
					addLast(i, e);
				}//end if
			}//end for loop j
		}//end for loop i
	}//end constructor-2

	//print method
	public static void printAdjacencyList(AdjacencyList AL)
	{
		int n = AL.Vertices.length-1;
		for (int i=1; i<=n; i++)
		{
			System.out.println("v"+i);
			System.out.println(AL.Vertices[i]+"\n");
		}//end for loop i
	}//end printAdjacencyList

	public static int[][] listToMatrix(AdjacencyList AL)
	{
		int n = AL.Vertices.length-1;
		int[][] M = new int[n+1][n+1];

		for (int i=1; i<=n; i++)
		{
			for (int j=1; j<=n; j++)
			{
				M[i][j] = AL.getWeight(i, j);
			}//end for loop j
		}//end for loop i

		return M;
	}//end listToMatrix

	//test methods
	public static void main(String[] args) throws Exception
	{
		int[][] M = TableIO.matrix("test-Figure3.2.xls");
		System.out.println("input Matrix is:");
		Print.print2dArray(M);
		System.out.println();

		AdjacencyList AL = new AdjacencyList(M);
		printAdjacencyList(AL);

		System.out.println("output Matrix is:");
		int[][] N = listToMatrix(AL);
		Print.print2dArray(N);
	}//end main
}//end class