class division
{
	public static void main (String[] args)
	{	
		String m = "123456789010";
		String q = quotient_2(m);
		boolean odd = isOddNumber(m);
		System.out.println(q);
		System.out.println(odd);
	}//end main

	public static String quotient_2 (String m)//m has no sign
	{	//transform String m into int[] mInt
		char[] mChar = m.toCharArray();
		int[] mInt = new int[mChar.length];
		for (int i=0; i<mInt.length; i++)
			mInt[i] = mChar[i] - '0';

		int[] quotient0 = new int[mInt.length];
		int[] remainder = new int[mInt.length];
		
		//division by bits
		for (int i=0; i<mInt.length; i++)
		{
			quotient0[i] = mInt[i]/2;
			remainder[i] = mInt[i]%2;
			if (i<mInt.length-1)
				mInt[i+1] += 10*remainder[i];
		}//end for

		//remove possible pre-positioned '0's
		int beginIndex;
		if (quotient0[0]!=0)
			beginIndex = 0;
		else if (quotient0.length == 1)
			beginIndex = 0;
		else
			beginIndex = 1;
		int[] quotient1 = new int[mInt.length-beginIndex];
		int g=0, f=beginIndex;
		while (f<quotient0.length && g<quotient1.length)
		{
			quotient1[g] = quotient0[f];
			f++;
			g++;
		}//end while
		
		//transform quotient1[] into String
		String result="";
		for(int i =0;i<quotient1.length;i++)
			result += quotient1[i]+"";
		return result;
	}//end quotient_2

	public static boolean isOddNumber (String m)
	{
		int unitDigit = m.charAt(m.length()-1) - '0';
		if (unitDigit%2==1)
			return true;
		else
			return false;
	}//end isOddNumber
}//end class