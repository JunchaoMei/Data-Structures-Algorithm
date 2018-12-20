import java.util.*;

class Arrangement
{
	static int x=0;

	public static int factorial (int n) throws IllegalArgumentException
	{
		if (n<0)//no factorial for negetive integer
			throw new IllegalArgumentException();
		else if (n==0)//base case
			return 1;
		else//recursive case
			return n*factorial(n-1);
	}//end factorial

	public static int permutation (int n, int m)//P(n,m)=n!/(n-m)!
	{
		int p = factorial(n)/factorial(n-m);
		return p;
	}//end permutation

	//use backtracking method to find all the arrangements of a[i]
    public static void vertexArrange (int[] a, int start, int end, int[][] A)
	{
		int n = A[0].length-1;

        if (start >= end)
		{
			for (int i=1; i<=n; i++)
				A[x][i] = a[i-1];
			x++;
            return;
        }//end if

        for (int i = start; i <= end; i++)
		{
            int temp = a[start];
            a[start] = a[i];
            a[i] = temp;
            vertexArrange(a, start + 1, end, A);
            temp = a[start];
            a[start] = a[i];
            a[i] = temp;
        }//end for loop
    }//end vertexArrange

	//test methods
    public static void main (String[] args)
	{
		Scanner inScan = new Scanner(System.in);
		System.out.println("Please enter 'n' for P(n,n): ");
		int n = inScan.nextInt();

		int p = permutation (n, n);
		int[] a = new int[n];
        int[][] A = new int[p][n+1];

		for (int i=0; i<n; i++)
			a[i] = i+1;

		vertexArrange(a, 0, a.length - 1, A);

		for (int i=0; i<p; i++)
		{
			System.out.print(Arrays.toString(A[i]));
			System.out.println();
		}//end for loop
    }//end main
}//end Arrangement