import java.util.*;

public class Algo7
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
         Random random = new Random();

        int s = random.nextInt(high)%(high-low+1) + low;
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
        
        for(int i=0; i<4; i++)
		{
             System.out.println("Please input k value to find");
             Scanner input = new Scanner(System.in);
             int k = input.nextInt();
             System.out.println("The "+(k)+"th-smallest key in S is "+selection(0,S.length,k-1));
        }//end for loop
    }//end main
}//end Algo7