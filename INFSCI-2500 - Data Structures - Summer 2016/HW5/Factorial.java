/*
This script is tested by entering 5, 1, 0, -1, 3.2 and 'a', repectively.
It should work for 5, 1 and 0, but not work for -1, 3.2 and 'a'
*/

import java.util.Scanner;

public class Factorial
{
	public static void main(String[] args) 
	{
		Scanner inScan = new Scanner(System.in);//create a Scanner
		int x, y;
		System.out.println("Please enter a nonnegetive integer for factorial");
		
		if (inScan.hasNextInt()) //if enter an integer, x will be initialized
			x = inScan.nextInt();
		else //if enter something else, Exception will be thrown
			throw new IllegalArgumentException();
				
		y = factorial(x);
		System.out.println("Factorial of "+x+" is "+y);
	}//end main

	public static int factorial(int n) throws IllegalArgumentException
	{
		if (n<0)//no factorial for negetive integer
			throw new IllegalArgumentException();
		else if (n==0)//base case
			return 1;
		else//recursive case
			return n*factorial(n-1);
	}//end factorial
}//end class