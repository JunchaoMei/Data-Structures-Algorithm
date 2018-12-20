//Non-recursive version of Mergesort using a stack
import java.util.*;
class MergeSort_Stack 
{	
	private static void merge(int [] A, int first, int last) 
	{
	    // Preconditions: A[first ... mid] and A[mid+1 ... last] are sorted
	    // Postcondition: A[first ... last] is sorted 
		int [] temp = new int[last-first+1];
		if (first<last) 
		{
			int i1 = first;
			int mid = (first+last)/2;
			int i2 = mid+1;
						
			for(int i=0;i< temp.length;i++)
			{
				if (i1>mid)
				{
					temp[i]= A[i2];
					i2++;
				} else if (i2>last)
				{
					temp[i]= A[i1];
					i1++;
				} else if (A[i1]<A[i2])
				{
					temp[i]= A[i1];
					i1++;
				} else
				{
					temp[i]= A[i2];
					i2++;
				}//end if...else
			}//end for loop i

			for(int i=0;i<temp.length;i++)
				A[first+i]=temp[i];
		}//end if
	}//end merge

	public static void mergeSort(int [] A)
	{
		Stack<MergesortRecord> stack = new Stack();
		MergesortRecord m = new MergesortRecord(false, 0, A.length-1);
		stack.push(m);
		while (!stack.empty())
		{
			m=stack.pop();
			//If first and second halves of array have been sorted, merge them
			if (m.sorted)
				merge(A,m.first,m.last);
			else if (m.first<m.last) 
			{
				int mid = (m.first+m.last)/2;
				stack.push(new MergesortRecord(true,m.first,m.last));
				stack.push(new MergesortRecord(false,m.first,mid));
				stack.push(new MergesortRecord(false,mid+1,m.last));
			}//end else
		}//end while
	}//end mergeSort

    public static void main(String[] args) 
	{
		//generate a random array
		int[] S = ArrayGenerator.randomArray(10, 50);
		int n = S.length;

		//print unsorted array
		System.out.println(Arrays.toString(S));

		//sorting
		mergeSort(S);

		//print sorted array
		System.out.println(Arrays.toString(S));
    }//end main
}//end class