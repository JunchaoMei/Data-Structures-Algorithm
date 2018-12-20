class addition
{
	public static void main (String[] args)
	{
		String sumValue = sum("12345678901","98765432123");
		System.out.println(sumValue);
	}//end main

	public static String sum(String f, String s)//without sign
	{
        //reverse String f & s, transform it into array
        char[] a = new StringBuffer(f).reverse().toString().toCharArray();
        char[] b = new StringBuffer(s).reverse().toString().toCharArray();
        int lenA = a.length;
        int lenB = b.length;

        //longer length of s & f
        int len = lenA > lenB ? lenA : lenB;
        int[] result = new int[len + 1];
        for (int i = 0; i < len + 1; i++)
		{
			//fill vacant high-order digits
			int aint = i < lenA ? (a[i] - '0') : 0;
			int bint = i < lenB ? (b[i] - '0') : 0;
			//addition by bits
			result[i] = aint + bint;
        }//end for

        //carry bits
        for (int i = 0; i<result.length; i++)
		{
            if (result[i] >= 10)
			{
                result[i+1] += result[i] / 10;
                result[i] %= 10;
            }//end if
        }//end for

        StringBuffer sb = new StringBuffer();
        //remove pre-positioned '0's
        boolean flag = true;
        for (int i = len; i >= 0; i--)
		{
            if (result[i] == 0 && flag)
                continue;
            else
                flag = false;

            sb.append(result[i]);
        }//end for
        return sb.toString();
    }//end sum
}//end class