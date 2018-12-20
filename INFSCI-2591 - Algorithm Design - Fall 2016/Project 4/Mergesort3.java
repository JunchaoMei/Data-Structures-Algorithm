import java.lang.Math;
import java.util.*;

class Mergesort3
{
	public static double logarithm(double b, double a)
	{
		double lnA = Math.log(a);
		double lnB = Math.log(b);
		double logbA = lnA/lnB;
		return logbA;
	}//end logarithm

	//works when n = 2^?
	public static void mergesort3(int n, int[] S)
	{
		int m;
		int low=0, mid=0, high=0, size;

		m = (int)Math.pow(2, (int)logarithm(2,n)) + 1;
		size = 1;
		int logm = (int)logarithm(2,m);

		for (int x=1; x<=logm; x++)
		{
			for (low=0; low<=m-2*size+1; low=low+2*size)
			{
				mid = low+size-1;
				high = low+2*size-1<n-1 ? low+2*size-1 : n-1;
				merge3(low,mid,high,S);
			}//end for loop low
			size = 2*size;
		}//end for loop x
		//System.out.println(low+" "+mid+" "+high+" "+size);
	}//end mergesort3

	public static void merge3(int low, int mid, int high, int[] S)
	{
		int i,j,k;
		int[] U = new int[high+1];

		//merging
		i=low; j=mid+1; k=low;
		while (i<=mid && j<=high)
		{
			if (S[i]<S[j])
			{
				U[k] = S[i];
				i++;
			} else
			{
				U[k] = S[j];
				j++;
			}//end else
			k++;
		}//end while loop
		if (i>mid)
		{
			//move S[j] through S[high] to U[k] through U[high]
			for (int x=j; x<=high; x++)
			{
				U[x-j+k] = S[x];
			}//end for loop
		} else
		{
			//move S[i] through S[mid] to U[k] through U[high]
			for (int x=i; x<=mid; x++)
			{
				U[x-i+k] = S[x];
			}//end for loop
		}//end else

		//move U[low] through U[high] to S[low] through S[high]
		for (int x=low; x<=high; x++)
		{
			S[x] = U[x];
		}//end for loop
	}//end merge3

	public static void main(String[] args)
	{
		System.out.println((int)logarithm(2,10));

		//generate a random array
		int[] S = ArrayGenerator.randomArray(10, 50);
		int n = S.length;

		//print unsorted array
		System.out.println(Arrays.toString(S));

		//sorting
		mergesort3(n,S);

		//print sorted array
		System.out.println(Arrays.toString(S));
	}//end main
}//end class