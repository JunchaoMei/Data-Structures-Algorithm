/*
Junchao Mei		Assignment 1
rectangle multiplication method		java-implementation
*/
import java.util.*;

class productRectangle
{
	public static long productRectangle (String a, String b)
	{
		char[] aChar = a.toCharArray(); //index h from 0 to (m-1)
		int m = aChar.length;
		int[] A = new int[m];
		for (int h=0; h<=m-1; h++)
			A[h] = Character.getNumericValue(aChar[h]);

		char[] bChar = b.toCharArray(); //index k from 0 to (n-1)
		int n = bChar.length;
		int[] B = new int[n];
		for (int k=0; k<=n-1; k++)
			B[k] = Character.getNumericValue(bChar[k]);

		int[] P1 = new int[m]; //index i from 0 to (m-1)
		int[] P2 = new int[n]; //index j from 0 to (n-1)
		long product=0;
		
		//lower half triangle
		for (int i=0; i<=(m-1); i++)
		{
			int h=m-i-1, k=n-1;
			boolean digitFlag = false; //unit digit

			while (h<=m-1 && k>=0)
			{
				if (digitFlag == false)
				{
					P1[i] = P1[i]+unitDigit(A[h], B[k]);
					h++;
				} else
				{
					P1[i] = P1[i]+tensDigit(A[h], B[k]);
					k--;
				}//end else

				digitFlag = !digitFlag;
			}//end while
		}//end for

		//upper half triangle
		for (int j=0; j<=(n-1); j++)
		{
			int h=0, k=n-j-1;
			boolean digitFlag = true; //tens digit

			while (h<=m-1 && k>=0)
			{
				if (digitFlag == true)
				{
					P2[j] = P2[j]+tensDigit(A[h], B[k]);
					k--;
				} else
				{
					P2[j] = P2[j]+unitDigit(A[h], B[k]);
					h++;
				}//end else

				digitFlag = !digitFlag;
			}//end while
		}//end for

		int[] P = new int[m+n];
		for (int p=0; p<=(m+n-1); p++)
		{	//combine P1[] & P2[] into P[]. index p from 0 to (m+n-1)
			if (p<=m-1)
				P[p] = P1[p];
			else
				P[p] = P2[p-m];

			product += P[p]*Math.pow(10,p);
		}//end for

		return product;
	}//end productRectangle

	public static int tensDigit (int x, int y)
	{
		return x*y/10;
	}//end tensDigit

	public static int unitDigit (int x, int y)
	{
		return (x*y)%10;
	}//end unitDigit

	public static void main (String[] args)
	{
		Scanner inScan = new Scanner (System.in);

		System.out.print("Please enter the multiplicator: ");
		String a = inScan.next();
		System.out.print("Please enter the multiplier: ");
		String b = inScan.next();

		System.out.print("Rectangle Multiplication Method - The product is: " + productRectangle(a,b));
	}//end main
}