/*
Junchao Mei		Project 1
Rectangle Multiplication Method		java-implementation
*/
import java.util.*;

class productRectangle
{	//both String a & b start with '+' ,'-' or '0'
	public static String productRectangle (String a, String b)
	{
		String aSub = a.substring(1);
		char aSign = a.charAt(0);
		char[] aChar = aSub.toCharArray(); //index h from 0 to (m-1)
		int m = aChar.length;
		int[] A = new int[m];
		for (int h=0; h<=m-1; h++)
			A[h] = aChar[h] - '0';

		String bSub = b.substring(1);
		char bSign = b.charAt(0);
		char[] bChar = bSub.toCharArray(); //index k from 0 to (n-1)
		int n = bChar.length;
		int[] B = new int[n];
		for (int k=0; k<=n-1; k++)
			B[k] = bChar[k] - '0';

		int[] P1 = new int[m]; //index i from 0 to (m-1)
		int[] P2 = new int[n]; //index j from 0 to (n-1)
		
		if (aSign=='0' || bSign=='0')
			return "0";
		else
		{
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
			
			//combine P1[] & P2[]
			int[] P = new int[m+n];
			for (int p=0; p<=(m+n-1); p++)
			{	//combine P1[] & P2[] into P[]. index p from 0 to (m+n-1)
				if (p<=m-1)
					P[p] = P1[p];
				else
					P[p] = P2[p-m];
			}//end for

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

			//reverse P[]
			int[] pReverse = new int[m+n];
			for (int f=pReverse.length-1,p=0; p<P.length; p++,f--)
			{
				pReverse[f] = P[p]%10;
				if (p!=P.length-1)
					P[p+1] += P[p]/10;
			}//end for

			//remove pre-positioned '0'
			int beginIndex;
			if (pReverse[0]==0) beginIndex = 1;	else beginIndex = 0;
			int[] pRearrange = new int[m+n-beginIndex];
			for (int g=0,f=beginIndex; f<pReverse.length; f++,g++)
				pRearrange[g] = pReverse[f];

			//transformation
			String pString = changeIntToString(pRearrange);

			String product = pSign + pString;
			return product;
		}//end else
	}//end productRectangle

	public static int tensDigit (int x, int y)
	{
		return x*y/10;
	}//end tensDigit

	public static int unitDigit (int x, int y)
	{
		return (x*y)%10;
	}//end unitDigit

	public static String changeIntToString(int[] arr){
			if(arr ==null){
				return null;
			}

			String result ="";

			for(int i =0;i<arr.length;i++){
				result += arr[i]+"";
			}
		return result;
	}

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