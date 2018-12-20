import java.util.*;

class Mergesort2
{
	public static int[] S;

	public static void mergesort2(int low, int high)
	{
		int mid;

		if (low < high)
		{
			mid = (low+high)/2;
			mergesort2(low,mid);
			mergesort2(mid+1,high);
			merge2(low,mid,high);
		}//end if
	}//end mergesort2

	public static void merge2(int low, int mid, int high)
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
	}//end merge2

	public static void main(String[] args)
	{
		//generate a random array
		S = ArrayGenerator.randomArray(10, 50);
		int n = S.length;

		//print unsorted array
		System.out.println(Arrays.toString(S));

		//sorting
		mergesort2(0,n-1);

		//print sorted array
		System.out.println(Arrays.toString(S));
	}//end main
}//end class