import java.util.*;

class Mergesort
{
	public static void mergesort (int[] S)
	{
		int n = S.length;

		if (n>1)
		{
			int h = n/2, m = n-h;
			int[] U = new int[h];
			int[] V = new int[m];

			//copy S[0] through S[h-1] to U[0] through U[h-1]
			for (int i=0; i<=h-1; i++)
			{
				U[i] = S[i];
			}//end for loop i

			//copy S[h] through S[n-1] to V[0] through V[m-1]
			for (int i=h; i<=n-1; i++)
			{
				V[i-h] = S[i];
			}//end for loop i

			mergesort(U);
			mergesort(V);

			merge(h,m,U,V,S);
		}//end if
	}//end mergesort

	public static void merge (int h, int m, int[] U, int[] V, int[] S)
	{
		int i,j,k;
		i=1;j=1;k=1;

		while (i<=h && j<=m)
		{
			if (U[i-1]<V[j-1])
			{
				S[k-1] = U[i-1];
				i++;
			} else
			{
				S[k-1] = V[j-1];
				j++;
			}//end else
			k++;
		}//end while

		if (i>h)
		{
			//copy V[j-1] through V[m-1] to S[k-1] through S[h+m-1];
			for (int x=j-1; x<=m-1; x++)
			{
				S[x+k-j] = V[x];
			}//end for loop x
		} else
		{
			//copy U[i-1] through U[h-1] to S[k-1] through S[h+m-1];
			for (int x=i-1; x<=h-1; x++)
			{
				S[x+k-i] = U[x];
			}
		}//end else
	}//end merge

	public static void main(String[] args)
	{
		//generate a random array
		int[] S = ArrayGenerator.randomArray(10, 50);

		//print unsorted array
		System.out.println(Arrays.toString(S));

		//sorting
		mergesort(S);

		//print sorted array
		System.out.println(Arrays.toString(S));
	}//end main
}//end class