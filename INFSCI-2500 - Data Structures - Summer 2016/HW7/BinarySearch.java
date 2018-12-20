import java.util.*;

class BinarySearch
{
	public static int binarySearch(int[] arr, int key)
	{
		int max, min, mid;
		min=0;
		max=arr.length-1;

		while (min<=max)
		{
			mid = (min + max)>>1;//(>>1 == /2)

			if (key>arr[mid])
				min = mid+1;
			else if (key<arr[mid])
				max = mid-1;
			else
				return mid;
		}//end while

		return -1;//not found
	}//end binarySearch
}//end BinarySearch

class TestBinarySearch
{
	public static void main(String[] args) 
	{
		//original array
		int[] arr = {22, 19, 25, 6, 36, 30, 5, 40};
		String arrStringUnsorted = Arrays.toString(arr);//pre-defined method
		System.out.println("Unsorted Array: " + arrStringUnsorted);

		//sorted array
		Arrays.sort(arr);//pre-defined method
		String arrStringSorted = Arrays.toString(arr);
		System.out.println("Sorted Array: " + arrStringSorted);

		//binary search
		Scanner inScan = new Scanner(System.in);
		System.out.println("Please enter an integer as the key for binary searching:");
		int key = inScan.nextInt();
		int result = BinarySearch.binarySearch(arr, key);

		if (result == -1)
			System.out.println("not found");
		else
			System.out.println("found at index " + result);
	}//end main
}//end TestBinarySearch