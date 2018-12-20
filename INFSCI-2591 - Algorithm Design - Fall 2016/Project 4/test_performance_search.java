import java.util.*;

class test_performance_search
{
	public static void main(String[] args)
	{
		int[] S;
		Scanner inScan = new Scanner(System.in);

		//determine algorithm (options: m1~m4, ms, q1~q5)
		System.out.println("Please enter algorithm:");
		String searchAlgo = inScan.next();
		System.out.println("Algorithm: "+ searchAlgo);

		//determine cases
		System.out.println("Please enter the pattern - 'r' for random, 'i' for increasing, 'd' for decreasing :");
		String pattern = inScan.next();
		System.out.println("Please enter the size:");
		int n = inScan.nextInt();
		System.out.println("Please enter the range:");
		int range = inScan.nextInt();
		System.out.println("Please enter the k:");
		int k = inScan.nextInt();

		//generate unsorted array / listed-array
		if (pattern.equals("r"))
		{
			S = ArrayGenerator.randomArray(n, range);
			Algo5.S = ArrayGenerator.randomArray(n, range);
			Algo7.S = ArrayGenerator.randomArray(n, range);
		} else if (pattern.equals("i"))
		{
			S = ArrayGenerator.increasingArray(n);
			Algo5.S = ArrayGenerator.increasingArray(n);
			Algo7.S = ArrayGenerator.increasingArray(n);
		} else if (pattern.equals("d"))
		{
			S = ArrayGenerator.decreasingArray(n);
			Algo5.S = ArrayGenerator.decreasingArray(n);
			Algo7.S = ArrayGenerator.decreasingArray(n);
		} else
		{
			S = new int[1];
			Algo5.S = new int[1];
			Algo7.S = new int[1];
			System.out.println("illegal input!");
		}//end else

		//test
/*
			//print array
			System.out.print("Array: ");
			switch (searchAlgo)
			{
				case "algo5":
					System.out.println(Arrays.toString(Algo5.S));
					break;
				case "algo6":
					System.out.println(Arrays.toString(S));
					Arrays.sort(S);
					break;
				case "algo7":
					System.out.println(Arrays.toString(Algo7.S));
					break;
				default:
					System.out.println("illegal output!");
			}//end switch
*/
		long begin_time = System.currentTimeMillis();

			//print searched item
			System.out.print("Search: ");
			switch (searchAlgo)
			{
				case "algo5":
					System.out.println("The "+k+"th-smallest key in S is "+Algo5.selection(0,Algo5.S.length,k-1));
					break;
				case "algo6":
					System.out.println("The " +k+ "th-smallest key in S is "+S[k-1]);
					break;
				case "algo7":
					System.out.println("The "+k+"th-smallest key in S is "+Algo7.selection(0,S.length,k-1));
					break;
				default:
					System.out.println("illegal output!");
			}//end switch

		long end_time = System.currentTimeMillis();
		long run_time = end_time - begin_time;
		System.out.println("Runtime: "+ run_time +" ms");
	}//end main
}//end class