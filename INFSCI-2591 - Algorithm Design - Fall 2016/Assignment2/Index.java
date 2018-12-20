import java.util.*;

class Index
{	//find the index of last ¡°non-zero¡± digit
	public static int indexOfLastNonZeroDigit(String inputString)
	{
		int n=inputString.length();
		//inputString does not contain '1'~'9'
		int index=-1;
		//inputString contains '1'~'9'
			//traverse backwards
			for (int i=n-1; i>=0; i--)
			{
				if (inputString.charAt(i)!='0')
				{
					index=i;
					break;
				}//end if
			}//end for loop
		return index;
	}//end indexOfLastNonZeroDigit
	
	//find the index of first ¡°non-zero¡± digit
	public static int indexOfFirstNonZeroDigit(String inputString)
	{
		int n=inputString.length();
		//inputString does not contain '1'~'9'
		int index = n-1;
		//inputString contains '1'~'9'
			//traverse forwards
			for (int i=0; i<=n-1; i++)
			{
				if (inputString.charAt(i)!='0')
				{
					index=i;
					break;
				}//end if
			}//end for loop
		return index;
	}//end indexOfFirstNonZeroDigit
	
	//test methods
	public static void main(String[] args) 
	{
		Scanner inScan = new Scanner(System.in);
		System.out.print("Please enter a string of digit(s): ");
		String inputString = inScan.next();
		System.out.println("The index of last non-zero digit is: " + indexOfLastNonZeroDigit(inputString));
		System.out.println("The index of first non-zero digit is: " + indexOfFirstNonZeroDigit(inputString));
	}//end main
}//end class