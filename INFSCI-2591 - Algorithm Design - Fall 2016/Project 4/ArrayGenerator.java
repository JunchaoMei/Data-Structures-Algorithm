import java.util.*;

class ArrayGenerator
{
	//generate a random integer within [a,b]
	public static int random(int a, int b)
	{
		Random r = new Random();
		return r.nextInt(b)+a;
	}//end random

	//generate an array with length n & elements ranged from [1,b] in random order
	public static int[] randomArray(int n, int b)
	{
		int[] arr = new int[n];

		for (int i=0; i<=n-1; i++)
		{
			arr[i] = random(1,b);
		}//end for loop i

		return arr;
	}//end randomArray

	//generate an array with length n & elements from [1,n] in increasing order
	public static int[] increasingArray(int n)
	{
		int[] arr = new int[n];

		for (int i=0; i<=n-1; i++)
		{
			arr[i] = i+1;
		}//end for loop i

		return arr;
	}//end increasingArray

	//generate an array with length n & elements from [1,n] in decreasing order
	public static int[] decreasingArray(int n)
	{
		int[] arr = new int[n];

		for (int i=0; i<=n-1; i++)
		{
			arr[i] = n-i;
		}//end for loop i

		return arr;
	}//end decreasingArray

	public static void main(String[] args)
	{
		int b = Integer.parseInt(args[0]);
		int n = Integer.parseInt(args[1]);

		System.out.println(Arrays.toString(randomArray(n, b)));
		System.out.println(Arrays.toString(increasingArray(n)));
		System.out.println(Arrays.toString(decreasingArray(n)));
	}//end main
}//end class