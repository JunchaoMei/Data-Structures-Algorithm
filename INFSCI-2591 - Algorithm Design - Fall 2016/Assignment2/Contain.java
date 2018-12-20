import java.util.*;

class Contain
{	//Determine whether the inputString contains digit 1~9
	public static boolean contains1to9(String inputString)
	{
		boolean contain = false;
		for (int i=1; i<=9; i++)
			contain = contain || inputString.contains(""+i);
		return contain;
	}//end contains1to9

	//Determine whether the inputString contains digit 0~9
	public static boolean contains0to9(String inputString)
	{
		boolean contain = false;
		for (int i=0; i<=9; i++)
			contain = contain || inputString.contains(""+i);
		return contain;
	}//end contains0to9

	//Determine whether a char belongs to a certain char[] array
	public static boolean belongsTo(char a, char[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			if(a==arr[i])
				return true;
		}//end for
		return false;
	}//end belongsTo

	//Determine whether the inputString contains illegal characters
	public static boolean legalInput(String inputString, char[] legalCharSet)
	{	
		char[] charArr = inputString.toCharArray();
		for (int i=0; i<charArr.length; i++)
		{
			if (!belongsTo(charArr[i], legalCharSet))
				return false;
		}//end for
		return true;
	}//end legalInput

	//Get the occurrence number of character
	public static int occurNumber(char key, String inputString)
	{
		int occur=0;
		for (int i=0; i<inputString.length(); i++)
		{
			if (inputString.charAt(i) == key)
				occur++;
		}//end for loop
		return occur;
	}//end occurNumber

	//test methods
	public static void main(String[] args) 
	{
		Scanner inScan = new Scanner(System.in);
		char[] charArr = {'.','1','2','3','4','5','6','7','8','9','0','+','-'};
		String inString = "1223334444+++++------.......";

		//test contains1to9(String inputString)
		System.out.print("Please enter a string: ");
		String inputString = inScan.next();
		System.out.println("The input String contains 1~9: " + contains1to9(inputString));

		//test belongsTo(char a, char[] arr)
		System.out.print("Please enter a character: ");
		char key = inScan.next().charAt(0);
		System.out.println(key + " belongs to charArr[]: " + belongsTo(key, charArr));

		//test legalInput(String inputString, char[] legalCharSet)
		System.out.print("Please enter a String: ");
		String inStr = inScan.next();
		System.out.println(inStr + " is legal: " + legalInput(inStr, charArr));

		//test occurNumber(char key, String inputString)
		System.out.print("Please enter a character: ");
		char inputChar = inScan.next().charAt(0);
		System.out.println(inputChar +" appeares "+ occurNumber(inputChar, inString) +" times in String.");
	}//end main
}//end class