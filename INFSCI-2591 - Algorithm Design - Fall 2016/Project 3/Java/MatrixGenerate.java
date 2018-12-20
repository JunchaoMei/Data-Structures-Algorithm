import java.util.*;

class MatrixGenerate
{	
	//generate a random integer within [1,m]
	public static int random (int m)
	{
		Random r = new Random();
		return r.nextInt(m)+1;
	}//end random

	//generate n distinct random integers within [min,max]
	public static int[] randomCommon(int min, int max, int n){
		max+=2;
		if (n > (max - min + 1) || max < min) {
            return null;
        }
		int[] result = new int[n];
		int count = 0;
		while(count < n) {
			int num = (int) (Math.random() * (max - min)) + min;
			boolean flag = true;
			for (int j = 0; j < n; j++) {
				if(num == result[j]){
					flag = false;
					break;
				}
			}
			if(flag){
				result[count] = num;
				count++;
			}
		}
		for (int i=0; i<result.length; i++)
			result[i]--;
		return result;
	}//end randomCommon

	public static int[][] sparseGraph (int n, int m)
	{
		int n1 = (n*(n-1))/2;
		int[] array_1D = new int[n1];

		//initialization
		for (int i=0; i<n1; i++)
			array_1D[i] = 300000;
		
		//detemine the locations of (n-1) links
		int[] indexLink = new int[n-1];
		for (int i=0; i<(n-1); i++)
		{
			indexLink = randomCommon(0,n1-1,n-1);
			array_1D[indexLink[i]] = random(m);
		}//end for loop i
		return OneD_Array.array_1to2(array_1D);
	}//end sparseGraph

	public static int[][] completeGraph (int n, int m)
	{
		int n1 = (n*(n-1))/2;
		int[] array_1D = new int[n1];

		for (int i=0; i<n1; i++)
			array_1D[i] = random(m);

		return OneD_Array.array_1to2(array_1D);
	}//end completeGraph

	//test methods
	public static void main (String[] args)
	{
		int a = random(30);
		System.out.println(a+"\n");

		int[] series = randomCommon(0,9,10);
		for (int i=0; i<series.length; i++)
			System.out.print(series[i]+" ");
		System.out.println("\n");

		int[][] sG = sparseGraph(5, 30);
		Print.print2dArray(sG);
		System.out.println();

		int[][] cG = completeGraph(5, 30);
		Print.print2dArray(cG);
	}//end main
}//end class