import java.util.*;

class TestGirthPerformance
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
				graph = MatrixGenerate.sparseGraph(n, 1);
				break;
			case 'c':
				graph = MatrixGenerate.completeGraph(n, 1);
				break;
			default:
				graph = MatrixGenerate.sparseGraph(n, 1);
		}//end switch

		//testings
		long begin_time = System.currentTimeMillis();

		Girth g = new Girth(graph);
		g.BFS();
		System.out.println("Girth="+g.getGirth());

		long end_time = System.currentTimeMillis();
		long run_time = end_time - begin_time;
		System.out.println("Runtime: "+ run_time +" ms");
	}//end main
}//end class