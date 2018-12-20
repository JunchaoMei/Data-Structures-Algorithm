import java.util.*;

class DecimalRecognition
{	//determine whether the input is a decimal number
	public static boolean isDecimal(String inputString)
	{
		char[] legalCharSet = {'0','1','2','3','4','5','6','7','8','9','.','+','-'};
		//Get the occurrence numbers of character '+', '-' and '.'
		int occurPlus = Contain.occurNumber('+', inputString);
		int occurMinus = Contain.occurNumber('-', inputString);
		int occurPoint = Contain.occurNumber('.', inputString);
		int indexPlus = inputString.indexOf('+');//return -1 if no found
		int indexMinus = inputString.indexOf('-');//return -1 if no found

		//rule out illegal input characters.
		if (!Contain.legalInput(inputString, legalCharSet))
			return false;
		//rule out inputString without any digit.
		else if (!Contain.contains0to9(inputString))
			return false;
		//rule out inputString containing multiple '+', '-' and '.'
		else if (occurPlus>1 || occurMinus>1 || occurPoint>1)
			return false;
		//rule out inputString containing both '+' and '-'
		else if (occurPlus+occurMinus>1)
			return false;
		//rule out inputString if '+' or '-' is not at the beginning.
		else if (indexPlus + indexMinus >= 0)//1+(-1)=0
			return false;
		else
			return true;
	}//end isDecimal

	//normalize the format of inputDecimalString
	public static String decimalNormalize(String inputDecimalString)
	{	String inStr = inputDecimalString;
		//if it does not start with '+' or '-', then add '+' at the beginning.
		if (!inputDecimalString.startsWith("+") && !inputDecimalString.startsWith("-"))//start with '.' or digit
			inStr = "+"+inputDecimalString;
		char sign = inStr.charAt(0);
		//if there is no '.', then add '.' at the end.
		if (!inStr.contains("."))
			inStr = inStr+".";
		//if there is no character between Sign and '.', insert '0'
		if (inStr.charAt(1) == '.')
		{
			StringBuffer sb = new StringBuffer(inStr);
			//StringBuffer insert(int index,String str): insert before index
			inStr = sb.insert(1, "0").toString();
		}//end if
		//create substring before '.' [beginIndex, endIndex)
		int n = inStr.length();
		int indexPoint = inStr.indexOf('.');//return -1 if no found
		String beforePoint = inStr.substring(1, indexPoint);
		int FirstNonZero = Index.indexOfFirstNonZeroDigit(beforePoint);
		//create substring after '.' [beginIndex, endIndex)
		boolean afterPointExist = inStr.charAt(n-1)!='.';
		String afterPoint="";
		int LastNonZero=-2;
		if (afterPointExist)
		{
			afterPoint = inStr.substring(indexPoint+1);
			LastNonZero = Index.indexOfLastNonZeroDigit(afterPoint);
		}//end if
		//if index(first non-zero digit)!=0, delete charAt index 0~[index(first non-zero digit)-1]
		if (FirstNonZero!=0)
			beforePoint = beforePoint.substring(FirstNonZero);
		//if index(last non-zero digit))!=last, delete charAt index [index(last non-zero digit))+1]~last
		if (afterPointExist && LastNonZero!=afterPoint.length()-1)
			afterPoint = afterPoint.substring(0, LastNonZero+1);
		//combine substring sign+beforeDecimal+"."+afterDecimal, return
		String outputString = sign + beforePoint + "." + afterPoint;
		return outputString;
	}//end decimalNormalize

	public static void printDigits(String normalizedDecimal)
	{
		int n = normalizedDecimal.length();
		int indexPoint = normalizedDecimal.indexOf('.');

		//part before decimal point
		String beforeDecimal = normalizedDecimal.substring(1,indexPoint);
		int x = beforeDecimal.length();
		System.out.print(x +" digit(s) before decimal: ");
		for (int i=0; i<x; i++)
			System.out.print(beforeDecimal.charAt(i)+" ");
		System.out.println();

		//part after decimal point
		if (indexPoint == n-1)//afterDecimal does not exist
			System.out.println("0 digit(s) after decimal.");
		else //afterDecimal exist
		{
			String afterDecimal = normalizedDecimal.substring(indexPoint+1);
			int y = afterDecimal.length();
			System.out.print(y +" digit(s) after decimal: ");
			for (int i=0; i<y; i++)
				System.out.print(afterDecimal.charAt(i)+" ");
			System.out.println();
		}//end else

		String afterDecimal = normalizedDecimal.substring(indexPoint+1);
	}//end printDigits

	public static void main(String[] args)
	{
		Scanner inScan = new Scanner(System.in);
		System.out.print("Please enter a string: ");
		String inputString = inScan.next();
		//determine whether it's a decimal number
		boolean isDecimalNumber = isDecimal(inputString);
		System.out.println("The input String is a decimal number: " + isDecimalNumber);
		//if it's a decimal number
		if (isDecimalNumber)
		{	//do normalization
			String normNumber = decimalNormalize(inputString);
			System.out.println("The normalized decimal number: " + normNumber);
			//print results
			System.out.println(Sign.getSign(normNumber));
			printDigits(normNumber);
			//convert into float
			float f=Float.parseFloat(normNumber);
			System.out.println("convert into float number: " + f);
		}//end if
	}//end main
}//end class