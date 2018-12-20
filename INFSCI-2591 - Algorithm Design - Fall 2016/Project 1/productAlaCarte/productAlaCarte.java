/*
Junchao Mei		Assignment 1
Ala Carte Multiplication Method		java-implementation
*/
import java.util.*;

class productAlaCarte
{	//both String a & b start with '+' ,'-' or '0'
	public static String productAlaCarte (String a, String b)
	{	//transform String a & b
		String aSub = a.substring(1);
		char aSign = a.charAt(0);
		char[] aChar = aSub.toCharArray(); //index h from 0 to (m-1)
		int m = aChar.length;
		int[] aInt = new int[m];
		for (int h=0; h<=m-1; h++)
			aInt[h] = aChar[h] - '0';
		String bSub = b.substring(1);
		char bSign = b.charAt(0);
		char[] bChar = bSub.toCharArray(); //index k from 0 to (n-1)
		int n = bChar.length;
		int[] bInt = new int[n];
		for (int k=0; k<=n-1; k++)
			bInt[k] = bChar[k] - '0';

		if (aSign=='0' || bSign=='0')
			return "0";
		else
		{
			//determine sign
			String pSign="";
			if (aSign=='+')
			{
				if (bSign=='+')
					pSign += "+";
				else
					pSign += "-";
			} else
			{
				if (bSign=='+')
					pSign += "-";
				else
					pSign += "+";
			}//end else

			//create Ala Carte Table -- log2(9.10E+37)=127
			String[] A = new String[150];//divide by 2
			A[0] = aSub;
			for (int p=1; p<A.length; p++)
				A[p] = division.quotient_2(A[p-1]);
			String[] B = new String[150];//multiply by 2
			B[0] = bSub;
			for (int q=1; q<B.length; q++)
				B[q] = addition.sum(B[q-1],B[q-1]);//x+x=2x

			//addition B[q]
			String pString = "";
			for (int q=0; q<B.length && !A[q].equals("0"); q++)
			{
				if (division.isOddNumber(A[q])==true)
					pString = addition.sum(B[q],pString);
				//System.out.print(A[q]+" ");
				//System.out.println(pString);
			}//end for

			String product = pSign + pString;
			return product;
		}//end else
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