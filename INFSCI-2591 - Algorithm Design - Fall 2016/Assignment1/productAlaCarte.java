/*
Junchao Mei		Assignment 1
ala carte multiplication method		java-implementation
*/
import java.util.*;

class productAlaCarte
{
	public static double log(double value, double base)
	{
		return Math.log(value) / Math.log(base);
	}//end log

	public static long productAlaCarte (String a, String b)
	{
		long a0 = Long.parseLong(a);
		long b0 = Long.parseLong(b);

		int i;
		long product=0;
		int n=(int)log(a0,2)+1;
		long[] A = new long[n]; //indexed from 0 to (n-1)
		long[] B = new long[n]; //indexed from 0 to (n-1)

		for (i=0; i<=(n-1); i++)
		{
			if (i==0)
			{
				A[i]=a0;
				B[i]=b0;
			} else
			{
				A[i] = A[i-1]/2;
				B[i] = B[i-1]*2;
			}//end else

			if (A[i]%2==1)
				product += B[i];
		}//end for
		return product;
	}//end productAlaCarte

	public static void main (String[] args)
	{
		Scanner inScan = new Scanner (System.in);

		System.out.print("Please enter the multiplicator: ");
		String a = inScan.next();
		System.out.print("Please enter the multiplier: ");
		String b = inScan.next();

		System.out.print("Ala Carte Multiplication Method - The product is: " + productAlaCarte(a,b));
	}//end main
}//end class