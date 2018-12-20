import java.util.*;

class test_cases_sort
{
	public static void main(String[] args)
	{
		int[] S;
		node[] nodeS;
		Scanner inScan = new Scanner(System.in);

		//determine algorithm (options: m1~m4, ms, q1~q5)
		System.out.println("Please enter algorithm:");
		String sortAlgo = inScan.next();
		System.out.println("Algo: "+ sortAlgo);

		//determine cases
		System.out.println("Please enter the pattern - 'r' for random, 'i' for increasing, 'd' for decreasing :");
		String pattern = inScan.next();
		System.out.println("Please enter the size:");
		int n = inScan.nextInt();
		System.out.println("Please enter the range:");
		int range = inScan.nextInt();

		//generate unsorted array / listed-array
		if (pattern.equals("r"))
		{
			S = ArrayGenerator.randomArray(n, range);
			Mergesort2.S = ArrayGenerator.randomArray(n, range);
			nodeS = Mergesort4.randomArray4(n, range);
		} else if (pattern.equals("i"))
		{
			S = ArrayGenerator.increasingArray(n);
			Mergesort2.S = ArrayGenerator.increasingArray(n);
			nodeS = Mergesort4.increasingArray4(n);
		} else if (pattern.equals("d"))
		{
			S = ArrayGenerator.decreasingArray(n);
			Mergesort2.S = ArrayGenerator.decreasingArray(n);
			nodeS = Mergesort4.decreasingArray4(n);
		} else
		{
			S = new int[1];
			nodeS = null;
			System.out.println("illegal input!");
		}//end else

		//test
			//print unsorted array
			System.out.print("Unsorted: ");
			switch (sortAlgo)
			{
				case "m1":
				case "m3":
				case "ms":
				case "q1":
				case "q2":
				case "q3":
				case "q4":
				case "q5":
					System.out.println(Arrays.toString(S));
					break;
				case "m2":
					System.out.println(Arrays.toString(Mergesort2.S));
					break;
				case "m4":
					Mergesort4.printUnsortedArray4(nodeS);
					break;
				default:
					System.out.println("illegal output!");
			}//end switch

			//sorting
			switch (sortAlgo)
			{
				case "m1":
					Mergesort.mergesort(S);
					break;
				case "m2":
					Mergesort2.mergesort2(0,n-1);
					break;
				case "m3":
					Mergesort3.mergesort3(n-1,S);
					break;
				case "m4":
					Mergesort4.mergesort4(1, n, 0, nodeS);
					break;
				case "ms":
					MergeSort_Stack.mergeSort(S);
					break;
				case "q1":
					quickSort1.sort(S);
					break;
				case "q2":
					quickSort2.sort(S);
					break;
				case "q3":
					quickSort3.sort(S);
					break;
				case "q4":
					quickSort4.sort(S);
					break;
				case "q5":
					quickSort5.sort(S);
					break;
				default:
					System.out.println("illegal sorting!");
			}//end switch

			//print sorted array
			System.out.print("Sorted: ");
			switch (sortAlgo)
			{
				case "m1":
				case "m3":
				case "ms":
				case "q1":
				case "q2":
				case "q3":
				case "q4":
				case "q5":
					System.out.println(Arrays.toString(S));
					break;
				case "m2":
					System.out.println(Arrays.toString(Mergesort2.S));
					break;
				case "m4":
					Mergesort4.printSortedArray4(nodeS);
					break;
				default:
					System.out.println("illegal output!");
			}//end switch
	}//end main
}//end class