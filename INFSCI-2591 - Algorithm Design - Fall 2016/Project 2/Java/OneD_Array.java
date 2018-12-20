class OneD_Array
{
	public static int[] array_2to1 (int[][] array_2D)
	{
		int n_2D = array_2D.length-1;//n_2D is the number of nodes
		int n_1D = (n_2D*(n_2D-1))/2;//n_1D is the actual length of 1D array
		int[] array_1D = new int[n_1D];
		int k=0;//index of array_1D

		for (int i=2; i<=n_2D; i++)
		{
			for (int j=1; j<i; j++)
			{
				array_1D[k] = array_2D[i][j];
				k++;
			}//end for loop j
		}//end for loop i

		return array_1D;
	}//end array_2to1

	public static int[][] array_1to2 (int[] array_1D)
	{
		int n_1D = array_1D.length;
		int n_2D = (int)(Math.sqrt(8*n_1D+1)+1)/2;
		int[][] array_2D = new int[n_2D+1][n_2D+1];
		int k=0;//index of array_1D

		for (int i=2; i<=n_2D; i++)
		{
			for (int j=1; j<i; j++)
			{
				array_2D[i][j] = array_1D[k];
				k++;
			}//end for loop j
		}//end for loop i

		for (int j=2; j<=n_2D; j++)
		{
			for (int i=1; i<j; i++)
				array_2D[i][j] = array_2D[j][i];
		}//end for loop i

		return array_2D;
	}//end array_1to2

	//transform array_1D[k] to array_2D[i][j]
	public static int getWeight_1D (int[] array_1D, int i, int j)
	{
		if (i==j)
			return 0;
		else if (i>j)
		{
			//k = [1+2+...(i-2)]+(j-1) = [1+(i-2)](i-2)/2 + (j-1) = (i-1)(i-2)/2 + j-1
			int k = ((i-1)*(i-2)/2) + j-1;
			return array_1D[k];
		} else
		{
			//exchange i & j
			int k = ((j-1)*(j-2)/2) + i-1;
			return array_1D[k];
		}//end else
	}//end getWeight_1D

	//test methods
	public static void main(String[] args) throws Exception
	{	
		int[][] array_2D = TableIO.matrix("test-OneD_Array.xls");
		int[] array_1D = array_2to1(array_2D);
		Print.print1dArray(array_1D);
		System.out.println();

		int[][] array_2D_new = array_1to2(array_1D);
		Print.print2dArray(array_2D_new);
		System.out.println();

		int D42 = getWeight_1D(array_1D, 4, 2);
		System.out.println(D42);
		int D24 = getWeight_1D(array_1D, 2, 4);
		System.out.println(D24);
		int D22 = getWeight_1D(array_1D, 2, 2);
		System.out.println(D22);
	}//end main
}//end class