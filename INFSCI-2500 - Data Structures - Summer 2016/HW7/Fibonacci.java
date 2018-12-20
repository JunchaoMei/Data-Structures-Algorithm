import java.util.*;

class Fibonacci
{
	public static long fibRecur(int n) throws IllegalArgumentException
	{
		if (n<0)//n must >= 0
			throw new IllegalArgumentException();
		else if (n<=1)
			return n;
		else
			return fibRecur(n-1) + fibRecur(n-2);
	}//end fibRecur

	public static long fibLoop(int n) throws IllegalArgumentException
	{
		long[] fib = new long[101];
		fib[0] = 0;
		fib[1] = 1;

		for (int i=2; i<=n; i++)
		{
			fib[i] = fib[i-1] + fib[i-2];
		}
		
		if (n<0)//n must >= 0
			throw new IllegalArgumentException();
		else
			return fib[n];
	}//end fibLoop

}//end Fibonacci

class TestFibonacci
{
	public static void main(String[] args) 
	{
		int n=0;
		long[] F_recur = new long[101];
		long[] F_loop = new long[101];
		Scanner inScan = new Scanner(System.in);
		System.out.println("Please enter n for F(n)");

		if (inScan.hasNextInt())
			n = inScan.nextInt();
		
		//use recursion
		long recurStartTime = System.currentTimeMillis();//start time of recursion
		F_recur[n] = Fibonacci.fibRecur(n);
		long recurEndTime = System.currentTimeMillis();//end time of recursion
		System.out.println();
		System.out.println("F(" + n + ")=" + F_recur[n]);
		System.out.println("Running Time of recursive method: " + (recurEndTime-recurStartTime) + " milliseconds");

		//use loop
		long loopStartTime = System.currentTimeMillis();//start time of loop
		F_loop[n] = Fibonacci.fibLoop(n);
		long loopEndTime = System.currentTimeMillis();//end time of loop
		System.out.println();
		System.out.println("F(" + n + ")=" + F_loop[n]);
		System.out.println("Running Time of loop method: " + (loopEndTime-loopStartTime) + " milliseconds");

		//print Fibonacci Sequence
		System.out.println();
		System.out.println("Results calculated by looping method:");
		for (int i=0; i<F_loop.length; i++)
		{
			//print F[i]
			F_loop[i] = Fibonacci.fibLoop(i);
			System.out.print("F(" + i + ")=" + F_loop[i]);

			//check out boundary
			if (F_loop[i] < 0)
				System.out.println("	wrong");
			else
				System.out.println();
		}//end for
	}//end main
}//end TestFibonacci