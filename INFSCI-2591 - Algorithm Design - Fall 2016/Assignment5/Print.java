class Print
{
	public static void print2dArray(int[][] table)
	{
		for (int x = 0; x < table.length; x++)
		{
			for (int y = 0; y < table[x].length; y++)
				System.out.print(table[x][y] + "	");
			System.out.println();
		}//end for loop x
	}//end print2dArray

	public static void printMatrix(int[][] matrix)
	{
		for (int x = 1; x < matrix.length; x++)
		{
			for (int y = 1; y < matrix[x].length; y++)
				System.out.print(matrix[x][y] + "	");
			System.out.println();
		}//end for loop x
	}//end printMatrix

	public static void printShortestPath(int[][] P, int q, int r)
	{
		if (P[q][r]!=0)
		{
			printShortestPath(P, q, P[q][r]);
			System.out.print("v"+P[q][r]+" ");
			printShortestPath(P, P[q][r],r);
		}//end if
	}//end printShortestPath

	public static void printAllShortestPath(int[][] P)
	{
		int n = P.length-1;
		for (int q=1; q<=n; q++)
		{
			for (int r=1; r<=n; r++)
			{
				System.out.print("The shortest path from v"+q+" to v"+r+" is: ");
				printShortestPath(P, q, r);
				System.out.println();
			}//end for loop r
		}//end for loop q
	}//end printAllShortestPath

	public static void print1dArray(int[] arr)
	{
		for (int i=0; i<arr.length; i++)
		{
			System.out.print(arr[i]+" ");
		}//end for
	}//end print1DArray

	//test methods
	public static void main (String[] args) throws Exception
	{
		int[][] matrixTable = TableIO.matrix("test-Print.xls");
		int q=3, r=2;

		print2dArray(matrixTable);
		System.out.println();

		printMatrix(matrixTable);
		System.out.println();

		System.out.print("The shortest path from v"+q+" to v"+r+" is: ");
		printShortestPath(matrixTable, q, r);
		System.out.println();
		System.out.println();

		printAllShortestPath(matrixTable);
		System.out.println();
	}//end main
}//end class