import java.util.*;

class TestIsomorphic
{
	public static boolean isIsomorphic (int[][] G1, int[][] G2, int[][] A, int p)
	{
		for (int k=1; k<p; k++) //G1 is A[0]
		{
			//generate Adjacency Matrix with version of k
			int[][] Gk = Isomorphic.isomorphor(G1, A, k);
			//whether Gk & G2 are equivalent
			if (Isomorphic.isEquivalentMatrix(Gk,G2))
			{
				//print G1 vertices
				System.out.print("G1 Vertices: ");
				for (int j=0; j<A[0].length; j++)
					System.out.print(A[0][j]+" ");
				System.out.println();
				//print G2 vertices
				System.out.print("G2 Vertices: ");
				for (int j=0; j<A[k].length; j++)
					System.out.print(A[k][j]+" ");
				System.out.println();
				return true;
			}//end if
		}//end for loop k
		return false;
	}//end isIsomorphic

	public static void main (String[] args) throws Exception
	{
		//initialize G1 & G2
		Scanner inScan = new Scanner(System.in);
		System.out.println("Please input the Excel file name of G1 (*.xls): ");
		String fileName1 = inScan.next();
		System.out.println("Please input the Excel file name of G2 (*.xls): ");
		String fileName2 = inScan.next();
		int[][] G1 = TableIO.matrix(fileName1);
		int[][] G2 = TableIO.matrix(fileName2);
		//Time Complexity: 5C+2*n^2 = O(n^2)

		//generate the Arrangements Matrix A[][] using Backtracking Algorithm
		int n = G1.length-1;
		int p = Arrangement.permutation (n, n);
		int[] a = new int[n];
        int[][] A = new int[p][n+1];
		for (int i=0; i<n; i++)
			a[i] = i+1;
		Arrangement.vertexArrange(a, 0, a.length - 1, A);
		//Time Complexity: C+2n+n+n*n! = O(n!)

		//determine whether G1 & G2 are isomorphic
		System.out.println("G1 & G2 are isomorphic: " + isIsomorphic(G1,G2,A,p));
		//Time Complexity: n!*(2*n^2) = O(n!)
		//Overall Time Complexity: O(n^2) + O(n!) + O(n!) = O(n!)
	}//end main
}//end Test_Isomorphic