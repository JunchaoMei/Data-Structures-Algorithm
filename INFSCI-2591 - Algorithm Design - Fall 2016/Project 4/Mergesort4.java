import java.util.*;

class Mergesort4
{
	public static void mergesort4(int low, int high, int mergedlist, node[] S)
	{
		int mid, list1, list2;

		if( low == high)
		{
			mergedlist = low;
			S[mergedlist].node = 0;
		} else
		{
			mid = (low + high) / 2;
			int min1 = 1000;
			int minindex1 = 0;

			for(int i = low; i< mid + 1;i++)
			{
				if(min1 > S[i].key)
				{
					min1 = S[i].key;
					minindex1 = i;
				}//end if
			}//end for loop i

			int min2 = 1000;
			int minindex2 = 0;

			for(int i = mid+1; i <= high ;i++)
			{
				if(min2 > S[i].key)
				{
					min2= S[i].key;
					minindex2 = i;
				}//end if
			}// end for loop i
			
			list1 = minindex1;  // find index list1, list2
			list2 = minindex2;
			
			mergesort4(low, mid, list1, S);
			mergesort4(mid + 1, high, list2, S);
			merge4(list1, list2, mergedlist, S);
		}//end else
	}//end mergesort4
	
	public static void merge4(int list1, int list2, int mergedlist, node[] S)
	{
		int lastsorted;
		if(S[list1].key< S[list2].key)
		{
			mergedlist = list1;
			list1 = S[list1].node;
		} else
		{
			mergedlist = list2;
			list2 = S[list2].node;
		}//end else
		
		lastsorted = mergedlist;

		while(list1 != 0 && list2!= 0)
		{
			if(S[list1].key < S[list2].key)
			{
				S[lastsorted].node = list1;
				lastsorted = list1;
				list1 = S[list1].node;
			} else
			{
				S[lastsorted].node = list2;
				lastsorted = list2;
				list2 = S[list2].node;
			}//end else
		}//end while
			
		if(list1 == 0)
			S[lastsorted].node =list2;
		else
			S[lastsorted].node =list1;
	}//end merge4
	
	public static void printUnsortedArray4(node[] S)
	{
		for (int i = 1; i < S.length; i++)
			System.out.print(S[i].key + " ");
		System.out.println();
	}//end printUnsortedArray4

	//return A-B
	public static HashSet subtractSet(HashSet A, HashSet B)
	{
		HashSet subtraSet = new HashSet();
		subtraSet.clear();
		subtraSet.addAll(A);
		subtraSet.removeAll(B);
		return subtraSet;
		//System.out.println("Subtract Set: "+subtraSet);
	}//end subtractSet

	public static void printSortedArray4(node[] S)
	{
		//find the starting node
		HashSet Nodes = new HashSet();
			for (int i=1; i<S.length; i++)
				Nodes.add(i);
		HashSet Links = new HashSet();
			for (int i=1; i<S.length; i++)
				Links.add(S[i].node);
		HashSet subtraSet = subtractSet(Nodes, Links);
		Iterator it = subtraSet.iterator();
		int start = (int) it.next();
		
		//print array
		System.out.print(S[start].key + " ");
		int next = S[start].node;

		for (int x=2; x<S.length; x++)
		{
			System.out.print(S[next].key + " ");
			next = S[next].node;
		}//end for loop x
			
		System.out.println();
	}//end printSortedArray4

	public static node[] randomArray4(int n, int max)
	{
		node[] arr = new node[n+1];
		arr[0] = new node(10000,10000);
		
		for (int i = 1; i <= n; i++)
			arr[i] = new node(ArrayGenerator.random(1, max),0);
		return arr;
	}//end ramdomArray4

	public static node[] increasingArray4(int n)
	{
		node[] arr = new node[n+1];
		arr[0] = new node(10000,10000);
		
		for (int i = 1; i <= n; i++)
			arr[i] = new node(i,0);
		return arr;
	}//end increasingArray4

	public static node[] decreasingArray4(int n)
	{
		node[] arr = new node[n+1];
		arr[0] = new node(10000,10000);
		
		for (int i = 1; i <= n; i++)
			arr[i] = new node(n-i+1,0);
		return arr;
	}//end decreasingArray4

	public static void main(String[] args)
	{			
		node[] S = randomArray4(10, 50);

		printUnsortedArray4(S);
		
		mergesort4(1, 10, 0, S); 

		printSortedArray4(S);
		System.out.println();

	}//end main
}//end class