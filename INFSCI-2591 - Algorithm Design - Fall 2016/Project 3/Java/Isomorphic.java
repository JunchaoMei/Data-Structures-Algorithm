import java.util.*;

class Isomorphic
{	
	//Adjacency Matrix with version of k
	//The Arrangements Matrix is A
	public static int[][] isomorphor (int[][] G1, int[][] A, int k)
	{
		int n = G1.length-1;
		int[][] G = new int[n+1][n+1];

		for (int i=1; i<=n; i++)
		{
			for (int j=1; j<=n; j++)
			{
				if (j!=i)
				{
					int a = A[k][i];
					int b = A[k][j];
					G[a][b] = G1[i][j];
				}//end if
			}//end for loop j
		}//end for loop i
		return G;
	}//end isomorphor

	public static boolean isEquivalentMatrix (int[][] G1, int[][] G2)
	{
		int n1 = G1.length-1;
		int n2 = G2.length-1;

		if (n1!=n2)
			return false;
		else //n1==n2
		{
			for (int i=0; i<=n1; i++)
			{
				for (int j=0; j<=n1; j++)
				{
					if (G1[i][j] != G2[i][j])
						return false;
				}//end for loop j
			}//end for loop i
			return true;
		}//end if...else
	}//end isEquivalentMatrix

	//test methods
	public static void main (String[] args) throws Exception
	{
		Scanner inScan = new Scanner(System.in);
		System.out.println("Please input one Excel file name (*.xls): ");
		String fileName1 = inScan.next();
		System.out.println("Please input another Excel file name (*.xls): ");
		String fileName2 = inScan.next();

		int[][] G1 = TableIO.matrix(fileName1);

		int[][] G2 = TableIO.matrix(fileName2);
		System.out.println(isEquivalentMatrix(G1,G2));

		int n = G1.length-1;
		int p = Arrangement.permutation (n, n);
		int[] a = new int[n];
        int[][] A = new int[p][n+1];

		for (int i=0; i<n; i++)
			a[i] = i+1;

		Arrangement.vertexArrange(a, 0, a.length - 1, A);

		for (int k=0; k<p; k++)
		{
			System.out.print("k="+k+" ");
			System.out.println(Arrays.toString(A[k]));
		}//end for loop

		int[][] G3 = isomorphor (G1, A, 61);
		for (int i=0; i<=n; i++)
			System.out.println(Arrays.toString(G3[i]));
	}//end main
}//end Isomorphic