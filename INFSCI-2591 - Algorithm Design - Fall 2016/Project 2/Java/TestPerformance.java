import java.util.*;

class TestPerformance
{
	public static void main (String[] args) throws Exception
	{	
		Scanner inScan = new Scanner(System.in);
		int[][] graph;

		//determine size n
		System.out.println("Please input the size n: ");
		int n = inScan.nextInt();
		
		//determine graph type
		System.out.println("Please select the graph type ('s'=sparse, 'c'=complete):");
		char graphType = inScan.next().charAt(0);
			//System.out.println(graphType);

		//generate adjacency matrix
		switch (graphType)
		{
			case 's':
				graph = MatrixGenerate.sparseGraph(n, 30);
				break;
			case 'c':
				graph = MatrixGenerate.completeGraph(n, 30);
				break;
			default:
				graph = MatrixGenerate.sparseGraph(n, 30);
		}//end switch
/*
		//output excel spreadsheets of graphs
		String graphFileName = graphType +"-Graph with size "+n+".xlsx";
		TableIO.createTable(graphFileName, graph);
*/
		//determine algorithm
		System.out.println("Please select the algorithm ('F'=Floyd's, 'D'=Dijkstra's):");
		String algorithm = inScan.next();
			//System.out.println("Algorithm chosen: "+algorithm);

		//determine data structure
		System.out.println("Please select the data structure ('1d'= 1D Array, '2d'= 2D Array, 'list'= Adjacency List):");
		String dataStructure = inScan.next();
		
		//testings
		long begin_memory = Runtime.getRuntime().totalMemory();
		long begin_time = System.currentTimeMillis();

		if (algorithm.equals("F"))
		{
			if (dataStructure.equals("2d"))
			{
				int[][] matrix = graph;
				System.out.println("\nUsing Floyd - 2D Array:\n");
				int[][] Dmf = new int[n+1][n+1];
				int[][] Pmf = new int[n+1][n+1];
				Floyd_2D_Array.floyd_2D_Array(matrix, Dmf, Pmf);
				//Print.printAllShortestPath(Pmf);
			} else if (dataStructure.equals("1d"))
			{
				int[] vector = OneD_Array.array_2to1(graph);
				System.out.println("\nUsing Floyd - 1D Array:\n");
				int[][] Dvf = new int[n+1][n+1];
				int[][] Pvf = new int[n+1][n+1];
				Floyd_1D_Array.floyd_1D_Array(vector, Dvf, Pvf);
				//Print.printAllShortestPath(Pvf);
			} else //dataStructure.equals("list")
			{
				AdjacencyList AdjList = new AdjacencyList(graph);
				System.out.println("\nUsing Floyd - Adjacency List:\n");
				int[][] Dalf = new int[n+1][n+1];
				int[][] Palf = new int[n+1][n+1];
				Floyd_Adjacency_List.floyd_Adjacency_List(AdjList, Dalf, Palf);
				//Print.printAllShortestPath(Palf);
			}//end Floyd's
		}else //algorithm.equals("D")
		{
			Edge[] F;
			if (dataStructure.equals("2d"))
			{
				int[][] matrix = graph;
				System.out.println("\nUsing Dijkstra - 2D Array:\n");
				for (int k=1; k<=n; k++)
				{
					F = new Edge[n*n];
					Dijkstra_2D_Array.dijkstra_2D_Array(matrix, F, k);
					//Dijkstra_2D_Array.printShortestPaths(F,k);
				}//end for loop k
			} else if (dataStructure.equals("1d"))
			{
				int[] vector = OneD_Array.array_2to1(graph);
				System.out.println("\nUsing Dijkstra - 1D Array:\n");
				for (int k=1; k<=n; k++)
				{
					F = new Edge[n*n];
					Dijkstra_1D_Array.dijkstra_1D_Array(vector, F, k);
					//Dijkstra_1D_Array.printShortestPaths(F,k);
				}//end for loop k
			} else //dataStructure.equals("list")
			{
				AdjacencyList AdjList = new AdjacencyList(graph);
				System.out.println("\nUsing Dijkstra - Adjacency List:\n");
				for (int k=1; k<=n; k++)
				{
					F = new Edge[n*n];
					Dijkstra_Adjacency_List.dijkstra_Adjacency_List(AdjList, F, k);
					//Dijkstra_Adjacency_List.printShortestPaths(F,k);
				}//end for loop k
			}//end Dijkstra's
		}//end if...else

		long end_memory = Runtime.getRuntime().totalMemory();
		long end_time = System.currentTimeMillis();

		long run_time = end_time - begin_time;
		long run_memory = end_memory - begin_memory;

		System.out.println(run_time/1000 +" s");
		System.out.println(run_memory +" bytes");
	}//end main
}//end class