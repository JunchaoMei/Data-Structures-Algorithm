/*
5 types of Sorting methods are defined and tested in this script:
(1) insertionSort1
(2) insertionSort2
(3) bubbleSort
(4) selectSort
(5) java.util.Arrays.sort
*/
import java.util.*;

public class TestSorts
{
	public static void main(String[] arg)
	{
		int[] arr1 = {9,8,3,5,2,7,1,6,4};		//initialize the array
		System.out.print("Original Array: ");	
		printArray(arr1);						//print original array
		insertionSort1(arr1);					//call method [insertionSort1]
		System.out.print("Sorted by insertionSort1:		");
		printArray(arr1);						//print sorted array
		System.out.println();

		int[] arr2 = {9,8,3,5,2,7,1,6,4};				//initialize again
		System.out.print("Original Array: ");
		printArray(arr2);						//print original array
		insertionSort2(arr2);					//call method [insertionSort1]
		System.out.print("Sorted by insertionSort2:		");
		printArray(arr2);						//print sorted array
		System.out.println();

		int[] arr3 = {9,8,3,5,2,7,1,6,4};				//initialize again
		System.out.print("Original Array: ");
		printArray(arr3);						//print original array
		bubbleSort(arr3);						//call method [insertionSort2]
		System.out.print("Sorted by bubbleSort:			");
		printArray(arr3);						//print sorted array
		System.out.println();

		int[] arr4 = {9,8,3,5,2,7,1,6,4};				//initialize again
		System.out.print("Original Array: ");
		printArray(arr4);						//print original array
		selectSort(arr4);						//call method [insertionSort2]
		System.out.print("Sorted by selecSort:			");
		printArray(arr4);						//print sorted array
		System.out.println();

		int[] arr5 = {9,8,3,5,2,7,1,6,4};				//initialize again
		System.out.print("Original Array: ");
		printArray(arr5);						//print original array
		Arrays.sort(arr5);						//call method [insertionSort2]
		System.out.print("Sorted by java.util.Arrays.sort:	");
		printArray(arr5);						//print sorted array
		System.out.println();
	}//end main

	//define method [printArray]
	public static void printArray(int[] arr)
	{
		for (int i=0; i<arr.length; i++)
		{
			System.out.print(arr[i]+" "); //print element and a space
		}//end for
		System.out.println();//new line
	}//end printArray

	//define method[insertionSort1]
	public static void insertionSort1(int[] arr)
	{
		for (int i=1; i<arr.length; i++)
		{
			int curr = arr[i]; //original array
			int j = i-1;
			while ((j>=0) && (arr[j]>curr)) // if bigger, move it
			{
				arr[j+1]=arr[j--];
			}//end while
			arr[j+1] = curr; // it not bigger, insert
		}//end for
	}//end insertionSort1

	//define method[insertionSort2]
	public static void insertionSort2(int[] arr)
	{
		for (int i=1; i<arr.length; i++)
		{
			int curr = arr[i]; //original array
			int j = i;
			while ((j>0) && (arr[j-1]>curr)) // if bigger, move it
			{
				arr[j]=arr[j-- -1];
			}//end while
			arr[j] = curr; // it not bigger, insert
		}//end for
	}//end insertionSort2

	//define method[bubbleSort]
	public static void bubbleSort(int[] arr)
	{
		for (int i=0; i<arr.length-1; i++) //outer loop
		{
			for (int j=0; j<arr.length-1-i; j++) //inner loop
			{
				if (arr[j]>arr[j+1]) //if bigger, swap
				{
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}//end if
			}//end inner loop
		}//end outer loop
	}//end bubbleSort

	//define method[selectSort]
	public static void selectSort(int[] arr)
	{
		for (int i=0; i<arr.length-1; i++) //outer loop
		{
			for (int j=i+1; j<arr.length; j++) //inner loop
			{
				if (arr[i]>arr[j]) //if bigger, swap
				{
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}//end if
			}//end inner loop
		}//end outer loop
	}//end selectSort

}//end class TestSorts