import java.util.*;

class TestCases
{
	public static void main(String[] args) throws Exception
	{
		Scanner inScan = new Scanner(System.in);
		System.out.println("Please input the Excel file name (*.xls): ");
		String fileName = inScan.next();

		//2D-Array
		int[][] matrix = TableIO.matrix(fileName);
		int n = matrix.length-1;
		int[][] matrixCopy = TableIO.matrix(fileName);

		//1D-Array
		int[] vector = OneD_Array.array_2to1(matrix);

		//Adjacency List
		AdjacencyList AdjList = new AdjacencyList(matrix);

	//Floyd's
		//using 2D-Array
		System.out.println("\nUsing Floyd - 2D Array:\n");
		int[][] Dmf = new int[n+1][n+1];
		int[][] Pmf = new int[n+1][n+1];
		Floyd_2D_Array.floyd_2D_Array(matrix, Dmf, Pmf);
		Print.printAllShortestPath(Pmf);

		//using 1D-Array
		System.out.println("\nUsing Floyd - 1D Array:\n");
		int[][] Dvf = new int[n+1][n+1];
		int[][] Pvf = new int[n+1][n+1];
		Floyd_1D_Array.floyd_1D_Array(vector, Dvf, Pvf);
		Print.printAllShortestPath(Pvf);

		//using Adjacency List
		System.out.println("\nUsing Floyd - Adjacency List:\n");
		int[][] Dalf = new int[n+1][n+1];
		int[][] Palf = new int[n+1][n+1];
		Floyd_Adjacency_List.floyd_Adjacency_List(AdjList, Dalf, Palf);
		Print.printAllShortestPath(Palf);
		System.out.println();

	//Dijkstra's
		Edge[] F;
		//using 2D-Array
		System.out.println("\nUsing Dijkstra - 2D Array:\n");
		for (int k=1; k<=n; k++)
		{
			F = new Edge[n*n];
			Dijkstra_2D_Array.dijkstra_2D_Array(matrixCopy, F, k);
			Dijkstra_2D_Array.printShortestPaths(F,k);
		}//end for loop k

		//using 1D-Array
		System.out.println("\nUsing Dijkstra - 1D Array:\n");
		for (int k=1; k<=n; k++)
		{
			F = new Edge[n*n];
			Dijkstra_1D_Array.dijkstra_1D_Array(vector, F, k);
			Dijkstra_1D_Array.printShortestPaths(F,k);
		}//end for loop k

		//using Adjacency List
		System.out.println("\nUsing Dijkstra - Adjacency List:\n");
		for (int k=1; k<=n; k++)
		{
			F = new Edge[n*n];
			Dijkstra_Adjacency_List.dijkstra_Adjacency_List(AdjList, F, k);
			Dijkstra_Adjacency_List.printShortestPaths(F,k);
		}//end for loop k

	}//end main
}//end class