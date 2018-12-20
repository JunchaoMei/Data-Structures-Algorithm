import java.util.*;

class Floyd_2D_Array
{
	public static void floyd_2D_Array (int[][] W, int[][] D, int[][] P)
	{
		int i,j,k,n;
		n = W.length-1;

		//initialize P[][]
		for (i=1; i<=n; i++)
		{
			for (j=1; j<=n; j++)
			{
				P[i][j] = 0;
			}//end loop j
		}//end loop i

		//initialize D using 2D_Array
		D = W;

		//D(k)[i][j] = D(k-1)[i][k] + D(k-1)[k][j]
		for (k=1; k<=n; k++)
		{
			for (i=1; i<=n; i++)
			{
				for (j=1; j<=n; j++)
				{
					if (D[i][k] + D[k][j] < D[i][j])
					{
						P[i][j] = k;
						D[i][j] = D[i][k] + D[k][j];
					}//end if
				}//end loop j
			}//end loop i
		}//end loop k
	}//end floyd_2D_Array

	public static void main (String[] args) throws Exception
	{
		Scanner inScan = new Scanner(System.in);
		System.out.println("Please input the Excel file name (*.xls): ");
		String fileName = inScan.next();
		System.out.println();

		int[][] W = TableIO.matrix(fileName);
		int n = W.length-1;
		int[][] D = new int[n+1][n+1];
		int[][] P = new int[n+1][n+1];
		System.out.print("The number of nodes: "+n+"\n\n");

		floyd_2D_Array(W,D,P);
/*
		Print.print2dArray(P);
		System.out.println();
*/
		System.out.println("The matrix P produced: ");
		Print.printMatrix(P);
		System.out.println();

		//optional output
		Print.printAllShortestPath(P);
		System.out.println();

	}//end main
}//end class