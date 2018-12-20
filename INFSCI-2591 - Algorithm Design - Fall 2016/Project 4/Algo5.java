import java.util.*;

class Algo5
{
    static int[] S;

	public static void constructor ()
	{
		Scanner inScan = new Scanner(System.in);
		System.out.println("Please enter the pattern - 'r' for random, 'i' for increasing, 'd' for decreasing :");
		String pattern = inScan.next();
		System.out.println("Please enter the size:");
		int size = inScan.nextInt();
		System.out.println("Please enter the range:");
		int range = inScan.nextInt();

		if (pattern.equals("r"))
			S = ArrayGenerator.randomArray(size, range);
		else if (pattern.equals("i"))
			S = ArrayGenerator.increasingArray(size);
		else if (pattern.equals("d"))
			S = ArrayGenerator.decreasingArray(size);
		else
		{
			S = new int[1];
			System.out.println("illegal input!");
		}//end else
	}//end constructor
    
    public static int selection(int low, int high, int k)
	{
        int pivotpoint;
        
        if(low == high)
            return S[low];
        else
		{
            pivotpoint = partition(low, high);
            if(k == pivotpoint)
                return S[pivotpoint];
            else if(k < pivotpoint)
                return selection(low, pivotpoint-1, k);
            else 
                return selection(pivotpoint+1, high, k);
        }//end else
    }//end selection
    
    private static int partition(int low, int high)
	{
        int i,j,temp;
        int pivotitem = S[low];
        j = low;
        
        for(i = low+1; i<high; i++)
		{
            if(S[i] < pivotitem)
			{
                j++;
                temp = S[i];
                S[i] = S[j];
                S[j] = temp;
            }//end if
        }//end for loop

        temp = S[j];
        S[j] = S[low];
        S[low] = temp;
        return j;
    }//end partition

    public static void main(String[] args)
	{
        constructor();
        System.out.println("The array S is "+Arrays.toString(S));
		Scanner inScan = new Scanner(System.in);
		System.out.println("please enter k:");
		int k = inScan.nextInt();
        System.out.println("The "+k+"th-smallest key in S is "+selection(0,S.length,k-1));
    }//end main
}//end class