import java.util.*;
//pivot: last element

class quickSort2
{
	public static void sort(int[] A) 
	{
    	quickSort(A, 0, A.length-1);
    }//end sort

    private static void quickSort(int[] A, int start, int end)
	{
    	if(start >= end)
    		return;
    	int left = start;
    	int right = end;

    	//choose the last value as pivot
    	int pivot = A[end];

    	while(left <= right)
		{
    		while(left <= right && A[left] < pivot)
			{
    			left++;
    		}//end while loop

    		while(left <= right && A[right] > pivot)
			{
    			right--;
    		}//end while loop

    		if(left <= right)
			{
    			int temp = A[left];
    			A[left] = A[right];
    			A[right] = temp;
    			left++;
    			right--;
    		}//end if
    	}//end while loop

    	quickSort(A, start, right);
    	quickSort(A, left, end);
    }//end quickSort

    public static void main(String[] args)
	{
		//generate a random array
		int[] S = ArrayGenerator.randomArray(10, 50);

		//print unsorted array
		System.out.println(Arrays.toString(S));

		//sorting
		sort(S);

		//print sorted array
		System.out.println(Arrays.toString(S));
    }//end main
}//end class