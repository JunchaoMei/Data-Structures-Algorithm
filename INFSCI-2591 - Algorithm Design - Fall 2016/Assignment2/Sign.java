import java.util.*;

class Sign
{	//determine whether it¡¯s positive, negative or zero
	public static String getSign(String inputString)
	{	//inputString does not contain '1'~'9'
		if (!Contain.contains1to9(inputString))
			return "zero";
		//inputString contains '1'~'9'
		else if (inputString.charAt(0) == '-')
			return "negative decimal number";
		else
			return "positive decimal number";
	}//end getSign
	
	//test methods
	public static void main(String[] args) 
	{
		Scanner inScan = new Scanner(System.in);

		System.out.print("Please enter a string of digit(s): ");
		String inputString = inScan.next();
		System.out.println("The input String is: " + getSign(inputString));
	}//end main
}//end class